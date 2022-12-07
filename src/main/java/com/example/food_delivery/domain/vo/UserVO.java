package com.example.food_delivery.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserVO {/*회원.*/
    private Integer userNum;
    private String userName;
    private String userId;
    private String userPw;
    private String userGender;
    private String userEmail;
    private String userPhoneNumber;
    private String userBirth;
    private Integer idealNum;
    private Integer userPoint;
}
