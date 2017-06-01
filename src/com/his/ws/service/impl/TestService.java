package com.his.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.FinalParam;
import com.his.ws.BaseWebService;
import com.his.ws.service.ITestService;
import com.model.db.AdvertInfo;
import com.model.ws.WSResult;
import com.servicecenter.service.db.IAdvertInfoMgrService;
import com.utils.DataSourceKeyHolder;

@Service
@Scope("prototype")
@WebService(serviceName = "TestService", portName = "TestServicePort", targetNamespace = "http://tempTest.org", endpointInterface = "com.his.ws.service.ITestService")
public class TestService extends BaseWebService implements ITestService {

	@Autowired
	private IAdvertInfoMgrService advertInfoMgrService;

	public WSResult isWsOk() {
		return new WSResult("api is ok!", FinalParam.WSRESULT_CODE_SUCCESS);
	}

	public WSResult dbChange() {
		String msg = "done deal.", resultCode = FinalParam.WSRESULT_CODE_SUCCESS;
		log.info("dbchange test start ...");
		List<AdvertInfo> ads = getAds();
		log.info("has " + ads.size() + " adverts.");
		DataSourceKeyHolder.changeDbsb();
		log.info("-------DataSource change-----without aop----"
				+ DataSourceKeyHolder.getCustomerType());
		log.info("writing...");
		if (mergeAds(ads)) {
			msg = "bad work.";
			resultCode = FinalParam.WSRESULT_CODE_FAIL;
		}

		DataSourceKeyHolder.changeDbsa();
		log.info("-------DataSource change-----"
				+ DataSourceKeyHolder.getCustomerType());

		return new WSResult(msg, resultCode);
	}

	private List<AdvertInfo> getAds() {
		List<AdvertInfo> a = advertInfoMgrService.findAll();
		List<AdvertInfo> ar = new ArrayList<AdvertInfo>();
		for (AdvertInfo ad : a) {
			ar.add((AdvertInfo) ad.clone());
		}
		return ar;
	}

	private boolean mergeAds(List<AdvertInfo> ads) {
		boolean flag = true;
		if (null != ads && ads.size() > 0) {
			for (AdvertInfo ad : ads) {
				flag &= add(ad);
			}
		}
		return flag;
	}

	private boolean add(AdvertInfo ad) {
		return advertInfoMgrService.add(ad);
	}

}
