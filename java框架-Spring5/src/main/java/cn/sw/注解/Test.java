package cn.sw.注解;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 对象创建注解
 * Component
 * Controller：一般用在表现层
 * Service：一般用在业务层
 * Repository：一般用在持久层
 * 属性注入注解
 *@Autowired默认按照类型进行注入
 *@Qualifier指定注入Bean的名称
 *@Resaruce既可以根据类型又可以根据名称注入
 *@Value注入普通属性
 */

public class Test {
    @org.junit.Test
    // Spring开发
    public void demo1() {
        // 创建一个工厂类.
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "applicationContext3.xml");//如果不写，回去WEB-INF下去找配置文件。写好的话回去SRC下找该配置文件
        UserService helloService = (UserService) applicationContext
                .getBean("userService");
        helloService.add();
    }
}
