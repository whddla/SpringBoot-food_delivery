package com.example.food_delivery.mapper;


import com.example.food_delivery.domain.vo.StoreVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreMapper {

    //카테고리
    public StoreVO cate(Integer no ,StoreVO storeVO);
}
