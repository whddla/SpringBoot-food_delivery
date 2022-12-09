package com.example.food_delivery.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MenuVO {/*회원.*/
    private Integer no;
    private Integer menu_cate;
    private String food_name;
    private Integer price;
    private Integer ceo_no;
}
