package bi.baiqiu.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import bi.baiqiu.pojo.RedisPojo;
import bi.baiqiu.service.RedisService;
import bi.baiqiu.utils.DateUtils;
import bi.baiqiu.utils.GsonUtils;

@Service("redisService")
public class RedisServiceImpl implements RedisService {
	@Autowired
	JedisPool jedisPool;

//	@Autowired
//	private Jedis jedisService;

	/**
	 * 查询范围 : 默认当前月
	 */
	@SuppressWarnings("deprecation")
	@Override
	public Map<String, Object> getThisMonth(String department) {
		Map<String, Object> map = new HashMap<String, Object>();
		Set<RedisPojo> treeSet = new TreeSet<RedisPojo>();
		// 当月天数
//		int maxDay = Calendar.getInstance().getActualMaximum(Calendar.DATE);
		
		Date today = new Date();
		int date = today.getDate();
		String yyyyMM = DateUtils.getyyyyMM(today);
		String lastyyyyMM = DateUtils.getLastyyyyMM(today);
		Jedis jedis = jedisPool.getResource();
		for (int i = 1;i<=date; i++) {
			String dd = (i > 9) ? "" + i : "0" + i;
			String yyyyMMdd = yyyyMM + dd;
			String stringPojo = jedis.hget(department+"DAY", yyyyMMdd);
			if (stringPojo != null) {
				RedisPojo index = GsonUtils.gson.fromJson(stringPojo,
						RedisPojo.class);

				treeSet.add(index);
			} else {
				RedisPojo index = new RedisPojo();
				index.setDatetime(yyyyMMdd);
				treeSet.add(index);
			}

		}
		RedisPojo last = new RedisPojo();
		String lastPojo = jedis.hget("AllMONTH", lastyyyyMM);
		if (lastPojo != null) {
			last = GsonUtils.gson.fromJson(lastPojo, RedisPojo.class);
		}
		map.put("treeSet", treeSet);
		map.put("last", last);
		jedisPool.returnResource(jedis); 
		return map;
	}

	/**
	 * 查询当月数据 并且带有同比 按day排序
	 */
	@SuppressWarnings("deprecation")
	@Override
	public Map<String, Object> getDayofWholeMonth(String department, Date end) {
		Map<String, Object> map = new HashMap<String, Object>();
		Set<RedisPojo> treeSet = new TreeSet<RedisPojo>();
		int date2 = end.getDate();
		int y = end.getYear();
		int m = end.getMonth();
		Jedis jedis = jedisPool.getResource();
		for (int i = 1; i < date2 + 1; i++) {
			String yyyyMMdd = DateUtils.getyyyyMMdd(new Date(y, m, i));
			String string = jedis.hget(department + "DAY", yyyyMMdd);
			if (StringUtils.isNotBlank(string)) {
				RedisPojo redisPojo = GsonUtils.gson.fromJson(string,
						RedisPojo.class);
				redisPojo.setAlipayCompleteness();
				redisPojo.setCompleteness();
				treeSet.add(redisPojo);
			}
		}

		map.put("treeSet", treeSet);
		// 获取同比数据
		String mm = DateUtils.getLastyyyyMM(end);
		String string = jedis.hget(department + "MONTH", mm);
		if (StringUtils.isNotBlank(string)) {
			RedisPojo redisPojo = GsonUtils.gson.fromJson(string,
					RedisPojo.class);
			redisPojo.setAlipayCompleteness();
			redisPojo.setCompleteness();
			map.put("last", redisPojo);
		}
		jedisPool.returnResource(jedis); 
		return map;
	}

	@Override
	public Map<String, Object> getDayOfMonth(String department, Date begin,
			Date end) {
		Map<String, Object> map = new HashMap<String, Object>();
		Set<RedisPojo> treeSet = new TreeSet<RedisPojo>();
		Jedis jedis = jedisPool.getResource();
		int d = begin.getDate();
		int m = begin.getMonth();
		int y = begin.getYear();
		String getyyyyMMdd = DateUtils.getyyyyMMdd(end);
		int endtime = Integer.parseInt(getyyyyMMdd);
		for (int i = d;; i++) {
			Date date = new Date(y, m, i);
			String thisdate = DateUtils.getyyyyMMdd(date);
			int thistime = Integer.parseInt(thisdate);
			if (endtime < thistime) {
				break;
			}
			String string = jedis.hget(department + "DAY", thisdate);
			if (StringUtils.isNotBlank(string)) {
				RedisPojo redisPojo = GsonUtils.gson.fromJson(string,
						RedisPojo.class);
				redisPojo.setAlipayCompleteness();
				redisPojo.setCompleteness();
				treeSet.add(redisPojo);
			}

		}
		map.put("treeSet", treeSet);
		map.put("last", null);
		jedisPool.returnResource(jedis); 
		return map;
	}

