package com.situ.scrm.setup.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.situ.scrm.dictionaries.domain.Dictionaries;
import com.situ.scrm.setup.domain.SysSetup;
import com.situ.scrm.setup.service.SysSetupService;

@RestController
@RequestMapping("/syssetup")
public class SysSetupController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String PAGE_INDEX_SYSSETUP = "syssetup/syssetup_index";

	@Autowired
	private SysSetupService sysSetupService;
	
	/**
	 * @Title: goIndex
	 * @Description:(进首页)
	 * @param modelAndView
	 * @return
	 */
	@GetMapping
	public ModelAndView goIndex(ModelAndView modelAndView) {
		modelAndView.addObject("syssetup", sysSetupService.getSysSetup());
		modelAndView.setViewName(PAGE_INDEX_SYSSETUP);
		return modelAndView;
	}
	
	/**
	 * @Title: updateSysSetup
	 * @Description:(修改设置)
	 * @param dictionary
	 * @return
	 */
	@PutMapping				
	public Long updateSysSetup(SysSetup sysSetup) {
		System.out.println(sysSetup);
		return sysSetupService.updateSysSetup(sysSetup);
	}
	
}
