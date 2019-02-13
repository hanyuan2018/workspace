package com.application.common.yuan.web.controller.system.menu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.application.common.yuan.common.constants.ForwardConstants;

@Controller
@RequestMapping("/menu/")
public class SysMenuController {

	@RequestMapping("listUI")
	public String listUI(Model model) {
		
		return ForwardConstants.SYSTEM + ForwardConstants.MENU + ForwardConstants.LIST;
	}
	
	@RequestMapping("addUI")
	public String addUI(Model model) {
		
		return ForwardConstants.SYSTEM + ForwardConstants.MENU + ForwardConstants.ADD;
	}
	
	@RequestMapping("editUI")
	public String editUI(Model model) {
		
		return ForwardConstants.SYSTEM + ForwardConstants.MENU + ForwardConstants.EDIT;
	}
}
