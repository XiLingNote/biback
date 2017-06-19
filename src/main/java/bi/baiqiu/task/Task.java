package bi.baiqiu.task;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author bqhome
 *
 *         定时器实体类 查询数据库 最近一分钟的订单数据 根据 部门名称 日期 部门 更新 数据
 */
@Component
public class Task {
	private Date begin;
	// 5秒更新一次
//	 @Scheduled(fixedDelay = 5000)
	// 一分钟更新一次
//	@Scheduled(cron = "0 0/1 * * * ?")
	public void doUpdateIndexData() {
		 if (begin==null) {
			 begin = new Date();
		}
		 System.out.println(begin);
		
	}

}
