package bi.baiqiu.mapper;


import java.util.List;

import com.github.abel533.mapper.Mapper;

import bi.baiqiu.pojo.GoalMonthAlip;

public interface GoalMonthAlipMapper extends Mapper<GoalMonthAlip>{
	public List<GoalMonthAlip> queryGoalMonthAlip();
}
