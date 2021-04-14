package com.github.sweet.staticproxy;


public class Student implements Person {
    private String name;

    public Student(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void giveHomework() {
        System.out.println(name + "上交家庭作业");
    }
}
