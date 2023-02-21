package com.course.httpclient.cookies;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    private String uri;
    private ResourceBundle bundle;
    private CookieStore cookieStore;

    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
        uri = bundle.getString("getCookies.uri");
    }

    @Test
    public void testGetCookies() throws IOException {
        HttpGet get = new HttpGet(url+uri);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();
        String s = EntityUtils.toString(entity, "utf-8");
        System.out.println(s);
        cookieStore = client.getCookieStore();
        List<Cookie> cookies = cookieStore.getCookies();
        for(Cookie cookie : cookies){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("name :" + name + ", value:" + value);
        }
    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException {
        uri = bundle.getString("test.get.with.cookies");
        HttpGet get = new HttpGet(url+uri);
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(cookieStore);
        HttpResponse response = client.execute(get);
        //获取响应状态码
        int statusCode = response.getStatusLine().getStatusCode();
        if(200 == statusCode){
            System.out.println("获取状态码为200");
        }
        HttpEntity entity = response.getEntity();
        String s = EntityUtils.toString(entity, "utf-8");
        System.out.println("s:" + s);


    }
}
