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

    // 전체 가게
    public List<StoreVO> getStoreList();

    // 가게 이름으로 가게정보
    public StoreVO getStoreName(StoreVO storeVO, String storeName);
    public List<MenuVO> manageMenu(MenuVO menuVO, Integer no);

    // 전체 메뉴
    public List<MenuVO> menu(MenuVO menuVO, Integer no);
    // 메뉴 1개
    public MenuVO selectMenu(Integer no);
    // 메뉴 수정
    public void menuUpdate(MenuVO menuVO, Integer no, String foodName, Integer price);
    public void deleteMenu(Integer no);

    // 주문 화면 가게
    public StoreVO order(StoreVO storeVO, Integer no);
    public UserOrderVO getOrder(UserOrderVO userOrderVO, String orderNo);
    public List<OrderMenuVO> getMenu(OrderMenuVO orderMenuVO, String orderNo);
    public List<UserOrderVO> orderList(UserOrderVO userOrderVO, Integer no);
    public List<OrderMenuVO> menuList(OrderMenuVO orderMenuVO, Integer no);

    //주문 접수
    public void updateReceipt(String orderNo, Integer deliveryTime);
    //주문 거절
    public void updateRefuse(String orderNo, String note);
    //주문 취소
    public void updateCancel(String orderNo, String note);
    //주문 완료
    public void updateCompletion(String orderNo);
}
