package com.example.food_delivery.domain.controller;

import com.example.food_delivery.domain.dto.OrderMenuDto;
import com.example.food_delivery.domain.service.OrderMenuService;
import com.example.food_delivery.domain.service.StoreService;
import com.example.food_delivery.domain.vo.MenuVO;
import com.example.food_delivery.domain.vo.OrderMenuVO;
import com.example.food_delivery.domain.vo.StoreVO;
import com.example.food_delivery.domain.vo.UserVO;
import com.example.food_delivery.web.LoginForm;
import com.example.food_delivery.web.SessionConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Object orderSuccess(@RequestBody Map<String, Object> map, OrderMenuVO orderMenuVO) {
        map.put("no", map.get("no"));
        map.put("totalMoney", map.get("money"));
        map.put("storeName", map.get("storeName"));
        map.put("userName", map.get("name"));
        map.put("phone", map.get("phone"));
        map.put("addr", map.get("addr"));
        map.put("detailAddr", map.get("detailAddr"));
        map.put("payment", map.get("payment"));
        map.put("orderDate", map.get("orderDate"));
        map.put("menu", map.get("menu"));
        System.out.println(map.get("menu"));
        orderMenuService.orderHistory(orderMenuVO);
        return map;
    }

}
