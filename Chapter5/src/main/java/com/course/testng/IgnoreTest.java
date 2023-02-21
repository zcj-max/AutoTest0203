package com.course.testng;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.testng.annotations.Test;

public class IgnoreTest {
    @Test
    public void test(){
        System.out.println("test1");
    }

    @Test(enabled = false)
    public void test2(){
        System.out.println("test2");
    }
}
