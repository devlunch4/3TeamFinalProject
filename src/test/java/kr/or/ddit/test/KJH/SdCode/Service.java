package kr.or.ddit.test.KJH.SdCode;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.batch.model.StandarditemcodeVo;
import kr.or.ddit.batch.repository.SdCodeDao;
import kr.or.ddit.batch.service.SdCodeService;
import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.farm.model.FhistoryVo;
import kr.or.ddit.farm.model.FmanageVo;
import kr.or.ddit.farm.model.MsrequipVo;
import kr.or.ddit.farm.model.MsrrecVo;
import kr.or.ddit.fsurpport.service.FsurpportService;
import kr.or.ddit.test.config.ModelTestConfig;

public class Service extends ModelTestConfig{

	@Resource(name = "sdCodeService")
	private SdCodeService sdCodeService;
	
	@Test
	public void selectAllCodes() {
		/***Given***/	
		
		/***When***/
		int cnt = sdCodeService.allsdcodeDelete();
		/***Then***/
		assertEquals(0, cnt);
	}
	
	@Test
	public void fmanageInfo() {
		/***Given***/	
		StandarditemcodeVo Vo = new StandarditemcodeVo();
		Vo.setLclasscode("1");
		Vo.setLclassname("1");
		Vo.setMclasscode("1");
		Vo.setMclassname("1");
		Vo.setSclasscode("1");
		Vo.setSclassname("1");
		/***When***/
		int cnt = sdCodeService.sdcodeInsert(Vo);
		/***Then***/
		assertEquals(1, cnt);
	}
	

}
