package com.example.food_delivery.domain.dao;

import com.example.food_delivery.domain.vo.MenuVO;
import com.example.food_delivery.domain.vo.StoreVO;
import com.example.food_delivery.mapper.MenuMapper;
import com.example.food_delivery.mapper.StoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
@Repository
@RequiredArgsConstructor
public class StoreDAO {
    private final StoreMapper storeMapper;
    private final MenuMapper menuMapper;

    public StoreVO cate(Integer no, StoreVO storeVO){
        return storeMapper.cate(no,storeVO);
    }
    public MenuVO menu(MenuVO menuVO, Integer no){
        return menuMapper.menu(menuVO, no);
    }
}
