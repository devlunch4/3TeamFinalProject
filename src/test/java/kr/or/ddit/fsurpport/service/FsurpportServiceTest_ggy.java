package kr.or.ddit.fsurpport.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.test.config.ModelTestConfig;

public class FsurpportServiceTest_ggy extends ModelTestConfig {
	
	@Resource(name = "fsurpportService")
	private FsurpportService fsurpportService;
	
	private static final Logger logger = LoggerFactory.getLogger(FsurpportServiceTest_ggy.class);
	
	// 20210311_ggy_fsurpport : 영농일지 진입 service Test
	@Test
	public void selectAllFsurpportList() {
		/***Given***/
		
		/***When***/
		String user_id = "brown";
		List<FarmdiaryVo> farmdiaryList = fsurpportService.selectAllFsurpportList(user_id);

		/***Then***/
		assertEquals(9, farmdiaryList.size());
	}
	
		
}









