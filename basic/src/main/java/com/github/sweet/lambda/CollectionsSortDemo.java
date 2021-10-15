package com.github.sweet.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author sweet
 * @description
 * @date 2021/10/15 10:14
 */
public class CollectionsSortDemo {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
                new Person(25, 10000, "zhangsan"),
                new Person(23, 12000, "lisi"),
                new Person(28, 6000, "wangwu"),
                new Person(22, 8000, "zhaoliu")
        );

        Collections.sort(list, (emp1, emp2) -> {
            if (emp1.getAge() > emp2.getAge()) {
                return Integer.compare(emp1.getSalary(), emp2.getSalary());
            } else {
                return emp1.getName().compareTo(emp2.getName());
            }
        });
    }
}

class Person {
    private int age;
    private int salary;
    private String name;

    public Person(int age, int salary, String name) {
        this.age = age;
        this.salary = salary;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}