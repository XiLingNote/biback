package bi.baiqiu.pojo;

import java.io.Serializable;


public class SortAmountByDate implements Comparable<RedisPojo>, Serializable{
	
	private String date;
	
	private double amount;
	
	private Double target;


	public String getDate()  {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getTarget() {
		return target;
	}
	
	public void setTarget(double target) {
		this.target = target;
	}
	
	@Override
	public String toString() {
		return "SortAmount [date=" + date + ", amount=" + amount + ", target="
				+ target + "]";
	}

	@Override
	public int compareTo(RedisPojo o) {
		int time1 = Integer.parseInt(this.date);
		int time2 = Integer.parseInt(o.getDatetime());
		return time1 - time2;
	}
	
}
