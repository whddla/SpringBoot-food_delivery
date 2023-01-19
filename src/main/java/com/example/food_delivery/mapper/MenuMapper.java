package com.example.food_delivery.mapper;


import com.example.food_delivery.domain.vo.MenuVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    public List<MenuVO> menu(MenuVO menuVO, Integer no);
    public MenuVO selectMenu(Integer no);
    public MenuVO menuUpdate(MenuVO menuVO, Integer no, String foodName, Integer price, String img);
    public void deleteMenu(Integer no);
}
