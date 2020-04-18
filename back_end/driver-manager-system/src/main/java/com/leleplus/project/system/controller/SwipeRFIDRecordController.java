package com.leleplus.project.system.controller;

import com.leleplus.core.web.controller.BaseController;
import com.leleplus.core.web.domain.AjaxResult;
import com.leleplus.core.web.page.TableDataInfo;
import com.leleplus.project.monitor.domain.SwipeRecord;
import com.leleplus.project.system.service.ISwipeRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @className SwipeRFIDRecordController
 * @date 2020-04-18 13:24
 * @description 刷卡记录前端接口
 */
@Api (tags = "RFID刷卡记录接口")
@RestController
@RequestMapping ("/swipeRFIDRecord")
public class SwipeRFIDRecordController extends BaseController {

	@Autowired
	private ISwipeRecordService swipeRecordService;


	@ApiOperation ("查询所有的刷卡记录")
	@PostMapping()
	public TableDataInfo getAllRFID(SwipeRecord record) {
		startPage();

		return getDataTable(swipeRecordService.selectAllByPage(record));
	}

	@ApiOperation(value = "删除刷卡记录",notes = "根据id删除刷卡记录（支持批量删除）")
	@DeleteMapping
	public AjaxResult delUserInfo(@RequestBody String ids) {
		swipeRecordService.BatchDelete(ids);
		return AjaxResult.success();
	}

}
