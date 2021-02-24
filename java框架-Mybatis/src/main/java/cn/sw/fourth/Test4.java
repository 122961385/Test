package cn.sw.fourth;

import cn.sw.first.Employee;
import cn.sw.second.EmployeeMapper;
import cn.sw.third.EmployeeMapper3;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Map;

public class Test4 {

    //多表关联查询
    @Test
    public void test1() throws Exception{
        String resource = "mybatis-config4.xml";
        // 加载配置文件到输入 流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper4 mapper = sqlSession.getMapper(EmployeeMapper4.class);

        sqlSession.close();
    }

}
