package com.example.food_delivery.mapper;


import com.example.food_delivery.domain.vo.MenuVO;
import com.example.food_delivery.domain.vo.OrderMenuVO;
import com.example.food_delivery.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.core.annotation.Order;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {

    public void orderHistory(OrderMenuVO orderMenuVO);
}
