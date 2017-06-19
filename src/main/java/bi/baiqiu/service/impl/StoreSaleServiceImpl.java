package bi.baiqiu.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import bi.baiqiu.pojo.RedisPojo;
import bi.baiqiu.pojo.SortShop;
import bi.baiqiu.pojo.SortShopDrillDown;
import bi.baiqiu.service.StoreSaleService;
import bi.baiqiu.utils.DateUtils;
import bi.baiqiu.utils.GsonUtils;
import bi.baiqiu.utils.PinYin4jUtils;

@SuppressWarnings("all")
@Service("storeSaleService")
public class StoreSaleServiceImpl implements StoreSaleService {

	@Autowired
	private JedisPool jedisPool;

	/**
	 * 查询当月的店铺销售排名
	 */

	@Override
	public Map<String, Object> queryThisMonth(String type) {

		Map<String, Object> map = new HashMap<String, Object>();
		Jedis jedis = jedisPool.getResource();
		Date date = new Date();
		int day = date.getDate();
		String yyyyMM = DateUtils.getyyyyMM(date);
		int j = Integer.parseInt(yyyyMM) - 1;
		String jStr = "" + j;
		Set<String> stores = jedis.smembers("store");
		Set<String> set = new HashSet<String>();
		for (String string : stores) {
			Set<String> depart = jedis.smembers(string);
			set.addAll(depart);
		}

		TreeSet<SortShop> treeSet = new TreeSet<SortShop>();
		for (String shopName : set) {

			String namePinyin = PinYin4jUtils.hanziToPinyin(shopName, "");
			String dataString = jedis.hget(namePinyin + "MONTH", jStr);

			String name = null;
			try {

				name = URLEncoder.encode(shopName, "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			if (StringUtils.isNotBlank(dataString)) {
				RedisPojo redisPojo = GsonUtils.gson.fromJson(dataString,
						RedisPojo.class);
				double value;
				if (type.equals("GMV")) {

					value = redisPojo.getGmv().doubleValue();
				} else {
					value = redisPojo.getAlipay().doubleValue();
				}

				double b = 0.0;
				if (b == value) {
					continue;
				}
				
				SortShop sortShop = new SortShop();
				sortShop.setAmount(value);
				sortShop.setShopName(name);
				sortShop.setId(namePinyin);
				treeSet.add(sortShop);

			}

		}

		map.put("set", treeSet);
		List<SortShopDrillDown> arrayList = new ArrayList<SortShopDrillDown>();

		for (String shopName : set) {
			SortShopDrillDown drillDown = new SortShopDrillDown();
			String name = null;
			String id = null;
			try {

				name = URLEncoder.encode(shopName, "utf-8");
				id = PinYin4jUtils.hanziToPinyin(shopName, "");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			drillDown.setId(id);
			drillDown.setShopName(name);

			List<RedisPojo> redisList = new ArrayList<RedisPojo>();
			for (int i = 1; i <= 31; i++) {
				String yyyyMMdd = (i < 9) ? jStr + "0" + i : jStr + i;
				String dataString = jedis.hget(id + "DAY", yyyyMMdd);
				if (StringUtils.isNotBlank(dataString)) {
					RedisPojo fromJson = GsonUtils.gson.fromJson(dataString,
							RedisPojo.class);
					redisList.add(fromJson);
				}
			}
			drillDown.setList(redisList);
			arrayList.add(drillDown);
		}
		map.put("arrayList", arrayList);

		jedisPool.returnResource(jedis);
		return map;
	}

	@Override
	public Map<String, Object> queryByThisDay(Date date, String type) {
		Map<String, Object> map = new HashMap<String, Object>();
		TreeSet<SortShop> treeSet = new TreeSet<SortShop>();
		if (date == null) {
			date = new Date();
		}
		// redis field
		String yyyyMMdd = DateUtils.getyyyyMMdd(date);
		// 获取redis客户端
		Jedis jedis = jedisPool.getResource();
		// 部门集合
		Set<String> stores = jedis.smembers("store");
		Set<String> set = new HashSet<String>();
		// 获取店铺名称集合
		for (String string : stores) {
			Set<String> depart = jedis.smembers(string);
			set.addAll(depart);
		}

		for (String shopName : set) {
			String namePinyin = PinYin4jUtils.hanziToPinyin(shopName, "");
			String dataString = jedis.hget(namePinyin + "DAY", yyyyMMdd);

			String name = null;
			try {
				name = URLEncoder.encode(shopName, "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			if (StringUtils.isNotBlank(dataString)) {
				RedisPojo redisPojo = GsonUtils.gson.fromJson(dataString,
						RedisPojo.class);
				double value;
				if (type.equals("GMV")) {

					value = redisPojo.getGmv().doubleValue();
				} else {
					value = redisPojo.getAlipay().doubleValue();
				}
				double b = 0.0;
				if (b == value) {
					continue;
				}
				SortShop sortShop = new SortShop();
				sortShop.setAmount(value);
				sortShop.setShopName(name);
				sortShop.setId(namePinyin);
				treeSet.add(sortShop);
			}
		}

		map.put("set", treeSet);
		jedisPool.returnResource(jedis);
		return map;
	}

	/**
	 * 
	 * 按天查询记录
	 * 
	 * */
	@Override
	public Map<String, Object> getDayOfMonth(String store, Date begin, Date end) {

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

			/*
			 * if (date.after(end)) { break; }
			 */
			String string = jedis.hget(store + "DAY", thisdate);
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
	public Map<String, Object> getMonthofYear(String store, Date begin, Date end) {
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
			String string = jedis.hget(store + "MONTH",
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
	public Map<String, Object> getYear(String store, int y1, int y2) {
		Map<String, Object> map = new HashMap<String, Object>();
		Set<RedisPojo> treeSet = new TreeSet<RedisPojo>();
		Jedis jedis = jedisPool.getResource();
		for (int i = y1; i <= y2; i++) {
			String string = jedis.hget(store + "YEAR", "" + i);
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
	public Set<String> queryStoreName() {
		Jedis jedis = jedisPool.getResource();
		Set<String> departNameSet = jedis.smembers("store");

		Set<String> storeNameSet = new HashSet<String>();

		Set<String> storeNameReturn = new HashSet<String>();

		for (String departName : departNameSet) {
			Set<String> shoes = jedis.smembers(departName);
			storeNameSet.addAll(shoes);
		}

		for (String shopName : storeNameSet) {
			try {
				String name = URLEncoder.encode(shopName, "utf-8");
				storeNameReturn.add(name);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

		}
		jedisPool.returnResource(jedis); 
		return storeNameReturn;
	}

}
