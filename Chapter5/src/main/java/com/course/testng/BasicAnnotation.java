package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("这个是beforeMethod方法");
    }
    //最基本的注解，用来把方法标记为测试的一部分
    @Test
    public void testCase1(){
        System.out.println("这是测试用例1");

    }
    @Test
    public void testCase2(){
        System.out.println("这是测试用例2");

    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("这个是afterMethod方法");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("这是在类之前运行的方法");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("这是在类之后运行的方法");
    }

    @BeforeSuite
    public void beforeSuit(){
        System.out.println("BeforeSuite测试套件");
    }
    @AfterSuite
    public void afterSuit(){
        System.out.println("AfterSuit测试套件");
    }
}
