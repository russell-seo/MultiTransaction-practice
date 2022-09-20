package com.example.multitransaction.mapper.admin;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {
    @Select("select count(*) from dbid")
    int test();
}
