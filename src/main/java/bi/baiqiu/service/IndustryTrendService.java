package bi.baiqiu.service;

import java.util.Date;
import java.util.Map;

public interface IndustryTrendService {

	Map<String, Object> getDayOfMonth(String[] storeArr, Date begin,
			Date end);

	Map<String, Object> getMonthofYear(String[] storeArr, Date begin,
			Date end);

	Map<String, Object> getYear(String[] storeArr, int i, int j);

}
