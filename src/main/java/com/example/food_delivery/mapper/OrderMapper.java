package com.example.food_delivery.mapper;


import com.example.food_delivery.domain.vo.OrderMenuVO;
import com.example.food_delivery.domain.vo.UserOrderVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface OrderMapper {

    // 메뉴 내역 insert
    void orderHistory(HashMap<String, Object> params);
    // 주문 내역 insert
    void orderHistory2(HashMap<String, Object> params);

    // 주문 내역 select
    List<UserOrderVO> orderAllList(UserOrderVO userOrderVO, Integer no);

    // 메뉴 내역 select
    List<OrderMenuVO> menuAllList(OrderMenuVO orderMenuVO, Integer no);
}
