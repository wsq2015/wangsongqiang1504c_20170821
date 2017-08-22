package com.bawei.service;

import com.bawei.bean.t_goods;
import com.bawei.bean.t_user;

import java.util.List;

/**
 * Created by admin on 2017/8/21.
 */
public interface CompairService {

    //用户注册
    void useradd(t_user user);

   /* //用户登陆
    t_user login(t_user user);*/

    //跳转商品列表页面,关联查询
    List<t_goods> queryList();

    //关联添加商品
    void addOrders(Integer nums);

    void kissOrders(Integer nums);
}
