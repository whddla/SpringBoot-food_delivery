package com.example.food_delivery.domain.controller;

import com.example.food_delivery.domain.dao.StoreDAO;
import com.example.food_delivery.domain.service.StoreService;
import com.example.food_delivery.domain.vo.*;
import com.example.food_delivery.web.SessionConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;
    private final StoreDAO storeDAO;

    //카테고리
    @GetMapping("cate")
    public String catePage(Model model, Integer no, StoreVO storeVO){
        model.addAttribute("cate",storeService.cate(no,storeVO));
        return "/cate";
    }
    
    //가게 이름으로 가게정보
    @GetMapping("order/{storeName}")
    public String storePage(StoreVO storeVO,MenuVO menuVO,  Model model){
        System.out.println(storeVO);
        Integer no = storeService.getStoreName(storeVO,storeVO.getStoreName()).getNo();
        model.addAttribute("store",storeService.getStoreName(storeVO,storeVO.getStoreName()));
        model.addAttribute("menu",storeService.menu(menuVO,no));
        return "user/userOrder";
    }

    @GetMapping("store/menu")
    public String menuPage(HttpServletRequest request, Model model, MenuVO menuVO){
        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute(SessionConstants.LOGIN_USER);
        Integer no = user.getNo();
        model.addAttribute("menu",storeService.manageMenu(menuVO, no));
        return "store/menu";
    }

    @GetMapping("store/manage")
    public String managePage(HttpServletRequest request, Model model, MenuVO menuVO){
        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute(SessionConstants.LOGIN_USER);
        Integer no = user.getNo();
        model.addAttribute("menu",storeService.manageMenu(menuVO, no));
        return "store/manage";
    }

    @GetMapping("store/completion")
    public String completionPage(){
        return "store/completion";
    }

    @GetMapping("store/order")
    public String orderPage(HttpServletRequest request,Model model, UserOrderVO userOrderVO, OrderMenuVO orderMenuVO){
        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute(SessionConstants.LOGIN_USER);
        Integer no = user.getNo();
        model.addAttribute("order",storeService.orderList(userOrderVO,no));
        model.addAttribute("menu",storeService.menuList(orderMenuVO,no));
        return "store/order";
    }

    @ResponseBody
    @RequestMapping(value = "/orderNo")
    public Object orderSelectPage(@RequestBody UserOrderVO object,UserOrderVO userOrderVO, OrderMenuVO orderMenuVO){
        Object menu = storeService.getMenu(orderMenuVO, object.getOrderNo());
        Object order = storeService.getOrder(userOrderVO, object.getOrderNo());
        Object[] arr = {menu, order};
        return arr;
    }

    // 주문 접수
    @GetMapping("updateState/{state}/{orderNo}/{deliveryTime}")
    public String orderReceipt(UserOrderVO object){
        storeService.updateReceipt(object.getOrderNo(),object.getDeliveryTime());
        return "redirect:/store/order";
    }

    // 완료
    @GetMapping("order/completion/{orderNo}")
    public String orderCompletion(UserOrderVO object){
        System.out.println(object.getOrderNo());
        storeService.updateCompletion(object.getOrderNo());
        return "redirect:/store/order";
    }

    // 주문 거부
    @GetMapping("order/refuse/{note}/{orderNo}")
    public String refuse(UserOrderVO object){
        storeService.updateRefuse(object.getOrderNo(),object.getNote());
        return "redirect:/store/order";
    }

    // 주문 취소
    @GetMapping("order/cancel/{note}/{orderNo}")
    public String cancel(UserOrderVO object){
        storeService.updateCancel(object.getOrderNo(),object.getNote());
        return "redirect:/store/order";
    }
    @ResponseBody
    @RequestMapping(value = "/updateMenu")
    public Map<String, Object> updateMenu(@RequestBody MenuVO menuVO){
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("no",storeService.selectMenu(menuVO.getNo()).getNo());
            result.put("foodName",storeService.selectMenu(menuVO.getNo()).getFoodName());
            result.put("price",storeService.selectMenu(menuVO.getNo()).getPrice());
            result.put("img",storeService.selectMenu(menuVO.getNo()).getImg());
            result.put("status", "OK");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", "False");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/saveMenu")
    public void saveMenu(@RequestBody MenuVO menuVO){
        storeService.menuUpdate(menuVO, menuVO.getNo(), menuVO.getFoodName(), menuVO.getPrice());
    }

    @ResponseBody
    @RequestMapping(value = "/deleteMenu")
    public void deleteMenu(@RequestBody MenuVO menuVO){
        storeService.deleteMenu(menuVO.getNo());
    }

    @PostMapping("/uploadMenu")
    public String uploadMenu(){

        return "/store/menu";
    }

}