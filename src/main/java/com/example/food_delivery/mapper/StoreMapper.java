package com.example.food_delivery.mapper;


import com.example.food_delivery.domain.vo.OrderMenuVO;
import com.example.food_delivery.domain.vo.StoreVO;
import com.example.food_delivery.domain.vo.UserOrderVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreMapper {

    //카테고리
    public StoreVO cate(Integer no ,StoreVO storeVO);

    //주문화면
    public StoreVO order(StoreVO storeVO,Integer no);
    public UserOrderVO getOrder(UserOrderVO userOrderVO, String orderNo);
    public List<OrderMenuVO> getMenu(OrderMenuVO orderMenuVO, String orderNo);
    public List<UserOrderVO> getOrderList(UserOrderVO userOrderVO, Integer no);
    public List<OrderMenuVO> getMenuList(OrderMenuVO orderMenuVO, Integer no);
}
