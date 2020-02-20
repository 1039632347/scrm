package com.situ.scrm.setup.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.situ.scrm.commons.domain.BaseClass;

@Alias("SysSetup")
public class SysSetup extends BaseClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sysSetup1;//公司名称
	private String sysSetup2;//公海天数
	private String sysSetup3;//提醒日期
	private String sysSetup4;//备用
	public String getSysSetup1() {
		return sysSetup1;
	}
	public void setSysSetup1(String sysSetup1) {
		this.sysSetup1 = sysSetup1;
	}
	public String getSysSetup2() {
		return sysSetup2;
	}
	public void setSysSetup2(String sysSetup2) {
		this.sysSetup2 = sysSetup2;
	}
	public String getSysSetup3() {
		return sysSetup3;
	}
	public void setSysSetup3(String sysSetup3) {
		this.sysSetup3 = sysSetup3;
	}
	public String getSysSetup4() {
		return sysSetup4;
	}
	public void setSysSetup4(String sysSetup4) {
		this.sysSetup4 = sysSetup4;
	}
	@Override
	public String toString() {
		return "SysSetup [sysSetup1=" + sysSetup1 + ", sysSetup2=" + sysSetup2 + ", sysSetup3=" + sysSetup3
				+ ", sysSetup4=" + sysSetup4 + "]";
	}
	
	
}
