package com.his.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.FinalParam;
import com.hessian.client.IAdvertHessianService;
import com.his.ws.BaseWebService;
import com.his.ws.service.ITestService;
import com.model.db.AdvertInfo;
import com.model.json.AdvertInfoJson;
import com.model.ws.WSResult;
import com.servicecenter.service.buss.IAdvertBussService;
import com.utils.DataSourceKeyHolder;
import com.utils.MiscUtil;

@Service
@Scope("prototype")
@WebService(serviceName = "TestService", portName = "TestServicePort", targetNamespace = "http://tempTest.org", endpointInterface = "com.his.ws.service.ITestService")
public class TestService extends BaseWebService implements ITestService {

	@Autowired
	private IAdvertHessianService advertHessianService;

	@Autowired
	private IAdvertBussService advertBussService;

	public WSResult isWsOk() {
		return new WSResult("api is ok!", FinalParam.WSRESULT_CODE_SUCCESS);
	}

	public WSResult dbChangeWithoutAop() {
		String msg = "done deal.", resultCode = FinalParam.WSRESULT_CODE_SUCCESS;
		log.info("dbchange test start ...");
		List<AdvertInfo> ads = getAds();
		log.info("has " + ads.size() + " adverts.");
		DataSourceKeyHolder.changeDbsb();
		log.info("-------DataSource change-----without aop----"
				+ DataSourceKeyHolder.getCustomerType());
		log.info("writing...");
		if (!advertBussService.mergeAds(ads)) {
			msg = "bad work.";
			resultCode = FinalParam.WSRESULT_CODE_FAIL;
		}
		DataSourceKeyHolder.changeDbsa();
		log.info("-------DataSource change-----"
				+ DataSourceKeyHolder.getCustomerType());

		return new WSResult(msg, resultCode);
	}

	public WSResult dbChange4Aop() {
		String msg = "done deal.", resultCode = FinalParam.WSRESULT_CODE_SUCCESS;
		log.info("dbchange test start ...");
		List<AdvertInfo> ads = getAds();
		log.info("has " + ads.size() + " adverts.");
		if (!advertBussService.mergeAds(ads)) {
			msg = "bad work.";
			resultCode = FinalParam.WSRESULT_CODE_FAIL;
		}
		return new WSResult(msg, resultCode);
	}

	private List<AdvertInfo> getAds() {
		List<AdvertInfo> a = advertBussService.findAllAdverts();
		List<AdvertInfo> ar = new ArrayList<AdvertInfo>();
		for (AdvertInfo ad : a) {
			ar.add((AdvertInfo) ad.clone());
		}
		return ar;
	}

	public WSResult testHessian() {
		String msg = "done deal.", resultCode = FinalParam.WSRESULT_CODE_SUCCESS;
		try {
			AdvertInfoJson adj = advertHessianService.getAdvert(2);
			log.info("hessian resp : " + adj.toString());
		} catch (Exception e) {
			log.info(MiscUtil.traceInfo(e));
			msg = "Excepiton";
			resultCode = FinalParam.WSRESULT_CODE_FAIL;
		}
		return new WSResult(msg, resultCode);
	}
}
