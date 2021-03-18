package kr.or.ddit.user.web.KKC;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;

import kr.or.ddit.test.config.WebTestConfig;

public class userControllerTest extends WebTestConfig {

	// 관리자가 모든 회원 보는거 (경찬) 3/16
	@Test
	public void allUser() throws Exception {
		mockMvc.perform(get("/user/allUser")).andExpect(status().isOk()).andExpect(view().name("tiles.user.allUser"));
	}

}
