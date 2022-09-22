package com.example.multitransaction.service;

import com.example.multitransaction.mapper.admin.AdminMapper;
import com.example.multitransaction.mapper.game.GameMapper;
import com.example.multitransaction.mapper.globalAdmin.GlobalAdminMapper;
import com.example.multitransaction.mapper.globalGame.GlobalGameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AdminService {

    @Autowired
    GlobalAdminMapper globalAdminMapper;

    @Autowired
    GlobalGameMapper globalGameMapper;

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    GameMapper gameMapper;

    @Transactional(value = "multiTxManager")
    public void createIp(String ip_address, Date start_date, Date end_date, String register_id, String ban_reason){
        globalGameMapper.createIpBan(ip_address);
        globalAdminMapper.ins(ip_address, start_date, end_date, register_id, "매크로");
    }

    @Transactional(value = "adminTxManager")
    public void notMultiTx(String ip_address, Date start_date, Date end_date, String register_id, String ban_reason){
        adminMapper.ins(ip_address, start_date, end_date, register_id, "매크로");
    }

    @Transactional(value = "gameTxManager")
    public void createGameIp(String ip_address){
        gameMapper.createIpBan(ip_address);
    }

    @Transactional(value = "adminTxManager")
    public void createGameIp2(String ip_address){
        gameMapper.createIpBan(ip_address);
    }

    @Transactional(value = "adminTxManager")
    public void notGlobal(String ip_address, Date start_date, Date end_date, String register_id, String ban_reason){
        gameMapper.createIpBan(ip_address);
        adminMapper.ins(ip_address, start_date, end_date, register_id, "매크로");
    }



}
