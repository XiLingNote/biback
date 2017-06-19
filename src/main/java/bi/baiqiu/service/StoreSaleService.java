package bi.baiqiu.service;

import java.util.Date;
import java.util.Map;
import java.util.Set;

public interface StoreSaleService {
	
	/**
	 * @param type 
	 * @return
	 * 查询本月  rank
	 */
	Map<String, Object> queryThisMonth(String type);
	
	/**
	 * @param date
	 * @param type
	 * @return
	 * 查询daily rank
	 */
	Map<String, Object> queryByThisDay(Date date, String type);
	
	/**
	 * @return
	 * 自定义日期查询
	 * 按日查询
	 */
	Map<String, Object> getDayOfMonth(String store, Date begin, Date end);
	
	/**
	 * @param department
	 * @param begin
	 * @param end
	 * @return
	 */
	Map<String, Object> getMonthofYear(String store, Date begin, Date end);
	
	/**
	 * @param department
	 * @param y1
	 * @param y2
	 * @return
	 * 
	 */
	Map<String, Object> getYear(String store, int y1, int y2);
	

	/**
	 * @param name
	 * @return
	 * 查询店铺名称
	 */
	Set<String> queryStoreName(); 
	
	
}
