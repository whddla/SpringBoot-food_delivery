package com.example.food_delivery.domain.controller;

import com.example.food_delivery.domain.service.StoreService;
import com.example.food_delivery.domain.vo.MenuVO;
import com.example.food_delivery.domain.vo.StoreVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController api 확인시 기존 Conroller 어노테이션 주석하고 이거 활성
@Controller
@Slf4j
@RequiredArgsConstructor
public class OrderController {
    private final StoreService storeService;

    //주문화면
    @GetMapping("order")
    public String orderPage(Model model, Integer no, StoreVO storeVO, MenuVO menuVO){
        model.addAttribute("store",storeService.order(storeVO,no));
        model.addAttribute("menu",storeService.menu(menuVO,no));
        return "user/userOrder";
    }

}
