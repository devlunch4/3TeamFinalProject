package kr.or.ddit.user.web.LYS;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.test.config.WebTestConfig;
import kr.or.ddit.user.service.UserService;

/**
 * @RunWith(SpringJUnit4ClassRunner.class) 를 사용해야 실제 스프링에 사용되는 빈을 설정하여 불러올수있다
 * @ContextConfiguration(locations = {...}) 을 사용하여 빈 컨텍스트를 불러오도록 한다
 */

// 20210313_LYS_Q&A
// 로그인 컨트롤러 테스트
public class LoginControllerTest extends WebTestConfig{

	@Resource(name="userService")
	private UserService userService;
	
	// 20210313_LYS_Q&A
	// 로그인 페이지로 이동
	@Test
	public void loginViewTest() throws Exception {
		mockMvc.perform(get("/login/view"))
				.andExpect(view().name("login"))
				.andExpect(status().isOk());
	}
	
	// 20210313_LYS_Q&A
	// 로그인 성공시
	@Test
	public void loginSuccessProcessTest() throws Exception {
		mockMvc.perform(post("/login/process")
					.param("user_id", "admin")
					.param("user_pw", "admin"))
				.andExpect(view().name("redirect:/user/main"))
				.andDo(print());
	}
	
	// 20210313_LYS_Q&A
	// 로그인 실패시
	@Test
	public void loginFailProcessTest() throws Exception {
		mockMvc.perform(post("/login/process")
				.param("user_id", "brown")
				.param("user_pw", "brownPass11"))
		.andExpect(view().name("alert"))
		.andDo(print());
	}

	
	

}
