package com.example.food_delivery.domain.dao;

import com.example.food_delivery.domain.vo.OrderMenuVO;
import com.example.food_delivery.domain.vo.UserVO;
import com.example.food_delivery.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    }

