package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 港口
 */
@TableName("u_port")
@Data
public class Port {

    @TableId(type = IdType.AUTO)
    Integer id;

    @NotNull(message = "请输入港口编号")
    Integer num;

    @NotEmpty(message = "请输入港口名称")
    String name;

    @NotEmpty(message = "请输入国家名称")
    String countryName;

    @NotEmpty(message = "请输入省份")
    String province;
}
