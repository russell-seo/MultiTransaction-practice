package com.example.multitransaction.mapper;

import com.example.multitransaction.mapper.globalAdmin.GlobalAdminMapper;
import com.example.multitransaction.mapper.globalGame.GlobalGameMapper;
import com.example.multitransaction.service.AdminService;
import com.example.multitransaction.service.GameService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@SpringBootTest
@Rollback(value = false)
public class GlobalTransactionTest {

    @Autowired
    GlobalAdminMapper adminMapper;

    @Autowired
    GlobalGameMapper gameMapper;

    @Autowired
    GameService gameService;

    @Autowired
    AdminService adminService;





    @Test
    @Transactional(transactionManager = "gameTxManager")
    @DisplayName("게임 IP 밴")
    void GameDB_Insert(){
        gameMapper.createIpBan("111.10.10.111");
    }


    @Test
    void Insert_테스트(){
        String ip_address = "123.123.123.4";
        adminService.createIp(ip_address, new Date(), new Date(), "kiaofk", "매크로");
    }

    @Test
    void 멀티아닌_Insert(){
        String ip_address = "123.123.123.5";
        adminService.notMultiTx(ip_address, new Date(), new Date(), "kiaofk", "매크로");
    }


    @Test
    void 일반DataSourceTest(){
        String ip_address = "123.123.123.5";
        adminService.notGlobal(ip_address, new Date(), new Date(), "kiaofk", "매크로");
    }
}
