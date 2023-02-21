package com.course.testng;

import org.testng.annotations.Test;

public class TimeOutTest {

    @Test(timeOut = 1900)
    public void timeOutTest() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("超时了");

    }
}
