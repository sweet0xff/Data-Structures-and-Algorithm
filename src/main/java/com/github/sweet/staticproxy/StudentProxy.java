package com.github.sweet.staticproxy;

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

    public void giveHomework() {
        stu.giveHomework();
    }
}
