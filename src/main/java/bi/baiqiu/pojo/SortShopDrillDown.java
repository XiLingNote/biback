package bi.baiqiu.pojo;

import java.util.List;

public class SortShopDrillDown {
	
	private String shopName;
	
	private String id;
	
	private List<RedisPojo> list;

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<RedisPojo> getList() {
		return list;
	}

	public void setList(List<RedisPojo> list) {
		this.list = list;
	}
}
