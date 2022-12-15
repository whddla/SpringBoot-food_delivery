package com.example.food_delivery.domain.controller;

import com.example.food_delivery.domain.service.StoreService;
import com.example.food_delivery.domain.service.UserService;
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
public class StoreController {
    private final StoreService storeService;

    //카테고리
    @GetMapping("cate")
    public String catePage(Model model, Integer no, StoreVO storeVO, MenuVO menuVO){
        model.addAttribute("cate",storeService.cate(no,storeVO));
//        model.addAttribute("menu",storeService.menu(menuVO,no));
        return "/cate";
    }

    @GetMapping("store/manage")
    public String managePage(){
        return "store/manage";
    }

    @GetMapping("store/completion")
    public String completionPage(){
        return "store/completion";
    }

    @GetMapping("store/detail")
    public String detailPage(){
        return "store/detail";
    }

    @GetMapping("store/progress")
    public String progressPage(){
        return "store/progress";
    }

    @GetMapping("store/order")
    public String orderPage(){
        return "store/order";
    }
}
