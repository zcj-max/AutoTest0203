package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsOnClass3 {
    public void test1(){
        System.out.println("GroupsOnClass3中的test1方法");
    }
    public void test2(){
        System.out.println("GroupsOnClass3中的test2方法");
    }
}
