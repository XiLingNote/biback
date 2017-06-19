package bi.baiqiu.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bi.baiqiu.service.IndustryTrendService;
import bi.baiqiu.utils.GsonUtils;

@Controller
@RequestMapping("industry")
public class IndustryTrendController {
	@Autowired
	IndustryTrendService industryTrendService;

	@RequestMapping("topStore")
	public String topStore(HttpServletRequest request) {
		Map<String, Object> map = null;
		String dateType = request.getParameter("datetype");
		String stores = request.getParameter("stores");
		
		if (StringUtils.isBlank(stores)) {
			return null;
		}
		
		String[] storeArr = stores.split(",");
		ArrayList<String> arrayList = new ArrayList<String>();

		String beginStr = request.getParameter("begin");

		String endStr = request.getParameter("end");

		SimpleDateFormat format = new SimpleDateFormat(
				"EEE MMM dd yyyy hh:mm:ss z", Locale.ENGLISH);
		Date begin = null;
		Date end = null;

		Integer beginYear = null;
		Integer endYear = null;;

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

				map = industryTrendService.getDayOfMonth(storeArr, begin, end);
				// 以月为单位进行查询
			} else if ("MONTH".equals(dateType)) {

				map = industryTrendService.getMonthofYear(storeArr, begin, end);
			} else if ("YEAR".equals(dateType)) {

				map = industryTrendService.getYear(storeArr, beginYear + 1900,
						endYear + 1900);
			} else {
				return null;
			}

		} else {// 缺少时间参数
			try {
				String encode = URLEncoder.encode("请选择参数", "utf-8");
				return encode;
			} catch (UnsupportedEncodingException e1) {

			}
		}

		String s = GsonUtils.gson.toJson(map);
		return GsonUtils.gson.toJson(map);

	}

}
