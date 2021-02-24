package cn.sw.first;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * 最原始的方式
 */
public class Test {

    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        // 加载配置文件到输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Employee employee = (Employee)sqlSession.selectOne("test.selectEmp", 1);
        System.out.println(employee.toString());
        sqlSession.close();
    }
}
