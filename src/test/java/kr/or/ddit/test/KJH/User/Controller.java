package kr.or.ddit.test.KJH.User;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;

import kr.or.ddit.test.config.WebTestConfig;

public class Controller extends WebTestConfig{
	
	@Test
	public void mian() throws Exception{
		mockMvc.perform(get("/user/main") 
				.param("sdate", "2021-03-01")
				.param("parent_code", "100")
				.param("code_no", "111"))
		.andExpect(status().isOk())
		.andExpect(view().name("tiles.main.main"));
	}

}
