package com.example.food_delivery.domain.controller;

import com.example.food_delivery.domain.service.OrderMenuService;
import com.example.food_delivery.domain.service.StoreService;
import com.example.food_delivery.domain.vo.MenuVO;
import com.example.food_delivery.domain.vo.OrderMenuVO;
import com.example.food_delivery.domain.vo.StoreVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.*;

//@RestController api 확인시 기존 Conroller 어노테이션 주석하고 이거 활성
@Controller
@Slf4j
@RequiredArgsConstructor
public class OrderController {
    private final StoreService storeService;
    private final OrderMenuService orderMenuService;

    //주문화면
    @GetMapping("order")
    public String orderPage(Model model, Integer no, StoreVO storeVO, MenuVO menuVO, HttpServletRequest request){
        model.addAttribute("store",storeService.order(storeVO,no));
        model.addAttribute("menu",storeService.menu(menuVO,no));
        return "user/userOrder";
    }

    //주문완료
    @GetMapping("order/wait")
    public String waitPage(){
        System.out.println();
        return "user/wait";
    }
    @PostMapping("order/success")
    @ResponseBody
    public Object orderSuccess(@RequestBody HashMap<String, Object> params, OrderMenuVO orderMenuVO) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("no", params.get("no"));
        map.put("totalMoney", params.get("money"));
        map.put("storeName", params.get("storeName"));
        map.put("phone", params.get("phone"));
        map.put("tip", params.get("tip"));
        map.put("addr", params.get("addr"));
        map.put("status", params.get("state"));
        map.put("forCeo", params.get("forCeo"));
        map.put("forRider", params.get("forRider"));
        map.put("detailAddr", params.get("detailAddr"));
        map.put("payment", params.get("payment"));
        map.put("orderDate", params.get("orderDate"));
        map.put("menu", params.get("menu"));
        String ran = RandomStringUtils.random(6,true, true);
        map.put("orderNo", ran);
        System.out.println(params.get("menu"));
//        orderMenuService.orderHistory(map);
        orderMenuService.orderHistory2(map);
        return map;
    }

}
