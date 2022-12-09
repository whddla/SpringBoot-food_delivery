package com.example.food_delivery.domain.dao;

import com.example.food_delivery.domain.vo.UserVO;
import com.example.food_delivery.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;

    public UserVO login(String id, String pw){
        return userMapper.login(id, pw);
    }
}
