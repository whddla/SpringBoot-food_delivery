package com.example.food_delivery.domain.service;

import com.example.food_delivery.domain.vo.OrderMenuVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface OrderMenuService {
    public void orderHistory(OrderMenuVO orderMenuVO);
}
