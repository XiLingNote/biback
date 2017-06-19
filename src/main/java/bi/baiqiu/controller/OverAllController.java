package bi.baiqiu.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bi.baiqiu.service.RedisService;
import bi.baiqiu.utils.DateUtils;
import bi.baiqiu.utils.GsonUtils;

@Controller
@RequestMapping("overall")
public class OverAllController {

	@Autowired
	RedisService redisService;

	/**
	 * @param model
	 * @return 本自然月数据 带有YOY同比 map.put("pojoset", treeSet); map.put("last",
	 *         pojo);
	 * 
	 *         map.put("pojoset", treeSet);(本月) map.put("last", last);(上月)
	 *         http://localhost:8080/page/index.do
	 */

	@ResponseBody
	@RequestMapping("sale")
	public String demo3(HttpServletRequest request) {
		Map<String, Object> map = null;
		String dateType = request.getParameter("datetype");
		String department = request.getParameter("department");
		if (StringUtils.isBlank(department)) {

			department = "All";
		}
		String beginStr = request.getParameter("begin");

		String endStr = request.getParameter("end");

		SimpleDateFormat format = new SimpleDateFormat(
				"EEE MMM dd yyyy hh:mm:ss z", Locale.ENGLISH);
		Date begin = null;
		Date end = null;

		Integer beginYear = null;
		Integer beginMonth = null;
		Integer endYear = null;
		Integer endMonth = null;

		if (StringUtils.isNotBlank(beginStr)) {
			try {
				String str1 = beginStr.replace("GMT", "").replaceAll(
						"\\(.*\\)", "");
				begin = format.parse(str1);
				beginYear = begin.getYear();
				beginMonth = begin.getMonth();
			} catch (ParseException e) {
				throw new RuntimeException("开始时间转换异常");
			}
		}

		if (StringUtils.isNotBlank(endStr)) {
			try {
				String str2 = endStr.replace("GMT", "").replaceAll("\\(.*\\)",
						"");
				end = format.parse(str2);
				endYear = end.getYear();
				endMonth = end.getMonth();
			} catch (ParseException e) {
				throw new RuntimeException("结束时间转换异常");
			}
		}

		if (begin != null && end != null) {

			// 按日期查找
			if ("DAY".equals(dateType)) {
				// 同一个年月
				Boolean b = DateUtils.sameyyyyMM(begin, end);

				Boolean theBeginOfMonth = DateUtils.isTheBeginOfMonth(begin);
				Boolean theEndOfMonth = DateUtils.isTheEndOfMonth(end);

				// 查询整月,带有同比
				if (b && theEndOfMonth && theBeginOfMonth) {
					map = redisService.getDayofWholeMonth(department, end);

				} else {
					map = redisService.getDayOfMonth(department, begin, end);
				}
				// 以月为单位进行查询
			} else if ("MONTH".equals(dateType)) {

				if (beginYear == endYear && endMonth - beginMonth == 11) {
					// 这个月正好是整年
					map = redisService.getMonthofWholeYear(department,
							beginYear + 1900);
				} else {
					map = redisService.getMonthofYear(department, begin, end);
				}
			} else if ("YEAR".equals(dateType)) {

				if (beginYear == endYear) {
					map = redisService.getWholeYear(department, endYear + 1900);
				} else {
					map = redisService.getYear(department, beginYear + 1900,
							endYear + 1900);
				}
			} else {
				return null;
			}

		} else {// 缺少时间参数

			map = redisService.getThisMonth(department);
		}

		String s = GsonUtils.gson.toJson(map);
		return GsonUtils.gson.toJson(map);

	}

}
