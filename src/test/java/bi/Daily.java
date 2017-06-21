package bi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import bi.baiqiu.mapper.DailyTargetMapper;
import bi.baiqiu.mapper.GoalMonthAlipMapper;
import bi.baiqiu.mapper.GoalMonthSaleMapper;
import bi.baiqiu.page.PageBean;
import bi.baiqiu.pojo.DailyTarget;
import bi.baiqiu.pojo.GoalMonthAlip;


@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Daily {
	Logger log= Logger.getLogger(Daily.class);
	@Autowired
	private DailyTargetMapper daily;
	@Autowired
	private  GoalMonthAlipMapper goalMonthAlipDao;
	/**
	 * 日计划分页查询
	 */
	@Test
	public void run() {
		PageBean page=new PageBean();
		DailyTarget da1=new DailyTarget();
		da1.setStartDate("19921020");
		//使用page插件
		List<DailyTarget> dailylist=daily.queryDailyTarget(da1,new PageBean());
		for(DailyTarget da:dailylist){
			System.out.println("日计划的id："+da.getId());
		}
	}
	/**
	 * alipay月计划
	 */
	@Test
	public void run2(){
		
		List<GoalMonthAlip> alipList=goalMonthAlipDao.queryGoalMonthAlip();
		for(GoalMonthAlip alip:alipList){
			System.out.println("日计划的id："+alip.getId());
		}
	}
	/**
	 * 日计划批量插入
	 */
	@Test
	public void run3(){
		List<DailyTarget> list=new ArrayList<>();
		DailyTarget dailyEntity=new DailyTarget("test","","100");
		
		list.add(dailyEntity);
		list.add(dailyEntity);

		int a =daily.insertByBatch(list);
		log.info(a+"---------------------------------------------");
	}
	@Test
	public void run4(){
		int [] s={1343,1344,1342};
		int a =daily.batchDeleteDailyTarget(s);
		log.info(a+"---------------------------------------------");
	}
}
