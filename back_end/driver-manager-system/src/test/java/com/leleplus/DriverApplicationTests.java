package com.leleplus;

import com.leleplus.common.utils.SecurityUtils;
import com.leleplus.project.system.domain.DriverLicense;
import com.leleplus.project.system.mapper.DriverLicenseMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DriverApplicationTests {

	@Autowired
	private DriverLicenseMapper mapper;

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


	/**
	 * 生成驾驶证类型数据
	 */
	@Test
	public void generateDriverLicense() {

		List<DriverLicense> list = new ArrayList<>();
		list.add(new DriverLicense("A1", "大型载客汽车", "A3、B1、B2、C1、C2、C3、C4、M", false));
		list.add(new DriverLicense("A2", "重型、中型全挂、半挂汽车列车", "B1、B2、C1、C2、C3、C4、M", false));
		list.add(new DriverLicense("A3", "核载10人以上的城市公共汽车", "C1、C2、C3、C4", false));
		list.add(new DriverLicense("B1", "中型载客汽车(含核载10人以上、19人以下的城市公共汽车)", "C1、C2、C3、C4、M", false));
		list.add(new DriverLicense("B2", "重型、中型载货汽车,大、重、中型专项作业车", "C1、C2、C3、C4、M", false));
		list.add(new DriverLicense("C1", "小型、微型载客汽车以及轻型、微型载货汽车、轻、小、微型专项作业车", "C2、C3、C4", false));
		list.add(new DriverLicense("C2", "小型、微型自动挡载客汽车以及轻型、微型自动挡载货汽车", null, false));
		list.add(new DriverLicense("C3", "低速载货汽车(原四轮农用运输车)", "C4", false));
		list.add(new DriverLicense("C4", "三轮汽车(原三轮农用运输车)", null, false));
		list.add(new DriverLicense("C5", "残疾人专用小型、微型自动挡载客汽车(只允许右下肢或者双下肢残疾人驾驶)", null, false));
		list.add(new DriverLicense("D", "普通三轮摩托车发动机排量大于50ml或者最大设计车速大于50km/h的三轮摩托车", "E、F", false));
		list.add(new DriverLicense("E", "普通二轮摩托车发动机排量大于50ml或者最大设计车速大于50km/h的二轮摩托车", "F", false));
		list.add(new DriverLicense("F", "轻便摩托车发动机排量小于等于50ml，最大设计车速小于等于50km/h的摩托车", null, false));
		list.add(new DriverLicense("M", "轮式自行机械车", null, false));
		list.add(new DriverLicense("N", "无轨电车无轨电车", null, false));
		list.add(new DriverLicense("P", "有轨电车有轨电车", null, false));

		list.forEach(item->{
			item.setDeleted(false).setCreateBy("witt");
			mapper.insert(item);
		});
	}

}
