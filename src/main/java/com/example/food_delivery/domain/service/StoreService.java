package com.example.food_delivery.domain.service;

import com.example.food_delivery.domain.vo.MenuVO;
import com.example.food_delivery.domain.vo.OrderMenuVO;
import com.example.food_delivery.domain.vo.StoreVO;
import com.example.food_delivery.domain.vo.UserOrderVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StoreService {
    
    // 카테고리 별 가게
    public StoreVO cate(Integer no, StoreVO storeVO);
    
    // 전체 메뉴
    public List<MenuVO> menu(MenuVO menuVO, Integer no);

    // 주문 화면 가게
    public StoreVO order(StoreVO storeVO, Integer no);

    public List<UserOrderVO> orderList(UserOrderVO userOrderVO, Integer no);
    public List<OrderMenuVO> menuList(OrderMenuVO orderMenuVO, Integer no);

}
