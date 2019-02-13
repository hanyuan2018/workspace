package com.application.common.yuan.web.entity.user;

import java.sql.Blob;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class SysUser {

	// 用户ID
	private Integer userId;
	// 姓名
	private String name;
	// 用户名称
	private String userName;
	// 用户密码
	private String password;
	// 身份证号
	private String sfzh;
	// 性别标识
	private String sex;
	// 手机号
	private String phone;
	// 邮箱
	private String email;
	// 图片信息
	private Blob avatar;
	// 备注信息
	private String comment;
	// 锁状态
	private String lockFlag;
	
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
