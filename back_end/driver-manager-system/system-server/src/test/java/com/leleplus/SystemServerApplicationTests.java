package com.leleplus;

import com.leleplus.bean.User;
import com.leleplus.dao.UserMapper;
import com.leleplus.expand.enums.SystemCodeEnum;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SystemServerApplicationTests {

    @Test
    void contextLoads () {
    }
    @Autowired
    private UserMapper userMapper;

    @Test
    public void addTestUser(){

        User user = new User();
        user.setEmail("1989161762@qq.com");
        user.setEnable(1);
        user.setIdCard("622223199709082335");
        user.setLoginId("driver@lele");
        user.setUsername("乐乐");
        user.setTelphone("13629365547");

        user.setRoleName(StringUtils.join(",",new String[]{
                SystemCodeEnum.ID_ADMINISTRATOR.getName(),
                SystemCodeEnum.ID_COACH.getName(),
                SystemCodeEnum.ID_STUDENT.getName(),
        }));
        user.setRoleCode(StringUtils.join(",",new String[]{
                SystemCodeEnum.ID_ADMINISTRATOR.getCode(),
                SystemCodeEnum.ID_COACH.getCode(),
                SystemCodeEnum.ID_STUDENT.getCode(),
        }));
        user.setPassword(new BCryptPasswordEncoder().encode("driver@123"));
        userMapper.insert(user);

    }

}
