package com.leleplus;

import com.leleplus.common.utils.SecurityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DriverApplicationTests {

	@Test
	void contextLoads() {
	}


	/**
	 * 生成密码
	 */
	@Test
	void generatePassword() {
		System.out.println("密码-> " + SecurityUtils.encryptPassword("12345"));
	}
}
