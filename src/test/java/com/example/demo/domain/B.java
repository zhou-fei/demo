package com.example.demo.domain;

/**
 *
 * User: Phil.
 * Date: 2018/10/19
 * Time: 13:43
 * Created by IntelliJ IDEA.
 */
public class B extends A{
    public B(){
        super();
        System.out.println("B");
    }
    static {
        System.out.println("B.static");
    }

    {
        System.out.println("B.block");
    }
}
