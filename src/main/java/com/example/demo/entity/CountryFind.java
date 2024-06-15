package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@TableName("u_country_find")
@Data
public class CountryFind {
    @TableId(type = IdType.AUTO)
    Integer id;

    @NotEmpty(message = "请输入生物名称")
    String organName;

    @NotEmpty(message = "请输入国家名称")
    String countryName;

    @NotNull(message = "请输入发现时间")
    Date foundTime;

    @NotNull(message = "请输入经度")
    BigDecimal longitude;

    @NotNull(message = "请输入纬度")
    BigDecimal latitude;
}
