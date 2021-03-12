package kr.or.ddit.fsurpport.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.test.config.ModelTestConfig;

public class FsurpportDaoTest_ggy extends ModelTestConfig {
	
	@Resource(name = "fsurpportDao")
	private FsurpportDao fsurpportDao;
	
	
	// 20210311_ggy_fsurpport : 영농일지 진입 dao Test
	@Test
	public void selectAllBoardTest() {
		/***Given***/
		
		/***When***/
		String user_id = "brown";
		List<FarmdiaryVo> farmdiaryList = fsurpportDao.selectAllFsurpportList(user_id);
		
		/***Then***/
		
		assertEquals(9, farmdiaryList.size());
	}
	
	

	
}









