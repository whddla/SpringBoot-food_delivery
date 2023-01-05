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
    public UserOrderVO getOrder(UserOrderVO userOrderVO, String orderNo){ return storeMapper.getOrder(userOrderVO, orderNo); }
    public List<OrderMenuVO> getMenu(OrderMenuVO orderMenuVO, String orderNo){ return storeMapper.getMenu(orderMenuVO, orderNo); }
    public List<UserOrderVO> orderList(UserOrderVO userOrderVO, Integer no){ return storeMapper.getOrderList(userOrderVO, no); }
    public List<OrderMenuVO> menuList(OrderMenuVO orderMenuVO, Integer no){ return storeMapper.getMenuList(orderMenuVO, no); }

    public void receipt(String orderNo, Integer deliveryTime){
        storeMapper.updateReceipt(orderNo, deliveryTime);
    }
    public void refuse(String orderNo, String note){
        storeMapper.updateRefuse(orderNo, note);
    }
    public void completion(String orderNo){
        storeMapper.updateCompletion(orderNo);
    }

}

