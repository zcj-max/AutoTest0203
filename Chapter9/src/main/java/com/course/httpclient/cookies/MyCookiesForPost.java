package com.course.httpclient.cookies;

import jdk.nashorn.internal.AssertsEnabled;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
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
    public void testPostWithCookies() throws IOException {
        String uri = bundle.getString("test.post.with.cookies");
        HttpPost post = new HttpPost(url + uri);
        post.setHeader("Content-type","application/json");
        JSONObject object = new JSONObject();
        object.put("name","huhansan");
        object.put("age","18");
        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(object.toString(), "utf-8");
        post.setEntity(entity);
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(cookieStore);
        HttpResponse response = client.execute(post);
        HttpEntity entity1 = response.getEntity();
        String s = EntityUtils.toString(entity1, "utf-8");
        System.out.println("s:" + s);
        JSONObject jsonObject = new JSONObject(s);
        String status = (String) jsonObject.get("status");
        String huhansan = (String) jsonObject.get("huhansan");
        Assert.assertEquals("1",status);
        Assert.assertEquals("success",huhansan);

    }
}
