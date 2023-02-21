package com.course.testng;

import org.testng.annotations.Test;

public class ExpectedException {

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSucess(){
        System.out.println("这是一个异常成功的测试");
        throw new RuntimeException();
    }
}
