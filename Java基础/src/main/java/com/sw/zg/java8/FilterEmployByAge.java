package com.sw.zg.java8;

public class FilterEmployByAge implements Mypredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        boolean b = employee.getAge() >= 35 ? true : false;
        return b;
    }


}
