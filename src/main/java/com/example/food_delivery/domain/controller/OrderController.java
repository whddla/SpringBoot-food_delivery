package com.example.food_delivery.domain.controller;

import com.example.food_delivery.domain.service.StoreService;
import com.example.food_delivery.domain.vo.MenuVO;
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
import java.util.Map;

//@RestController api 확인시 기존 Conroller 어노테이션 주석하고 이거 활성
@Controller
@Slf4j
@RequiredArgsConstructor
public class OrderController {
    private final StoreService storeService;

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
        return "user/wait";
    }
    @PostMapping("order/success")
    @ResponseBody
    public Object orderSuccess(@RequestBody Map<String, Object> map) {
        map.put("no", map.get("no"));
        map.put("money", map.get("money"));
        return map;
    }

}
