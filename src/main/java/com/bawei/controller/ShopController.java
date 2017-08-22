package com.bawei.controller;

import com.bawei.bean.t_goods;
import com.bawei.bean.t_user;
import com.bawei.service.CompairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2017/8/21.
 */

@Controller
@RequestMapping("test")
public class ShopController {

    @Autowired
    private CompairService compairService;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("index")
    public String index() {
        return "index";
    }
    @RequestMapping("dl")
    public String dl() {
        return "dl";
    }
    @RequestMapping(value="useradd",method = RequestMethod.POST)
    public String useradd(t_user user) {
        compairService.useradd(user);
        return "dl";
    }

    @RequestMapping("login")
    public String login(t_user user,HttpSession session) {
        ValueOperations<Serializable,Object> operations = redisTemplate.opsForValue();
        String password = (String)operations.get(user.getUsername());
        if(user.getPassword()!=null && password.equals(user.getPassword())){
            session.setAttribute("username",user.getUsername());
            return "show";
        }
        return "dl";
    }
   // http://localhost/test/login
    @RequestMapping(value="queryList",method = RequestMethod.POST)
    @ResponseBody
    public List<t_goods> queryList() {
        return compairService.queryList();
    }

    @RequestMapping(value="addOrders",method = RequestMethod.POST)
    public String addOrders(@RequestParam("nums") Integer nums) {
        compairService.addOrders(nums);
        return "show";
    }

    @RequestMapping(value="kissOrders",method = RequestMethod.POST)
    public String kissOrders(@RequestParam("nums") Integer nums) {
        compairService.kissOrders(nums);
        return "show";
    }



}
