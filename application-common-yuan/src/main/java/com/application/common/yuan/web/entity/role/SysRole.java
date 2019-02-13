package com.application.common.yuan.web.entity.role;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class SysRole {

	// 角色ID
	private Integer roleId;
	// 角色key
	private String roleKey;
	// 角色名称
	private String roleName;
	// 备注描述信息
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
