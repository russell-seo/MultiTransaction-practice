package com.example.multitransaction.mapper;

import com.example.multitransaction.mapper.admin.AdminMapper;
import com.example.multitransaction.mapper.game.GameMapper;
import com.example.multitransaction.service.GameService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class MapperTest {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    GameMapper gameMapper;

    @Autowired
    GameService gameService;

    @Test
    void 테스트(){
        int test = adminMapper.test();

        System.out.println("test = " + test);

        Assertions.assertThat(test).isEqualTo(7);
    }

    @Test
    void GameDBTest(){
        int ipBanList = gameMapper.findIpBanList();

        System.out.println("ipBanList = " + ipBanList);

        Assertions.assertThat(ipBanList).isEqualTo(9);
    }


    @Test
    @Transactional
    @Rollback(value = true)
    @DisplayName("게임 IP 밴")
    void GameDB_Insert(){
        gameMapper.createIpBan("10.10.10.1");
    }
}
