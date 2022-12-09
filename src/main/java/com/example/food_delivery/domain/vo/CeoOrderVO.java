package com.example.food_delivery.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CeoOrderVO {/*사장님 주문목록.*/
    private Integer no;
    private Integer status;
    private Integer order_no;
}
