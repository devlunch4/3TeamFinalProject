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
import kr.or.ddit.user.service.UserServiceImpl;

@RequestMapping("login")
@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Resource(name = "userService")
	private UserServiceImpl userService;

//	20210302_LYS_Login2 - 로그인페이지로 이동
	@RequestMapping(path = "view", method = { RequestMethod.GET })
	public String loginView() {
		logger.debug("iNN login controller >> loginView");
		return "login";
	}

//	20210302_LYS_Login2 - 로그인 구현 페이지
	@RequestMapping(path = "process", method = { RequestMethod.POST })
	public String loginProcess(UserVo userVo, HttpSession session) {
		logger.debug("iNN login controller >> loginProcess");

		UserVo dbUser = userService.selectUser(userVo.getUser_id());

		if (dbUser != null && userVo.getUser_pw().equals(dbUser.getUser_pw())) {
			session.setAttribute("S_USER", dbUser);
			return "redirect:/user/main";
		} else {
			return "redirect:/login/view";
		}
	}

	

	// 누구?
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
		model.addAttribute("url", "/login/view");
		req.getSession().invalidate();
		return "logoutRedirect";
	}
}
