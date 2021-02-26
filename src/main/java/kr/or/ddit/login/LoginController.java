package kr.or.ddit.login;

import java.io.IOException;
import java.io.PrintWriter;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserServiceImpl;

@RequestMapping("login")
@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Resource(name = "userService")
	private UserServiceImpl userService;

	@RequestMapping(path = "view", method = { RequestMethod.GET })
	public String view() {
		logger.debug("iNN login controller >> view");
		return "login";
	}
	
	
	@RequestMapping(path = "view2", method = { RequestMethod.GET })
	public String view2() {
		logger.debug("iNN login controller >> view");
		return "tiles.fdata.index";
	}

	// String userid = req.getParameter("userid");
	// String pass = req.getParameter("pass");
	// @RequestMapping("process")
	public String process(String userid, String pass, int price) {
		logger.debug("userid : {}", userid);
		logger.debug("pass : {}", pass);
		logger.debug("price : {}", price);
		return "";
	}

	// post만 처리하도 설정
	@RequestMapping(path = "process", method = { RequestMethod.POST })
	public String process(UserVo userVo, HttpSession session, HttpServletRequest request, RedirectAttributes ra) {
		logger.debug("userVo : {}", userVo);

		// 아이디 가져오기
		UserVo dbUser = userService.selectUser(userVo.getUserid());

		// logger.debug("{} / {}",dbUser.getPass(),userVo.getPass());
		if (dbUser != null && userVo.getPass().equals(dbUser.getPass())) {
			// 로그인 성공시
			// 세션 내장객체 호출
			session.setAttribute("S_USER", dbUser);
			return "main";
		} else {
			// 로그인 실패시
			// session.setAttribute("msg", "잘못된 사용자 정보입니다.");

			// 내부적으로 session 사용하여 속성을 저장
			// 리다이렉트 처리가 완료되면 스프링 프레임워크에서 자동으로 session에서 제거
			ra.addFlashAttribute("msg", "잘못된 사용자 정보입니다.");
			// 일반 속성을 추가한경우: addAttribute
			// 리다이렉트 페이지의 파라미터로 전달된
			ra.addAttribute("userid", userVo.getUserid());
			return "redirect:/login/view";
		}
	}

	// 로그아웃
	@RequestMapping("logout") // 모든 사용자 정보 조회
	public String logout(Model model, HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		UserVo dbUser = (UserVo) session.getAttribute("S_USER");
		String outid = "";
		if (dbUser != null) {
			outid = dbUser.getUserid();
		}
		model.addAttribute("msg", outid + " 님 로그아웃 되셨습니다.");
		model.addAttribute("url", "/login/view");
		req.getSession().invalidate();
		return "logoutRedirect";
	}
}
