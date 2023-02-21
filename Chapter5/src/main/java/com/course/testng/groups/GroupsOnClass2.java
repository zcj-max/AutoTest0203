package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass2 {
    public void test1(){
        System.out.println("GroupsOnClass2中的test1方法");
    }
    public void test2(){
        System.out.println("GroupsOnClass2中的test2方法");
    }
}
