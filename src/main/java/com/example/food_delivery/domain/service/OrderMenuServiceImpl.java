package com.example.food_delivery.domain.service;

import com.example.food_delivery.domain.dao.OrderDAO;
import com.example.food_delivery.domain.dao.StoreDAO;
import com.example.food_delivery.domain.vo.OrderMenuVO;
import com.example.food_delivery.domain.vo.StoreVO;
import com.example.food_delivery.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Primary
@Slf4j
public class OrderMenuServiceImpl implements OrderMenuService {
    private final OrderDAO orderDAO;
    @Override
    public void orderHistory(HashMap<String, Object> params) {
        orderDAO.orderHistory(params);
    }
}
