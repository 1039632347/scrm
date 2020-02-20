package com.situ.scrm.setup.service;

import com.situ.scrm.setup.domain.SysSetup;

public interface SysSetupService {

	SysSetup getSysSetup();

	void initData();

	Long updateSysSetup(SysSetup sysSetup);
}
