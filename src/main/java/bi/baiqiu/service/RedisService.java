package bi.baiqiu.service;

import java.util.Date;
import java.util.Map;

public interface RedisService {
	
	/**
	 * @return
	 * 查询本自然月的数据 :  带同比
	 */
	Map<String, Object> getThisMonth(String department);

	/**
	 * @param department
	 * @param begin
	 * @return
	 * 查询整一个自然月:带同比
	 */
	Map<String, Object> getDayofWholeMonth(String department,Date begin);
	
	/**
	 * @return
	 * 自定义日期查询
	 * 按日查询
	 */
	Map<String, Object> getDayOfMonth(String department, Date begin, Date end);

	/**
	 * @return
	 * 查询整年数:  据带同比
	 */
	Map<String, Object> getMonthofWholeYear(String department, int y1);

	
	/**
	 * @param department
	 * @param begin
	 * @param end
	 * @return
	 */
	Map<String, Object> getMonthofYear(String department, Date begin, Date end);

	
	
	/**
	 * @param department
	 * @param y2
	 * @return
	 * 查询一整年的数据: 带同比
	 */
	Map<String, Object> getWholeYear(String department, int y2);

	
	
	/**
	 * @param department
	 * @param y1
	 * @param y2
	 * @return
	 * 
	 * 查询的数据 不止一个年份 :	不带同比
	 */
	Map<String, Object> getYear(String department, int y1, int y2); 
}
