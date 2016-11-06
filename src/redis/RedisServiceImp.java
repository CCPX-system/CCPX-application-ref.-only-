package redis;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.metamodel.source.hbm.Helper.ValueSourcesAdapter;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

@Service("redisService")
public class RedisServiceImp implements RedisService{
	
	@Resource(name="redisTemplate")
	private RedisTemplate<String, String> redisTemplate;
	
	@Override
	public void saveList(List<?> list, String keywords) {
		
		
	}

	@Override
	public void delObject(String keywords) {
		ValueOperations<String, String> valueop= redisTemplate.opsForValue();
		RedisOperations<String, String> op=valueop.getOperations();
		op.delete(keywords);
		
	}

	@Override
	public Object getObject(String keywords) {
		ValueOperations<String, String> valueop= redisTemplate.opsForValue();
		String json=valueop.get(keywords);
		Object result=JSON.parse(json);
		return result;
	}

	@Override
	public List<?> getList(String keywords) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveObject(Object input, String keywords) {
		// TODO Auto-generated method stub

		ValueOperations<String, String> valueop= redisTemplate.opsForValue();
		
		String json=JSON.toJSONString(input);

		valueop.set(keywords, json);
	}

	

}
