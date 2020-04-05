package com.leleplus.project.system.domain.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 路由显示信息
 *
 * @author witt
 */

@Data
@Accessors(chain = true)
public class MetaVo {
    /**
     * 设置该路由在侧边栏和面包屑中展示的名字
     */
    private String title;

    /**
     * 设置该路由的图标，对应路径src/icons/svg
     */
    private String icon;

    public MetaVo() {
    }

    public MetaVo(String title, String icon) {
        this.title = title;
        this.icon = icon;
    }
}
