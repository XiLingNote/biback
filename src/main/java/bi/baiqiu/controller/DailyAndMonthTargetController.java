package bi.baiqiu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import bi.baiqiu.mapper.DailyTargetDao;
import bi.baiqiu.mapper.GoalMonthAlipDao;
import bi.baiqiu.mapper.GoalMonthSaleDao;
import bi.baiqiu.page.PageBean;
import bi.baiqiu.pojo.DailyTarget;
import bi.baiqiu.pojo.GoalMonthAlip;
import bi.baiqiu.pojo.GoalMonthsale;
import bi.baiqiu.service.DailyTargetService;
@Controller
@RequestMapping("target")
public class DailyAndMonthTargetController extends BaseController {
	Logger log=Logger.getLogger(DailyAndMonthTargetController.class);

	@Autowired
	private DailyTargetDao dailyTargetDao;
	@Autowired
	private DailyTargetService dailyTargetService;
	@Autowired
	private GoalMonthAlipDao goalMonthAlipDao;
	@Autowired
	private GoalMonthSaleDao goalMonthSaleDao;
	
	//@responsebody表示该方法的返回结果直接写入HTTP response body中
		//日计划相关
	/**分页查询日计划
	 * @param dailyTarget
	 * @param rowBounds
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value ="queryDailyTarget.do")
	public void queryDailyTarget(DailyTarget dailyTarget,PageBean page, HttpServletRequest request,HttpServletResponse response) throws Exception  {
		log.info(dailyTargetDao.queryDailyTarget(dailyTarget, page));
		WriteObject(response,dailyTargetDao.queryDailyTarget(dailyTarget, page),page.getTotal());
	}
	/**不分页
	 * @param dailyTarget
	 * @param rowBounds
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params ="queryDailyTargetNopage", method = RequestMethod.POST)
	public void queryDailyTargetNoPage(DailyTarget dailyTarget,RowBounds rowBounds, HttpServletRequest request,HttpServletResponse response) throws Exception  {
		dailyTargetDao.selectByRowBounds(dailyTarget, rowBounds);
	}
	/**插入单条日计划把日期作为唯一约束，错误则提示
	 * @param dailyTarget
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params ="insertDailyTarget", method = RequestMethod.POST)
	public void insertDailyTarget(DailyTarget dailyTarget, HttpServletRequest request,HttpServletResponse response){
		
		try {
			dailyTargetService.insertDailyTarget(dailyTarget);
		} catch (Exception e) {
			WriteMsg(response, "重复增加计划");
			e.printStackTrace();
		}
	
	}
	
	/**插入多条日计划把日期作为唯一约束，错误则提示
	 * @param dailyTarget
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params ="insertDailyTargetByBatch", method = RequestMethod.POST)
	public void insertDailyTargetByBatch(List<DailyTarget> dailyTargetList, HttpServletRequest request,HttpServletResponse response){
			int num = 0;
			try {
				num=dailyTargetService.insertDailyTargetByBatch(dailyTargetList);
				WriteMsg(response, "保存成功");
			} catch (Exception e) {
				WriteMsg(response, num+"");
				e.printStackTrace();
			}
		
	
	}
	/**更新日计划
	 * @param dailyTarget
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params ="updateDailyTarget", method = RequestMethod.POST)
	public void updateDailyTarget(DailyTarget dailyTarget, HttpServletRequest request,HttpServletResponse response) throws Exception {
		dailyTargetDao.updateByPrimaryKey(dailyTarget);
	}

	/**删除日计划
	 * @param dailyTarget
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params ="deleteDailyTarget", method = RequestMethod.POST)
	public void deleteDailyTarget(DailyTarget dailyTarget, HttpServletRequest request,HttpServletResponse response) throws Exception {
		dailyTargetDao.delete(dailyTarget);
	}
	/**alipay月度计划
	 * @param goalMonthAlip
	 * @param request
	 * @param response
	 */
	@RequestMapping(params ="insertGoalMonthAlip", method = RequestMethod.POST)
	public void insertGoalMonthAlip(GoalMonthAlip goalMonthAlip, HttpServletRequest request,HttpServletResponse response) throws Exception {
		goalMonthAlipDao.insert(goalMonthAlip);
	}
	
	@RequestMapping(params ="updateGoalMonthAlip", method = RequestMethod.POST)
	public void updateGoalMonthAlip(GoalMonthAlip goalMonthAlip, HttpServletRequest request,HttpServletResponse response) throws Exception {
		goalMonthAlipDao.updateByPrimaryKey(goalMonthAlip);
	}
	@RequestMapping(params ="deleteGoalMonthAlip", method = RequestMethod.POST)
	public void deleteGoalMonthAlip(GoalMonthAlip goalMonthAlip, HttpServletRequest request,HttpServletResponse response) throws Exception {
		goalMonthAlipDao.delete(goalMonthAlip);
	}
	/**GMV月度计划
	 * @param goalMonthsale
	 * @param request
	 * @param response
	 */
	@RequestMapping(params ="insertGoalMonthSale", method = RequestMethod.POST)
	public void insertGoalMonthSale(GoalMonthsale goalMonthsale, HttpServletRequest request,HttpServletResponse response) throws Exception {
		goalMonthSaleDao.insert(goalMonthsale);
	}
	
	@RequestMapping(params ="updateGoalMonthSale", method = RequestMethod.POST)

	public void updateGoalMonthSale(GoalMonthsale goalMonthsale, HttpServletRequest request,HttpServletResponse response) throws Exception {
		goalMonthSaleDao.updateByPrimaryKey(goalMonthsale);
	}
	@RequestMapping(params ="deleteGoalMonthSale", method = RequestMethod.POST)
	public void deleteGoalMonthSale(GoalMonthsale goalMonthsale, HttpServletRequest request,HttpServletResponse response) throws Exception {
		goalMonthSaleDao.delete(goalMonthsale);
	}
}
