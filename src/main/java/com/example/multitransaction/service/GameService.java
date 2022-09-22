package com.example.multitransaction.service;

import com.example.multitransaction.mapper.globalGame.GlobalGameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    GlobalGameMapper gameMapper;
    public void createIpBan(String ip){
        gameMapper.createIpBan(ip);
    }
}
