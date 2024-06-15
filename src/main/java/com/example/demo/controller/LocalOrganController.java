package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.commom.Result;
import com.example.demo.entity.LocalOrgan;
import com.example.demo.mapper.LocalOrganMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/local-organ")
public class LocalOrganController {
    @Resource
    LocalOrganMapper localOrganMapper;

    @PostMapping
    public Result<?> add(@RequestBody @Valid LocalOrgan country) {
        localOrganMapper.insert(country);
        return Result.success();
    }

    @PutMapping
    public Result<?> update(@RequestBody @Valid LocalOrgan country) {
        localOrganMapper.updateById(country);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<?> info(@PathVariable Long id) {
        LocalOrgan country = localOrganMapper.selectById(id);
        return Result.success(country);
    }


    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        localOrganMapper.deleteById(id);
        return Result.success();
    }

    @DeleteMapping
    public Result<?> deleteBatch(@RequestParam List<Long> ids) {
        localOrganMapper.deleteBatchIds(ids);
        return Result.success();
    }

    @GetMapping
    public Result<?> list(@RequestParam(defaultValue = "1") Integer pageNum,
                          @RequestParam(defaultValue = "10") Integer pageSize,
                          @RequestParam(defaultValue = "") String name,
                          @RequestParam(defaultValue = "") String men) {
        LambdaQueryWrapper<LocalOrgan> wrappers = Wrappers.lambdaQuery();

        if (StringUtils.isNotBlank(name)) {
            wrappers.like(LocalOrgan::getName, name);
        }

        if (StringUtils.isNotBlank(men)) {
            wrappers.like(LocalOrgan::getMen, men);
        }

        Page<LocalOrgan> result = localOrganMapper.selectPage(new Page<>(pageNum, pageSize), wrappers);
        return Result.success(result);
    }
}
