package com.example.demo.controller;

public class Person {
    private String name;
    public int age;

    public Person() {
        System.out.println("Person的无参构造方法被调用");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person的有参构造方法被调用: " + name + ", " + age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void secretMethod() {
        System.out.println("这是一个私有方法！");
    }

    public void sayHello(String greeting) {
        System.out.println(greeting + ", 我是 " + name + "，今年 " + age + " 岁。");
    }
}
