package com.application.common.yuan.web.entity.menu;

import lombok.Data;

@Data
public class SysRightConfig {

	// 角色ID
	private Integer roleId;
	// 菜单或资源ID
	private Integer rightId;
	// 菜单或资源标识
	private Integer resourceFlag;
}
