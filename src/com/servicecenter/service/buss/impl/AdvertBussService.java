package com.servicecenter.service.buss.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.db.AdvertInfo;
import com.servicecenter.BaseService;
import com.servicecenter.service.buss.IAdvertBussService;
import com.servicecenter.service.db.IAdvertInfoMgrService;

@Service
public class AdvertBussService extends BaseService implements
		IAdvertBussService {

	@Autowired
	private IAdvertInfoMgrService advertInfoMgrService;

	public Boolean add(AdvertInfo ad) {
		return advertInfoMgrService.add(ad);
	}

	public List<AdvertInfo> findAllAdverts() {
		return advertInfoMgrService.findAll();
	}

	public boolean mergeAds(List<AdvertInfo> ads) {
		boolean flag = true;
		if (null != ads && ads.size() > 0) {
			for (AdvertInfo ad : ads) {
				flag &= add(ad);
			}
		}
		return flag;
	}

}
