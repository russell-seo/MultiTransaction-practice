package com.example.multitransaction.service;

import com.example.multitransaction.mapper.game.GameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class GameService {

    @Autowired
    GameMapper gameMapper;
    public void createIpBan(String ip){
        gameMapper.createIpBan(ip);
    }
}
