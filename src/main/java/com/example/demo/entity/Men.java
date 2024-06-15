package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@TableName("u_men")
public class Men {
    @TableId(type = IdType.AUTO)
    Integer id;

    @NotNull(message = "请输入门编号")
    Integer num;

    @NotEmpty(message = "请输入门名称")
    String name;
}
