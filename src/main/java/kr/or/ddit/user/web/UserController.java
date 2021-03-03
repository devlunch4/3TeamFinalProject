package kr.or.ddit.user.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.farm.model.ItemsVo;
import kr.or.ddit.fdata.service.FdataServiceImpl;
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

	// 메인 가기
	@RequestMapping("main") // 모든 사용자 정보 조회
	public String main(Model model, ItemsVo itemsVo, String sdate) {
		// 메인으로 가면서 크롤링하여 시세분석값을 가져옴
		int itemcategorycode = 100;
		int itemcode = 111;
		Date date = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		String mydate = transFormat.format(date);

//		Calendar day = Calendar.getInstance();
//	    day.add(Calendar.DATE , -1);
//	    String mydate = new java.text.SimpleDateFormat("yyyy-MM-dd").format(day.getTime());

		if (sdate != null) {
			mydate = sdate;
		}
		if (itemsVo.getCategory_code() != 0) {
			itemcategorycode = itemsVo.getCategory_code();
			itemcode = itemsVo.getItem_code();

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

		List<ItemsVo> itemsList = fdataService.selectItems(itemcategorycode);
		model.addAttribute("itemsList", itemsList);

		return "tiles.main.main";
	}

	// 로그인 하는거 02-27 12시11분 (경찬)
	@RequestMapping("login")
	public String login() {
		return "login";
	}

	// 로그인 하는거 03-02 09시50분 (경찬)
	@RequestMapping("login2")
	public String loginController(UserVo userVo, HttpSession session) {
		UserVo dbUser = userService.selectUser(userVo.getUser_id());
		if (dbUser != null && userVo.getUser_pw().equals(dbUser.getUser_pw())) {
			session.setAttribute("S_USER", dbUser);
			return "tiles.main.main";
		} else {
			return "login";
		}
	}

	// 마이페이지 가는거 03-02 16시20분 (경찬)
	@RequestMapping("myPage")
	public String myPage(UserVo userVo) {
		return "tiles.user.userinfo";
	}

	// 관리자가 모든 회원보는거 03-02 16시20분 (경찬)
	@RequestMapping("allUser")
	public String allUser(Model model, PageVo pageVo) {
		logger.debug("in allUser()");
		long start = System.currentTimeMillis(); //시작하는 시점 계산
		
		List<UserVo> userList =  userService.selectAllUser();
		
		long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
		
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 +"초"); //실행 시간 계산 및 출력
		logger.debug("실행 시간 : " + ( end - start )/1000.0 +"초");
		
		model.addAttribute("userList", userList);
		
		return "tiles.user.allUser";
	}
	
	// 관리자가 회원상세정보 보는거  03-03 15시20분 (경찬)
	@RequestMapping("userDetail")  
	public String userForm(Model model, String user_id) {
		UserVo user = userService.selectUser(user_id);
		model.addAttribute("user", user);
		return "tiles.user.userDetail";
	}
	
//	@RequestMapping("allUser") // 모든 사용자 정보 조회
//	public String allUser(Model model) {
//		logger.debug("INN UserController allUser() :");
//		// 객체 모델에 넣기
//		model.addAttribute("userList", userService.selectAllUser());
//		return "user/allUser";
//	}

//	// 1번 방법-guide
//	@RequestMapping("pagingUser") // 페이징 처리
//	public String paginUser(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int pageSize,
//			Model model) {
//		logger.debug("(page:{}, pageSize:{}", page, pageSize);
//		// logger.debug("(price:{}", price); // price 삭제
//		PageVo pageVo = new PageVo(page, pageSize);
//		Map<String, Object> map = userService.selectPagingUser(pageVo);
//		model.addAllAttributes(map);
//		return "user/pagingUser";
//	}

//	// 2번 방법
//	// @RequestMapping("pagingUser")
//	public String paginUser(Model model, PageVo pageVo) {
//		logger.debug("INN UserController pagingUser()");
//		Map<String, Object> map = userService.selectPagingUser(pageVo);
//		int userCnt = (int) map.get("userCnt");
//		int pagination = (int) Math.ceil((double) userCnt / pageVo.getPageSize());
//		model.addAttribute("userList", map.get("userList"));
//		model.addAttribute("pageVo", pageVo);
//		model.addAttribute("pagination", pagination);
//		return "user/pagingUser";
//	}
//
	
