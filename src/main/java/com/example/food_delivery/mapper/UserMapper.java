package com.example.food_delivery.mapper;


import com.example.food_delivery.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //로그인
    public UserVO login(String id, String pw);

    //회원가입
    public void insert(UserVO userVO);

    //유저정보
    public  UserVO user(Integer no);
}
