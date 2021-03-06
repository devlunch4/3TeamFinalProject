package kr.or.ddit.user.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.fdata.service.FdataServiceImpl;
import kr.or.ddit.fsurpport.service.FsurpportServiceImpl;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserServiceImpl;

@RequestMapping("user")
@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	// 필요한 스프링 빈 호출
	@Resource(name = "userService")
	private UserServiceImpl userService;

	@Resource(name = "fdataService")
	private FdataServiceImpl fdataService;

	@Resource(name = "fsurpportService")
	private FsurpportServiceImpl fsurpportService;

	// 메인 가기
	// 20210302_KJH items - > codes 변경
	@RequestMapping("main") // 모든 사용자 정보 조회

	public String main(Model model, CodesVo codesVo, String sdate) {
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
		try {// regday="+mydate+"
			doc = Jsoup.connect("https://www.kamis.or.kr/customer/price/wholesale/item.do?action=priceinfo&regday="
					+ mydate + "&itemcategorycode=" + itemcategorycode + "&itemcode=" + itemcode
					+ "&kindcode=&productrankcode=0&convert_kg_yn=N").get();
//		    Jsoup.connect("https://www.kamis.or.kr/customer/price/wholesale/item.do?action=priceinfo&regday=2021-03-02&itemcategorycode=100&itemcode=111&kindcode=&productrankcode=0&convert_kg_yn=N").get();

			System.out.println((doc.select("tr").get(12)).select("td").size());
			int docsize = (doc.select("tr").get(12)).select("td").size();

			List<String> target = new ArrayList<String>();
			target.add(((doc.select("tr").get(11)).select("th").get(1)).text());
			target.add(((doc.select("tr").get(11)).select("th").get(docsize - 4)).text());
			target.add(((doc.select("tr").get(11)).select("th").get(docsize - 3)).text());
			target.add(((doc.select("tr").get(11)).select("th").get(docsize - 2)).text());
			target.add(((doc.select("tr").get(11)).select("th").get(docsize - 1)).text());
			System.out.println((doc.select("tr").get(11)).select("th").get(1));
			System.out.println((doc.select("tr").get(11)).select("th").get(docsize - 1));

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
			e1.printStackTrace();
		}

		List<CodesVo> codesList = fdataService.selectcodes();
		model.addAttribute("codesList", codesList);

		return "tiles.main.main";
	}

	// 로그인한 회원이 자기정보 보는거 02/26(경찬)
	@RequestMapping("myPage")
	public String myPage(UserVo userVo) {
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
	@RequestMapping("userDetail")
	public String userForm(Model model, String user_id) {
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
	@RequestMapping("deleteUser")
	public String deleteUser(String user_id) {
		UserVo user = userService.deleteUser(user_id);
		return "redirect:/user/allUser";
	}

	// 회원이 정보수정 하는거 03/05(경찬)
	@RequestMapping("modifyUser")
	public String modifyUser(UserVo userVo) {
		return "tiles.user.modifyUser";
	}

	// 관리자가 비밀번호 로그인횟수 수정 03/04 (경찬)
	@RequestMapping("modifyUser2")
	public String modifyUser2(UserVo userVo) {
		userVo = userService.modifyUser(userVo);
		return "tiles.user.allUser";
	}

}