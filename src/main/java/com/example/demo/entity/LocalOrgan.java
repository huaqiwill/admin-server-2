package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@TableName("u_local_organ")
public class LocalOrgan {
    @TableId(type = IdType.AUTO)
    Integer id;

    @NotNull(message = "请输入本地生物编号")
    Integer num;

    @NotEmpty(message = "请输入本地生物名称")
    String name;

    @NotEmpty(message = "请输入门")
    String men;

    @NotNull(message = "请输入发现时间")
    Date foundTime;
}
