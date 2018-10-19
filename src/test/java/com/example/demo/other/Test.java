package com.example.demo.other;

import com.example.demo.model.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 传值引用
 * User: Phil.
 * Date: 2018/7/20
 * Time: 9:17
 * Created by IntelliJ IDEA.
 */
public class Test {
	@org.junit.Test
	public void test1() {
		Integer i = new Integer(0);

		add(i);

		System.out.println(i);
		i += 3;

		System.out.println(i);
	}

	private void add(Integer i) {
		i = i + 3;
		i = new Integer(i);
	}


    @org.junit.Test
    public void test2() {
        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(3);
        System.out.println(a.size());
        addd(a);


        System.out.println(a.size());
    }

    private void addd(List<Integer> a) {
        a.add(5);
        a = new ArrayList<>();
        a.add(55);
    }

    @org.junit.Test
    public void test23(){
        System.out.println(4<<3);
        String[] strings = {"aaa","bbb","ccc"};
        System.out.println(strings.length);

        System.out.println("kaishi");
        for(int i=0;i<10;i++){
            ojbk:for(int j=0;j<10;j++){
                System.out.println("i="+i+",j="+j);
                if(j==5){
                    break ojbk;//跳到循环外的ok出，即终止整个循环
                }
            }
        }
        System.out.println("jieshu");
    }

    @org.junit.Test
    public void tt(){
        User user = new User();
        user.setName("1");
        t(user);
        System.out.println(user.getName());
    }

    private void t(User user){
        user = new User();
        user.setName("xxxx");
    }
}
