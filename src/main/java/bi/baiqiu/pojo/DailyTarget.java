package bi.baiqiu.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/**每日计划实体类
 * @author Administrator
 *
 */
@Table(name = "dailytarget")
@Entity
public class DailyTarget {
	private Integer id;
	private String storename;
	private String date;
	private String payment;
	private String startDate;
	private String endDate;
	
	public DailyTarget() {
	}
	public DailyTarget(String storename, String date, String payment) {
		super();
		this.storename = storename;
		this.date = date;
		this.payment = payment;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
