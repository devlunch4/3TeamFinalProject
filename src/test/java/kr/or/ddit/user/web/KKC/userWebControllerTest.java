package kr.or.ddit.user.web.KKC;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.test.config.ModelTestConfig;
import kr.or.ddit.test.config.WebTestConfig;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.repository.UserDao;

public class userWebControllerTest extends ModelTestConfig {

	@Resource(name = "UserDao")
	private UserDao userDao;

	// 모든회원 정보 조회 (경찬) 3/16
	@Test
	public void userDetail() throws Exception {
		/*** Given ***/

		/*** When ***/
		List<UserVo> userList = userDao.selectAllUser();
		/*** Then ***/
		assertEquals(38, userList.size());
	}

}
