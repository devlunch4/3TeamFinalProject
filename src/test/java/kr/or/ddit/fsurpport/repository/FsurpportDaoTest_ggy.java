package kr.or.ddit.fsurpport.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.common.model.FilesVo;
import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.farm.model.MySimpleCodeVo;
import kr.or.ddit.test.config.ModelTestConfig;

public class FsurpportDaoTest_ggy extends ModelTestConfig {
	
	@Resource(name = "fsurpportDao")
	private FsurpportDao fsurpportDao;
	
	
	// 20210311_ggy_fsurpport : 영농일지 진입 dao Test_OK
	@Test
	public void selectAllBoardTest() {
		/***Given***/
		
		/***When***/
		String user_id = "brown";
		List<FarmdiaryVo> farmdiaryList = fsurpportDao.selectAllFsurpportList(user_id);
		
		/***Then***/
		
		assertEquals(16, farmdiaryList.size());
	}
	
	// 20210312_ggy_fsurpport : 등록된 품목 조회_OK
	@Test
	public void selectAllItem_codeListTest() {
		/***Given***/
		
		/***When***/
		List<CodesVo> codesList = fsurpportDao.selectAllItem_codeList();
		
		/***Then***/
		
		assertEquals(63, codesList.size());
	}
	
	// 20210312_ggy_fsurpport : 등록된 작업단계 조회 수정_OK
	@Test
	public void selectAllW_step_codeListTest() {
		/***Given***/
		
		/***When***/
		List<CodesVo> codesList = fsurpportDao.selectAllW_step_codeList("1");
		
		/***Then***/
		
		assertEquals(31, codesList.size());
	}
	
	// 20210312_ggy_fsurpport : 등록된 사업유형 조회_OK
	@Test
	public void selectAllB_type_codeListTest() {
		/***Given***/
		
		/***When***/
		List<CodesVo> codesList = fsurpportDao.selectAllB_type_codeList();
		
		/***Then***/
		
		assertEquals(7, codesList.size());
	}
	
	// 20210312_ggy_fsurpport : 등록한 나만의 영농일지-간편등록 목록 조회_OK
	@Test
	public void selectMySimpleCodeListTest() {
		/***Given***/
		String user_id = "brown";
		
		/***When***/
		List<MySimpleCodeVo> codesList = fsurpportDao.selectMySimpleCodeList(user_id);
		
		/***Then***/
		
		assertEquals(11, codesList.size());
	}
	
	// 20210312_ggy_fsurpport : 등록한 나만의 영농일지-나의 간편등록 조회 해서 배치_OK
	@Test
	public void selectMySimpleCodeInfoTest() {
		/***Given***/
		MySimpleCodeVo mySimpleCodeVo = new MySimpleCodeVo();
		mySimpleCodeVo.setOwner("brown");
		mySimpleCodeVo.setMy_simple_code(26);
		
		/***When***/
		mySimpleCodeVo = fsurpportDao.selectMySimpleCodeInfo(mySimpleCodeVo);
		
		/***Then***/
		assertNotNull(mySimpleCodeVo);
	}
	
	// 20210312_ggy_fsurpport : 농업지원-영농일지 내 간편등록을 위해 사업 유형 코드 조회_OK
	@Test
	public void selectB_type_code_noTest() {
		/***Given***/
		
		/***When***/
		CodesVo codesVo = fsurpportDao.selectB_type_code_no("1");
		
		/***Then***/
		assertNotNull(codesVo);
	}
	
	// 20210312_ggy_fsurpport : 농업지원-영농일지 내 간편등록을 위해 품목 코드 조회_OK
	@Test
	public void selectItem_type_code_noTest() {
		/***Given***/
		
		/***When***/
		CodesVo codesVo = fsurpportDao.selectItem_type_code_no("317");
		
		/***Then***/
		assertNotNull(codesVo);
	}
	
//	// 20210312_ggy_fsurpport : 농업지원-영농일지 내 간편등록 작성한걸 등록_OK
//	@Test
//	public void registMySimpleCodeTest() {
//		/***Given***/
//		MySimpleCodeVo mySimpleCodeVo = new MySimpleCodeVo();
//		
//		mySimpleCodeVo.setB_type_code("1");
//		mySimpleCodeVo.setOwner("brown");
//		mySimpleCodeVo.setItem_code("314");
//		mySimpleCodeVo.setArea(400);
//		
//		String code_alias = mySimpleCodeVo.getB_type_code() + "-" + mySimpleCodeVo.getItem_code() + "-" + mySimpleCodeVo.getArea();
//
//		mySimpleCodeVo.setCode_alias(code_alias);
//		
//		/***When***/
//		int registCnt = fsurpportDao.registMySimpleCode(mySimpleCodeVo);
//		
//		/***Then***/
//		assertEquals(1, registCnt);
//	}
	
	// 20210312_ggy_fsurpport : 등록된 일지 조건 검색_OK
	@Test
	public void searchAllFarmdiaryListTest() {
		/***Given***/
		FarmdiaryVo farmdiaryVo = new FarmdiaryVo();
		
		farmdiaryVo.setStartDate("2021/03/12");
		farmdiaryVo.setEndDate("2021/03/12");
		farmdiaryVo.setItem_code("317");
		farmdiaryVo.setWriter("brown");
		
		/***When***/
		List<FarmdiaryVo> farmdiaryList = fsurpportDao.searchAllFarmdiaryList(farmdiaryVo);
		
		/***Then***/
		assertEquals(7, farmdiaryList.size());
	}
	
