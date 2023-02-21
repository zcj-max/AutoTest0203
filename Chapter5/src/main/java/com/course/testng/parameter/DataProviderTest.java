package com.course.testng.parameter;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {

    @Test(dataProvider = "data")
    public void testDataProvider(String name ,int age){
        System.out.println("name = " + name + ";age = " + age);
    }

    @DataProvider(name = "data")
    public Object [][] providerData(){
        Object [][] o = new Object[][]{{"郑传杰",32},{"硕硕",18},{"世界你好",18}};
        return  o;
    }

    @Test(dataProvider = "methodData")
    public void test1(String name ,int age){
        System.out.println("test11111方法的name = " + name + ";age = " + age);
    }

    @Test(dataProvider = "methodData")
    public void test2(String name ,int age){
        System.out.println("test222222方法的name = " + name + ";age = " + age);
    }
    @DataProvider(name = "methodData")
    public Object [][] methodDataTest(Method method){
        Object [][] result = null;
        if(method.getName().equals("test1")){
            result = new Object [][]{{"郑传杰",32},{"硕硕",18}};
        }else if(method.getName().equals("test2")){
            result = new Object [][]{{"小郑",10},{"小硕",10}};
        }else{

        }
        return result;
    }
}
