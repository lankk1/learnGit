package com.jia.changle.controller;

import com.jia.changle.po.ClUser;
import com.jia.changle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by slipkinem on 9/1/2017.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(@RequestBody ClUser user) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Integer errorCode = userService.login(user);
            map.put("errorCode", errorCode);
            if (errorCode == 0) {
                map.put("errorMessage", "登录成功");
            } else {
                map.put("errorMessage", "系统出错");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
}
