package com.bawei.service.Impl;

import com.bawei.bean.t_goods;
import com.bawei.bean.t_user;
import com.bawei.mapper.GoodsMapper;
import com.bawei.mapper.OrderMapper;
import com.bawei.mapper.UserMapper;
import com.bawei.service.CompairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2017/8/21.
 */
@Service
@Transactional
public class CompairImpl implements CompairService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    @Transactional(readOnly = false)
    public void useradd(t_user user) {
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        String names = user.getUsername();
        String password = user.getPassword();
        operations.set(names,password);
        userMapper.useradd(user);

    }
 @Override
    public List<t_goods> queryList() {
        return goodsMapper.queryList();
    }

    @Override
    @Transactional(readOnly = false)
    public void addOrders(Integer nums) {
        orderMapper.addOrders(nums);
    }

    @Override
    @Transactional(readOnly = false)
    public void kissOrders(Integer nums) {
        orderMapper.kissOrders(nums);
    }


}