//
//	// 사용자 수정 // GET // 해당 수정 페이지로 이동
//	@RequestMapping(path = "userModify", method = { RequestMethod.GET })
//	public String userModifyGet(Model model, String userid) {
//		UserVo user = userService.selectUser(userid);
//		model.addAttribute("user", user);
//		return "user/userModify";
//	}
//
//	// 사용자 수정 // POST // 해당 아이디에 대하여 값 업데이트
//	@RequestMapping(path = "userModify", method = { RequestMethod.POST })
//	public String userModifyPost(UserVo userVo, MultipartFile profile, Model model,
//			@RequestParam("reg_dt2") String reg_dt2) {
//		logger.debug("INN UserController pagingUser() :");
//		logger.debug("수정할 userid: {}", userVo.getUserid());
//		// 파일 세팅 설정
//		UserVo dbUser = userService.selectUser(userVo.getUserid());
//
//		String originalFileName = "";
//		String realFileName = "";
//		// profile.isEmpty()
//		if (profile.getSize() > 0) {
//
//			originalFileName = profile.getOriginalFilename();
//			realFileName = UUID.randomUUID().toString() + "."
//					+ originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
//			try {
//				// 저장위치 지정 및 저장
//				profile.transferTo(new File("d:\\upload\\" + realFileName));
//			} catch (IllegalStateException | IOException e) {
//				e.printStackTrace();
//			}
//		}
//
////		userVo.setFilename(originalFileName);
////		if (realFileName.equals("")) {
////			userVo.setRealfilename(dbUser.getRealfilename());
////		} else {
////			userVo.setRealfilename("d:\\upload\\" + realFileName);
////		}
//		// file 컬럼 2부분 설정 / 날짜 부분 재설정
//
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
//		Date parseDate = null;
//		try {
//			parseDate = dateFormat.parse(reg_dt2);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		userVo.setReg_dt(parseDate);
//
//		// 사용자 수정 sql 시행
//		model.addAttribute("user", userVo);
//		int updateCnt = userService.modifyUser(userVo);
//		if (updateCnt == 1) {
//			// 성공시 파일 저장 및 상세정보로 이동
//			logger.debug("사용자 정보 수정 성공");
//			return "/user/userForm";
//		} else {
//			// 실패시 수정 페이지로 이동
//			logger.debug("사용자 정보 수정 실패");
//			return "user/userModify";
//		}
//	}
//
//	// 사용자 삭제 POST
//	@RequestMapping(path = "userDelete", method = { RequestMethod.POST })
//	public String userDeletePost(Model model, String userid) {
//		logger.debug("INN UserController.userDeletePost()");
//		int deleteCnt = 0;
//		try {
//			deleteCnt = userService.deleteUser(userid);
//		} catch (Exception e) {
//			deleteCnt = -1;
//		}
//		if (deleteCnt == 1) {
//			logger.debug("사용자 {} 삭제 완료", userid);
//			model.addAttribute("userList", userService.selectAllUser());
//			return "user/allUser";
//		} else {
//			return "user/userModify";
//		}
//	}
//
//	// 사용자 신규 등록 POST
//	// BindingResult 객체는 command 객체 바로 뒤에 기술해야한다.
//	@RequestMapping(path = "userRegist", method = { RequestMethod.POST })
//	public String userRegistPost(@Valid UserVo userVo, BindingResult result, MultipartFile profile, Model model) {
//		logger.debug("INN UserController.userRegistPost()");
//
//		// 검증클래스 호출 및 검증 클래스의 검증로직 실행
//		// new UserVoValidator().validate(userVo, result);
//
//		if (result.hasErrors()) {
//			logger.debug("result.hasErrors() at userRegistPost()");
//			return "user/userRegist";
//		}
//
//		// 파일 세팅 설정
//		String originalFileName = "";
//		String realFileName = "";
//		// profile.isEmpty()
//		if (profile.getSize() > 0) {
//			originalFileName = profile.getOriginalFilename();
//			realFileName = UUID.randomUUID().toString() + "."
//					+ originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
//
//			try {
//				// 저장위치 지정 및 저장
//				profile.transferTo(new File("d:\\upload\\" + realFileName));
//			} catch (IllegalStateException | IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//		// 신규 등록에 따른 파일/날짜 컬럼 값 설정
////		userVo.setFilename(originalFileName);
////		if (realFileName.equals("")) {
////			userVo.setRealfilename(realFileName);
////		} else {
////			userVo.setRealfilename("d:\\upload\\" + realFileName);
////		}
//		userVo.setReg_dt(new Date());
//		// 등록 sql 시행
//		int insertCnt = userService.insertUser(userVo);
//		if (insertCnt == 1) {
//			// 성공시 파일 저장 및 상세정보로 이동
//			// 성공시 페이징 페이지로 이동
//			logger.debug("사용자 정보 등록 성공");
//			String useridx = userVo.getUserid();
//			UserVo user = userService.selectUser(useridx);
//			model.addAttribute("user", user);
//			return "/user/userForm";
//		} else {
//			// 실패시 수정 페이지로 이동
//			logger.debug("사용자 정보 등록 실패");
//			model.addAttribute("user", userVo);
//			return "user/userRegist";
//		}
//	}
//
//	// 사용자 등록 GET
//	@RequestMapping(path = "userRegist", method = { RequestMethod.GET })
//	public String userRegistGet() {
//		logger.debug("INN UserController.userRegistGet()");
//		return "user/userRegist";
//	}
//
//	// 사용자 등록 GET
//	@RequestMapping(path = "userRegistTiles", method = { RequestMethod.GET })
//	public String userRegistTilesGet() {
//		logger.debug("INN UserController.userRegistGet()");
//		return "tiles.user.userRegist";
//	}
//
//	// localhost:8081/user/excelDownload
//	// 사용자 전체 엑셀 다운로드
//	@RequestMapping("excelDownload")
//	public String excelDownload(Model model) {
//		List<String> header = new ArrayList<String>();
//		header.add("사용자 아이디");
//		header.add("사용자 이름");
//		header.add("사용자 별명");
//
//		model.addAttribute("header", header);
//		model.addAttribute("data", userService.selectAllUser());
//		return "userExcelDownloadView";
//	}
//
//	@RequestMapping("pagingUserTiles") // 페이징 처리 Tiles
//	public String pagingUserTails(@RequestParam(defaultValue = "1") int page,
//			@RequestParam(defaultValue = "5") int pageSize, Model model) {
//		logger.debug("( Tiles page:{}, pageSize:{}", page, pageSize);
//		// logger.debug("(price:{}", price); // price 삭제
//		PageVo pageVo = new PageVo(page, pageSize);
//		model.addAllAttributes(userService.selectPagingUser(pageVo));
//		return "tiles.user.pagingUser";
//	}
//
//	@RequestMapping("allUserTiles") // 모든 사용자 정보 조회 Tiles
//	public String allUserTiles(Model model) {
//		logger.debug("INN Tiles UserController allUser() :");
//		// 객체 모델에 넣기
//		model.addAttribute("userList", userService.selectAllUser());
//		return "tiles.user.allUser";
//	}
//
//	@RequestMapping("userFormTiles") // 사용자 상세보기 Tiles
//	public String userFormTiles(Model model, String userid) {
//		logger.debug("INN Tiles UserController pagingUser() :");
//		logger.debug("클릭된 userid값 : {}", userid);
//		UserVo user = userService.selectUser(userid);
//		model.addAttribute("user", user);
//		return "tiles.user.userForm";
//	}

	// localhost/user/profile
