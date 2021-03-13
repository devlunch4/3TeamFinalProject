package kr.or.ddit.test.KJH.finfo;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.farm.model.GardenguideVo;
import kr.or.ddit.finfo.repository.FinfoDaoImpl;
import kr.or.ddit.test.config.ModelTestConfig;

public class Dao extends ModelTestConfig{
	
	@Resource(name = "finfoDao")
	private FinfoDaoImpl finfoDao;
	
	@Test
	public void guide_codeselect() {
		/***Given***/
		
		/***When***/
		GardenguideVo vo = finfoDao.guide_codeselect("배추");
		/***Then***/
		assertEquals("12", vo.getGuide_code());
	}

}
