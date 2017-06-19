package bi.baiqiu.pojo;

import java.io.Serializable;

public class SortShop implements Comparable<SortShop>, Serializable {

	private String shopName;
	
	private String id;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	private double amount;
	
	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public int compareTo(SortShop o) {
		int a = (int) this.amount;
		int b = (int) o.getAmount();
		return b - a;
	}

	@Override
	public String toString() {
		return "SortShop [shopName=" + shopName + ", id=" + id + ", amount=" + amount + "]";
	}

}
