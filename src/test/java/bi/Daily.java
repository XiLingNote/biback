package bi;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import bi.baiqiu.mapper.DailyTargetDao;
import bi.baiqiu.mapper.GoalMonthSaleDao;
import bi.baiqiu.page.PageBean;
import bi.baiqiu.pojo.DailyTarget;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Daily {
	@Autowired
	private DailyTargetDao daily;
	@Autowired
	private  GoalMonthSaleDao goalMonthSaleDao;
	@Test
	public void run() {
		PageBean page=new PageBean();
		//使用page插件
		List<DailyTarget> dailylist=daily.queryDailyTargetTest();
		for(DailyTarget da:dailylist){
			System.out.println("日计划的id："+da.getId());
		}
	}
}
