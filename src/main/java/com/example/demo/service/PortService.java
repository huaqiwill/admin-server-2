package com.example.demo.service;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.commom.Result;
import com.example.demo.entity.Country;
import com.example.demo.entity.Port;
import com.example.demo.mapper.PortMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class PortService {
    @Resource
    private PortMapper portMapper;

    public Result<?> list(Integer pageNum, Integer pageSize, String countryName, String portName, String province) {
        LambdaQueryWrapper<Port> wrappers = Wrappers.lambdaQuery();

        if (StringUtils.isNotBlank(countryName)) {
            wrappers.like(Port::getCountryName, countryName);
        }

        if (StringUtils.isNotBlank(portName)) {
            wrappers.like(Port::getName, portName);
        }

        if (StringUtils.isNotBlank(province)) {
            wrappers.like(Port::getProvince, province);
        }

        Page<Port> result = portMapper.selectPage(new Page<>(pageNum, pageSize), wrappers);
        return Result.success(result);
    }

    public Result<?> nameList() {
        List<String> result = portMapper.nameList();
        return Result.success(result);
    }

    public Result<?> info(Long id) {
        Port country = portMapper.selectById(id);
        return Result.success(country);
    }

    public Result<?> delete(Long id) {
        portMapper.deleteById(id);
        return Result.success();
    }

    public Result<?> add(Port port) {
        try {
            Port port1 = portMapper.selectOne(new LambdaQueryWrapper<Port>().eq(Port::getName, port.getName()));
            if (!Objects.isNull(port1)) {
                return Result.error("1", "港口已存在");
            }
        } catch (Exception e) {
            return Result.error("1", "港口已存在");
        }
        portMapper.insert(port);
        return Result.success();
    }

    public Result<?> update(Port port) {
        portMapper.updateById(port);
        return Result.success();
    }

    public Result<?> deleteBatch(List<Long> ids) {
        portMapper.deleteBatchIds(ids);
        return Result.success();
    }
}

