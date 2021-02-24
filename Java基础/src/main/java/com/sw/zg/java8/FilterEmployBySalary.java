package com.sw.zg.java8;

public class FilterEmployBySalary implements Mypredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() >= 5000 ? true : false;
    }


}
