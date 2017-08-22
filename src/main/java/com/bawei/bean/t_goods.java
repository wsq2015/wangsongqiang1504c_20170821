package com.bawei.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/8/21.
 */
public class t_goods implements Serializable {
      /*
    a)	创建名为***_test的数据库（***：为自己姓名的拼音全拼），
        建用户表t_user(编号ID,姓名name,用户名username,密码password),
        建商品表t_goods(编号ID,商品名称goodsname,商品价格price,商品数量account),
        建订单表t_order(编号ID,用户编号user_id,商品编号goods_id,商品数量goods_account)
    b)	创建注册界面,用于用户注册,点击注册添加用户信息到t_user表,并同步到redis缓存中,用户名作为redis的key,密码作为value.
    c)	创建登录页面,用户登录,利用redis缓存判断用户是否登录,思路:用户点击登录,后台从redis取出与用户名相同的key,判断相同key的value值是否相同,若相同,则登录成功,若不同则登录失败
    d)	登录成功,跳转商品列表页面,在列表上方显示登录用户,商品列表显示t_goods表中数据,在商品数量这一列为一个输入框,输入框两边有’+’和’-’两个按钮,点击按钮实现商品数量的加减.
    e)	为每一行商品前面添加一个复选框,点击列表下方的购买按钮,根据复选框的选中情况,将用户id,商品id,商品数量添加到t_order表中

     */
      private int id;
      private String goodsname;
      private float price;
      private int account;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "t_goods{" +
                "goodsname='" + goodsname + '\'' +
                ", price=" + price +
                ", account=" + account +
                '}';
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
}
