package com.wanjiayun.shirojwt.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "easy_user")
public class User implements Serializable {
    private Integer id;

    private String username;

    private String pass;

    private String role;

    private String permission;

}
