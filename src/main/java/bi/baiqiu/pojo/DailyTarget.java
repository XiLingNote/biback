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
	private String id;
	private String storename;
	private Date date;
	private String payment;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}

}
