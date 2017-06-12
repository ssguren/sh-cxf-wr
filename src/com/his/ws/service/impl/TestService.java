package com.his.ws.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.FinalParam;
import com.hessian.client.IAdvertHessianService;
import com.hessian.client.IAuthHessianService;
import com.hessian.util.AdvertHessianUtil;
import com.hessian.util.AuthHessianUtil;
import com.his.ws.BaseWebService;
import com.his.ws.service.ITestService;
import com.model.db.AdvertInfo;
import com.model.json.AdvertInfoJson;
import com.model.ws.WSResult;
import com.servicecenter.service.buss.IAdvertBussService;
import com.utils.DataSourceKeyHolder;
import com.utils.DateUtil;
import com.utils.MD5HashUtil;
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

	public WSResult testHessianProxy() {
		String msg = "done deal.", resultCode = FinalParam.WSRESULT_CODE_SUCCESS;
		IAdvertHessianService advertService = AdvertHessianUtil.service();
		AdvertInfoJson json = advertService.getAdvert(2);
		if (null != json) {
			log.info(json.toString());
		} else {
			msg = "null";
			resultCode = FinalParam.WSRESULT_CODE_FAIL;
		}
		return new WSResult(msg, resultCode);
	}

	/**
	 * 角色鉴权
	 */
	public WSResult testAuthHessian() {
		String msg = "done deal.", resultCode = FinalParam.WSRESULT_CODE_SUCCESS;
		IAdvertHessianService advertService = AdvertHessianUtil.service();
		AdvertInfoJson json = advertService.getAdvert(2);
		if (null != json) {
			log.info(json.toString());
		} else {
			msg = "null";
			resultCode = FinalParam.WSRESULT_CODE_FAIL;
		}
		return new WSResult(msg, resultCode);
	}

	/**
	 * 角色加头部鉴权
	 */
	public WSResult testAuthHessian4Header() {
		String msg = "done deal.", resultCode = FinalParam.WSRESULT_CODE_SUCCESS;

		// 添加默认的头部
		// IAuthHessianService authService = AuthHessianUtil
		// .service4AuthHeader(null);

		// 添加自定义头部
		Map<String, String> headerParamMap = new HashMap<String, String>();
		String timestamp = DateUtil.getDate().getTime() + "";
		headerParamMap.put("timestamp", timestamp);
		headerParamMap.put("sign",
				MD5HashUtil.hashCode(timestamp + "hessianDemo"));
		IAuthHessianService authService = AuthHessianUtil
				.service4AuthHeader(headerParamMap);

		AdvertInfoJson json = authService.testAuth();
		if (null != json) {
			log.info(json.toString());
		} else {
			msg = "null";
			resultCode = FinalParam.WSRESULT_CODE_FAIL;
		}
		return new WSResult(msg, resultCode);
	}

}