	// 20210312_ggy_fsurpport : 해당 일지 정보 조회_OK
	@Test
	public void selectFarmdiaryInfoTest() {
		/***Given***/
		
		/***When***/
		FarmdiaryVo farmdiaryInfo = fsurpportDao.selectFarmdiaryInfo(1);
		
		/***Then***/
		assertNotNull(farmdiaryInfo);
	}
	
	// 20210312_ggy_fsurpport : 일지 등록을 위해 일지 정보 가져오기_OK
	@Test
	public void selectMySimpleCode_noInfoTest() {
		/***Given***/
		MySimpleCodeVo mySimpleCodeVo = new MySimpleCodeVo();
		mySimpleCodeVo.setOwner("brown");
		mySimpleCodeVo.setMy_simple_code(1);
		/***When***/
		mySimpleCodeVo = fsurpportDao.selectMySimpleCode_noInfo(mySimpleCodeVo);
		
		/***Then***/
		assertNotNull(mySimpleCodeVo);
	}
	
//	// 20210312_ggy_fsurpport : 일지 등록때 파일 있으면 파일 등록_OK
//	@Test
//	public void registFiles() {
//		/***Given***/
//		FilesVo filesVo = new FilesVo();
//		filesVo.setFile_nm("test.jpg");
//		filesVo.setFile_path("c:\\fdown\\test.jpg");
//		
//		/***When***/
//		int registFilesCnt = fsurpportDao.registFiles(filesVo);
//		
//		/***Then***/
//		assertEquals(121, registFilesCnt);
//	}
	
	// 20210312_ggy_fsurpport : 일지 등록을 위해 일지 정보 가져오기_OK
	@Test
	public void selectFilesInfoTest() {
		/*** Given ***/
		
		/*** When ***/
		FilesVo filesVo = fsurpportDao.selectFilesInfo(121);

		/*** Then ***/
		assertNotNull(filesVo);
	}
	
//	// 20210312_ggy_fsurpport : 일지 등록_OK
//	@Test
//	public void registFarmdiaryTest() {
//		/*** Given ***/
//		FarmdiaryVo farmdiaryVo = new FarmdiaryVo();
//		farmdiaryVo.setFile_no(87);
//		farmdiaryVo.setArea(500);
//		farmdiaryVo.setB_type_code("1");
//		farmdiaryVo.setContent("dao Test");
//		farmdiaryVo.setHigh_temp(0);
//		farmdiaryVo.setHumid(0);
//		farmdiaryVo.setItem_code("317");
//		farmdiaryVo.setLow_temp(0);
//		farmdiaryVo.setMy_simple_code(84);
//		farmdiaryVo.setRainfall(0);
//		farmdiaryVo.setW_step_code("24");
//		farmdiaryVo.setWeather("비");
//		farmdiaryVo.setWriter("brown");
//		farmdiaryVo.setYield(900);
//		farmdiaryVo.setFile_nm("test.jpg");
//		
//		/*** When ***/
//		int registCnt = fsurpportDao.registFarmdiary(farmdiaryVo);
//		
//		/*** Then ***/
//		assertEquals(1, registCnt);
//	}
	
	// 20210312_ggy_fsurpport : 영농일지 일지내용 수정_OK
	@Test
	public void modifyFarmdiaryInfoTest() {
		/*** Given ***/
		FarmdiaryVo farmdiaryVo = new FarmdiaryVo();
		farmdiaryVo.setF_diary_no(88);
		farmdiaryVo.setFile_no(87);
		farmdiaryVo.setArea(500);
		farmdiaryVo.setB_type_code("1");
		farmdiaryVo.setContent("dao Test");
		farmdiaryVo.setHigh_temp(0);
		farmdiaryVo.setHumid(0);
		farmdiaryVo.setItem_code("317");
		farmdiaryVo.setLow_temp(0);
		farmdiaryVo.setMy_simple_code(84);
		farmdiaryVo.setRainfall(0);
		farmdiaryVo.setW_step_code("24");
		farmdiaryVo.setWeather("비");
		farmdiaryVo.setWriter("brown");
		farmdiaryVo.setYield(900);
		farmdiaryVo.setFile_nm("test.jpg");
		
		/*** When ***/
		int modifyCnt = fsurpportDao.modifyFarmdiaryInfo(farmdiaryVo);
		
		/*** Then ***/
		assertEquals(1, modifyCnt);
	}
	
//	// 20210312_ggy_fsurpport : 영농일지 파일 삭제 시파일 코드 삭제_OK
//	@Test
//	public void deleteFile_noTest() {
//		/*** Given ***/
//		
//		/*** When ***/
//		int deleteCnt = fsurpportDao.deleteFile_no(3);
//		
//		/*** Then ***/
//		assertEquals(1, deleteCnt);	
//	}	
	
	// 20210312_ggy_fsurpport : 해당 영농일지 삭제_OK
	@Test
	public void deleteFarmdiaryTest() {
		/*** Given ***/
		FarmdiaryVo farmdiaryVo = new FarmdiaryVo();
		farmdiaryVo.setWriter("brown");
		farmdiaryVo.setF_diary_no(88);
		
		/*** When ***/
		int deleteCnt = fsurpportDao.deleteFarmdiary(farmdiaryVo);
		
		/*** Then ***/
		assertEquals(1, deleteCnt);	
	}	
		
		
	
	
	
	
	
	
	

	
}









