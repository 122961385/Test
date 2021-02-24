package cn.sw.demo4;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
* @ClassName: SpringTest4
* @Description: TODO(Bean完整的生命周期)
* @author 张刚
* @date 2020年2月24日
*   1.instantiate bean对象实例化
	2.populate properties 封装属性
	3.如果Bean实现BeanNameAware 执行 setBeanName
	4.如果Bean实现BeanFactoryAware 或者 ApplicationContextAware 设置工厂 setBeanFactory 或者上下文对象 setApplicationContext
	5.如果存在类实现 BeanPostProcessor（后处理Bean） ，执行postProcessBeforeInitialization
	6.如果Bean实现InitializingBean 执行 afterPropertiesSet 
	7.调用<bean init-method="init"> 指定初始化方法 init
	8.如果存在类实现 BeanPostProcessor（处理Bean） ，执行postProcessAfterInitialization
	9.执行业务处理
	10.如果Bean实现 DisposableBean 执行 destroy
	11.调用<bean destroy-method="customerDestroy"> 指定销毁方法 customerDestroy
 */
public class SpringTest4 {

	@Test
	// Bean完整的生命周期
	public void demo1() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		CustomerService customerService = (CustomerService) applicationContext.getBean("customerService");
		customerService.add();
		customerService.find();
		applicationContext.close();
	}
}
