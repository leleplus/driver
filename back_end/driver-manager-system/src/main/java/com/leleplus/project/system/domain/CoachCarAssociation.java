package com.leleplus.project.system.domain;

import com.leleplus.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @className CoachANDCar关联表
 * @date 2020-04-06 22:29
 * @description 教练和教练车关联表
 */

@Data
@Accessors (chain = true)
public class CoachCarAssociation extends BaseEntity {

	private static final long serialVersionUID = - 6109540712519121311L;

	// 教练id
	private Long coachId;

	// 车辆id
	private Long carId;

	// 是否删除
	private Boolean deleted;

	// 级联车信息
	private CoachCar car;
}
