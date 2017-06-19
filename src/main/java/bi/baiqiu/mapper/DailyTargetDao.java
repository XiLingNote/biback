package bi.baiqiu.mapper;

import java.util.List;

import com.github.abel533.mapper.Mapper;

import bi.baiqiu.page.PageBean;
import bi.baiqiu.pojo.DailyTarget;

public interface DailyTargetDao extends Mapper<DailyTarget> {
	
	
	public List<DailyTarget> queryDailyTarget(DailyTarget daily,PageBean page);
	public List<DailyTarget> queryDailyTargetTest();


	/**批量增加日计划
	 * @param list
	 * @return
	 */
	public int insertByBatch(List<DailyTarget> list);
}
