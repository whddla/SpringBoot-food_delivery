package com.example.food_delivery.domain.service;

import com.example.food_delivery.domain.dao.StoreDAO;
import com.example.food_delivery.domain.vo.MenuVO;
import com.example.food_delivery.domain.vo.OrderMenuVO;
import com.example.food_delivery.domain.vo.StoreVO;
import com.example.food_delivery.domain.vo.UserOrderVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
@Slf4j
public class StoreServiceImpl implements StoreService {
    private final StoreDAO storeDAO;

    @Override
    public StoreVO cate(Integer no, StoreVO storeVO) {
        return storeDAO.cate(no,storeVO);
    }

    @Override
    public List<MenuVO> menu(MenuVO menuVO, Integer no) {
        return storeDAO.menu(menuVO, no);
    }

    @Override
    public StoreVO order(StoreVO storeVO, Integer no) {return storeDAO.order(storeVO, no);}

    @Override
    public List<UserOrderVO> orderList(UserOrderVO userOrderVO, Integer no){return storeDAO.orderList(userOrderVO, no);}

    @Override
    public List<OrderMenuVO> menuList(OrderMenuVO orderMenuVO, Integer no){return storeDAO.menuList(orderMenuVO, no);}
}