//	@RequestMapping("profile")
//	public void profile(HttpServletResponse resp, String userid, HttpServletRequest req) {
//		resp.setContentType("image");
//
//		// userid 파라미터를 이용하여
//		// userService 객체를 통해 사용자의 사진 파일 이름을 획득
//		// 파일 입출력을 통해 사진을 읽어들여 resp객체의 outputStream으로 응답 생성
//
//		UserVo userVo = userService.selectUser(userid);

//		String path = "";
//		if (userVo.getRealfilename() == null) {
//			path = req.getServletContext().getRealPath("/image/unknown.png");
//		} else {
//			path = userVo.getRealfilename();
//		}

//		logger.debug("path : {} ", path);

//		try {
//			FileInputStream fis = new FileInputStream(path);
//			ServletOutputStream sos = resp.getOutputStream();
//
//			byte[] buff = new byte[512];
//
//			while (fis.read(buff) != -1) {
//				sos.write(buff);
//			}
//
//			fis.close();
//			sos.close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	@RequestMapping("profileDownload")
//	public void profileDownload(String userid, HttpServletRequest req, HttpServletResponse resp) {
//
//		UserVo userVo = userService.selectUser(userid);
//
//		String path = "";
//		String filename = "";
////		if (userVo.getRealfilename() == null) {
////			path = req.getServletContext().getRealPath("/image/unknown.png");
////			filename = "unknown.png";
////		} else {
////			path = userVo.getRealfilename();
////			filename = userVo.getFilename();
////		}
//
//		resp.setHeader("Content-Disposition", "attachment; filename=" + filename);
//
//		// userid 파라미터를 이용하여
//		// userService 객체를 통해 사용자의 사진 파일 이름을 획득
//		// 파일 입출력을 통해 사진을 읽어들여 resp객체의 outputStream으로 응답 생성
//
//		logger.debug("path : {} ", path);
//
//		try {
//			FileInputStream fis = new FileInputStream(path);
//			ServletOutputStream sos = resp.getOutputStream();
//
//			byte[] buff = new byte[512];
//
//			while (fis.read(buff) != -1) {
//				sos.write(buff);
//			}
//
//			fis.close();
//			sos.close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
////	
////	@RequestMapping("pagingUserTilesAjax") // 페이징 처리 Tiles
////	public String pagingUserTailsAjax(@RequestParam(defaultValue = "1") int page,
////			@RequestParam(defaultValue = "5") int pageSize, Model model) {
////		logger.debug("( Tiles page:{}, pageSize:{}", page, pageSize);
////		// logger.debug("(price:{}", price); // price 삭제
////		PageVo pageVo = new PageVo(page, pageSize);
////		model.addAllAttributes(userService.selectPagingUser(pageVo));
////		return "tiles.user.pagingUser";
////	}
//
//	// 사용자가 리스트가 없는 상태의 화면만 응답으로 생성
//	@RequestMapping("pagingUserAjaxView") // 페이징 처리 ajax /jsp내부
//	public String pagingUserAjax() {
//		return "tiles.user.pagingUserAjax";
//	}
//
//	@RequestMapping("pagingUserAjax") // 페이징 처리 ajax
//	public String paginUserAjax(@RequestParam(defaultValue = "1") int page,
//			@RequestParam(defaultValue = "5") int pageSize, Model model) {
//		logger.debug("(page:{}, pageSize:{}", page, pageSize);
//		PageVo pageVo = new PageVo(page, pageSize);
//		model.addAllAttributes(userService.selectPagingUser(pageVo));
//		return "jsonView";
//	}
//
//	@RequestMapping("pagingUserAjaxHtml") // 페이징 처리 ajax
//	public String paginUserAjaxHtml(@RequestParam(defaultValue = "1") int page,
//			@RequestParam(defaultValue = "5") int pageSize, Model model) {
//
//		PageVo pageVo = new PageVo(page, pageSize);
//		model.addAllAttributes(userService.selectPagingUser(pageVo));
//		return "user/pagingUserAjaxHtml";
//		// WEB-INF/views/user/paginUserAjaxHtml.jsp
//	}
//
//	// 검색하여 처리
//	@RequestMapping("pagingUserSearch")
//	public String pagingUserSearch(@RequestParam(defaultValue = "1") int page,
//			@RequestParam(defaultValue = "5") int pageSize, String keyword, String searchType, Model model) {
//		PageVo pageVo = new PageVo(page, pageSize);
//		PageVoSearch pageVoSearch = new PageVoSearch(page, pageSize, keyword);
//
//		// 검색시을 사용될 값 설정을 위한 map 설정
//		Map<String, Object> map = new HashMap<String, Object>();
//		// searchType 값에 따른 검색 메소드 실행 설정
//		if (searchType == null || searchType.equals("")) {
//			// 아무 값이 없는경우
//			map = userService.selectPagingUser(pageVo);
//		} else if (searchType.equals("i")) {
//			// 아이디로 검색
//			pageVoSearch.setSerachvalue("%" + keyword + "%");
//			map = userService.idSearchUser(pageVoSearch);
//		} else if (searchType.equals("n")) {
//			// 이름으로 검색
//			pageVoSearch.setSerachvalue("%" + keyword + "%");
//			map = userService.nameSearchUser(pageVoSearch);
//		} else if (searchType.equals("a")) {
//			// 별명으로 검색
//			pageVoSearch.setSerachvalue("%" + keyword + "%");
//			map = userService.aliasSearchUser(pageVoSearch);
//		} else {
//			map = userService.selectPagingUser(pageVo);
//		}
//
//		List<UserVo> userList = (List<UserVo>) map.get("userList");
//		int userCnt = (int) map.get("userCnt");
//		int pagination = (int) Math.ceil((double) userCnt / pageSize);
//		logger.debug("userCnt 값 : {}, pagination 값 : {}", userCnt, pagination);
//
//		model.addAttribute("userList", userList);
//		model.addAttribute("keyword", keyword);
//		model.addAttribute("searchType", searchType);
//		model.addAttribute("pagination", pagination);
//		model.addAttribute("pageVo", pageVo);
//
//		return "user/pagingUserSearch";
//	}

}