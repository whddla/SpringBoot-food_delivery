package com.example.food_delivery.domain.dao;

import com.example.food_delivery.domain.vo.StoreVO;
import com.example.food_delivery.mapper.StoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
@Repository
@RequiredArgsConstructor
public class StoreDAO {
    private final StoreMapper storeMapper;

    public StoreVO cate(Integer no, StoreVO storeVO){
        return storeMapper.cate(no,storeVO);
    }
}
