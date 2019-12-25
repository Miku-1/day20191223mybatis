package com.pojo;

/*
 *@Date: 22:51 2019/12/23
 *@Description:
 */

import lombok.Data;

import java.util.Date;

@Data
public class Member {
    private Integer id;
    private String qq_number;
    private String password;
    private String img_url;
    private String nick_name;
    private String sex;

}
