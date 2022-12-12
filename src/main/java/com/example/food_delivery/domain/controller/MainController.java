package com.example.food_delivery.domain.controller;

import com.example.food_delivery.domain.service.UserService;
import com.example.food_delivery.domain.vo.UserVO;
import com.example.food_delivery.web.SessionConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;

    //메인 페이지
    @GetMapping("/")
    public String home(HttpServletRequest request, Model model) {
        // 세션이 없으면 홈으로 이동
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "index";
        }

        // 세션에 저장된 회원 조회
        UserVO user = (UserVO) session.getAttribute(SessionConstants.LOGIN_USER);

        // 세션에 회원 데이터가 없으면 홈으로 이동
        if (user == null) {
            return "index";
        }

        // 세션이 유지되면 로그인으로 이동
        model.addAttribute("loginUser", user);

        return "index";
    }

    //우리집 주소
    @GetMapping("myHome")
    @ResponseBody
    public String addr(Integer no,HttpSession session){
        String addr = userService.user(no).getAddr();
        System.out.println(addr);
        return addr;
    }

}
