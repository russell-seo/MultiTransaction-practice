package com.example.multitransaction.mapper.admin;


import com.example.multitransaction.bean.IpBan;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface AdminMapper {
    @Select("select count(*) from dbid")
    int test();

    @Insert("insert into ip_ban(ip_address, start_date, end_date, register_id, ban_reason) " +
            "values (#{ip_address}, #{start_date}, #{end_date}, #{register_id}, #{ban_reason})")
    int ins(String ip_address, Date start_date, Date end_date, String register_id, String ban_reason);


    int createIpBanByExcel(List<IpBan.BanDto> ipBanDto);
}
