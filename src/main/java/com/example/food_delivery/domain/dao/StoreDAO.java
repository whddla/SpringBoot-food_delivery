package com.example.food_delivery.domain.dao;

import com.example.food_delivery.domain.vo.MenuVO;
import com.example.food_delivery.domain.vo.OrderMenuVO;
import com.example.food_delivery.domain.vo.StoreVO;
import com.example.food_delivery.domain.vo.UserOrderVO;
import com.example.food_delivery.mapper.MenuMapper;
import com.example.food_delivery.mapper.StoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoreDAO {
    private final StoreMapper storeMapper;
    private final MenuMapper menuMapper;

    public StoreVO cate(Integer no, StoreVO storeVO){
        return storeMapper.cate(no,storeVO);
    }
    public List<MenuVO> menu(MenuVO menuVO, Integer no){
        return menuMapper.menu(menuVO, no);
    }
    public StoreVO order(StoreVO storeVO, Integer no){ return storeMapper.order(storeVO, no); }
    public UserOrderVO orderList(UserOrderVO userOrderVO, String orderNo){ return storeMapper.getOrderList(userOrderVO, orderNo); }
    public List<OrderMenuVO> menuList(OrderMenuVO orderMenuVO, String orderNo){ return storeMapper.getMenuList(orderMenuVO, orderNo); }
    }

