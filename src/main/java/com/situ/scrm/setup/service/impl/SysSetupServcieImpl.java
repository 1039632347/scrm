package com.situ.scrm.setup.service.impl;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.scrm.setup.dao.SysSetupDao;
import com.situ.scrm.setup.domain.SysSetup;
import com.situ.scrm.setup.service.SysSetupService;
@Service
public class SysSetupServcieImpl implements SysSetupService{
	@Autowired
	private SysSetupDao sysSetupDao;

	@Override
	public SysSetup getSysSetup() {
		return sysSetupDao.getSysSetup();
	}

	@Override
	@PostConstruct
	public void initData() {
		SysSetup sysSetup = sysSetupDao.getSysSetup();
		if(sysSetup==null) {
			sysSetup = new SysSetup();
			sysSetup.setCreateBy("sys");
			sysSetup.setCreateDate(new Date());
			sysSetup.setActiveFlag(1);
			sysSetupDao.save(sysSetup);
		}
		
		
	}

	@Override
	public Long updateSysSetup(SysSetup sysSetup) {
		sysSetup.setUpdateBy("sys");
		sysSetup.setUpdateDate(new Date());
		return sysSetupDao.update(sysSetup);
	}
}
