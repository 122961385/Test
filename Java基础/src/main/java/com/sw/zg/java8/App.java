package com.sw.zg.java8;

import org.junit.Test;

import java.util.*;

public class App {

    List<Employee> employees = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );
    //练习1
    @Test
    public void test1(){
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee s1, Employee s2) {
                // 升序
//                return s1.getAge()-s2.getAge();
                // 降序
                // return s2.getAge()-s1.getAge();
                 return Integer.compare(s2.getAge(),s1.getAge());
            }
        });

        for(Employee employee:employees){
            System.out.println(employee.getAge());
        }
    }



    @Test
    public void test3(){
        List<Employee> employeeList = filterEmployee2(this.employees);
        for(Employee employee: employeeList){
            System.out.println(employee);
        }
    }

    //年薪大于35的
    public List<Employee>  filterEmployee(List<Employee> list){
        List<Employee> emp = new ArrayList<>();
        for (Employee ee:list){
            if(ee.getAge()>=35){
                emp.add(ee);
            }
        }
        return emp;
    }

    //工资大于5000
    public List<Employee>  filterEmployee2(List<Employee> list){
        List<Employee> emp = new ArrayList<>();
        for (Employee ee:list){
            if(ee.getSalary()>=5000){
                emp.add(ee);
            }
        }
        return emp;
    }

    //优化方式1  策略模式
    @Test
    public void test4(){
//        List<Employee> employeeList = filterEmployee(this.employees,new FilterEmployByAge());
//        for(Employee employee: employeeList){
//            System.out.println(employee);
//        }

        List<Employee> employeeListSala = filterEmployee(this.employees,new FilterEmployBySalary());
        for(Employee employee: employeeListSala){
            System.out.println(employee);
        }

    }

    public List<Employee>  filterEmployee(List<Employee> list,Mypredicate<Employee> mp){
        List<Employee> emp = new ArrayList<>();
        for (Employee employee:list) {
            if(mp.test(employee))
                emp.add(employee);
        }
        return emp;
    }


    //优化方式2 匿名内部类
    @Test
    public void test5(){
        List<Employee> list = filterEmployee(this.employees, new Mypredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() > 30;
            }
        });

        for (Employee employee : list){
            System.out.println(employee);
        }
    }

    //优化方式3  Lambda表达式
    @Test
    public void test6(){
        List<Employee> list = filterEmployee(this.employees, (e) -> e.getSalary() > 5000);

        list.forEach(System.out::println);
    }

    //优化方式4  StreamAPI
    @Test
    public void test7(){
        employees.stream()
                .filter((e) -> e.getSalary() > 5000)
                .limit(3)
                .forEach(System.out::println);
        System.out.println("==========================");
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

    }
    }
