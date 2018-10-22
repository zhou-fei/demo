package com.example.demo.domain;


/**
 *
 * User: Phil.
 * Date: 2018/10/19
 * Time: 13:43
 * Created by IntelliJ IDEA.
 */
public class A {

    public A(){
        System.out.println("A");
    }
    static {
        System.out.println("A.static");
    }

    {
        System.out.println("A.block");
    }
}
