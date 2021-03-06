package bi.baiqiu.controller;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import bi.baiqiu.ImportExcel.InfoVo;
import bi.baiqiu.mapper.DailyTargetMapper;
import bi.baiqiu.mapper.GoalMonthAlipMapper;
import bi.baiqiu.mapper.GoalMonthSaleMapper;
import bi.baiqiu.page.PageBean;
import bi.baiqiu.pojo.DailyTarget;
import bi.baiqiu.pojo.GoalMonthAlip;
import bi.baiqiu.pojo.GoalMonthsale;
import bi.baiqiu.service.DailyTargetService;
import bi.baiqiu.utils.ExportExcelUtils;
import bi.baiqiu.utils.ImportExcelUtils;

@Controller
@RequestMapping("target")
public class DailyAndMonthTargetController extends BaseController {
	Logger log = Logger.getLogger(DailyAndMonthTargetController.class);

	@Autowired
	private DailyTargetMapper dailyTargetDao;
	@Autowired
	private DailyTargetService dailyTargetService;
	@Autowired
	private GoalMonthAlipMapper goalMonthAlipDao;
	@Autowired
	private GoalMonthSaleMapper goalMonthSaleDao;

	// @responsebody表示该方法的返回结果直接写入HTTP response body中
	// 日计划相关
	/**
	 * 分页查询日计划
	 * 
	 * @param dailyTarget
	 * @param rowBounds
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "queryDailyTarget.do")
	public void queryDailyTarget(DailyTarget dailyTarget, PageBean page, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Date date = new Date();

	
		response.setCharacterEncoding("utf-8");
		List<DailyTarget> dailyTargets = dailyTargetDao.queryDailyTarget(dailyTarget, page);
		Gson gson = new GsonBuilder().serializeNulls().create();
		String json = "{\"total\":" + page.getTotal() + ",\"rows\":" + gson.toJson(dailyTargets) + "}";
		response.getWriter().print(json);
		Date date1 = new Date();
		log.info("--------------------生成时间-------------------------------"+(date1.getTime()-date.getTime()));
	}

	/**
	 * 不分页
	 * 
	 * @param dailyTarget
	 * @param rowBounds
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "queryDailyTargetNopage.do", method = RequestMethod.POST)
	public void queryDailyTargetNoPage(DailyTarget dailyTarget, RowBounds rowBounds, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		dailyTargetDao.selectByRowBounds(dailyTarget, rowBounds);
	}

	/**
	 * 插入单条日计划把日期添加唯一索引
	 * 
	 * @param dailyTarget
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "insertDailyTarget.do", method = RequestMethod.POST)
	public void insertDailyTarget(DailyTarget dailyTarget, HttpServletRequest request, HttpServletResponse response) {

		try {
			dailyTargetService.insertDailyTarget(dailyTarget);
		} catch (Exception e) {
			WriteMsg(response, "重复增加计划");
			e.printStackTrace();
		}

	}

	/**
	 * 插入多条日计划把日期作为唯一索引，错误则提示
	 * 
	 * @param dailyTarget
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "insertDailyTargetByBatch.do", method = RequestMethod.POST)
	public void insertDailyTargetByBatch(List<DailyTarget> dailyTargetList, HttpServletRequest request,
			HttpServletResponse response) {
		int num = 0;
		try {
			num = dailyTargetService.insertDailyTargetByBatch(dailyTargetList);
			WriteMsg(response, "保存成功");
		} catch (Exception e) {
			WriteMsg(response, num + "");
			e.printStackTrace();
		}

	}

	/**
	 * 更新日计划
	 * 
	 * @param dailyTarget
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "updateDailyTarget.do", method = RequestMethod.POST)
	public void updateDailyTarget(DailyTarget dailyTarget, HttpServletRequest request, HttpServletResponse response) {
		try {
			dailyTargetDao.updateByPrimaryKey(dailyTarget);
		} catch (Exception e) {
			WriteMsg(response, "重复计划");
			e.printStackTrace();
		}
	}

	/**
	 * 删除日计划
	 * 
	 * @param dailyTarget
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "deleteDailyTarget", method = RequestMethod.POST)
	public void deleteDailyTarget(DailyTarget dailyTarget, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		dailyTargetDao.delete(dailyTarget);
	}

	/**
	 * 日计划上传
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "uploadDailyTarget.do", method = { RequestMethod.GET, RequestMethod.POST })
	public void uploadDailyTarget(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 上传文件用
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		System.out.println("通过 jquery.form.js 提供的ajax方式上传文件！");

		InputStream in = null;
		List<List<Object>> listob = null;
		MultipartFile file = multipartRequest.getFile("upfile");
		if (file.isEmpty()) {
			throw new Exception("文件不存在！");
		}

		in = file.getInputStream();
		listob = new ImportExcelUtils().getBankListByExcel(in, file.getOriginalFilename());
		List<DailyTarget> dailyTargets = new ArrayList<DailyTarget>();
		for (int i = 0; i < listob.size(); i++) {
			List<Object> lo = listob.get(i);
			DailyTarget dailyTarget = new DailyTarget();
			dailyTarget.setId(Integer.valueOf(String.valueOf(lo.get(0))));
			dailyTarget.setStorename(String.valueOf(1));// 店铺名称
			dailyTarget.setDate(String.valueOf(lo.get(2)));// 日期
			dailyTarget.setPayment(String.valueOf(lo.get(3)));// 计划量
			dailyTargets.add(dailyTarget);
		}
		dailyTargetService.insertDailyTargetByBatch(dailyTargets);
		in.close();
		log.info(dailyTargets);
		WriteObject(response, dailyTargets);
		// 该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
		/*
		 * for (int i = 0; i < listob.size(); i++) { List<Object> lo =
		 * listob.get(i); InfoVo vo = new InfoVo();
		 * vo.setCode(String.valueOf(lo.get(0)));
		 * vo.setName(String.valueOf(lo.get(1)));
		 * vo.setDate(String.valueOf(lo.get(2)));
		 * vo.setMoney(String.valueOf(lo.get(3)));
		 * 
		 * System.out.println("打印信息-->机构:" + vo.getCode() + "  名称：" +
		 * vo.getName() + "   时间：" + vo.getDate() + "   资产：" + vo.getMoney()); }
		 * 
		 * PrintWriter out = null; response.setCharacterEncoding("utf-8"); //
		 * 防止ajax接受到的中文信息乱码 out = response.getWriter(); out.print("文件导入成功！");
		 * out.flush(); out.close();
		 */
	}

	/**
	 * 日计划导出
	 * 
	 * @param dailyTarget
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "exportDailyTarget.do", method = RequestMethod.POST)
	public void exportDailyTarget(DailyTarget dailyTarget, PageBean page, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info("--------------------导出-------------------------------");
		ExportExcelUtils util = new ExportExcelUtils();
		page.setMeToDefault();
		Date date = new Date();
		String path = "C:";
		String fileName = date.getTime() + ".xlsx";
		util.init_Excel(path, fileName, new String[] { "id", "店铺", "时间", "目标计划数" });
		String[] dailyfiles = new String[] { "id", "storename", "date", "payment" };// 对象的属性名字
		List<Object> dailys = new ArrayList<>();
		dailys.addAll(dailyTargetDao.queryDailyTarget(dailyTarget, page));
		util.write_data_Excel(dailys, dailyfiles);
		util.write_excel_disk();
		Date date1 = new Date();

		util.downLoad(path+fileName,response,false);
		Date date2 = new Date();
		log.info("--------------------生成时间-------------------------------"+(date1.getTime()-date.getTime()));
		log.info("--------------------导出时间-------------------------------"+(date2.getTime()-date1.getTime()));

	}

	/**
	 * alipay月度计划
	 * 
	 * @param goalMonthAlip
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "insertGoalMonthAlip", method = RequestMethod.POST)
	public void insertGoalMonthAlip(GoalMonthAlip goalMonthAlip, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		goalMonthAlipDao.insert(goalMonthAlip);
	}

	@RequestMapping(value = "updateGoalMonthAlip", method = RequestMethod.POST)
	public void updateGoalMonthAlip(GoalMonthAlip goalMonthAlip, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		goalMonthAlipDao.updateByPrimaryKey(goalMonthAlip);
	}

	@RequestMapping(value = "deleteGoalMonthAlip", method = RequestMethod.POST)
	public void deleteGoalMonthAlip(GoalMonthAlip goalMonthAlip, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		goalMonthAlipDao.delete(goalMonthAlip);
	}

	/**
	 * GMV月度计划
	 * 
	 * @param goalMonthsale
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "insertGoalMonthSale", method = RequestMethod.POST)
	public void insertGoalMonthSale(GoalMonthsale goalMonthsale, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		goalMonthSaleDao.insert(goalMonthsale);
	}

	@RequestMapping(value = "updateGoalMonthSale", method = RequestMethod.POST)

	public void updateGoalMonthSale(GoalMonthsale goalMonthsale, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		goalMonthSaleDao.updateByPrimaryKey(goalMonthsale);
	}

	@RequestMapping(value = "deleteGoalMonthSale", method = RequestMethod.POST)
	public void deleteGoalMonthSale(GoalMonthsale goalMonthsale, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		goalMonthSaleDao.delete(goalMonthsale);
	}
}
