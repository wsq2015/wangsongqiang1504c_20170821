package com.bawei.mapper;

import com.bawei.bean.t_goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by admin on 2017/8/21.
 */
@Mapper
public interface GoodsMapper {
     /*
    b)	创建注册界面,用于用户注册,点击注册添加用户信息到t_user表,并同步到redis缓存中,
         用户名作为redis的key,密码作为value.

    c)	创建登录页面,用户登录,利用redis缓存判断用户是否登录,思路:用户点击登录,后台从redis取出
          与用户名相同的key,判断相同key的value值是否相同,若相同,则登录成功,若不同则登录失败

    d)	登录成功,跳转商品列表页面,在列表上方显示登录用户,商品列表显示t_goods表中数据,在商品数量
        这一列为一个输入框,输入框两边有’+’和’-’两个按钮,点击按钮实现商品数量的加减.

    e)	为每一行商品前面添加一个复选框,点击列表下方的购买按钮,根据复选框的选中情况,将用户id,
         商品id,商品数量添加到t_order表中
  */


   //跳转商品列表页面,关联查询
     List<t_goods> queryList();








}
