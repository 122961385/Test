package cn.sw.third;

import cn.sw.first.Employee;
import cn.sw.second.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Map;

public class Test3 {

    //查找
    @Test
    public void test1() throws Exception{
        String resource = "mybatis-config3.xml";
        // 加载配置文件到输入 流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getEmployeeById(2);
        sqlSession.close();
        System.out.println(employee.toString());
    }

    //新增
    @Test
    public void test2() throws Exception{
        String resource = "mybatis-config3.xml";
        // 加载配置文件到输入 流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper3 mapper3 = sqlSession.getMapper(EmployeeMapper3.class);
        Employee employee1 = new Employee("11121", "111", "123", "234");
        Long aLong = mapper3.addEmp(employee1);
        sqlSession.commit();
        //https://baijiahao.baidu.com/s?id=1654584636719216432&wfr=spider&for=pc
        System.out.println(employee1.getId());
    }

    //更新
    @Test
    public void test3() throws Exception{
        String resource = "mybatis-config3.xml";
        // 加载配置文件到输入 流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper3 mapper3 = sqlSession.getMapper(EmployeeMapper3.class);
        Employee employee1 = new Employee("11121", "111", "123", "234");
        Long aLong = mapper3.updateEmp(employee1);
        sqlSession.commit();
        //https://baijiahao.baidu.com/s?id=1654584636719216432&wfr=spider&for=pc
        System.out.println(aLong);
    }

    //删除
    @Test
    public void test4() throws Exception{
        String resource = "mybatis-config3.xml";
        // 加载配置文件到输入 流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper3 mapper3 = sqlSession.getMapper(EmployeeMapper3.class);
        Long aLong = mapper3.delEmpById(335438);
        sqlSession.commit();
        //https://baijiahao.baidu.com/s?id=1654584636719216432&wfr=spider&for=pc
        System.out.println(aLong);
    }

    //多参数查询
    @Test
    public void test5() throws Exception{
        String resource = "mybatis-config3.xml";
        // 加载配置文件到输入 流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper3 mapper = sqlSession.getMapper(EmployeeMapper3.class);
        Employee employee = mapper.getEmployeeByIdANDsIDNO(335439,"11121");
        //实体，map,to
        sqlSession.close();
        System.out.println(employee.toString());
    }

    @Test
    public void test6() throws Exception{
        String resource = "mybatis-config3.xml";
        // 加载配置文件到输入 流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper3 mapper = sqlSession.getMapper(EmployeeMapper3.class);
        Map<Integer, Employee> empByIdReturnMap = mapper.getEmpByIdReturnMap(335439);
        System.out.println(empByIdReturnMap.get(335439));
        sqlSession.close();
    }

    //resultType  返回Map
    @Test
    public void test7() throws Exception{
        String resource = "mybatis-config3.xml";
        // 加载配置文件到输入 流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper3 mapper = sqlSession.getMapper(EmployeeMapper3.class);
        Map<String, Object> empByIdresultMap = mapper.getEmpByIdresultType(335439);
        System.out.println(empByIdresultMap.get("sIDNO"));
        sqlSession.close();
    }
}
