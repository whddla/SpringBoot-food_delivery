package com.example.food_delivery.domain.service;

import com.example.food_delivery.domain.vo.MenuVO;
import com.example.food_delivery.domain.vo.StoreVO;
import org.springframework.stereotype.Service;

@Service
public interface StoreService {
    
    // 카테고리 별 가게
    public StoreVO cate(Integer no, StoreVO storeVO);
    
    // 전체 메뉴
    public MenuVO menu(MenuVO menuVO, Integer no);
}
