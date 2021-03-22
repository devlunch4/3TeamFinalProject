package kr.or.ddit.test.KJH.fanalysis;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.fanalysis.model.MyMaxMrrecListVo;
import kr.or.ddit.fanalysis.service.FanalysisService;
import kr.or.ddit.farm.model.FhistoryVo;
import kr.or.ddit.test.config.ModelTestConfig;

public class Service extends ModelTestConfig{

	@Resource(name = "fanalysisService")
	private FanalysisService fanalysisService;

	@Test
	public void myfanalysisInfo() {
		/***Given***/	
		MyMaxMrrecListVo mymaxmrreclistVo = new MyMaxMrrecListVo();
		mymaxmrreclistVo.setManage_no("2");
		mymaxmrreclistVo.setNumber(3);
		MyMaxMrrecListVo mymaxmrreclistVo2 = new MyMaxMrrecListVo();
		/***When***/
		mymaxmrreclistVo2 = fanalysisService.myfanalysisInfo(mymaxmrreclistVo);
		/***Then***/
		assertEquals("23", mymaxmrreclistVo2.getMsr_temp());
	}
	
	
	@Test
	public void mymaxmsrrecList() {
		/***Given***/	
		MyMaxMrrecListVo mymaxmrreclistVo = new MyMaxMrrecListVo();
		
		
		FhistoryVo fhistoryVo = new FhistoryVo();
		fhistoryVo.setManage_no("2");
		/***When***/
		mymaxmrreclistVo = fanalysisService.mymaxmsrrecList(fhistoryVo);
		/***Then***/
		assertEquals("23", mymaxmrreclistVo.getMsr_temp());
	}

}
