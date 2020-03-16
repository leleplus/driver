package com.leleplus.domain;

import com.leleplus.bean.User;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author lele
 * @version 1.0
 * @ClassName UserPlus
 * @date 2020-02-19 21:46
 * @description page使用的User类
 */
@Data
@Accessors(chain = true)
public class UserPlus extends User {

    public String realName;

    private String gender;

    private String address;

    private String birthday;

}
