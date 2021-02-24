package cn.sw.demo1;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
/**
	* @ClassName: SpringTest1
	* @Description: TODO(Spring入门程序)
	* @author 张刚
	* @date 2020年2月23日
 */
public class SpringTest1 {

	@Test
	// 传统方式
	public void demo1() {
		// 造成程序紧密耦合
		HelloService helloService = new HelloServiceImpl();
		helloService.sayHello();
	}
	

	/**
	 * ioc 原理
	 * 1、xml配置文件，写需要实例化的对象路径
	 * 2、解析xml,用工厂类创建
	 * 进一步降低耦合度
	 * di 原理
	 * 1、依赖注入
	 * 讲的是属性的注入方法和对象的注入
	 */
	@Test
	// Spring开发
	public void demo2() {
		// 创建一个工厂类.
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");//如果不写，回去WEB-INF下去找配置文件。写好的话回去SRC下找该配置文件
		HelloService helloService = (HelloService) applicationContext
				.getBean("helloService");
		helloService.sayHello();
	}
	
	@Test
	// 加载磁盘路径下的配置文件:
	public void demo3() {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
				"applicationContext.xml");
		HelloService helloService = (HelloService) applicationContext
				.getBean("helloService");
		helloService.sayHello();
	}
	
	@Test
	public void demo4(){
		BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("applicationContext.xml"));
		HelloService helloService = (HelloService) beanFactory.getBean("helloService");
		helloService.sayHello();
	}
	
}
