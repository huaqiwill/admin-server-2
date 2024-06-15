package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.commom.Result;
import com.example.demo.entity.Country;
import com.example.demo.mapper.CountryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class CountryService {
    @Resource
    private CountryMapper countryMapper;

    public Result<?> list(Integer pageNum, Integer pageSize, String name, String isTrader) {
        LambdaQueryWrapper<Country> wrappers = Wrappers.lambdaQuery();

        if (StringUtils.isNotBlank(name)) {
            wrappers.like(Country::getName, name);
        }

        if (StringUtils.isNotBlank(isTrader)) {
            wrappers.like(Country::getIsTrader, isTrader);
        }

        Page<Country> result = countryMapper.selectPage(new Page<>(pageNum, pageSize), wrappers);
        return Result.success(result);
    }

    public Result<?> nameList() {
        List<String> result = countryMapper.nameList();
        return Result.success(result);
    }

    public Result<?> info(Long id) {
        Country country = countryMapper.selectById(id);
        return Result.success(country);
    }

    public Result<?> delete(Long id) {
        countryMapper.deleteById(id);
        return Result.success();
    }

    public Result<?> add(Country country) {
        try {
            Country country1 = countryMapper.selectOne(new LambdaQueryWrapper<Country>().eq(Country::getName, country.getName()));
            if (!Objects.isNull(country1)) {
                return Result.error("1", "国家已存在");
            }
        } catch (Exception e) {
            return Result.error("1", "国家已存在");
        }
        countryMapper.insert(country);
        return Result.success();
    }

    public Result<?> update(Country country) {
        countryMapper.updateById(country);
        return Result.success();
    }

    public Result<?> deleteBatch(List<Long> ids) {
        countryMapper.deleteBatchIds(ids);
        return Result.success();
    }
}
