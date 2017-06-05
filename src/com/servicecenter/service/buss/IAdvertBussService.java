package com.servicecenter.service.buss;

import java.util.List;

import com.model.db.AdvertInfo;
import com.utils.DataSource;

public interface IAdvertBussService {

	// @DataSource("writeDb")
	public Boolean add(AdvertInfo ad);

	public List<AdvertInfo> findAllAdverts();

	@DataSource("writeDb")
	public boolean mergeAds(List<AdvertInfo> ads);

}
