package cn.sw.zhujie;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements UserDaoInterface{
    public void add() {
        System.out.println("添加到数据库了哈哈");
    }
}
