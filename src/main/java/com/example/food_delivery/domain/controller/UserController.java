package com.example.food_delivery.domain.controller;

import com.example.food_delivery.domain.service.OrderMenuService;
import com.example.food_delivery.domain.service.UserService;
import com.example.food_delivery.domain.vo.*;
import com.example.food_delivery.web.LoginForm;
import com.example.food_delivery.web.SessionConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RestController api 확인시 기존 Conroller 어노테이션 주석하고 이거 활성
@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final OrderMenuService orderMenuService;

    //로그인
    @GetMapping("/login")
    public String loginForm(@ModelAttribute LoginForm loginForm) {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute @Validated LoginForm loginForm,
                        BindingResult bindingResult,
                        @RequestParam(defaultValue = "/") String redirectURL,
                        HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "user/login";
        }

        UserVO user = userService.login(loginForm.getId(), loginForm.getPw());

        if (user == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "user/login";
        }

        // 로그인 성공 처리
        HttpSession session = request.getSession();                         // 세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성하여 반환
        session.setAttribute(SessionConstants.LOGIN_USER, user);   // 세션에 로그인 회원 정보 보관

        return "redirect:" + redirectURL;
    }

    //로그아웃
    @GetMapping("logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();   // 세션 날림

        }

        return "redirect:/";
    }

    //회원가입
    @GetMapping("signup")
    public String signupPage(){
        return "user/signup";
    }

    @PostMapping("signup")
    public String signup(UserVO userVO){
        userService.userInsert(userVO);
        return "redirect:/";
    }

    //아이디찾기
    @GetMapping("findId")
    public String findIdPage(){
        return "user/findId";
    }

    //비밀번호찾기
    @GetMapping("findPw")
    public String findPwPage(){
        return "user/findPw";
    }


    //가게등록
    @GetMapping("register")
    public String registerPage(){
        return "user/register";
    }

    //주문내역
    @GetMapping("myOrder")
    public String myOrderPage(HttpServletRequest request,Model model,OrderMenuVO orderMenuVO, UserOrderVO userOrderVO){
        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute(SessionConstants.LOGIN_USER);
        System.out.println(session);
        System.out.println(user);
        Integer no= user.getNo();
        model.addAttribute("order",orderMenuService.orderAllList(userOrderVO ,no));
        model.addAttribute("menu",orderMenuService.menuAllList(orderMenuVO ,no));
        return "user/myOrder";
    }

}
