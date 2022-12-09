package com.example.food_delivery.domain.service;

import com.example.food_delivery.domain.vo.StoreVO;
import org.springframework.stereotype.Service;

@Service
public interface StoreService {
    public StoreVO cate(Integer no, StoreVO storeVO);
}
