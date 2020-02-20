package com.situ.scrm.setup.dao;

import org.springframework.stereotype.Repository;

import com.situ.scrm.setup.domain.SysSetup;



@Repository
public interface SysSetupDao {

	SysSetup getSysSetup();

	void save(SysSetup sysSetup);

	Long update(SysSetup sysSetup);

}
