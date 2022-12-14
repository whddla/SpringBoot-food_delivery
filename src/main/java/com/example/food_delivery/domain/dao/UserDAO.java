package com.example.food_delivery.domain.dao;

import com.example.food_delivery.domain.vo.UserOrderVO;
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

    //회원가입
    public void userInsert(UserVO userVO){userMapper.insert(userVO);}

    //유저
    public UserVO user(Integer no){ return userMapper.user(no);}


}
