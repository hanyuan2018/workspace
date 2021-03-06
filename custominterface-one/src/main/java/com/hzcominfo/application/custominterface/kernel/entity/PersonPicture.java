package com.hzcominfo.application.custominterface.kernel.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * 实体类对应mongodb中对应的人员照片的collection
 * 
 * @author hanp
 *
 */
@Document(collection = "XJ_PEOPLE_PICTURE")
@Data
public class PersonPicture {

	@Id
	private String id;
	@Field(value = "ZJHM")
	private String zjhm;
	@Field(value = "YWSJ")
	private String ywsj;
	@Field(value = "PIC_URL")
	private String picUrl;
	@Field(value = "PRIORITY")
	private String priority;
	@Field(value = "CI_UPDATE_TIME")
	private String ciUpdateTime;
	@Field(value = "CI_SRC_DB_TABLE_NAME")
	private String ciSrcDbTableName;

}
