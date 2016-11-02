package redis;

import java.util.List;

public interface RedisService {
	
	public void saveObject(Object input,String keywords);
	
	public void saveList(List<?> list,String keywords);
	
	public void delObject(String keywords);
	
	public Object getObject(String keywords);
	
	public List<?> getList(String keywords);

}
