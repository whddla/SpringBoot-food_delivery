package com.example.food_delivery.domain.service;

import com.example.food_delivery.domain.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface UserService {
    public UserVO login(String id, String pw);
    //회원가입
    public void userInsert(UserVO userVO);
}
