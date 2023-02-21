package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhengchuanjie
 * @date 2021/3/20
 */
@RestController
@Api(value = "/", description = "这是我全部的post方法")
@RequestMapping("/v1")
public class MyPostMethod {
    //这个变量是用来装我们cookies信息的
    private static Cookie cookie;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登陆接口，成功后获取cookies信息", httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName", required = true) String userName,
                        @RequestParam(value = "passWord", required = true) String passWord) {
        if ("zhangsan".equals(userName) && "123456".equals(passWord)) {
            cookie = new Cookie("login", "true");
            response.addCookie(cookie);
            return "恭喜您登录成功了！";
        }
        return "用户名或密码错误！";
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户信息列表", httpMethod = "POST")
    public String getUserList(HttpServletRequest request, @RequestBody User u) {
        //获取cookies
        Cookie[] cookies = request.getCookies();
        User user;
        //验证cookies是否合法
        for (Cookie c : cookies) {
            if (c.getName().equals("login")
                    && c.getValue().equals("true")
                    && u.getUserName().equals("zhangsan")
                    && "123456".equals(u.getPassWord())) {
                user = new User();
                user.setName("lisi");
                user.setAge("18");
                user.setSex("man");
                return user.toString();

            }
        }
        return "参数不合法";
    }
}
