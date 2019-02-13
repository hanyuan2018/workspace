package com.application.common.yuan.web.entity.resource;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class SysResource {

	// 资源ID
	private Integer resourceId;
	// 资源代码code
	private String resourceCode;
	// 资源名称
	private String resourceName;
	// 资源类型
	private String type;
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
