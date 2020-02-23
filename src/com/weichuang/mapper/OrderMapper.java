package com.weichuang.mapper;

import com.weichuang.pojo.Order;
import com.weichuang.pojo.OrderUser;

import java.util.List;

public interface OrderMapper {

    List<Order> getAllOrder();

    List<Order> getOrderUserOBO();
}
