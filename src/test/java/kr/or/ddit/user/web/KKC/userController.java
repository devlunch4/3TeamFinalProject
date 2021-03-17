package kr.or.ddit.user.web.KKC;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.test.config.WebTestConfig;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.repository.UserDaoImpl;

public class userController extends WebTestConfig {

	@Resource(name = "UserDao")
	private UserDaoImpl userDao;

	// 관리자가 모든 회원 보는거 (경찬) 3/16
	@Test
	public void allUser() throws Exception {
		mockMvc.perform(get("/user/allUser")).andExpect(status().isOk()).andExpect(view().name("tiles.user.allUser"));
	}

	// 모든회원 정보 조회 (경찬) 3/16
//	@Test
//	public void userDetail() throws Exception {
//		/*** Given ***/
//
//		/*** When ***/
//		List<UserVo> userList = userDao.selectAllUser();
//		/*** Then ***/
//		assertEquals(38, userList.size());
//	}

}
