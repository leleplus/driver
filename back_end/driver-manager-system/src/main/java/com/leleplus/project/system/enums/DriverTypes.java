package com.leleplus.project.system.enums;

import com.leleplus.project.system.domain.DriverLicense;
import lombok.Getter;

/**
 * Copyright (C) @2020 fgwang.660@gmail.com
 *
 * @author witt
 * @version 1.0
 * @enumName DriverTypes
 * @date 2020-04-03 17:05
 * @description 驾照类型枚举
 */
public enum DriverTypes {
//    A1(new DriverLicense("A1","大型载客汽车","A3、B1、B2、C1、C2、C3、C4、M",false)),
//    A2(new DriverLicense("A2","重型、中型全挂、半挂汽车列车","B1、B2、C1、C2、C3、C4、M",false)),
//    A3(new DriverLicense("A3","核载10人以上的城市公共汽车","C1、C2、C3、C4",false)),
//    B1(new DriverLicense("B1","中型载客汽车(含核载10人以上、19人以下的城市公共汽车)","C1、C2、C3、C4、M",false)),
//    B2(new DriverLicense("B2","重型、中型载货汽车;大、重、中型专项作业车","C1、C2、C3、C4、M",false)),
//    C1(new DriverLicense("C1","小型、微型载客汽车以及轻型、微型载货汽车、轻、小、微型专项作业车","C2、C3、C4",false)),
//    C2(new DriverLicense("C2","小型、微型自动挡载客汽车以及轻型、微型自动挡载货汽车","无",false)),
//    C3(new DriverLicense("C3","低速载货汽车(原四轮农用运输车)","C4",false)),
//    C4(new DriverLicense("C4","三轮汽车(原三轮农用运输车)","无",false)),
//    C5(new DriverLicense("C5","残疾人专用小型、微型自动挡载客汽车(只允许右下肢或者双下肢残疾人驾驶)","无",false)),
//    D (new DriverLicense("D", "普通三轮摩托车发动机排量大于50ml或者最大设计车速大于50km/h的三轮摩托车","E、F",false)),
//    E (new DriverLicense("E", "普通二轮摩托车发动机排量大于50ml或者最大设计车速大于50km/h的二轮摩托车","F",false)),
//    F (new DriverLicense("F", "轻便摩托车发动机排量小于等于50ml，最大设计车速小于等于50km/h的摩托车","无",false)),
//    M (new DriverLicense("M", "轮式自行机械车","无",false)),
//    N (new DriverLicense("N", "无轨电车无轨电车","无",false)),
//    P (new DriverLicense("P", "有轨电车有轨电车","无",false)),

//    A1("A1","大型载客汽车","A3、B1、B2、C1、C2、C3、C4、M",false)),
//    A2("A2","重型、中型全挂、半挂汽车列车","B1、B2、C1、C2、C3、C4、M",false)),
//    A3("A3","核载10人以上的城市公共汽车","C1、C2、C3、C4",false)),
//    B1("B1","中型载客汽车(含核载10人以上、19人以下的城市公共汽车)","C1、C2、C3、C4、M",false)),
//    B2("B2","重型、中型载货汽车;大、重、中型专项作业车","C1、C2、C3、C4、M",false)),
//    C1("C1","小型、微型载客汽车以及轻型、微型载货汽车、轻、小、微型专项作业车","C2、C3、C4",false)),
//    C2("C2","小型、微型自动挡载客汽车以及轻型、微型自动挡载货汽车","无",false)),
//    C3("C3","低速载货汽车(原四轮农用运输车)","C4",false)),
//    C4("C4","三轮汽车(原三轮农用运输车)","无",false)),
//    C5("C5","残疾人专用小型、微型自动挡载客汽车(只允许右下肢或者双下肢残疾人驾驶)","无",false)),
//    D ("D", "普通三轮摩托车发动机排量大于50ml或者最大设计车速大于50km/h的三轮摩托车","E、F",false)),
//    E ("E", "普通二轮摩托车发动机排量大于50ml或者最大设计车速大于50km/h的二轮摩托车","F",false)),
//    F ("F", "轻便摩托车发动机排量小于等于50ml，最大设计车速小于等于50km/h的摩托车","无",false)),
//    M ("M", "轮式自行机械车","无",false)),
//    N ("N", "无轨电车无轨电车","无",false)),
//    P ("P", "有轨电车有轨电车","无",false)),
    ;

    @Getter
    private DriverLicense driverLicense;

    DriverTypes(DriverLicense driverLicense){
        this.driverLicense = driverLicense;
    }
}
