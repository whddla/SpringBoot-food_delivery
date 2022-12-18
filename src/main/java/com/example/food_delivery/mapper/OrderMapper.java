package com.example.food_delivery.mapper;


import com.example.food_delivery.domain.vo.MenuVO;
import com.example.food_delivery.domain.vo.OrderMenuVO;
import com.example.food_delivery.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.core.annotation.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {

    // 메뉴 내역
    void orderHistory(HashMap<String, Object> params);
    // 주문 내역
    void orderHistory2(HashMap<String, Object> params);
}
