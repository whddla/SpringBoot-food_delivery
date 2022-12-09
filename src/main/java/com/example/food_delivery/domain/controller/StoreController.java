package com.example.food_delivery.domain.controller;

import com.example.food_delivery.domain.service.StoreService;
import com.example.food_delivery.domain.service.UserService;
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
    public String catePage(Model model, Integer no, StoreVO storeVO){
        model.addAttribute("cate",storeService.cate(no,storeVO));
        return "/cate";
    }
}
