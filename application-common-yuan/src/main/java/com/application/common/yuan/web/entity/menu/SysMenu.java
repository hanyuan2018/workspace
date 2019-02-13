package com.application.common.yuan.web.entity.menu;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class SysMenu {

	// 菜单ID
	private Integer menuId;
	// 菜单名称
	private String menuName;
	// 父ID
	private Integer parentId;
	// 菜单key
	private String menuKey;
	// 类型
	private String type;
	// 菜单url
	private String menuUrl;
	// 菜单级别
	private String menuLevel;
	// 图标
	private String icon;
	// 菜单样式
	private String menuStyle;
	// 是否隐藏标识
	private String isHide;
	// 备注信息
	private String comment;
	// 删除标志
	private String deleteFlag;
	// 创建用户ID 
	private Integer createrUser;
	// 创建时间
	private Timestamp createrTime;
	// 更新用户ID
	private Integer updateUser;
	// 更新时间
	private Timestamp updateTime;

	// 关键词，用于模糊搜索
	private String keyword;
}
