package bi.baiqiu.mapper;


import java.util.List;

import com.github.abel533.mapper.Mapper;

import bi.baiqiu.pojo.DailyTarget;
import bi.baiqiu.pojo.GoalMonthsale;

public interface GoalMonthSaleMapper extends Mapper<GoalMonthsale>{
	List<GoalMonthsale> queryGoalMonthAlip();
}
