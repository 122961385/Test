package cn.sw.AOP.AspectJ;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "applicationContext5.xml");
        User user = (User) applicationContext.getBean("user");
        user.add();
    }
}
