package bi.baiqiu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bi.baiqiu.mapper.DailyTargetMapper;
import bi.baiqiu.pojo.DailyTarget;
@Transactional
@Service
public class DailyTargetService {
		@Autowired
		private DailyTargetMapper dailyTargetDao;
		
		/**插入单条日计划
		 * @param dailyTarget
		 * @throws Exception
		 */
		public void insertDailyTarget(DailyTarget dailyTarget) throws Exception{
			dailyTargetDao.insert(dailyTarget);
		}
		/**插入多条日计划
		 * @param list
		 * @return
		 * @throws Exception
		 */
		public int insertDailyTargetByBatch(List<DailyTarget>list) throws Exception{
			return dailyTargetDao.insertByBatch(list);
		}
}
