package com.application.common.yuan.web.controller.index;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.application.common.yuan.common.constants.ForwardConstants;

@Controller
@RequestMapping("/")
public class BaseBackGroundController extends BaseController{

	@Value("${spring.profiles.active}")
	public String profiles;	// 获取对应配置对应的配置文件信息，如：dev | prod | test | uat
	
	/**
     * 登陆画面
     * 
     * @return
     */
    @RequestMapping(value = "")
    public String toIndex() {
        return ForwardConstants.REDIRECT + ForwardConstants.LOGIN;
    }

    /**
     * 进入登陆画面
     */
    @RequestMapping(value = "login", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String login(HttpServletRequest request) {
    	System.out.println("配置文件：" + profiles);
    	System.out.println("配置文件：" + profiles);
    	System.out.println("配置文件：" + profiles);
        return ForwardConstants.LOGIN;
    }
    
    @RequestMapping(value = "index", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String toIndex(HttpServletRequest request) {
    	System.out.println("配置文件：" + profiles);
    	System.out.println("配置文件：" + profiles);
    	System.out.println("配置文件：" + profiles);
        return ForwardConstants.INDEX;
    }
    
    @RequestMapping("main")
    public String main() {
        return ForwardConstants.MAIN;
    }
}