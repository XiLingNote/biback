package bi.baiqiu.pojo;

import java.io.Serializable;
import java.util.List;

public class Top implements Serializable {
	
	private String name;
	
	private List<SortAmountByDate> list;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SortAmountByDate> getList() {
		return list;
	}

	public void setList(List<SortAmountByDate> list) {
		this.list = list;
	}
	
}
