package com.example.food_delivery.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AdVO {/*회원.*/
    private Integer no;
    private String name;
    private String id;
    private String pw;
    private String addr;
    private String email;
    private String phone;
    private Integer ceo;
    private Integer order_no;
    private Integer order_count;
}
