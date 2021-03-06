package kr.or.ddit.login;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserServiceImpl;

@RequestMapping("join")
@Controller
public class RegistController {
	private static final Logger logger = LoggerFactory.getLogger(RegistController.class);

	// 필요한 스프링 빈 호출
	@Resource(name = "userService")
	private UserServiceImpl userService;

//	20210302_LYS_Login2 - 회원가입페이지로 이동
	@RequestMapping(path = "view", method = { RequestMethod.GET })
	public String registerView() {
		logger.debug("iNN RegistController >> registerView");
		return "register";
	}

	//	20210304_LYS_Login3 - 회원가입 시, 아이디 중복체크
	@RequestMapping(path = "id_check", method = RequestMethod.POST)
	public String idCheck(String user_id, Model model) {
		
		logger.debug("iNN RegistController >> idCheck");
		String user_id_check = userService.checkForDuplicateId(user_id);
		
		if(user_id_check.equals(user_id)) {
			String txt_taken = "가입된 아이디입니다.";
			model.addAttribute("txt_taken", txt_taken);
		}else {
			String txt_available = "사용 가능한 아이디입니다.";
			model.addAttribute(txt_available);
		}
		return "jsonView";
		
	}

	// 20210304_LYS_Login3 - 회원가입 구현
	@RequestMapping(path = "process", method = { RequestMethod.POST })
	public String registerProcess(UserVo userVo) {
		logger.debug("iNN RegistController >> registerProcess");

		userService.insertUser(userVo);

		return "register";
	}

}
