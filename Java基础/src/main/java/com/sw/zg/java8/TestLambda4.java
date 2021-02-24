package com.sw.zg.java8;


import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

//方法引用
//https://blog.csdn.net/qingci_/article/details/106750644
//https://blog.csdn.net/weixin_43889466/article/details/89233499
public class TestLambda4 {


    //类型 	        语法 	                对应lambda表达式
    //构造器引用 	Class::new 	            (args) -> new 类名(args)
    //静态方法引用 	Class::static_method 	(args) -> 类名.static_method(args)
    //对象方法引用 	Class::method 	        (inst,args) -> 类名.method(args)
    //实例方法引用 	instance::method 	    (args) -> instance.method(args)


    /**
     *对象方法引用
     * 对象::method
     */
    @Test
    public void test01(){
//        List<String> wordsList = GetListData.wordsList;
        //上一章提到的
        //wordsList.forEach(s-> System.out.println(s));
        //wordsList.forEach(System.out::println);

        Date date = new Date();
        /*long time = date.getTime();
        System.out.println(time);*/
        //返回一个毫秒数的时间戳  1970-现在的毫秒数
        //进行对象方法引用之后
        Supplier<Long> getTime = date::getTime;
        Long aLong = getTime.get()/1000;
        System.out.println(aLong);
    }


    List<Employee> employees = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    // *对象方法引用
    // * 对象::method
    @Test
    public void test02(){
        Consumer<String> con = (x)-> System.out.println(x);
        con.accept("haha");
        System.out.println("========================");
        Consumer<String> con2 = System.out::println;
        con2.accept("嗯嗯");
    }
    @Test
    public void test03(){
        Employee employee = new Employee(101, "张三", 18, 9999.99);
        Supplier<String> supplier = () -> employee.getName();
        String s = supplier.get();
        System.out.println(s);

        System.out.println("===================");
        Supplier<Integer> sup2 = employee::getAge;
        System.out.println(sup2.get());

    }


    //静态方法引用
    //类::静态方法
    @Test
    public void test04(){
        Comparator<Integer> com = (x,y)->Integer.compare(x,y);
        int compare = com.compare(100, 20);
        System.out.println(compare);

        Comparator<Integer> com2 = Integer::compare;
        int compare1 = com2.compare(100, 100);
        System.out.println(compare1);
    }
    //类::实列方法
    //1610604282(1).jpg
    @Test
    public void test05(){
        BiPredicate<String,String> bp = (x,y)->x.equals(y);
        boolean test = bp.test("zhangsan", "zhangsan");
        System.out.println(test);

        BiPredicate<String,String> bp2 = String::equals;
        bp2.test("a","a");

    }

//构造器引用
    @Test
    public void test06(){
//        Supplier<Employee> sup = () ->new Employee();
//        Employee employee = sup.get();
//        Supplier<Employee> sup2 = Employee::new;
//        Employee employee1 = sup2.get();

    }

    //数组引用
    @Test
    public void test07(){
        Function<Integer,String[]> fun = (x)->new String[x];
        String[] apply = fun.apply(10);
        System.out.println(apply.length);

        Function<Integer,String[]> fun2 = String[]::new;
        System.out.println(fun2.apply(10).length);
    }
}
