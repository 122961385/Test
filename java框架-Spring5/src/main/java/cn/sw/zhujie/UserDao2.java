package cn.sw.zhujie;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao2 implements UserDaoInterface{
    public void add() {
        System.out.println("我是UserDao2");
    }
}
