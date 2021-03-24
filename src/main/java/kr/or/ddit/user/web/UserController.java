package kr.or.ddit.user.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.codes.service.CodesService;
import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.fdata.service.FdataService;
import kr.or.ddit.fsurpport.service.FsurpportService;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;

@RequestMapping("user")
@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	// 필요한 스프링 빈 호출
	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "fdataService")
	private FdataService fdataService;

	@Resource(name = "fsurpportService")
	private FsurpportService fsurpportService;

	@Resource(name = "codesService")
	private CodesService codesService;

	// 메인 가기
	// 20210302_KJH items - > codes 변경 test ok
	@RequestMapping("main")
	public String main(Model model, CodesVo codesVo, String sdate) {
		logger.debug("In main()");
		// KJH - 메인으로 가면서 크롤링하여 시세분석값을 가져옴
		String itemcategorycode = "100";
		String itemcode = "111";
		Date date = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		String mydate = transFormat.format(date);
		if (sdate != null) {
			mydate = sdate;
		}
		if (codesVo.getCode_no() != null) {
			itemcategorycode = codesVo.getParent_code();
			itemcode = codesVo.getCode_no();
		}
		// Jsoup라이브러리를 사용한 크롤링
		Document doc;
		try {
			doc = Jsoup.connect("https://www.kamis.or.kr/customer/price/wholesale/item.do?action=priceinfo&regday="
					+ mydate + "&itemcategorycode=" + itemcategorycode + "&itemcode=" + itemcode
					+ "&kindcode=&productrankcode=0&convert_kg_yn=N").get();
			int docsize = (doc.select("tr").get(12)).select("td").size();

			List<String> target = new ArrayList<String>();
			target.add(((doc.select("tr").get(11)).select("th").get(1)).text());
			target.add(((doc.select("tr").get(11)).select("th").get(docsize - 4)).text());
			target.add(((doc.select("tr").get(11)).select("th").get(docsize - 3)).text());
			target.add(((doc.select("tr").get(11)).select("th").get(docsize - 2)).text());
			target.add(((doc.select("tr").get(11)).select("th").get(docsize - 1)).text());

			List<String> average = new ArrayList<String>();
			average.add(((doc.select("tr").get(12)).select("td").get(1)).text());
			average.add(((doc.select("tr").get(12)).select("td").get(docsize - 4)).text());
			average.add(((doc.select("tr").get(12)).select("td").get(docsize - 3)).text());
			average.add(((doc.select("tr").get(12)).select("td").get(docsize - 2)).text());
			average.add(((doc.select("tr").get(12)).select("td").get(docsize - 1)).text());

			List<String> maxvalue = new ArrayList<String>();
			maxvalue.add(((doc.select("tr").get(13)).select("td").get(1)).text());
			maxvalue.add(((doc.select("tr").get(13)).select("td").get(docsize - 4)).text());
			maxvalue.add(((doc.select("tr").get(13)).select("td").get(docsize - 3)).text());
			maxvalue.add(((doc.select("tr").get(13)).select("td").get(docsize - 2)).text());
			maxvalue.add(((doc.select("tr").get(13)).select("td").get(docsize - 1)).text());

			List<String> minvalue = new ArrayList<String>();
			minvalue.add(((doc.select("tr").get(14)).select("td").get(1)).text());
			minvalue.add(((doc.select("tr").get(13)).select("td").get(docsize - 4)).text());
			minvalue.add(((doc.select("tr").get(14)).select("td").get(docsize - 3)).text());
			minvalue.add(((doc.select("tr").get(14)).select("td").get(docsize - 2)).text());
			minvalue.add(((doc.select("tr").get(14)).select("td").get(docsize - 1)).text());

			List<String> flrate = new ArrayList<String>();
			flrate.add(((doc.select("tr").get(15)).select("td").get(1)).text());
			flrate.add(((doc.select("tr").get(15)).select("td").get(docsize - 4)).text());
			flrate.add(((doc.select("tr").get(15)).select("td").get(docsize - 3)).text());
			flrate.add(((doc.select("tr").get(15)).select("td").get(docsize - 2)).text());
			flrate.add(((doc.select("tr").get(15)).select("td").get(docsize - 1)).text());

			model.addAttribute("target", target);
			model.addAttribute("average", average);
			model.addAttribute("maxvalue", maxvalue);
			model.addAttribute("minvalue", minvalue);
			model.addAttribute("flrate", flrate);

			model.addAttribute("itemcategorycode", itemcategorycode);
			model.addAttribute("itemcode", itemcode);
			model.addAttribute("mydate", mydate);
		} catch (IOException e1) {
		}
		List<CodesVo> codesList = fdataService.selectAllCodes();
		model.addAttribute("codesList", codesList);
		return "tiles.main.main";
	}

	// 로그인한 회원이 자기정보 보는거 02/26(경찬)
	@RequestMapping(path = "myPage", method = { RequestMethod.GET })
	public String myPage(UserVo userVo) {
		logger.debug("in myPage()");
		return "tiles.user.userinfo";
	}

	// 관리자가 모든 회원보는거 03/02 (경찬)
	@RequestMapping("allUser")
	public String allUser(Model model) {
		logger.debug("in allUser()");
		long start = System.currentTimeMillis(); // 시작하는 시점 계산
		List<UserVo> userList = userService.selectAllUser();
		long end = System.currentTimeMillis(); // 프로그램이 끝나는 시점 계산
		logger.debug("실행 시간 : " + (end - start) / 1000.0 + "초");
		model.addAttribute("userList", userList);
		return "tiles.user.allUser";
	}

	// 관리자가 회원상세정보 보는거 03/03 (경찬)
	@RequestMapping(path = "userDetail", method = { RequestMethod.POST })
	public String userForm(Model model, String user_id) {
		logger.debug("In userForm()");
		UserVo user = userService.selectUser(user_id);
		// 시설카운트
		int fcount = fsurpportService.fmanageCount(user_id);
		// 일지카운트
		int ffcount = fsurpportService.fsurCount(user_id);
		model.addAttribute("user", user);
		model.addAttribute("count", fcount);
		model.addAttribute("ffcount", ffcount);
		return "tiles.user.userDetail";
	}

	// 회원탈퇴 누르면 use가 n으로 변하는거 03/04 (경찬)
	@RequestMapping(path = "deleteUser", method = { RequestMethod.POST })
	public String deleteUser(String user_id) {
		UserVo user = userService.deleteUser(user_id);
		logger.debug("in deleteUser() user : {]", user);
		return "redirect:/user/allUser";
	}

	// 회원이 정보수정 하는거 03/05(경찬)
	@RequestMapping(path = "modifyUser", method = { RequestMethod.POST })
	public String modifyUser(UserVo userVo) {
		logger.debug("In modifyUser()");
		return "tiles.user.modifyUser";
	}

	// 관리자가 비밀번호 로그인횟수 수정 03/04 (경찬)
	// 수정 03/08 (경찬)
	@RequestMapping(path = "modifyUser2", method = { RequestMethod.POST })
	public String modifyUser2(UserVo userVo, Model model) {
		logger.debug("In modifyUser2()");
		userVo = userService.modifyUser(userVo);
		List<UserVo> userList = userService.selectAllUser();
		model.addAttribute("userList", userList);
		return "tiles.user.allUser";
	}

	// 모든 회원정보 엑셀 다운로드 03/05 (경찬)
	@RequestMapping("userExcelDownload")
	public String userExcelDownload(Model model) {
		logger.debug("In userExcelDownload()");
		List<String> header = new ArrayList<String>();
		header.add("아이디");
		header.add("이름");
		header.add("가입일");

		model.addAttribute("header", header);

		List<UserVo> data = new ArrayList<UserVo>();
		logger.debug("??? new data : {}", data);
		model.addAttribute("data", userService.selectAllUser());

		return "UserExcelDownloadView";
	}

	// 모든 코드를 조회하는거 03/06 (경찬)
	@RequestMapping("codesView")
	public String codesView(Model model) {
		logger.debug("In codesView()");
		List<CodesVo> codeList = codesService.allCodes();
		model.addAttribute("codeList", codeList);
		return "tiles.user.allCodes";
	}

	// 코드 상세정보를 조회 03/08 (경찬)
	@RequestMapping(path = "codeDetail", method = { RequestMethod.POST })
	public String codeDetail(Model model, String code_seq) {
		logger.debug("In codeDetail()");
		CodesVo code = codesService.selectCodes(code_seq);
		model.addAttribute("code", code);
		return "tiles.user.codeDetail";
	}

	// 모든 코드정보 엑셀 다운로드 03/08 (경찬)
	@RequestMapping("CodeExcelDownload")
	public String excelDownLoad(Model model) {
		logger.debug("In excelDownLoad()");
		List<String> header = new ArrayList<String>();
		header.add("코드번호");
		header.add("코드이름");
		header.add("상위코드");
		header.add("사용여부");

		model.addAttribute("header", header);

		List<CodesVo> data = new ArrayList<CodesVo>();
		logger.debug("??? new data : {}", data);
		model.addAttribute("data", codesService.allCodes());

		return "CodeExcelDownloadView";
	}

	// 관리자가 코드수정 하는거 03/08 (경찬)
	@RequestMapping(path = "modifyCode", method = { RequestMethod.POST })
	public String modifyCode(String code_seq, Model model) {
		logger.debug("In modifyCode()");
		CodesVo code = codesService.selectCodes(code_seq);
		model.addAttribute("code", code);
		return "tiles.user.modifyCode";
	}

	// 관리자가 코드수정 하는거 03/08 (경찬)
	@RequestMapping("modifyCode2")
	public String modifyCode2(CodesVo codesVo, Model model) {
		logger.debug("In modifyCode2()");
		logger.debug("codesVo:{}", codesVo);
		codesVo = codesService.modifyCode(codesVo);
		List<CodesVo> codesList = codesService.allCodes();
		model.addAttribute("codeList", codesList);
		return "tiles.user.allCodes";
	}

	// 로그인하고 메인페이지 가기전에 비번입력하는거 03/09 (경찬)
	@RequestMapping(path = "userCheck", method = { RequestMethod.GET })
	public String userCheck() {
		logger.debug("In userCheck()");
		return "tiles.user.userCheck";
	}

	// 로그인하고 메인페이지 가기전에 비번입력하는거 03/09 (경찬)
	@RequestMapping(path = "userCheck2", method = { RequestMethod.POST })
	public String userCheck2(UserVo userVo, String input_pass, HttpSession session, HttpServletResponse response)
			throws IOException {
		logger.debug("In userCheck2()");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		logger.debug("??? out :{}", out);

		UserVo dbUser = (UserVo) session.getAttribute("S_USER");
		if (input_pass.equals(dbUser.getUser_pw())) {
			return "redirect:/user/myPage";
		} else {
			return "tiles.user.checkFail";
		}
	}

	// 사용자가 개인정보 수정하는거 03/10 (경찬)
	@RequestMapping(path = "modifyUser3", method = { RequestMethod.POST })
	public String modifyUser2(UserVo userVo) {
		logger.debug("In modifyUser2()");
		userVo = userService.modifyUser2(userVo);
		return "tiles.main.main";
	}

	// 이메일과 이름으로 아이디 찾기 03/23 (경찬)
	@RequestMapping(path = "findId", method = { RequestMethod.GET })
	public String findId() {
		return "tiles.user.findId";
	}
	
	// 이메일과 이름으로 아이디 찾기 03/24 (경찬)
	@RequestMapping(path = "findId2", method = { RequestMethod.POST })
	public String findId2(UserVo userVo, Model model) {

		userVo = userService.findId(userVo);
		String result = "존재하지 않는 회원입니다";
		if (userVo == null) {
			model.addAttribute("result", result);
		} else {
			String user_id = "회원님의 아이디는 : " + userVo.user_id;
			model.addAttribute("user_id", user_id);
		}

		return "tiles.user.findIdResult";
	}
}