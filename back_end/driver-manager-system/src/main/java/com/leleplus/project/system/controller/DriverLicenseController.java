package com.leleplus.project.system.controller;

import com.leleplus.core.web.domain.AjaxResult;
import com.leleplus.project.system.service.IDriverLicenseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @className DriverLicenseController
 * @date 2020-04-11 23:15
 * @description 驾驶证类型前端控制器
 */

@Api (tags = "驾驶证前端接口")
@RestController
@RequestMapping ("/driverLicense")
public class DriverLicenseController {

	@Autowired
	private IDriverLicenseService service;


	@ApiOperation ("查询所有的驾驶证类型")
	@GetMapping
	public AjaxResult getAll() {
		AjaxResult ajax = AjaxResult.success();
		ajax.put(AjaxResult.DATA_TAG, service.selectAll());
		return ajax;
	}


}
