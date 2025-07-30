package com.example.demo.controller;

public class SharedResource {
    private int value = 0;
    private final Object lock = new Object(); // 作为锁的对象

    public void modifyValue(int delta) {
        synchronized (lock) {
            value += delta;
            System.out.println(Thread.currentThread().getName() + " modified value to: " + value);
       }
    }

    public int getValue() {
        synchronized (lock) {
            return value;
        }

    }
}
