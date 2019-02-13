package com.boot.bootstrap.web.controller.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/demo/")
public class DemoController {

	@RequestMapping("listUI")
	public String listUI() {

		return "demo/list";
	}

	@ResponseBody
	@RequestMapping("getListInfo")
	public List<Object> getListInfo() {

		String jsonStr = "[{\"id\":0,\"name\":\"测试0\",\"price\":\"&yen;0\",\"column1\":\"c10\",\"column2\":\"c20\",\"column3\":\"c30\",\"column4\":\"c40\"},{\"id\":1,\"name\":\"测试1\",\"price\":\"&yen;1\",\"column1\":\"c10\",\"column2\":\"c20\",\"column3\":\"c30\",\"column4\":\"c40\"},{\"id\":2,\"name\":\"测试2\",\"price\":\"&yen;2\",\"column1\":\"c10\",\"column2\":\"c20\",\"column3\":\"c30\",\"column4\":\"c40\"},{\"id\":3,\"name\":\"测试3\",\"price\":\"&yen;3\",\"column1\":\"c10\",\"column2\":\"c20\",\"column3\":\"c30\",\"column4\":\"c40\"},{\"id\":4,\"name\":\"测试4\",\"price\":\"&yen;4\",\"column1\":\"c10\",\"column2\":\"c20\",\"column3\":\"c30\",\"column4\":\"c40\"},{\"id\":5,\"name\":\"测试5\",\"price\":\"&yen;5\",\"column1\":\"c10\",\"column2\":\"c20\",\"column3\":\"c30\",\"column4\":\"c40\"},{\"id\":6,\"name\":\"测试6\",\"price\":\"&yen;6\",\"column1\":\"c10\",\"column2\":\"c20\",\"column3\":\"c30\",\"column4\":\"c40\"},{\"id\":7,\"name\":\"测试7\",\"price\":\"&yen;7\",\"column1\":\"c10\",\"column2\":\"c20\",\"column3\":\"c30\",\"column4\":\"c40\"},{\"id\":8,\"name\":\"测试8\",\"price\":\"&yen;8\",\"column1\":\"c10\",\"column2\":\"c20\",\"column3\":\"c30\",\"column4\":\"c40\"},{\"id\":9,\"name\":\"测试9\",\"price\":\"&yen;9\",\"column1\":\"c10\",\"column2\":\"c20\",\"column3\":\"c30\",\"column4\":\"c40\"},{\"id\":10,\"name\":\"测试10\",\"price\":\"&yen;10\",\"column1\":\"c10\",\"column2\":\"c20\",\"column3\":\"c30\",\"column4\":\"c40\"},{\"id\":11,\"name\":\"测试11\",\"price\":\"&yen;11\",\"column1\":\"c10\",\"column2\":\"c20\",\"column3\":\"c30\",\"column4\":\"c40\"},{\"id\":12,\"name\":\"测试12\",\"price\":\"&yen;12\",\"column1\":\"c10\",\"column2\":\"c20\",\"column3\":\"c30\",\"column4\":\"c40\"},{\"id\":13,\"name\":\"测试13\",\"price\":\"&yen;13\",\"column1\":\"c10\",\"column2\":\"c20\",\"column3\":\"c30\",\"column4\":\"c40\"},{\"id\":14,\"name\":\"测试14\",\"price\":\"&yen;14\",\"column1\":\"c10\",\"column2\":\"c20\",\"column3\":\"c30\",\"column4\":\"c40\"},{\"id\":15,\"name\":\"测试15\",\"price\":\"&yen;15\",\"column1\":\"c10\",\"column2\":\"c20\",\"column3\":\"c30\",\"column4\":\"c40\"},{\"id\":16,\"name\":\"测试16\",\"price\":\"&yen;16\",\"column1\":\"c10\",\"column2\":\"c20\",\"column3\":\"c30\",\"column4\":\"c40\"},{\"id\":17,\"name\":\"测试17\",\"price\":\"&yen;17\",\"column1\":\"c10\",\"column2\":\"c20\",\"column3\":\"c30\",\"column4\":\"c40\"},{\"id\":18,\"name\":\"测试18\",\"price\":\"&yen;18\",\"column1\":\"c10\",\"column2\":\"c20\",\"column3\":\"c30\",\"column4\":\"c40\"},{\"id\":19,\"name\":\"测试19\",\"price\":\"&yen;19\",\"column1\":\"c10\",\"column2\":\"c20\",\"column3\":\"c30\",\"column4\":\"c40\"},{\"id\":20,\"name\":\"测试20\",\"price\":\"&yen;20\",\"column1\":\"c10\",\"column2\":\"c20\",\"column3\":\"c30\",\"column4\":\"c40\"}]\r\n"
				+ "";
		List<Object> list = new ArrayList<>();
		JSONArray fromObject = JSONArray.fromObject(jsonStr);
		for (Object object : fromObject) {
			list.add(object);
		}

		return list;
	}

	@RequestMapping("addUI")
	public String addUI() {

		return "demo/add";
	}

	@RequestMapping("editUI")
	public String editUI() {

		return "demo/edit";
	}
}
