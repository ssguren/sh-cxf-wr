package com.servicecenter.service.db.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datacenter.dao.IAdvertInfoDAO;
import com.model.db.AdvertInfo;
import com.servicecenter.DAOBasedService;
import com.servicecenter.service.db.IAdvertInfoMgrService;

@Service
@Transactional(readOnly = true)
public class AdvertInfoMgrService extends
		DAOBasedService<AdvertInfo, Integer, IAdvertInfoDAO> implements
		IAdvertInfoMgrService {

	// @Override
	public AdvertInfo findByIdAndTime(Integer id, Date date) {
		if (null != dao)
			return dao.findByIdAndTime(id, date);
		return null;
	}

	// @Override
	public List<AdvertInfo> findByIdLikeNameAndTimeProperties(Integer id,
			String likeName, Date beginTime, Date endTime, Short status) {
		if (null != dao)
			return dao.findByIdLikeNameAndTimeProperties(id, likeName,
					beginTime, endTime, status);
		return null;
	}

}
