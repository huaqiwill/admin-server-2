package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.commom.Result;
import com.example.demo.entity.Country;
import com.example.demo.entity.User;
import com.example.demo.mapper.CountryMapper;
import com.example.demo.service.CountryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Resource
    private CountryService countryService;

    @PostMapping
    public Result<?> add(@RequestBody @Valid Country country) {
        return countryService.add(country);
    }

    @PutMapping
    public Result<?> update(@RequestBody @Valid Country country) {
        return countryService.update(country);
    }

    @GetMapping("/{id}")
    public Result<?> info(@PathVariable Long id) {
        return countryService.info(id);
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        return countryService.delete(id);
    }

    @DeleteMapping
    public Result<?> deleteBatch(@RequestParam List<Long> ids) {
        return countryService.deleteBatch(ids);
    }

    @GetMapping
    public Result<?> list(@RequestParam(defaultValue = "1") Integer pageNum,
                          @RequestParam(defaultValue = "10") Integer pageSize,
                          @RequestParam(defaultValue = "") String name,
                          @RequestParam(defaultValue = "") String isTrader) {
        return countryService.list(pageNum, pageSize, name, isTrader);
    }

    @GetMapping("/nameList")
    public Result<?> nameList() {
        return countryService.nameList();
    }
}
