package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@TableName("u_trade_organ")
public class TraderOrgan {
    @TableId(type = IdType.AUTO)
    Integer id;

    @NotEmpty(message = "请输入编号")
    Integer num;

    @NotEmpty(message = "请输入名称")
    String name;

    @NotEmpty(message = "请输入门")
    String men;

    @NotEmpty(message = "请输入刚")
    String gang;

    @NotEmpty(message = "请输入环境")
    String environment;

    @NotEmpty(message = "请输入形态")
    String shape;

    @NotEmpty(message = "请输入危害性")
    String harm;
}
