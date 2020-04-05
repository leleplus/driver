package com.leleplus.project.system.service;

import com.leleplus.common.service.ICRUDService;
import com.leleplus.project.system.domain.RFIDCard;

import java.util.List;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @interfaceName IRFIDService
 * @date 2020-04-05 16:25
 * @description RFIDService层接口
 */
public interface IRFIDCardService extends ICRUDService<RFIDCard> {


    /**
     * 根据条件分页查询RFID数据
     *
     * @param rfidCard
     * @return
     */
    List<RFIDCard> getAll(RFIDCard rfidCard);
}
