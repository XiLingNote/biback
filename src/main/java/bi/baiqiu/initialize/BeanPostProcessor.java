package bi.baiqiu.initialize;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author bqhome
 * 
 *         新需求 新字段 修改所有业务方法
 * @param <V>
 *
 */
@Component
public class BeanPostProcessor<V> implements
		ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
	}
}
