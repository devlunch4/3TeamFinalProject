package kr.or.ddit.fsurpport.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.common.model.FilesVo;
import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.farm.model.MySimpleCodeVo;
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
		assertEquals(17, farmdiaryList.size());
	}
	
	
	// 20210312_ggy_fsurpport : 등록된 품목 조회_OK
	@Test
	public void selectAllItem_codeListTest() {
		/***Given***/
		
		/***When***/
		List<CodesVo> codesList = fsurpportService.selectAllItem_codeList();
		
		/***Then***/
		
		assertEquals(62, codesList.size());
	}
	
	// 20210312_ggy_fsurpport : 등록된 작업단계 조회 수정_OK
	@Test
	public void selectAllW_step_codeListTest() {
		/***Given***/
		
		/***When***/
		List<CodesVo> codesList = fsurpportService.selectAllW_step_codeList("1");
		
		/***Then***/
		
		assertEquals(31, codesList.size());
	}
	
	// 20210312_ggy_fsurpport : 등록된 사업유형 조회_OK
	@Test
	public void selectAllB_type_codeListTest() {
		/***Given***/
		
		/***When***/
		List<CodesVo> codesList = fsurpportService.selectAllB_type_codeList();
		
		/***Then***/
		
		assertEquals(7, codesList.size());
	}
	
	// 20210312_ggy_fsurpport : 등록한 나만의 영농일지-간편등록 목록 조회_OK
	@Test
	public void selectMySimpleCodeListTest() {
		/***Given***/
		String user_id = "brown";
		
		/***When***/
		List<MySimpleCodeVo> codesList = fsurpportService.selectMySimpleCodeList(user_id);
		
		/***Then***/
		
		assertEquals(14, codesList.size());
	}
	
	// 20210312_ggy_fsurpport : 등록한 나만의 영농일지-나의 간편등록 조회 해서 배치_OK
	@Test
	public void selectMySimpleCodeInfoTest() {
		/***Given***/
		MySimpleCodeVo mySimpleCodeVo = new MySimpleCodeVo();
		mySimpleCodeVo.setOwner("brown");
		mySimpleCodeVo.setMy_simple_code(26);
		
		/***When***/
		mySimpleCodeVo = fsurpportService.selectMySimpleCodeInfo(mySimpleCodeVo);
		
		/***Then***/
		assertNotNull(mySimpleCodeVo);
	}
	
	// 20210312_ggy_fsurpport : 농업지원-영농일지 내 간편등록을 위해 사업 유형 코드 조회_OK
	@Test
	public void selectB_type_code_noTest() {
		/***Given***/
		
		/***When***/
		CodesVo codesVo = fsurpportService.selectB_type_code_no("1");
		
		/***Then***/
		assertNotNull(codesVo);
	}
	
	// 20210312_ggy_fsurpport : 농업지원-영농일지 내 간편등록을 위해 품목 코드 조회_OK
	@Test
	public void selectItem_type_code_noTest() {
		/***Given***/
		
		/***When***/
		CodesVo codesVo = fsurpportService.selectItem_type_code_no("317");
		
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
//		int registCnt = fsurpportService.registMySimpleCode(mySimpleCodeVo);
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
		List<FarmdiaryVo> farmdiaryList = fsurpportService.searchAllFarmdiaryList(farmdiaryVo);
		
		/***Then***/
		assertEquals(8, farmdiaryList.size());
	}
	
	// 20210312_ggy_fsurpport : 해당 일지 정보 조회_OK
	@Test
	public void selectFarmdiaryInfoTest() {
		/***Given***/
		
		/***When***/
		FarmdiaryVo farmdiaryInfo = fsurpportService.selectFarmdiaryInfo(1);
		
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
		mySimpleCodeVo = fsurpportService.selectMySimpleCode_noInfo(mySimpleCodeVo);
		
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
//		int registFilesCnt = fsurpportService.registFiles(filesVo);
//		
//		/***Then***/
//		assertEquals(125, registFilesCnt);
//	}
	
	// 20210312_ggy_fsurpport : 일지 등록을 위해 일지 정보 가져오기_OK
	@Test
	public void selectFilesInfoTest() {
		/*** Given ***/
		
		/*** When ***/
		FilesVo filesVo = fsurpportService.selectFilesInfo(121);

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
//		int registCnt = fsurpportService.registFarmdiary(farmdiaryVo);
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
		int modifyCnt = fsurpportService.modifyFarmdiaryInfo(farmdiaryVo);
		
		/*** Then ***/
		assertEquals(1, modifyCnt);
	}
	
	// 20210312_ggy_fsurpport : 영농일지 파일 삭제 시파일 코드 삭제_OK
	@Test
	public void deleteFile_noTest() {
		/*** Given ***/
		
		/*** When ***/
		int deleteCnt = fsurpportService.deleteFile_no(3);
		
		/*** Then ***/
		assertEquals(1, deleteCnt);	
	}	
	
	// 20210312_ggy_fsurpport : 해당 영농일지 삭제_OK
	@Test
	public void deleteFarmdiaryTest() {
		/*** Given ***/
		FarmdiaryVo farmdiaryVo = new FarmdiaryVo();
		farmdiaryVo.setWriter("brown");
		farmdiaryVo.setF_diary_no(91);
		
		/*** When ***/
		int deleteCnt = fsurpportService.deleteFarmdiary(farmdiaryVo);
		
		/*** Then ***/
		assertEquals(1, deleteCnt);	
	}	
	
		
}









