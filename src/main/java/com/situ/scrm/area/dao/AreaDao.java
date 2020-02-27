/**
 * @Company:中享思途   
 * @Title:AreaDao.java 
 * @Author:wxinpeng   
 * @Date:2019年12月30日 上午9:47:42     
 */
package com.situ.scrm.area.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.situ.scrm.area.domain.Area;



/** 
 * @ClassName:AreaDao 
 * @Description:(AreaDao)  
 */
@Repository
public interface AreaDao {
	
	List<Area> findByParent(Integer parentCode);
}
