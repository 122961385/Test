package cn.sw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("cn.sw.mappers")
@EnableTransactionManagement
public class HelloWorldMainApplication {
    public static void main(String[] args) {
        //Spring应用启动
        SpringApplication.run(HelloWorldMainApplication.class, args);
    }
}
