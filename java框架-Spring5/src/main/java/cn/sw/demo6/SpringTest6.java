package cn.sw.demo6;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
* @ClassName: SpringTest6
* @Description: TODO(bean的集合属性的注入)
* @author 张刚
* @date 2020年2月25日
*
 */
public class SpringTest6 {

	@Test
	public void demo1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		CollectionBean collectionBean = (CollectionBean) applicationContext.getBean("collectionBean");
		System.out.println(collectionBean);
	}
}
