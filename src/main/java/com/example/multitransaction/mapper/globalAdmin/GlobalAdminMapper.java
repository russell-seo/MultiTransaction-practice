package com.example.multitransaction.mapper.globalAdmin;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface GlobalAdminMapper {

    @Insert("insert into ip_ban(ip_address, start_date, end_date, register_id, ban_reason) " +
            "values (#{ip_address}, #{start_date}, #{end_date}, #{register_id}, #{ban_reason})")
    int ins(String ip_address, Date start_date, Date end_date, String register_id, String ban_reason);
}
