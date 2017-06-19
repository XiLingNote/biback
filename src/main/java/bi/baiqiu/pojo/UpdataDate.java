package bi.baiqiu.pojo;

import java.io.Serializable;

/**
 * @author bqhome
 * 
 * 更新日期排序实体类
 * Reids中的 Set自带去重,本类自带排序 Set集合接受
 *	
 */
public class UpdataDate implements Comparable<UpdataDate>, Serializable{
	
	private String datetime;

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	@Override
	public int compareTo(UpdataDate o) {
		
		int time1 = Integer.parseInt(this.datetime);
		int time2 = Integer.parseInt(o.getDatetime());
		
		return time1 - time2;
	}
}
