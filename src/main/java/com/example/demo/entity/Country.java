package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 国家
 */
@TableName("u_country")
@Data
public class Country {
    @TableId(type = IdType.AUTO)
    Integer id;

    @NotNull(message = "请输入国家编号")
    Integer num;

    @NotEmpty(message = "请输入国家名称")
    String name;

//    @NotEmpty(message = "请输入端口名称")
//    String portName;

    @NotEmpty(message = "是否为贸易国家？")
    String isTrader;

    Integer status;
}
