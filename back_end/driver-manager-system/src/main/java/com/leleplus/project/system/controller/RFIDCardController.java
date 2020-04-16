package com.leleplus.project.system.controller;

import com.leleplus.core.web.controller.BaseController;
import com.leleplus.core.web.domain.AjaxResult;
import com.leleplus.core.web.page.TableDataInfo;
import com.leleplus.project.system.domain.RFIDCard;
import com.leleplus.project.system.domain.UserRFID;
import com.leleplus.project.system.service.IRFIDCardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @className RFIDCardController
 * @date 2020-04-05 19:20
 * @description RFID前端控制器
 */

@Api(tags = "RFID卡片数据接口")
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

    @ApiOperation("查询所有已经注册的RFID数据")
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

    @ApiOperation("根据系统id查询RFID数据")
    //    @PreAuthorize("@ss.hasPermi('system:user:query')")
    @GetMapping("/{id}")
    public AjaxResult getRFID(@PathVariable(value = "id", required = false) Long id) {
        AjaxResult ajax = AjaxResult.success();
        ajax.put(AjaxResult.DATA_TAG, rfidCardService.selectById(id));
        return ajax;
    }

    /**
     * 通过RFID物理卡号查询数据
     *
     * @param phyId
     * @return
     */

    @ApiOperation("根据RFID物理卡号查询数据")
    @GetMapping("rw/{phyId}")
    public AjaxResult getRFID(@PathVariable(value = "phyId", required = false) String phyId) {
        AjaxResult ajax = AjaxResult.success();
        ajax.put(AjaxResult.DATA_TAG, rfidCardService.selectByPhyNumber(phyId));
        return ajax;
    }


    /**
     * 登记RFID卡片信息
     *
     * @param rfidCard
     * @return
     */

    @ApiOperation("注册RFID卡数据")
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

    @ApiOperation("更新RFID卡数据")
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

    @ApiOperation("删除RFID卡数据")
    @DeleteMapping
    public AjaxResult delRFID(@RequestBody String ids) {
        rfidCardService.BatchDelete(ids);
        return AjaxResult.success();
    }

    /**
     * 查询用户绑定的RFID卡
     *
     * @param userInfoId
     * @return
     */
    @ApiOperation("查询用户绑定的RFID卡信息")
    @GetMapping("/user/{userInfoId}")
    public AjaxResult getUserRFID(@PathVariable(value = "userInfoId") Long userInfoId) {
        List<UserRFID> userRFIDS = rfidCardService.selectUserRFID(userInfoId);
        AjaxResult ajax = AjaxResult.success();
        ajax.put(AjaxResult.DATA_TAG, userRFIDS);
        return ajax;
    }


    /**
     * 用户绑定RFID
     *
     * @param userInfoId
     * @return
     */

    @ApiOperation("为用户绑定RFID")
    @GetMapping("/user/add/{userInfoId}")
    public AjaxResult bindUserRFID(@PathVariable("userInfoId") Long userInfoId) {
        rfidCardService.bindUserRFID(userInfoId);
        return AjaxResult.success();
    }

    /**
     * 用户换绑
     *
     * @param userRFID
     * @return
     */

    @ApiOperation("为用户换绑RFID卡数据")
    @PutMapping("/user/change")
    public AjaxResult changeUserRFID(@RequestBody UserRFID userRFID) {
        rfidCardService.updateUserRFID(userRFID);
        return AjaxResult.success();
    }

    /**
     * 解绑卡
     *
     * @param userRFID
     * @return
     */

    @ApiOperation("解绑用户RFID卡数据")
    @DeleteMapping("/user/delete/")
    public AjaxResult untieUserRFID(@RequestBody UserRFID userRFID) {
        rfidCardService.deleteUserRFID(userRFID);
        return AjaxResult.success();
    }


    /**
     * STM32刷卡接口
     * @param machineId 刷卡设备
     * @param number 当前卡的物理卡号
     * @return 请求
     */

    @ApiOperation("RFID刷卡接口")
    @GetMapping("/swipe/{machineId}/{number}")
    public AjaxResult swipe(@PathVariable("machineId") String machineId, @PathVariable("number") String number) {
        rfidCardService.swipe(machineId,number);
        return AjaxResult.success("OK!");
    }

    /**
     * 前端获取卡id，从redis中获取
     *
     * @return
     */

    @ApiOperation("前端轮询卡数据接口")
    @GetMapping("/testing")
    public AjaxResult testing() {
        RFIDCard rfidCard = rfidCardService.testing();
        return AjaxResult.success(rfidCard);
    }


}
