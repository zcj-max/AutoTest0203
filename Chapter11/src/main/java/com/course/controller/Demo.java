package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@Api(value = "v1",description = "这是我的第一个版本的demo")
@Log4j
public class Demo {
    //首先获取一个执行sql语句的对象
    @Autowired
    private SqlSessionTemplate template;
    @RequestMapping(value = "/getUserConut",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户的数量",httpMethod = "GET")
    public int getUserConut(){
       return template.selectOne("getUserCount");
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户",httpMethod = "POST")
    public int addUser(@RequestBody User user){
        return template.insert("addUser",user);
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.PUT)
    @ApiOperation(value = "更新用户信息",httpMethod = "PUT")
    public int updateUser(@RequestBody User user){
        return template.update("updateUser",user);
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除用户信息",httpMethod = "DELETE")
    public int deleteUser(@RequestBody User user){
        return  template.delete("deleteUser",user);
    }
}
