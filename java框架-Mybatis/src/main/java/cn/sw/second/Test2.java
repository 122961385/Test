package cn.sw.second;

import cn.sw.first.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test2 {

    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config2.xml";
        // 加载配置文件到输入 流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getEmployeeById(2);
        System.out.println(employee.toString());
    }
}
