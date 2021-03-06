/**
 * @Company:中享思途   
 * @Title:IndexController.java 
 * @Author:wxinpeng   
 * @Date:2020年2月8日 下午3:23:18     
 */
package com.situ.scrm.index.controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.situ.scrm.commons.domain.LayResult;
import com.situ.scrm.sysresource.domain.SysResource;
import com.situ.scrm.user.domain.User;
import com.situ.scrm.user.service.UserService;

/** 
 * @ClassName:IndexController 
 * @Description:(Index的Controller层)  
 */
@RestController
public class IndexController implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String PAGE_INDEX = "index";
	private static final String PAGE_LOGIN = "login";
    @Autowired
	private UserService userService;
	/**
	 * @Title: goIndex 
	 * @Description:(进系统首页)
	 * @param modelAndView
	 * @return
	 */
	@GetMapping(path = { "/index", "/" })
	public ModelAndView goIndex(ModelAndView modelAndView,HttpSession session) {
	List<SysResource> resourceList=	userService.findAuthResourceList(session);
		modelAndView.addObject("resourceList", userService.findAuthResourceList(session));
		modelAndView.setViewName(PAGE_INDEX);
		return modelAndView;
	}
	
	/**
	 * @Title: goLogin 
	 * @Description:(进登录页面)
	 * @param modelAndView
	 * @return
	 */
	@GetMapping(path = { "/login"})
	public ModelAndView goLogin(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_LOGIN);
		return modelAndView;
	}
	@GetMapping("/dologin")
	public LayResult doLogin(User loginUserParam,HttpSession session, HttpServletResponse response) {
		return userService.doUserLogin(loginUserParam, session, response);		
	}	
	@GetMapping("/loginOut")
	public ModelAndView loginOut(ModelAndView modelAndView,HttpSession session) {
		session.removeAttribute("login_user");
		session.removeAttribute("actionInfoMap");
		modelAndView.setViewName(PAGE_INDEX);
		return modelAndView;
	}
	
}
