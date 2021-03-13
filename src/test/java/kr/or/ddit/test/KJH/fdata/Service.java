package kr.or.ddit.test.KJH.fdata;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.fdata.service.FdataServiceImpl;
import kr.or.ddit.test.config.ModelTestConfig;

public class Service extends ModelTestConfig{

	@Resource(name = "fdataService")
	private FdataServiceImpl fdataService;


	@Test
	public void selectAllCodes() {
		/***Given***/	
		
		/***When***/
		List<CodesVo> codes = fdataService.selectAllCodes();
		/***Then***/
		assertEquals("b", codes.get(0).getCode_no());
	}

	
	@Test
	public void selectCode() {
		/***Given***/	
		
		/***When***/
		CodesVo codes = fdataService.selectCode("111");
		/***Then***/
		assertEquals("쌀", codes.getCode_nm());
	}

	@Test
	public void datefarmCount() {
		/***Given***/	
		FarmdiaryVo farmdiaryVo = new FarmdiaryVo();
		farmdiaryVo.setB_type_code("2020-12-12");
		farmdiaryVo.setW_step_code("2222-12-12");
		/***When***/
		List<FarmdiaryVo> datefarmCount = fdataService.datefarmCount(farmdiaryVo);
		/***Then***/
		assertEquals("쌀", datefarmCount.get(0).getContent());
	}

}
