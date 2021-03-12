package kr.or.ddit.test.KJH.fsurpport;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.farm.model.FhistoryVo;
import kr.or.ddit.farm.model.FmanageVo;
import kr.or.ddit.farm.model.MsrequipVo;
import kr.or.ddit.farm.model.MsrrecVo;
import kr.or.ddit.fsurpport.service.FsurpportService;
import kr.or.ddit.test.config.ModelTestConfig;

public class Service extends ModelTestConfig{

	@Resource(name = "fsurpportService")
	private FsurpportService fsurpportService;
	
	@Test
	public void selectAllCodes() {
		/***Given***/	
		
		/***When***/
		List<FmanageVo> fmanageVo = fsurpportService.myfmanageList();
		/***Then***/
		assertEquals("brown", fmanageVo.get(0).getOwner());
	}
	
	@Test
	public void fmanageInfo() {
		/***Given***/	
		
		/***When***/
		FmanageVo fmanageVo = fsurpportService.fmanageInfo("2");
		/***Then***/
		assertEquals("10", fmanageVo.getHistory_no());
	}
	@Test
	public void latelyData() {
		/***Given***/	
		FhistoryVo fhistoryVo = new FhistoryVo();
		fhistoryVo.setManage_no("26");
		fhistoryVo.setHistory_no("49");
		
		MsrrecVo msrrecVo = new MsrrecVo();
		/***When***/
		msrrecVo = fsurpportService.latelyData(fhistoryVo);
		/***Then***/
		assertEquals(27, msrrecVo.getMsr_temp());
	}
	@Test
	public void msrequipList() {
		/***Given***/	
		
		/***When***/
		List<MsrequipVo> msrequipVo = fsurpportService.msrequipList("brown");
		/***Then***/
		assertEquals("내장비", msrequipVo.get(0).getMsr_nm());
	}
	@Test
	public void availableList() {
		/***Given***/	
		MsrequipVo vo = new MsrequipVo();
		vo.setOwner("brown");
		vo.setMsr_code("uno03");
		
		/***When***/
		int cnt = fsurpportService.availableList(vo);
		/***Then***/
		assertEquals(1, cnt);
	}
	@Test
	public void msrList() {
		/***Given***/	
		
		/***When***/
		List<MsrequipVo> msrequipVo = fsurpportService.msrList("brown");
		/***Then***/
		assertEquals("내장비2", msrequipVo.get(0).getMsr_nm());
	}
	
	@Test
	public void insertFmanage() {
		/***Given***/	
		FmanageVo fmanageVo = new FmanageVo();
		fmanageVo.setOwner("brown");
		fmanageVo.setLocation("ok");
		fmanageVo.setInfo("no");
		fmanageVo.setItem_code("111");
		/***When***/
		int cnt = fsurpportService.insertFmanage(fmanageVo);
		/***Then***/
		assertEquals(1, cnt);
	}
	@Test
	public void insertFhistory() {
		/***Given***/	
		FhistoryVo vo = new FhistoryVo();
		vo.setManage_no("1");
		vo.setMsr_code("uno04");
		/***When***/
		int cnt = fsurpportService.insertFhistory(vo);
		/***Then***/
		assertEquals(1, cnt);
	}

	@Test
	public void updatefmanageInfo() {
		/***Given***/	
		/***When***/
		FmanageVo fmanageVo = fsurpportService.updatefmanageInfo("26");
		/***Then***/
		assertEquals("26", fmanageVo.getManage_no());
	}
	
	@Test
	public void fmanageUpdate() {
		/***Given***/	
		FmanageVo fmanageVo = new FmanageVo();
		fmanageVo.setLocation("333");
		fmanageVo.setInfo("222");
		fmanageVo.setItem_code("111");
		fmanageVo.setManage_no("1");
		/***When***/
		int cnt = fsurpportService.fmanageUpdate(fmanageVo);
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void fmanageDelete() {
		/***Given***/	
		FmanageVo fmanageVo = new FmanageVo();
		fmanageVo.setManage_no("1");
		/***When***/
		int cnt = fsurpportService.fmanageDelete(fmanageVo);
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void fhistoryDelete() {
		/***Given***/	
		FmanageVo fmanageVo = new FmanageVo();
		fmanageVo.setManage_no("1");
		/***When***/
		int cnt = fsurpportService.fhistoryDelete(fmanageVo);
		/***Then***/
		assertEquals(1, cnt);
	}
	
	@Test
	public void myYield() {
		/***Given***/	
		FarmdiaryVo vo = new FarmdiaryVo();
		vo.setB_type_code("2000-11-11");
		vo.setW_step_code("2222-12-30");
		vo.setWriter("brown");
		/***When***/
		List<FarmdiaryVo> farmdiaryList = fsurpportService.myYield(vo);
		/***Then***/
		assertEquals(6, farmdiaryList.size());
	}

}
