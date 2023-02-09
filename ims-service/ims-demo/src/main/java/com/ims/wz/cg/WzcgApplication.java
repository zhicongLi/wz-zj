package com.ims.wz.cg;

import com.ims.common.constant.CommonConstant;
import org.springblade.core.launch.BladeApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * Demo启动器
 *
 * @author Chill
 */
@SpringCloudApplication
@ComponentScans({
	@ComponentScan("com.ims.ext.act")
})
public class WzcgApplication {
	public static void main(String[] args) {
		BladeApplication.run(CommonConstant.APPPLICATION_WZCG_NAME, WzcgApplication.class, args);
	}
}
