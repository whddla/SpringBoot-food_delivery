package com.example.food_delivery.domain.service;

import com.example.food_delivery.domain.dao.UserDAO;
import com.example.food_delivery.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Qualifier("user")
@Primary
@Slf4j
public class UserServiceImpl implements com.example.food_delivery.domain.service.UserService {

}