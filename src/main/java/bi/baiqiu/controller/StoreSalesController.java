package bi.baiqiu.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bi.baiqiu.service.StoreSaleService;
import bi.baiqiu.utils.GsonUtils;
import bi.baiqiu.utils.PinYin4jUtils;

@Controller
@RequestMapping("store")
public class StoreSalesController {

	@Autowired
	private StoreSaleService storeSaleService;

	@ResponseBody
	@RequestMapping("month")
	public String monthSales(Model model, HttpServletRequest request) {
		String type = request.getParameter("type");
		Map<String, Object> map = storeSaleService.queryThisMonth(type);
		String json = GsonUtils.gson.toJson(map);
		System.out.println(type); 
		return json;
	}

	/**
	 * @param date
	 *            日期
	 * @param type
	 *            Gmv、Alipay
	 * @return
	 */
	@ResponseBody
	@RequestMapping("daily")
	public String daliySales(HttpServletRequest request) {
		String dateStr = request.getParameter("date");
		SimpleDateFormat format = new SimpleDateFormat(
				"EEE MMM dd yyyy hh:mm:ss z", Locale.ENGLISH);
		Date date = null;
		String type = request.getParameter("type");
		if (StringUtils.isBlank(type)) {
			type = "GMV";
		}

		if (StringUtils.isNotBlank(dateStr)) {
			String str1 = dateStr.replace("GMT", "").replaceAll("\\(.*\\)", "");
			try {
				date = format.parse(str1);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		Map<String, Object> map = storeSaleService.queryByThisDay(date, type);

		String json = GsonUtils.gson.toJson(map);

		return json;
	}

	// datetype：y m d, date 日期, store 店铺名称 请求参数
	@ResponseBody
	@RequestMapping("salesTrend")
	public String salesTrend(HttpServletRequest request) {
		Map<String, Object> map = null;
		String dateType = request.getParameter("datetype");
		String store = request.getParameter("store");
		
		if (StringUtils.isBlank(store)) {
			
			return null;
		}
		String namePinyin = PinYin4jUtils.hanziToPinyin(
				store, "");

		String beginStr = request.getParameter("begin");

		String endStr = request.getParameter("end");

		SimpleDateFormat format = new SimpleDateFormat(
				"EEE MMM dd yyyy hh:mm:ss z", Locale.ENGLISH);
		Date begin = null;
		Date end = null;

		Integer beginYear = null;
		Integer endYear = null;

		if (StringUtils.isNotBlank(beginStr)) {
			try {
				String str1 = beginStr.replace("GMT", "").replaceAll(
						"\\(.*\\)", "");
				begin = format.parse(str1);
				beginYear = begin.getYear();
			} catch (ParseException e) {
				throw new RuntimeException("开始时间转换异常");
			}
		}

		if (StringUtils.isNotBlank(endStr)) {
			try {
				String str2 = endStr.replace("GMT", "").replaceAll("\\(.*\\)",
						"");
				end = format.parse(str2);
				endYear = begin.getYear();
			} catch (ParseException e) {
				throw new RuntimeException("结束时间转换异常");
			}
		}

		if (begin != null && end != null) {

			// 按日期查找
			if ("DAY".equals(dateType)) {

				map = storeSaleService.getDayOfMonth(namePinyin, begin, end);
				// 以月为单位进行查询
			} else if ("MONTH".equals(dateType)) {

				map = storeSaleService.getMonthofYear(namePinyin, begin, end);
			} else if ("YEAR".equals(dateType)) {

				map = storeSaleService.getYear(namePinyin, beginYear + 1900,
						endYear + 1900);
			} else {
				return null;
			}

		} else {// 缺少时间参数
			try {
				String encode = URLEncoder.encode("请选择起止时间", "utf-8");
				return encode;
			} catch (UnsupportedEncodingException e1) {

			}
		}

		String s = GsonUtils.gson.toJson(map);
		return GsonUtils.gson.toJson(map);

	}

	@ResponseBody
	@RequestMapping("name")
	public String name(Model model, HttpServletRequest request) {

		Set<String> set = storeSaleService.queryStoreName();
		String json = GsonUtils.gson.toJson(set);
		return json;
	}

}
