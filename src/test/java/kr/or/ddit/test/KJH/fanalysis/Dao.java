package kr.or.ddit.test.KJH.fanalysis;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.fanalysis.model.MyMaxMrrecListVo;
import kr.or.ddit.fanalysis.repository.FanalysisDao;
import kr.or.ddit.farm.model.FhistoryVo;
import kr.or.ddit.farm.model.FmanageVo;
import kr.or.ddit.farm.model.MsrrecVo;
import kr.or.ddit.test.config.ModelTestConfig;

public class Dao extends ModelTestConfig{
	@Resource(name = "fanalysisDao")
	private FanalysisDao fanalysisDao;

	@Test
	public void myfanalysisInfo() {
		/***Given***/	
		MyMaxMrrecListVo mymaxmrreclistVo = new MyMaxMrrecListVo();
		mymaxmrreclistVo.setManage_no("3");
		mymaxmrreclistVo.setNumber(4);
		MyMaxMrrecListVo mymaxmrreclistVo2 = new MyMaxMrrecListVo();
		/***When***/
		mymaxmrreclistVo2 = fanalysisDao.myfanalysisInfo(mymaxmrreclistVo);
		/***Then***/
		assertEquals(null, mymaxmrreclistVo2.getHistory_no());
	}
	
	
	@Test
	public void mymaxmsrrecList() {
		/***Given***/	
		MyMaxMrrecListVo mymaxmrreclistVo = new MyMaxMrrecListVo();
		
		
		FhistoryVo fhistoryVo = new FhistoryVo();
		fhistoryVo.setManage_no("3");
		/***When***/
		mymaxmrreclistVo = fanalysisDao.mymaxmsrrecList(fhistoryVo);
		/***Then***/
		assertEquals("3", mymaxmrreclistVo.getManage_no());
	}
	
	
	@Test
	public void selectFmanage() {
		/***Given***/	
		FmanageVo fmanageVo = new FmanageVo();
		/***When***/
		List<FmanageVo> volist = fanalysisDao.selectFmanage("brown");
		/***Then***/
		assertEquals(1, volist.size());
	}
	
	
	@Test
	public void avgFmanage() {
		/***Given***/	
		MsrrecVo msrrecVo = new MsrrecVo();
		msrrecVo.setMsr_code("3");
		msrrecVo.setMsr_no(9);
		/***When***/
		msrrecVo = fanalysisDao.avgFmanage(msrrecVo);
		/***Then***/
		assertEquals(23, msrrecVo.getMsr_temp());
	}
	
	@Test
	public void selectTempList() {
		/***Given***/	
		MyMaxMrrecListVo Vo = new MyMaxMrrecListVo();
		/***When***/
		List<MyMaxMrrecListVo> VoList = fanalysisDao.selectTempList();
		/***Then***/
		assertEquals("배추", VoList.get(1).getItem_code());
	}
}
