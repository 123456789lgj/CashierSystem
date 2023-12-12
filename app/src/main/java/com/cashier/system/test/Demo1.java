package com.cashier.system.test;

public class Demo1 {
    public static void main(String[] args) {
        String name = Demo1.class.getName();
        String canonicalName = Demo1.class.getCanonicalName();
        String name1 = byte[].class.getName();
        String canonicalName1 = byte[].class.getCanonicalName();
        System.out.println("111 name :" + name);
        System.out.println("111 canonicalName :" + canonicalName);
        System.out.println("111 name1 :" + name1);
        System.out.println("111 canonicalName1 :" + canonicalName1);

//        111 name :com.cashier.system.test.Demo1
//        111 canonicalName :com.cashier.system.test.Demo1
//        111 name1 :[B
//        111 canonicalName1 :byte[]
    }
}
