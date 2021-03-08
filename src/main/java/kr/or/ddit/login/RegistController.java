package kr.or.ddit.login;

import java.util.Properties;
import java.util.Random;

import javax.annotation.Resource;

import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
		
		if(user_id_check != null) {
			String id_status_taken = "가입된 아이디입니다.";
			model.addAttribute("id_status_taken", id_status_taken);
		}else {
			String id_status_ok = "사용 가능한 아이디입니다.";
			model.addAttribute("id_status_ok", id_status_ok);
		}
		return "jsonView";
	}
	
	
	//20210308_LYS_Join2 - 이메일인증
	@RequestMapping(path="email_verify", method = RequestMethod.POST)
	public String email_verify(String email, Model model) {
		
		String a[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String b[] = { "as", "bb", "cq", "dy", "ex", "fv", "gf", "ha", "ir", "jn", "kc", "lg", "mp", "ni", "ok", "pm", "qn", "rb", "sc",
				"tq", "ur", "vx", "wb", "xf", "yj", "za" };
		String c[] = { "AU", "BC", "CB", "DE", "Ed", "Fv", "Gr", "HQ", "IB", "Jb", "Ku", "L4", "M7", "Ng", "O2", "Pf", "Qq", "Rd", "Sv",
				"Th", "Ut", "Vm", "Wp", "Xf", "gY", "Zs" };
		String d[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		
		String Brandom1 = (a[new Random().nextInt(a.length)]);
		String Brandom2 = (b[new Random().nextInt(a.length)]);
		String Brandom3 = (c[new Random().nextInt(a.length)]);
		String Brandom4 = (d[new Random().nextInt(a.length)]);
		
		String code = Brandom1+Brandom2+Brandom3+Brandom4;

		model.addAttribute("code", code);

		//인증코드를 보내는 이메일	
		String host = "smtp.naver.com";
		final String user = "test_for_develop@naver.com";
		final String password = "smartFarmers";
		
		String to = email;

		Properties props = new Properties();

		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		try {

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));

			message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));

			// 제목
			message.setSubject("똑똑한 농부들 회원가입 이메일 인증코드입니다.");

			// 내용
			message.setText("똑똑한 농부들 회원가입 인증코드는 " + code + " 입니다.");

			Transport.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return "jsonView";
	}
	
	
//	//20210308_LYS_Join2 - 핸드폰인증
//	@RequestMapping(path="mobile_verify", method = RequestMethod.POST)
//	public String mobile_verify(Model model) {
//		
//		
//		String api_key = "NCSO84P8OV8CL2LC";
//		String api_secret = "0EVDBPVNWPT5K4S8FKIWXEYDK0VSXFD8";
//		Message coolsms = new Message(api_key, api_secret);
//
//		String a[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
//		String b[] = { "as", "bb", "cq", "dy", "ex", "fv", "gf", "ha", "ir", "jn", "kc", "lg", "mp", "ni", "ok", "pm", "qn", "rb", "sc",
//				"tq", "ur", "vx", "wb", "xf", "yj", "za" };
//		String c[] = { "AU", "BC", "CB", "DE", "Ed", "Fv", "Gr", "HQ", "IB", "Jb", "Ku", "L4", "M7", "Ng", "O2", "Pf", "Qq", "Rd", "Sv",
//				"Th", "Ut", "Vm", "Wp", "Xf", "gY", "Zs" };
//		String d[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
//		
//		String Brandom1 = (a[new Random().nextInt(a.length)]);
//		String Brandom2 = (b[new Random().nextInt(a.length)]);
//		String Brandom3 = (c[new Random().nextInt(a.length)]);
//		String Brandom4 = (d[new Random().nextInt(a.length)]);
//		
//		String num = Brandom1+Brandom2+Brandom3+Brandom4;
//
//		String tel = request.getParameter("tel");
//		String telcode = request.getParameter("telcode");
//
//		request.setAttribute("num", num);
//		request.setAttribute("telcode", telcode);
//
//		System.out.println(tel);
//		HashMap<String, String> params = new HashMap<String, String>();
//		params.put("to", tel); // 수신전화번호
//		params.put("from", "01029937927"); // 발신전화번호.
//		params.put("type", "SMS");
//		params.put("text", "인증코드 : " + num +" 입니다");
//		params.put("app_version", "test app 1.2"); // application name and version
//
//		try {
//			JSONObject obj = (JSONObject) coolsms.send(params);
//			System.out.println(obj.toString());
//		} catch (CoolsmsException e) {
//			System.out.println(e.getMessage());
//			System.out.println(e.getCode());
//		}
//
//		
//		return "";
//		
//	}

	// 20210304_LYS_Login3 - 회원가입 구현
	@RequestMapping(path = "process", method = { RequestMethod.POST })
	public String registerProcess(UserVo userVo) {
		logger.debug("iNN RegistController >> registerProcess");

		userService.insertUser(userVo);

		return "register";
	}

}
