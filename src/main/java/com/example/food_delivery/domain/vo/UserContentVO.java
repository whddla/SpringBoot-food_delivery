package com.example.food_delivery.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserContentVO {/*회원.*/
    private Integer no;
    private String content;
    private String title;
    private String upload_date;
    private String update_date;
    private Integer view_cnt;
    private Integer user_no;
}
