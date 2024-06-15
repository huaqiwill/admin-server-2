package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Country;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CountryMapper extends BaseMapper<Country> {
    @Select("SELECT name FROM u_country WHERE status=1")
    List<String> nameList();

}
