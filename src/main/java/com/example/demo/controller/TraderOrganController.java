package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.commom.Result;
import com.example.demo.entity.TraderOrgan;
import com.example.demo.mapper.TraderOrganMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/trader-organ")
public class TraderOrganController {
    @Resource
    TraderOrganMapper traderOrganMapper;

    @PostMapping
    public Result<?> add(@RequestBody @Valid TraderOrgan traderOrgan) {
        traderOrganMapper.insert(traderOrgan);
        return Result.success();
    }

    @PutMapping
    public Result<?> update(@RequestBody @Valid TraderOrgan traderOrgan) {
        traderOrganMapper.updateById(traderOrgan);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<?> info(@PathVariable Long id) {
        TraderOrgan country = traderOrganMapper.selectById(id);
        return Result.success(country);
    }


    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        traderOrganMapper.deleteById(id);
        return Result.success();
    }

    @DeleteMapping
    public Result<?> deleteBatch(@RequestParam List<Long> ids) {
        traderOrganMapper.deleteBatchIds(ids);
        return Result.success();
    }

    @GetMapping
    public Result<?> list(@RequestParam(defaultValue = "1") Integer pageNum,
                          @RequestParam(defaultValue = "10") Integer pageSize,
                          @RequestParam(defaultValue = "") String name,
                          @RequestParam(defaultValue = "") String men,
                          @RequestParam(defaultValue = "") String gang) {
        LambdaQueryWrapper<TraderOrgan> wrappers = Wrappers.lambdaQuery();

        if (StringUtils.isNotBlank(name)) {
            wrappers.like(TraderOrgan::getName, name);
        }

        if (StringUtils.isNotBlank(men)) {
            wrappers.like(TraderOrgan::getMen, men);
        }

        if (StringUtils.isNotBlank(gang)) {
            wrappers.like(TraderOrgan::getGang, gang);
        }

        Page<TraderOrgan> result = traderOrganMapper.selectPage(new Page<>(pageNum, pageSize), wrappers);
        return Result.success(result);
    }
}
