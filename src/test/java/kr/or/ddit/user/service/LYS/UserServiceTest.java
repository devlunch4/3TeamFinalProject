package kr.or.ddit.user.service.LYS;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.test.config.WebTestConfig;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserServiceImpl;

public class UserServiceTest extends WebTestConfig{

	@Resource(name="userService")
	private UserServiceImpl userService;
	
	// userid에 해당하는 사용자 한명의 정보 조회
		@Test
		public void selectUsertest() {
			/*** Given ***/
			String userid = "brown";

			/*** When ***/
			UserVo userVo = userService.selectUser(userid);

			/*** Then ***/
			assertEquals("brownPass", userVo.getUser_pw());
		}
		
		// 로그인을 한 사용자의 사용여부(use_yn) 확인
		@Test
		public void selectUse_yn() {
			/*** Given ***/
			String userid = "brown";

			/*** When ***/
			UserVo userVo = userService.selectUser(userid);

			/*** Then ***/
			assertEquals("Y", userVo.getUse_yn());
		}
		
		
		// 지금까지 실패한 로그인 카운트
		@Test
		public void updateLoginFailCnt() {
			/*** Given ***/
			String userid = "brown";
			
			/*** When ***/
			UserVo userVo = userService.selectUser(userid);
			
			/*** Then ***/
			assertEquals(0, userVo.getLogin_fail_cnt());
		}
		
	
}
