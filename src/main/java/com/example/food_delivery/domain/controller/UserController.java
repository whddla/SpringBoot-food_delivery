package com.example.food_delivery.domain.controller;

import com.example.food_delivery.domain.service.UserService;
import com.example.food_delivery.domain.vo.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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

    //로그인
    @GetMapping("login")
    public String loginForm(){
        return "user/login";
    }

    @PostMapping("login")
    public String login(String id, String pw, HttpServletRequest req){
        UserVO userVO = userService.login(id, pw);
        HttpSession session = req.getSession();

        Integer userNum = userVO.getNo();
        Integer ceo = userVO.getCeo();

        session.setAttribute("userNum",userNum);
        session.setAttribute("ceo",ceo);

        return "redirect:/";
    }

    //로그아웃
    @GetMapping("logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
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
    public String myOrderPage(){
        return "user/myOrder";
    }

}
