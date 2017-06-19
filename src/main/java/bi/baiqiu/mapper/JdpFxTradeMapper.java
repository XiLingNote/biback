package bi.baiqiu.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import bi.baiqiu.pojo.JdpFxTrade;
import bi.baiqiu.pojo.SuperPojo;

import com.github.abel533.mapper.Mapper;

/**
 * @author bqhome
 *	订单实体类对应的Mapper接口 
 */
public interface JdpFxTradeMapper extends Mapper<JdpFxTrade> {
	

	/**
	 * @return
	 * 查询订单最早日期
	 */
	Date selectMinDate();

}
