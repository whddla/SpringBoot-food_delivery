package com.example.food_delivery.domain.service;

import com.example.food_delivery.domain.dao.StoreDAO;
import com.example.food_delivery.domain.vo.StoreVO;
import com.example.food_delivery.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("user")
@Primary
@Slf4j
public class StoreServiceImpl implements StoreService {
    private final StoreDAO storeDAO;

    @Override
    public StoreVO cate(Integer no) {
        return storeDAO.cate(no);
    }
}
