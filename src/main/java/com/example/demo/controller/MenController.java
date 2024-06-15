package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.commom.Result;
import com.example.demo.entity.Men;
import com.example.demo.mapper.MenMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/men")
public class MenController {
    @Resource
    MenMapper menMapper;

    @PostMapping
    public Result<?> add(@RequestBody @Valid Men country) {
        menMapper.insert(country);
        return Result.success();
    }

    @PutMapping
    public Result<?> update(@RequestBody @Valid Men country) {
        menMapper.updateById(country);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<?> info(@PathVariable Long id) {
        Men country = menMapper.selectById(id);
        return Result.success(country);
    }


    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        menMapper.deleteById(id);
        return Result.success();
    }

    @DeleteMapping
    public Result<?> deleteBatch(@RequestParam List<Long> ids) {
        menMapper.deleteBatchIds(ids);
        return Result.success();
    }

    @GetMapping
    public Result<?> list(@RequestParam(defaultValue = "1") Integer pageNum,
                          @RequestParam(defaultValue = "10") Integer pageSize,
                          @RequestParam(defaultValue = "") String name) {
        LambdaQueryWrapper<Men> wrappers = Wrappers.lambdaQuery();

        if (StringUtils.isNotBlank(name)) {
            wrappers.like(Men::getName, name);
        }

        Page<Men> result = menMapper.selectPage(new Page<>(pageNum, pageSize), wrappers);
        return Result.success(result);
    }

    @GetMapping("/nameList")
    public Result<?> nameList() {
        List<String> nameList = menMapper.nameList();
        return Result.success(nameList);
    }
}
