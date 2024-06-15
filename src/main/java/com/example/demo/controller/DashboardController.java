package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.*;
import com.example.demo.mapper.*;
import com.example.demo.utils.LoginUser;
import com.example.demo.commom.Result;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Resource
    private UserMapper userMapper;

    @Resource
    private LocalOrganMapper localOrganMapper;

    @Resource
    private CountryMapper countryMapper;

    @Resource
    private PortMapper portMapper;

    @Resource
    private PortFindMapper portFindMapper;

    @Resource
    private TraderOrganMapper traderOrganMapper;

    @Resource
    private CountryFindMapper countryFindMapper;

    @GetMapping
    public Result<?> records() {
        // 总访问
        int visitCount = LoginUser.getVisitCount();
        // 用户数
        int userCount = userMapper.selectCount(new QueryWrapper<>());
        // 生物数
        int biologyCount = localOrganMapper.selectCount(new QueryWrapper<>());
        // 国家数
        int countryCount = countryMapper.selectCount(new QueryWrapper<>());
        // 港口数
        int portCount = portMapper.selectCount(new QueryWrapper<>());
        // 港口发现生物
        int portFindCount = portFindMapper.selectCount(new QueryWrapper<>());
        // 港口检测生物
        int portCheckCount = traderOrganMapper.selectCount(new QueryWrapper<>());
        // 国家发现有害生物
        int countryFindCount = countryFindMapper.selectCount(new QueryWrapper<>());

        Map<String, Object> map = new HashMap<>();//键值对形式
        map.put("visitCount", visitCount);//放置visitCount到map中
        map.put("userCount", userCount);
        map.put("biologyCount", biologyCount);
        map.put("countryCount", countryCount);
        map.put("portCount", portCount);
        map.put("portFindCount", portFindCount);
        map.put("portCheckCount", portCheckCount);
        map.put("countryFindCount", countryFindCount);

        return Result.success(map);
    }
}
