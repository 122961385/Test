package cn.sw.注解;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public void add() {
        System.out.println("添加到数据库了哈哈");
    }
}
