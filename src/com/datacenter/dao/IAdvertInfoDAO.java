package com.datacenter.dao;

import java.util.Date;
import java.util.List;

import com.datacenter.IBaseDAO;
import com.model.db.AdvertInfo;

public interface IAdvertInfoDAO extends IBaseDAO<AdvertInfo, Integer> {

	public AdvertInfo findByIdAndTime(java.lang.Integer id, Date date);

	// public List<AdvertInfo> findByName(String advertName);
	//
	// public List<AdvertInfo> findByIsEffective(Short isEffective);
	//
	// public List<AdvertInfo> findByTypeAndArea(String provinceId, String
	// cityId,
	// Integer typeId);
	//
	// public List<AdvertInfo> findByProvinceCityType(Integer provinceId,
	// Integer cityId, Integer typeId);

	public List<AdvertInfo> findByIdLikeNameAndTimeProperties(Integer id,
			String likeName, Date beginTime, Date endTime, Short status);

}
