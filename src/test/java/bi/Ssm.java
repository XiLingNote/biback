package bi;

import java.util.Date;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;
import bi.baiqiu.utils.DateUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Ssm {
	@Autowired
	private Jedis jedisService;


	@Test
	public void run() {
		// Date maxDate = jdpFxTradeService.selectMaxDate();
		// System.out.println(maxDate);
		// String mm = DateUtils.getMM(maxDate);
		// System.out.println(mm);
		// Date date = jdpFxTradeService.selectMinDate();
		// List<SuperPojo> list = storeService.getDailytarget();
		// System.out.println(list.get(0).get("department"));
		// System.out.println(list.get(0).get("target"));
		// java.util.Date date2 = (Date)list.get(0).get("date");
		// String mMdd = DateUtils.getyyyyMMdd(date2);
		// System.out.println(mMdd);
		// System.out.println(date2);

		Set<String> set = jedisService.smembers("updateList");
		// 存储最后一次执行时间的int值 和 String值
		int last = 0;
		String lastDate = null;
		for (String string : set) {
			int j = Integer.parseInt(string);
			if (j > last) {
				last = j;
				lastDate = string;
			}
		}

		int beginy = Integer.parseInt(lastDate.subSequence(0, 4).toString()) - 1900;
		int beginm = Integer.parseInt(lastDate.subSequence(4, 6).toString()) - 1;
		int begind = Integer.parseInt(lastDate.subSequence(6, 8).toString());
		Date begintimes = new Date(beginy, beginm, begind);
		int endy = DateUtils.getyyyy();
		int endm = DateUtils.getMM();
		int endd = DateUtils.getdd();
		Date end = new Date(endy, endm, endd);
		long endtimes = new Date(endy, endm, endd + 1).getTime() - 1;
		Date date = new Date(endtimes);
		String getyyyyMMdd = DateUtils.getyyyyMMdd(date);
		String thisyyyy = null;
		String thisyyyyMM = null;

		for (int i = begind;; i++) {
			Date arr = new Date(beginy, beginm, i);
			String yyyy = DateUtils.getyyyy(arr);
			String yyyyMM = DateUtils.getyyyyMM(arr);
			String yyyyMMdd = DateUtils.getyyyyMMdd(arr);
			System.out.println(arr);
			if (Integer.parseInt(yyyyMMdd)<Integer.parseInt(getyyyyMMdd)) {
				break;
			}
		}
	}
}
