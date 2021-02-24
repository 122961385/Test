package cn.sw.JdbcTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "applicationContext6.xml");
        BookService user = (BookService) applicationContext.getBean("bookService");
        System.out.println("你好啊啊啊啊");
    }
}
