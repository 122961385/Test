package cn.sw.demo5;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
* @ClassName: SpringTest5
* @Description: TODO(类的属性--变量和对象的注入)
* @author 张刚
* @date 2020年2月24日
 */
public class SpringTest5 {
	
	@Test
	public void demo1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Car car = (Car) applicationContext.getBean("car");
		System.out.println(car.toString());
	}
	
	@Test
	public void demo2(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Car2 car2 = (Car2) applicationContext.getBean("car2");
		System.out.println(car2.toString());
	}
	
	@Test
	public void demo3(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person);
	}
	
	
}
