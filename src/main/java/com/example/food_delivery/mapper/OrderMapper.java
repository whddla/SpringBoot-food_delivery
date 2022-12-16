package com.example.food_delivery.mapper;


import com.example.food_delivery.domain.vo.OrderMenuVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    //카테고리
    public StoreVO cate(Integer no ,StoreVO storeVO);

    //주문화면
    public StoreVO order(StoreVO storeVO,Integer no);
}
