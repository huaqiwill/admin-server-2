package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.annotations.Update;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Map;

@TableName("u_user")
@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @NotEmpty(message = "请输入用户名")
    private String username;

    @NotEmpty(message = "请输入用户昵称")
    private String nickName;

    @NotEmpty(message = "请输入密码")
    private String password;

    @NotEmpty(message = "请输入性别")
    private String sex;

    @NotEmpty(message = "请输入地址 ")
    private String address;

    @NotEmpty(message = "请输入手机号")
    private String phone;

//    @TableField(exist = false)  //表中没有token不会报错仍能编译运行
    private String token;

    @NotNull(message = "请输入角色")
    private String role;
}
