package bi.baiqiu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import bi.baiqiu.pojo.RedisPojo;
import bi.baiqiu.pojo.SortAmountByDate;
import bi.baiqiu.pojo.Top;
import bi.baiqiu.service.IndustryTrendService;
import bi.baiqiu.utils.DateUtils;
import bi.baiqiu.utils.GsonUtils;
import bi.baiqiu.utils.PinYin4jUtils;

@Service("industryTrendService")
public class IndustryTrendServiceImpl implements IndustryTrendService {
	@Autowired
	JedisPool jedisPool;

	@Override
	public Map<String, Object> getDayOfMonth(String[] storeArr, Date begin,
			Date end) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Top> topList = new ArrayList<Top>();
		Jedis jedis = jedisPool.getResource();
		int d = begin.getDate();
		int m = begin.getMonth();
		int y = begin.getYear();
		String getyyyyMMdd = DateUtils.getyyyyMMdd(end);
		int endtime = Integer.parseInt(getyyyyMMdd);
		for (String store : storeArr) {
			Top top = new Top();
			String namePinyin = PinYin4jUtils.hanziToPinyin(store, "");
			List<SortAmountByDate> list = new ArrayList<SortAmountByDate>();
			for (int i = d;; i++) {
				Date date = new Date(y, m, i);
				String thisdate = DateUtils.getyyyyMMdd(date);
				int thistime = Integer.parseInt(thisdate);
				if (endtime < thistime) {
					break;
				}
				RedisPojo redisPojo;
				SortAmountByDate sortAmountByDate = new SortAmountByDate();
				String string = jedis.hget(namePinyin + "DAY", thisdate);
				if (StringUtils.isNotBlank(string)) {
					redisPojo = GsonUtils.gson
							.fromJson(string, RedisPojo.class);
				} else {
					redisPojo = new RedisPojo();
					redisPojo.setDatetime(thisdate);
				}

				double amount = redisPojo.getGmv().doubleValue();
				sortAmountByDate.setAmount(amount);
				sortAmountByDate.setDate(thisdate);
				list.add(sortAmountByDate);
			}
			top.setName(store);
			top.setList(list);
			topList.add(top);
		}

		// DAY
		map.put("topList", topList);
		jedisPool.returnResource(jedis);
		return map;
	}

	@Override
	public Map<String, Object> getMonthofYear(String[] storeArr, Date begin,
			Date end) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Top> topList = new ArrayList<Top>();
		Jedis jedis = jedisPool.getResource();
		int m = begin.getMonth();
		int y = begin.getYear();
		int d = begin.getDate();
		String yyyyMM = DateUtils.getyyyyMM(end);
		int endtime = Integer.parseInt(yyyyMM);
		for (String store : storeArr) {
			Top top = new Top();
			String namePinyin = PinYin4jUtils.hanziToPinyin(store, "");
			List<SortAmountByDate> list = new ArrayList<SortAmountByDate>();
			for (int i = m;; i++) {
				Date date = new Date(y, i, d);
				String thisdate = DateUtils.getyyyyMM(date);
				int thistime = Integer.parseInt(thisdate);
				if (endtime < thistime) {
					break;
				}
				RedisPojo redisPojo;
				SortAmountByDate sortAmountByDate = new SortAmountByDate();
				String string = jedis.hget(namePinyin + "MONTH", thisdate);
				if (StringUtils.isNotBlank(string)) {
					redisPojo = GsonUtils.gson
							.fromJson(string, RedisPojo.class);
				} else {
					redisPojo = new RedisPojo();
					redisPojo.setDatetime(thisdate);
				}
				double amount = redisPojo.getGmv().doubleValue();
				sortAmountByDate.setAmount(amount);
				sortAmountByDate.setDate(thisdate);
				list.add(sortAmountByDate);
			}
			top.setName(store);
			top.setList(list);
			topList.add(top);
		}

		map.put("topList", topList);
		jedisPool.returnResource(jedis);
		return map;
	}

	@Override
	public Map<String, Object> getYear(String[] storeArr, int i, int j) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Top> topList = new ArrayList<Top>();
		Jedis jedis = jedisPool.getResource();
		for (String store : storeArr) {
			Top top = new Top();
			String namePinyin = PinYin4jUtils.hanziToPinyin(store, "");
			List<SortAmountByDate> list = new ArrayList<SortAmountByDate>();
			for (int k = i; k < j; k++) {

				RedisPojo redisPojo;
				SortAmountByDate sortAmountByDate = new SortAmountByDate();

				String string = jedis.hget(namePinyin + "YEAR", "" + k);
				if (StringUtils.isNotBlank(string)) {
					redisPojo = GsonUtils.gson
							.fromJson(string, RedisPojo.class);
				} else {
					redisPojo = new RedisPojo();
				}

				double amount = redisPojo.getGmv().doubleValue();
				sortAmountByDate.setAmount(amount);
				sortAmountByDate.setDate("" + k);
				list.add(sortAmountByDate);
			}
			top.setName(store);
			top.setList(list);
			topList.add(top);
		}

		// YEAR
		map.put("topList", topList);
		jedisPool.returnResource(jedis);
		return map;
	}

}
