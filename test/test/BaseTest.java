package test;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTest {
	
	protected ApplicationContext applicationContext;
	
	@Before
	public void setUp(){
		applicationContext = new ClassPathXmlApplicationContext(new String[]{
				"config/spring-beans.xml",
				"config/spring-data.xml",
				"config/spring-hibernate.xml",
				"config/spring-servlet.xml",
				"config/hibernate.cfg.xml"
		});
	}
}
