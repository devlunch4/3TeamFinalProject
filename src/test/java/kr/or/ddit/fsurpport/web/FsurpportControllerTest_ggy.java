package kr.or.ddit.fsurpport.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartFile;

import kr.or.ddit.fsurpport.service.FsurpportService;
import kr.or.ddit.test.config.WebTestConfig;

public class FsurpportControllerTest_ggy  extends WebTestConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(FsurpportControllerTest_ggy.class);
	
	@Resource(name = "fsurpportService")
	private FsurpportService fsurpportService;
	
	// 20210311_ggy_fsurpport : 영농일지 진입 controller Test_OK
	@Test
	public void mainTest() throws Exception {
		
		mockMvc.perform(get("/fsurpport/main").param("user_id", "brown") )
				.andExpect(view().name("tiles.fsurpport.fsurpportMain"))
				.andExpect(model().attributeExists("farmdiaryList", "workstepsList", "itemsList"))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	// 20210313_ggy_fsurpport : 농업지원-영농일지 내 일지 목록 검색 Test_OK
	@Test
	public void searchAllFsurpportListTest() throws Exception {
		
		mockMvc.perform(post("/fsurpport/searchAllFsurpportList")
				.param("startDate", "2021/03/12")
				.param("endDate", "2021/03/12")
				.param("item_code", "112")
				.param("writer", "brown")
				)
		.andExpect(view().name("tiles.fsurpport.fsurpportMain"))
		.andExpect(model().attributeExists("farmdiaryList", 
				"workstepsList", "itemsList"))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	// 20210313_ggy_fsurpport : 농업지원-영농일지 내 일지 상세조회를 위한 진입페이지 Test_OK
	@Test
	public void infoViewTest() throws Exception {
		
		mockMvc.perform(get("/fsurpport/infoView")
				.param("f_diary_no", "23")
				)
		.andExpect(view().name("tiles.fsurpport.fsurpportInfo"))
		.andExpect(model().attributeExists("farmdiaryList"
					))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	// 20210313_ggy_fsurpport : 농업지원-영농일지 내 일지 상세조회를 위한 진입페이지 Test_OK
	@Test
	public void insertViewTest() throws Exception {
		
		mockMvc.perform(get("/fsurpport/insertView")
				.param("owner", "brown")
				)
		.andExpect(view().name("tiles.fsurpport.fsurpportInsert"))
		.andExpect(model().attributeExists("mySimpleCodeList"
				, "workstepsList", "itemsList", "b_typeList"
				))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	
	// 20210313_ggy_fsurpport : 농업지원-영농일지 내 일지 상세조회를 위한 진입페이지 Test_OK
	@Test
	public void selectMySimpleCodeInsertViewTest() throws Exception {
		
		mockMvc.perform(get("/fsurpport/selectMySimpleCodeInsertView")
				.param("owner", "brown")
				.param("my_simple_code", "26")
				)
		.andExpect(view().name("tiles.fsurpport.fsurpportInsert"))
		.andExpect(model().attributeExists("mySimpleCodeList"
				, "workstepsList", "itemsList", "b_typeList"
				))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	// ggy_20210313 : 농업지원-영농일지 간편등록 목록 선택시 값 자동으로 배치_OK
	@Test
	public void selectMySimpleCodeInfoTest() throws Exception {
		
		mockMvc.perform(get("/fsurpport/selectMySimpleCodeInfo")
				.param("user_id", "brown")
				.param("my_simple_code", "26")
				)
		.andExpect(view().name("tiles.fsurpport.fsurpportInsert"))
		.andExpect(model().attributeExists("mySimpleCodeList"
				, "workstepsList", "itemsList", "selectMySimpleCodeInfo"
				))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	
	// ggy_20210313 : 농업지원-영농일지 내 일지 간편등록를 위한 진입페이지_OK
	@Test
	public void simpleInsertViewTest() throws Exception {
		
		mockMvc.perform(get("/fsurpport/simpleInsertView")
				)
		.andExpect(view().name("tiles.fsurpport.fsurpportSimpleInsert"))
		.andExpect(model().attributeExists("workstepsList"
				, "itemsList"
				, "b_typeList"
				))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
//	// ggy_20210313 : 농업지원-영농일지 내 간편등록 작성한걸 등록_OK
//	@Test
//	public void registMySimpleCodeTest() throws Exception {
//		
//		mockMvc.perform(post("/fsurpport/registMySimpleCode")
//				.param("owner", "brown")
//				.param("user_id", "brown")
//				.param("b_type_code", "1")
//				.param("item_code", "317")
//				.param("area", "500")
//				)
//		.andExpect(view().name("tiles.fsurpport.fsurpportInsert"))
//		.andExpect(model().attributeExists("workstepsList"
//				, "itemsList"
//				, "mySimpleCodeList"
//				))
//		.andExpect(status().isOk())
//		.andDo(print());
//	}
	
//	// ggy_20210313 : 농업지원-영농일지 내 일지 등록_OK
//	@Test
//	public void registFarmdiaryTest() throws Exception {
//		
//		ClassPathResource resource = new ClassPathResource("kr/or/ddit/upload/test.jpg");
//		
//		MockMultipartFile file = new MockMultipartFile("file_file", "test.jpg", "image/png", new byte[512]);
//		
//		
//		mockMvc.perform(fileUpload("/fsurpport/registFarmdiary").file(file)
//				.param("area", "500")
//				.param("b_type_code", "1")
//				.param("content", "testCode_test")
//				.param("high_temp", "0")
//				.param("humid", "0")
//				.param("item_code", "317")
//				.param("low_temp", "0")
//				.param("my_simple_code", "84")
//				.param("rainfall", "0")
//				.param("w_step_code", "24")
//				.param("weather", "비")
//				.param("writer", "brown")
//				.param("yield", "800")
//				
//				)
//		.andExpect(redirectedUrl("/fsurpport/main?user_id=brown"))
//		.andExpect(status().is3xxRedirection())
//		.andDo(print());
//	}
	

	// ggy_20210313 : 농업지원-영농일지 내 일지 수정을 위한 진입페이지_OK
	@Test
	public void ModifyViewTest() throws Exception {
		
		mockMvc.perform(get("/fsurpport/ModifyView")
				.param("writer", "brown")
				.param("f_diary_no", "85")
				.param("my_simple_code", "84")
				)
		.andExpect(view().name("tiles.fsurpport.fsurpportModify"))
		.andExpect(model().attributeExists("workstepsList"
				, "itemsList"
				, "b_typeList"
				,"farmdiaryList"
				,"mySimpleCodeList"
				))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	// ggy_20210313 : 농업지원-영농일지 내 일지 내용 수정후 수정 완료_OK
	@Test
	public void modifyFarmdiaryTest() throws Exception {
	
	ClassPathResource resource = new ClassPathResource("kr/or/ddit/upload/test.jpg");
	
	MockMultipartFile file = new MockMultipartFile("file_file", "test.jpg", "image/png", new byte[512]);
	
	
	mockMvc.perform(fileUpload("/fsurpport/modifyFarmdiary").file(file)
			.param("f_diary_no", "85")
			.param("area", "500")
			.param("b_type_code", "1")
			.param("content", "testCode_test")
			.param("high_temp", "0")
			.param("humid", "0")
			.param("item_code", "317")
			.param("low_temp", "0")
			.param("my_simple_code", "84")
			.param("rainfall", "0")
			.param("w_step_code", "24")
			.param("weather", "비")
			.param("writer", "brown")
			.param("yield", "800")
			.param("file_nm", "")
			
			)
	.andExpect(redirectedUrl("/fsurpport/infoView?f_diary_no=85"))
	.andExpect(status().is3xxRedirection())
	.andDo(print());
	}
	
//	// ggy_20210309 : 농업지원-영농일지 내 일지 삭제_OK
//	@Test
//	public void deleteFarmdiaryTest() throws Exception {
//		
//		mockMvc.perform(post("/fsurpport/deleteFarmdiary")
//				.param("writer", "1")
//				.param("f_diary_no", "1")
//				)
//		.andExpect(redirectedUrl("/fsurpport/main?user_id=1"))
//		.andExpect(status().is3xxRedirection())
//		.andDo(print());
//	}
	
	// ggy_20210309 : 농업지원-영농일지 일지 목록들 다운로드_OK
	@Test
	public void excelFamrdiaryListTest() throws Exception {
		
		mockMvc.perform(post("/fsurpport/excelFamrdiaryList")
				.param("user_id", "brown")
				)
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	// ggy_20210309 : 농업지원-영농일지 일지 목록들 pdf 열기_OK
	@Test
	public void farmdiaryListPDFTest() throws Exception {
		
		mockMvc.perform(post("/fsurpport/farmdiaryListPDF.pdf")
				.param("user_id", "brown")
				)
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	// ggy_20210309 : 파일 경로_OK
	@Test
	public void filePathTest() throws Exception {
		
		mockMvc.perform(post("/fsurpport/filePath")
				.param("file_nm", "test.jpg")
				)
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
