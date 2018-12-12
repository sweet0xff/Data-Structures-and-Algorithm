package com.github.zengge95.staticproxy;

public class StaticProxyTest {
    public static void main(String[] args) {
        Person student = new Student("李四");

        //生成代理类
        Person proxyPerson = new StudentProxy(student);

        proxyPerson.giveHomework();
    }
}
