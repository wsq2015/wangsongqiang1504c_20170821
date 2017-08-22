package com.bawei.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by admin on 2017/8/21.
 */
@Mapper
public interface OrderMapper {
    //关联添加商品

    void addOrders(Integer nums);

    void kissOrders(Integer nums);
}
