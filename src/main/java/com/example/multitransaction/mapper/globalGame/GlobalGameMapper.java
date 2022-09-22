package com.example.multitransaction.mapper.globalGame;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface GlobalGameMapper {

    @Insert("insert into ip_blocklist values(#{ip})")
    void createIpBan(@Param("ip") String ip);
}
