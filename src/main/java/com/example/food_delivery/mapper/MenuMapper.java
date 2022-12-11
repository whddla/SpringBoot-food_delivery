package com.example.food_delivery.mapper;


import com.example.food_delivery.domain.vo.MenuVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    public List<MenuVO> menu(MenuVO menuVO, Integer no);
}
