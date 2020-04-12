package com.leleplus.project.monitor.controller;


import com.leleplus.core.web.controller.BaseController;
import com.leleplus.core.web.domain.AjaxResult;
import com.leleplus.core.web.domain.Server;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务器监控
 *
 * @author witt
 */

@Api (tags = "服务器监控接口")
@RestController
@RequestMapping ("/monitor/server")
public class ServerController extends BaseController {

	@ApiOperation ("查询服务器信息")
	@PreAuthorize ("@ss.hasPermi('monitor:server:list')")
	@GetMapping ()
	public AjaxResult getInfo() throws Exception {
		Server server = new Server();
		server.copyTo();
		return AjaxResult.success(server);
	}
}
