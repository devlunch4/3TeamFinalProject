package kr.or.ddit.login;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;

@RequestMapping("login")
@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Resource(name = "userService")
	private UserService userService;

//	20210302_LYS_Login2 - 로그인페이지로 이동
	@RequestMapping(path = "view", method = { RequestMethod.GET })
	public String loginView() {
		logger.debug("iNN login controller >> loginView");
		return "login";
	}

//	20210302_LYS_Login2 - 로그인 구현 페이지
	@RequestMapping(path = "process", method = { RequestMethod.POST })
	public String loginProcess(UserVo userVo, HttpSession session, Model model) {
		logger.debug("iNN login controller >> loginProcess");

		UserVo dbUser = userService.selectUser(userVo.getUser_id());
		String use_yn = userService.selectUse_yn(userVo.getUser_id());
		int login_fail_cnt = userService.sumLoginFailCnt(userVo.getUser_id());

		// use_yn이 N이면 로그인 불가능하게끔
		if (dbUser != null && use_yn.equals("N")) {
			model.addAttribute("msg", "아이디 '" + dbUser.getUser_id() + "' 로그인이 불가능합니다.");
			model.addAttribute("url", "/login/view");
			return "alert";
		}

		// 5번이상 로그인 실패시
		if (login_fail_cnt >= 5) {
			model.addAttribute("msg", "아이디 '" + dbUser.getUser_id() + "' 5회 오류. \\n로그인이 불가능합니다.");
			model.addAttribute("url", "/login/view");
			return "alert";
		}

		// 아이디가 널이아니고 use_yn이 Y이고 비밀번호가 일치하면 로그인 가능
		if (dbUser != null && use_yn.equals("Y") && userVo.getUser_pw().equals(dbUser.getUser_pw())) {
			
			//로그인 성공했을때 login_fail_cnt 카운트 0으로 리셋
			userService.updateLoginFailCnt_reset(userVo.getUser_id());
	
			logger.debug("dbUser : {}", dbUser);
			
			session.setAttribute("S_USER", dbUser);
			
			return "redirect:/user/main";
		} // 아이디가 널이아니고 use_yn이 Y이지만 비밀번호가 틀림 -> login_fail_cnt 1 증가
		else if (dbUser != null && use_yn.equals("Y") && !userVo.getUser_pw().equals(dbUser.getUser_pw())) {

			// login_fail_cnt 1 증가하는 쿼리
			int update_login_fail_cnt = userService.updateLoginFailCnt(userVo.getUser_id());

			// update_login_fail_cnt 이거 성공하면
			if (update_login_fail_cnt > 0) {

				// 이유는 모르겠는데 update+1 쿼리를 실행했는데 바로 적용이 안되서 뷰에서 카운트 뽑아내려고 ++
				login_fail_cnt++;
				// +추가 : 이유는 update하는 와중에 한번에 바로 코드가 실행이되서 적용이 안됨   
				
				model.addAttribute("msg", "비밀번호가 일치하지 않습니다. \\n아이디 '" + dbUser.getUser_id() + "' 로그인 " + login_fail_cnt
						+ "회 오류입니다. \\n5회 오류 시 로그인이 불가능 합니다.");
				model.addAttribute("url", "/login/view");
				return "alert";

			} else {
				return "redirect:/login/view";
			}

		} else {
			return "redirect:/login/view";
		}
	}

	// 누구? 누구얔!
	@RequestMapping(path = "view2", method = { RequestMethod.GET })
	public String view2() {
		logger.debug("iNN login controller >> view");
		return "tiles.fdata.index";
	}

	// 로그아웃
	@RequestMapping("logout") // 모든 사용자 정보 조회
	public String logout(Model model, HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		UserVo dbUser = (UserVo) session.getAttribute("S_USER");
		String outid = "";
		if (dbUser != null) {
			outid = dbUser.getUser_id();
		}
		model.addAttribute("msg", outid + " 님 로그아웃 되셨습니다.");
		model.addAttribute("url", "/user/main");
		req.getSession().invalidate();
		return "alert";
	}
}
