package com.example.multitransaction.mapper.game;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface GameMapper {

//    @Select("select count(*) from ip_blocklist")
    int findIpBanList();


    @Insert("insert into ip_blocklist values(#{ip})")
    void createIpBan(@Param("ip") String ip);



    @Select("select * from ip_blocklist")
    List<String> findAllBannedIp();

    int createIpBanToOpGameDB(List<String> notDuplicateIpAddress);

}
