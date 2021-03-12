package kr.or.ddit.fsurpport.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
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
		
		mockMvc.perform(post("/fsurpport/main").param("user_id", "brown") )
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
		
		mockMvc.perform(post("/fsurpport/infoView")
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
		
		mockMvc.perform(post("/fsurpport/insertView")
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
		
		mockMvc.perform(post("/fsurpport/selectMySimpleCodeInsertView")
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
	
	// ggy_20210309 : 농업지원-영농일지 간편등록 목록 선택시 값 자동으로 배치_OK
	@Test
	public void selectMySimpleCodeInfoTest() throws Exception {
		
		mockMvc.perform(post("/fsurpport/selectMySimpleCodeInfo")
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
