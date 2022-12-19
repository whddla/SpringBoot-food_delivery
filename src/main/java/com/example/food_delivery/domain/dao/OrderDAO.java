package com.example.food_delivery.domain.dao;

import com.example.food_delivery.domain.vo.OrderMenuVO;
import com.example.food_delivery.domain.vo.UserOrderVO;
import com.example.food_delivery.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderDAO {
    private final OrderMapper orderMapper;

    public void orderHistory(HashMap<String, Object> params) {
        orderMapper.orderHistory(params);
    }

    public void orderHistory2(HashMap<String, Object> params) {
        orderMapper.orderHistory2(params);
    }

    //주문내역 select
    public List<UserOrderVO> orderAllLIst(UserOrderVO userOrderVO, Integer no){ return orderMapper.orderAllList(userOrderVO, no); }
    //메뉴내역 select
    public List<OrderMenuVO> menuAllLIst(OrderMenuVO orderMenuVO, Integer no){ return orderMapper.menuAllList(orderMenuVO, no); }
}

