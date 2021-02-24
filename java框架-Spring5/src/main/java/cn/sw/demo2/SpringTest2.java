package cn.sw.demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
* @ClassName: SpringTest2
* @Description: TODO(Spring  Bean的三种实例化方式)
* @author 张刚
* @date 2020年2月24日
 */
public class SpringTest2 {

	@Test
	// 无参数的构造方法的实例化
	public void demo1() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean1 bean1 = (Bean1) applicationContext.getBean("bean1");
		System.out.println(bean1);
	}

	/**
	 * 遇到一个神奇的Bug
	 * 主要是因为spring版本与Java版本以对应导致的，我刚才前面提到的我一开始手痒在升级tomcat的时候对jdk也做了升级，就是这个操作导致了这个错误，这个地方需要记住两点
		spring 3.X版本支持到java7
		spring 4.X版本支持Java8最低支持到Java6
	 */
	@Test
	// 静态工厂实例化
	public void demo2() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean2 bean2 = (Bean2) applicationContext.getBean("bean2");
		System.out.println(bean2);
	}

	@Test
	// 实例工厂实例化
	public void demo3() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean3 bean3 = (Bean3) applicationContext.getBean("bean3");
		System.out.println(bean3);
	}
}