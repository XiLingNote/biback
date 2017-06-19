package bi.baiqiu.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
	
	public static final SimpleDateFormat BYDAY = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
	public static final SimpleDateFormat DAY = new SimpleDateFormat("dd", Locale.getDefault());
	public static final SimpleDateFormat BYMONTH = new SimpleDateFormat("yyyyMM", Locale.getDefault());
	public static final SimpleDateFormat MONTH = new SimpleDateFormat("MM", Locale.getDefault());
	public static final SimpleDateFormat BYYEAR = new SimpleDateFormat("yyyy", Locale.getDefault());
	private static Calendar calendar = Calendar.getInstance();
	
	public static int getdd(){		
		return calendar.get(Calendar.DATE);
	}
	/**
	 * @return
	 * 0-11
	 */
	public static int getMM(){		
		return calendar.get(Calendar.MONTH);
	}
	
	/**
	 * @return 2017
	 */
	public static int getyyyy(){
		
		return calendar.get(Calendar.YEAR); 
	}
	
	public static String getyyyyMMdd(Date date){
		
		return BYDAY.format(date);
	}
	
	public static String dd(Date date){
		
		return DAY.format(date);
	}
	
	public static String getyyyyMM(Date date){
		
		return BYMONTH.format(date);
	}
	
	public static String getMM(Date date){
		
		return MONTH.format(date);
	}
	
	/**
	 * @param date
	 * @return
	 * 117
	 * 1900 开始
	 * 2017 :117
	 */
	public static String getyyyy(Date date){
		
		return BYYEAR.format(date);
	}
	
	public static Boolean isTheEndOfMonth(Date date){
		int day = date.getDate();
		int month = date.getMonth();
		int year = date.getYear();
		int month2 = new Date(year,month,day+1).getMonth();
				
		return !(month==month2);
	}
	
	/**
	 * @param date
	 * @return
	 * true :是第一天
	 */
	public static Boolean isTheBeginOfMonth(Date date){
		int day = date.getDate();
		return day==1;
	}
	
	/**
	 * @param date
	 * @return
	 * true :不是最后一天
	 */
	public static boolean isTheEndOfYear(Date date){
		int day = date.getDate();
		int month = date.getYear();
		int year = date.getYear();
		int year2 = new Date(year,month+1,day).getYear();
		
		return !(year==year2);
	}
	
	public static boolean sameyyyyMM(Date begin ,Date end){
		String getyyyyMM = DateUtils.getyyyyMM(begin);
		String getyyyyMM2 = DateUtils.getyyyyMM(end);
		return getyyyyMM.equals(getyyyyMM2);
		
	}

	@SuppressWarnings("deprecation")
	public static String getLastyyyyMM(Date date) {
		int y = date.getYear()+1900;
		
		int m = date.getMonth();
		String mm = (m>9)?""+m:"0"+m;
		int d = date.getDate();
		return ""+y+mm;
	}
}
