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
    public List<StoreVO> getStoreList() {
        return storeDAO.getStoreList();
    }

    @Override
    public StoreVO getStoreName(StoreVO storeVO, String storeName) {
        return storeDAO.getStoreName(storeVO,storeName);
    }

    @Override
    public List<MenuVO> menu(MenuVO menuVO, Integer no) {
        return storeDAO.menu(menuVO, no);
    }

    @Override
    public List<MenuVO> manageMenu(MenuVO menuVO, Integer no) {
        return storeDAO.manageMenu(menuVO, no);
    }

    @Override
    public StoreVO order(StoreVO storeVO, Integer no) {return storeDAO.order(storeVO, no);}

    @Override
    public UserOrderVO getOrder(UserOrderVO userOrderVO, String orderNo) {return storeDAO.getOrder(userOrderVO, orderNo);}

    @Override
    public List<OrderMenuVO> getMenu(OrderMenuVO orderMenuVO, String orderNo) {return storeDAO.getMenu(orderMenuVO, orderNo);}

    @Override
    public List<UserOrderVO> orderList(UserOrderVO userOrderVO, Integer no){return storeDAO.orderList(userOrderVO, no);}

    @Override
    public List<OrderMenuVO> menuList(OrderMenuVO orderMenuVO, Integer no){return storeDAO.menuList(orderMenuVO, no);}

    //주문 접수
    @Override
    public void updateReceipt(String orderNo, Integer deliveryTime){
        storeDAO.receipt(orderNo, deliveryTime);
    }
    //주문 거절
    @Override
    public void updateRefuse(String orderNo, String note){
        storeDAO.refuse(orderNo, note);
    }
    //주문 취소
    @Override
    public void updateCancel(String orderNo, String note){
        storeDAO.refuse(orderNo, note);
    }
    //주문 완료
    @Override
    public void updateCompletion(String orderNo){
        storeDAO.completion(orderNo);
    }
}
