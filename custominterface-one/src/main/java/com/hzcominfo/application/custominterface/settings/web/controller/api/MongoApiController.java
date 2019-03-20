package com.hzcominfo.application.custominterface.settings.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzcominfo.application.custominterface.kernel.entity.CarPicture;
import com.hzcominfo.application.custominterface.kernel.entity.PersonPicture;

@Controller
@RequestMapping("/api/mongo/")
public class MongoApiController {

	@Autowired
	@Qualifier(value="mongoUriTemplate")
	private MongoTemplate mongoUriTemplate;
	
	@Autowired
	@Qualifier(value="mongoTemplate")
	private MongoTemplate mongoTemplate;
	
	@ResponseBody
	@RequestMapping("findPersonPictureList")
	public List<PersonPicture> findPersonPictureList() {
		
		List<PersonPicture> list = mongoUriTemplate.findAll(PersonPicture.class);
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping("findCarPictureList")
	public List<CarPicture> findCarPictureList() {
		
		List<CarPicture> list = mongoUriTemplate.findAll(CarPicture.class);
		
		return list;
	}
	
}
