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
	
	// 20210311_ggy_fsurpport : 영농일지 진입 controller Test
	@Test
	public void process() throws Exception {
		
		mockMvc.perform(post("/fsurpport/main").param("user_id", "brown") )
				.andExpect(view().name("tiles.fsurpport.fsurpportMain"))
				.andExpect(model().attributeExists("farmdiaryList"))
				.andExpect(model().attributeExists("workstepsList"))
				.andExpect(model().attributeExists("itemsList"))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
