package com.leleplus.project.system.controller;

import com.leleplus.core.web.controller.BaseController;
import com.leleplus.core.web.domain.AjaxResult;
import com.leleplus.core.web.page.TableDataInfo;
import com.leleplus.project.system.domain.RFIDCard;
import com.leleplus.project.system.service.IRFIDCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @className RFIDCardController
 * @date 2020-04-05 19:20
 * @description RFID前端控制器
 */
@RestController
@RequestMapping("/rfid")
public class RFIDCardController extends BaseController {

    @Autowired
    private IRFIDCardService rfidCardService;


    /**
     * 获取所有已经登记的RFID卡
     *
     * @param rfidCard
     * @return
     */
    @GetMapping("/list")
    public TableDataInfo getAllRFID(RFIDCard rfidCard) {
        startPage();
        return getDataTable(rfidCardService.getAll(rfidCard));
    }

    /**
     * 获取卡片详细信息
     *
     * @param id
     * @return
     */
//    @PreAuthorize("@ss.hasPermi('system:user:query')")
    @GetMapping("/{id}")
    public AjaxResult getRFID(@PathVariable(value = "id", required = false) Long id) {
        AjaxResult ajax = AjaxResult.success();
        ajax.put(AjaxResult.DATA_TAG, rfidCardService.selectById(id));
        return ajax;
    }

    /**
     * 登记RFID卡片信息
     *
     * @param rfidCard
     * @return
     */
    @PostMapping
    public AjaxResult newRFID(@RequestBody RFIDCard rfidCard) {
        AjaxResult ajax = AjaxResult.success();
        ajax.put(AjaxResult.DATA_TAG, rfidCardService.addByObject(rfidCard));
        return ajax;
    }

    /**
     * 修改RFID信息
     *
     * @param rfidCard
     * @return
     */
    @PutMapping
    public AjaxResult updateRFID(@RequestBody RFIDCard rfidCard) {
        rfidCardService.updateByArg(rfidCard);
        return AjaxResult.success();
    }

    /**
     * 删除RFID信息（支持批量删除），需要前端拼接id，使用,
     *
     * @param ids
     * @return
     */
    @DeleteMapping
    public AjaxResult delRFID(@RequestBody String ids) {
        rfidCardService.BatchDelete(ids);
        return AjaxResult.success();
    }

}
