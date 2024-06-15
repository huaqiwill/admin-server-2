package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.commom.Result;
import com.example.demo.entity.Port;
import com.example.demo.mapper.PortMapper;
import com.example.demo.service.PortService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/port")
public class PortController {

    @Resource
    private PortService portService;

    @PostMapping
    public Result<?> add(@RequestBody @Valid Port port) {
        return portService.add(port);
    }

    @PutMapping
    public Result<?> update(@RequestBody @Valid Port port) {
        return portService.update(port);
    }

    @GetMapping("/{id}")
    public Result<?> info(@PathVariable Long id) {
        return portService.info(id);
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        return portService.delete(id);
    }

    @DeleteMapping
    public Result<?> deleteBatch(@RequestParam("ids") List<Long> ids) {
        return portService.deleteBatch(ids);
    }


    @GetMapping
    public Result<?> list(@RequestParam(defaultValue = "1") Integer pageNum,
                          @RequestParam(defaultValue = "10") Integer pageSize,
                          @RequestParam(defaultValue = "") String countryName,
                          @RequestParam(defaultValue = "") String portName,
                          @RequestParam(defaultValue = "") String province) {
        return portService.list(pageNum, pageSize, countryName, portName, province);
    }

    @GetMapping("/nameList")
    public Result<?> nameList() {
        return portService.nameList();
    }
}
