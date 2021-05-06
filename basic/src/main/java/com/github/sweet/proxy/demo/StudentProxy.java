package com.github.sweet.proxy.demo;

/**
 * 代理类
 */
public class StudentProxy implements Person {
    private Student stu;

    public StudentProxy(Person person){
        if (person.getClass() == Student.class) {
            this.stu = (Student) person;
        }
    }

    @Override
    public void giveHomework() {
        stu.giveHomework();
    }
}
