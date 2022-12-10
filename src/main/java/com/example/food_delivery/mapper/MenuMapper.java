package com.example.food_delivery.mapper;


import com.example.food_delivery.domain.vo.MenuVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper {
    public MenuVO menu(MenuVO menuVO, Integer no);
}
