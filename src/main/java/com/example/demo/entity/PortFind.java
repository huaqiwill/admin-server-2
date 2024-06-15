package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.sql.rowset.spi.SyncResolver;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@TableName("u_port_find")
public class PortFind {

    @TableId(type = IdType.AUTO)
    Integer id;

    @NotEmpty(message = "请输入生物名称")
    String organName;

    @NotEmpty(message = "请输入港口名称")
    String portName;

    @NotEmpty(message = "请输入省份")
    String province;

    @NotEmpty(message = "请输入特殊种类")
    String superiorSpecies;

    @NotEmpty(message = "请输入丰富度")
    String abundance;

    @NotEmpty(message = "请输入丰富度比例")
    String abundanceRate;
}