	@Override
	public Map<String, Object> getMonthofWholeYear(String department, int y1) {
		Map<String, Object> map = new HashMap<String, Object>();
		Set<RedisPojo> treeSet = new TreeSet<RedisPojo>();
		Jedis jedis = jedisPool.getResource();
		for (int i = 1; i < 13; i++) {
			String field = (i < 10) ? y1 + "0" + i : "" + y1 + i;
			String string = jedis.hget(department + "MONTH", field);
			if (StringUtils.isNotBlank(string)) {
				RedisPojo redisPojo = GsonUtils.gson.fromJson(string,
						RedisPojo.class);
				redisPojo.setAlipayCompleteness();
				redisPojo.setCompleteness();
				treeSet.add(redisPojo);
			}
		}
		map.put("treeSet", treeSet);
		String string = jedis.hget(department + "YEAR", y1 - 1 + "");
		if (StringUtils.isNotBlank(string)) {
			RedisPojo redisPojo = GsonUtils.gson.fromJson(string,
					RedisPojo.class);
			redisPojo.setAlipayCompleteness();
			redisPojo.setCompleteness();
			map.put("redisPojo", redisPojo);
		}
		jedisPool.returnResource(jedis); 
		return map;
	}

	@Override
	public Map<String, Object> getMonthofYear(String department, Date begin,
			Date end) {
		Jedis jedis = jedisPool.getResource();
		Map<String, Object> map = new HashMap<String, Object>();
		Set<RedisPojo> treeSet = new TreeSet<RedisPojo>();
		int y = begin.getYear();
		int m = begin.getMonth();
		int d = begin.getDate();
		for (int i = m;; i++) {
			Date date = new Date(y, i, d);
			if (date.after(end)) {
				break;
			}
			String string = jedis.hget(department + "MONTH",
					DateUtils.getyyyyMM(date));
			if (StringUtils.isNotBlank(string)) {
				RedisPojo redisPojo = GsonUtils.gson.fromJson(string,
						RedisPojo.class);
				redisPojo.setAlipayCompleteness();
				redisPojo.setCompleteness();
				treeSet.add(redisPojo);
			}
		}
		map.put("treeSet", treeSet);
		jedisPool.returnResource(jedis); 
		return map;
	}

	@Override
	public Map<String, Object> getWholeYear(String department, int y2) {
		Map<String, Object> map = new HashMap<String, Object>();
		Set<RedisPojo> treeSet = new TreeSet<RedisPojo>();
		Jedis jedis = jedisPool.getResource();
		String string = jedis.hget(department + "YEAR", "" + y2);
		if (StringUtils.isNotBlank(string)) {
			RedisPojo redisPojo = GsonUtils.gson.fromJson(string,
					RedisPojo.class);
			redisPojo.setAlipayCompleteness();
			redisPojo.setCompleteness();
			treeSet.add(redisPojo);
		}
		map.put("treeSet", treeSet);
		
		String string2 = jedis.hget(department + "YEAR", y2 - 1 + "");
		if (StringUtils.isNotBlank(string)) {
			RedisPojo RedisPojo2 = GsonUtils.gson.fromJson(string2,
					RedisPojo.class);
			RedisPojo2.setAlipayCompleteness();
			RedisPojo2.setCompleteness();
			map.put("last", RedisPojo2);
		}
		jedisPool.returnResource(jedis); 
		return map;
	}

	@Override
	public Map<String, Object> getYear(String department, int y1, int y2) {
		Map<String, Object> map = new HashMap<String, Object>();
		Set<RedisPojo> treeSet = new TreeSet<RedisPojo>();
		Jedis jedis = jedisPool.getResource();
		for (int i = y1; i <= y2; i++) {
			String string = jedis.hget(department + "YEAR", "" + i);
			if (StringUtils.isNotBlank(string)) {
				RedisPojo redisPojo = GsonUtils.gson.fromJson(string,
						RedisPojo.class);
				redisPojo.setAlipayCompleteness();
				redisPojo.setCompleteness();
				treeSet.add(redisPojo);
			}
		}
		map.put("treeSet", treeSet);
		jedisPool.returnResource(jedis); 
		return map;
	}
}
