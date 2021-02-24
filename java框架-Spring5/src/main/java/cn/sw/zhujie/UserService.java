package cn.sw.zhujie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//value值可以不写，默认类首字母小写
@Service(value = "userService")
public class UserService {


//    @Qualifier(value = "userDao")
    @Autowired
    private UserDaoInterface userDao;

//    @Resource  本是不是Spring的注解，是javax的注解
//    private UserDao userDao;
    @Value("张刚")
    private String name;

    public void add(){
        System.out.println(name+"调用了add方法");
        userDao.add();
    }
}
