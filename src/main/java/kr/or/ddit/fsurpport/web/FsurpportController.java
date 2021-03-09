package kr.or.ddit.fsurpport.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.common.model.FilesVo;
import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.farm.model.FhistoryVo;
import kr.or.ddit.farm.model.FmanageVo;
import kr.or.ddit.farm.model.MsrrecVo;
import kr.or.ddit.farm.model.MySimpleCodeVo;
import kr.or.ddit.fsurpport.service.FsurpportService;

@RequestMapping("fsurpport")
@Controller
public class FsurpportController {

	private static final Logger logger = LoggerFactory.getLogger(FsurpportController.class);

	@Resource(name = "fsurpportService")
	private FsurpportService fsurpportService;
	
	public FsurpportController() {
		logger.debug("fsurpport 진입");
	}
	

	// ggy_20210302 : 농업지원-영농일지 내 일지 페이징 목록조회를 위한 진입페이지
	@RequestMapping("main")
	public String main(String user_id, Model model) {

		logger.debug("/finalProject/main 진입");
		
		if(user_id != null) {
			model.addAttribute("farmdiaryList", fsurpportService.selectAllFsurpportList());
		}
		model.addAttribute("workstepsList", fsurpportService.selectAllW_step_codeList());
		model.addAttribute("itemsList", fsurpportService.selectAllItem_codeList());

		return "tiles.fsurpport.fsurpportMain";
	}

	// ggy_20210303 : 농업지원-영농일지 내 일지 목록 검색
	@RequestMapping(path = "searchAllFsurpportList", method = { RequestMethod.POST })
	public String searchAllFsurpportList(HttpServletRequest req, Model model) {
		logger.debug("searchAllFsurpportList 진입");
		
		logger.debug("값 확인 startDate : {}, endDate : {}", req.getParameter("startDate"), req.getParameter("endDate"));
		
		FarmdiaryVo farmdiaryVo = new FarmdiaryVo();

		if (req.getParameter("startDate") != null && !req.getParameter("startDate").equals("")) {
			logger.debug("1");
			farmdiaryVo.setStartDate(req.getParameter("startDate").replace("-", ""));
			logger.debug("farmdiaryVo.getStartDate() : {} ", farmdiaryVo.getStartDate());
		} else {
			logger.debug("-1");
			farmdiaryVo.setStartDate("");
		}

		if (req.getParameter("endDate") != null && !req.getParameter("endDate").equals("")) {
			logger.debug("2");
			farmdiaryVo.setEndDate(req.getParameter("endDate").replace("-", ""));
			logger.debug("farmdiaryVo.getEndDate() : {} ", farmdiaryVo.getEndDate());
		} else {
			logger.debug("-2");
			farmdiaryVo.setEndDate("");
		}

		if (req.getParameter("item_code") != null && !req.getParameter("item_code").equals("")) {
			logger.debug("3");
			farmdiaryVo.setItem_code(req.getParameter("item_code"));
		} else {
			logger.debug("-3");
			farmdiaryVo.setItem_code("");
		}

		if (req.getParameter("w_step_code") != null && !req.getParameter("w_step_code").equals("")) {
			logger.debug("4");
			farmdiaryVo.setW_step_code(req.getParameter("w_step_code"));
		} else {
			logger.debug("-4");
			farmdiaryVo.setW_step_code("");
		}

		if (farmdiaryVo.getStartDate() != null && !farmdiaryVo.getStartDate().equals("")
				&& farmdiaryVo.getEndDate() != null && !farmdiaryVo.getEndDate().equals("")) {
			logger.debug("값 있으니 searchAllFarmdiaryList로 DB 조회");
			model.addAttribute("farmdiaryList", fsurpportService.searchAllFarmdiaryList(farmdiaryVo));

			model.addAttribute("workstepsList", fsurpportService.selectAllW_step_codeList());
			model.addAttribute("itemsList", fsurpportService.selectAllItem_codeList());

			return "tiles.fsurpport.fsurpportMain";
		} else {
			logger.debug("값 없으니 redirect main");
			return "redirect:/fsurpport/main";
		}
	}

	// ggy_20210305 : 농업지원-영농일지 내 일지 상세조회를 위한 진입페이지
	@RequestMapping("infoView")
	public String infoView(int f_diary_no, Model model) {

		model.addAttribute("farmdiaryList", fsurpportService.selectFarmdiaryInfo(f_diary_no));

		return "tiles.fsurpport.fsurpportInfo";
	}
	
	// ggy_20210308 : 농업지원-영농일지 내 일지 등록을 위한 진입페이지
	@RequestMapping("insertView")
	public String insertView(String owner, Model model) {
		
		model.addAttribute("mySimpleCodeList", fsurpportService.selectMySimpleCodeList(owner));
		
		model.addAttribute("workstepsList", fsurpportService.selectAllW_step_codeList());
		model.addAttribute("itemsList", fsurpportService.selectAllItem_codeList());
		model.addAttribute("b_typeList", fsurpportService.selectAllB_type_codeList());
		
		
		return "tiles.fsurpport.fsurpportInsert";
		
	}

	// ggy_20210308 : 농업지원-영농일지 내 간편 등록 셋팅을 위해 간편 코드 조회
	@RequestMapping("selectMySimpleCodeInsertView")
	public String insertView(String owner, int my_simple_code, Model model) {
		
		MySimpleCodeVo mySimpleCodeVo = new MySimpleCodeVo();
		
		mySimpleCodeVo.setOwner(owner);
		mySimpleCodeVo.setMy_simple_code(my_simple_code);
		
		logger.debug("insertView 진입 user_id : "+mySimpleCodeVo.getOwner());
		logger.debug("my_simple_code : "+mySimpleCodeVo.getMy_simple_code());
		
		
		if(mySimpleCodeVo.getMy_simple_code() > 0) {
			model.addAttribute("selectMySimpleCodeInfo", fsurpportService.selectMySimpleCodeInfo(mySimpleCodeVo));
		}
		
		logger.debug("000");
		model.addAttribute("mySimpleCodeList", fsurpportService.selectMySimpleCodeList(mySimpleCodeVo.getOwner()));
		
		logger.debug("111");
		model.addAttribute("workstepsList", fsurpportService.selectAllW_step_codeList());
		logger.debug("222");
		model.addAttribute("itemsList", fsurpportService.selectAllItem_codeList());
		logger.debug("333");
		model.addAttribute("b_typeList", fsurpportService.selectAllB_type_codeList());
		logger.debug("444");
		

		return "tiles.fsurpport.fsurpportInsert";
		
	}
	
	// ggy_20210305 : 농업지원-영농일지 간편등록 목록 선택시 값 자동으로 배치
	@RequestMapping("selectMySimpleCodeInfo")
	public String selectMySimpleCodeInfo(String user_id, int my_simple_code, Model model) {
		
		MySimpleCodeVo mySimpleCodeVo = new MySimpleCodeVo();
		mySimpleCodeVo.setMy_simple_code(my_simple_code);
		mySimpleCodeVo.setOwner(user_id);
		
		logger.debug("selectMySimpleCodeInfo 진입 my_simple_code {}, user_id {} ", mySimpleCodeVo.getMy_simple_code(), mySimpleCodeVo.getOwner());
		
		model.addAttribute("mySimpleCodeList", fsurpportService.selectMySimpleCodeList(user_id));
		model.addAttribute("selectMySimpleCodeInfo", fsurpportService.selectMySimpleCodeInfo(mySimpleCodeVo));
		model.addAttribute("workstepsList", fsurpportService.selectAllW_step_codeList());
		model.addAttribute("itemsList", fsurpportService.selectAllItem_codeList());
		
		logger.debug("selectMySimpleCodeInfo item_code : {}, bsn_code : {}",fsurpportService.selectMySimpleCodeInfo(mySimpleCodeVo).getItem_code(), fsurpportService.selectMySimpleCodeInfo(mySimpleCodeVo).getB_type_code());
		
		return "tiles.fsurpport.fsurpportInsert";
	}

	// ggy_20210302 : 농업지원-영농일지 내 일지 간편등록를 위한 진입페이지
	@RequestMapping("simpleInsertView")
	public String simpleInsertView(Model model) {

		model.addAttribute("workstepsList", fsurpportService.selectAllW_step_codeList());
		model.addAttribute("itemsList", fsurpportService.selectAllItem_codeList());
		model.addAttribute("b_typeList", fsurpportService.selectAllB_type_codeList());

		return "tiles.fsurpport.fsurpportSimpleInsert";
	}
	
	// ggy_20210308 : 농업지원-영농일지 내 간편등록 작성한걸 등록
	@RequestMapping(path = "registMySimpleCode", method = { RequestMethod.POST })
	public String registMySimpleCode(MySimpleCodeVo mySimpleCodeVo,  Model model) {
		
		String user_id = mySimpleCodeVo.getOwner();
		
		String b_type_code_nm = fsurpportService.selectB_type_code_no(mySimpleCodeVo.getB_type_code()).getCode_nm();
		String item_code_nm = fsurpportService.selectB_type_code_no(mySimpleCodeVo.getItem_code()).getCode_nm();
		int area = mySimpleCodeVo.getArea();
		
		String code_alias = b_type_code_nm + "-"+ item_code_nm + "-" + area; 
		
		mySimpleCodeVo.setCode_alias( code_alias );
		
		int registCnt = fsurpportService.registMySimpleCode(mySimpleCodeVo);
		
		logger.debug("registCnt :" + registCnt);
		
		if(registCnt == 1) {
			
			model.addAttribute("workstepsList", fsurpportService.selectAllW_step_codeList());
			model.addAttribute("itemsList", fsurpportService.selectAllItem_codeList());
			model.addAttribute("mySimpleCodeList", fsurpportService.selectMySimpleCodeList(user_id));
			return "tiles.fsurpport.fsurpportInsert";
		} else {
			
			model.addAttribute("workstepsList", fsurpportService.selectAllW_step_codeList());
			model.addAttribute("itemsList", fsurpportService.selectAllItem_codeList());
			return "tiles.fsurpport.fsurpportSimpleInsert";
		}
		
		
	}
	
	// ggy_20210308 : 농업지원-영농일지 내 일지 등록
	@RequestMapping(path = "registFarmdiary", method = { RequestMethod.POST })
	public String registFarmdiary(HttpServletRequest req, MultipartFile file_file, Model model) {
		
		logger.debug("registFarmdiary 진입");
		
		FarmdiaryVo farmdiaryVo = new FarmdiaryVo();
		
		farmdiaryVo.setArea( Integer.parseInt(req.getParameter("area")) );
		farmdiaryVo.setB_type_code(req.getParameter("b_type_code"));
		farmdiaryVo.setContent(req.getParameter("content"));
		farmdiaryVo.setHigh_temp( Integer.parseInt(req.getParameter("high_temp")) );
		farmdiaryVo.setHumid( Integer.parseInt(req.getParameter("humid")) );
		farmdiaryVo.setItem_code( req.getParameter("item_code") );
		farmdiaryVo.setLow_temp( Integer.parseInt(req.getParameter("low_temp")) );
		farmdiaryVo.setMy_simple_code( Integer.parseInt(req.getParameter("my_simple_code")) );
		farmdiaryVo.setRainfall( Integer.parseInt(req.getParameter("rainfall")) );
		farmdiaryVo.setW_step_code(req.getParameter("w_step_code"));
		farmdiaryVo.setWeather(req.getParameter("weather"));
		farmdiaryVo.setWriter(req.getParameter("writer"));
		

		FilesVo filesVo = new FilesVo();

		String upload_path = "c:\\fdown\\";

		try {

			file_file.transferTo(new File(upload_path + file_file.getOriginalFilename()));

			filesVo.setFile_nm("");
			filesVo.setFile_nm(file_file.getOriginalFilename());
			filesVo.setFile_path(upload_path + filesVo.getFile_nm());
		} catch (IllegalStateException | IOException e) {
			filesVo.setFile_nm("");
		}

		int registFilesCnt = fsurpportService.registFiles(filesVo);

		logger.debug("registFilesCnt : " + registFilesCnt);

		if (registFilesCnt < 1) {
			model.addAttribute("farmdiaryList", farmdiaryVo);
			logger.debug("파일 등록 실패");
			return "redirect:/fsurpport/fsurpportInsert";
		}

		filesVo = fsurpportService.selectFilesInfo(registFilesCnt);
		
		farmdiaryVo.setFile_no(filesVo.getFile_no());
		
		MySimpleCodeVo mySimpleCodeVo = new MySimpleCodeVo();
		mySimpleCodeVo.setOwner(farmdiaryVo.getWriter());
		mySimpleCodeVo.setMy_simple_code(farmdiaryVo.getMy_simple_code());
		
		mySimpleCodeVo = fsurpportService.selectMySimpleCode_noInfo(mySimpleCodeVo);
		
		farmdiaryVo.setB_type_code(mySimpleCodeVo.getB_type_code());
		farmdiaryVo.setItem_code(mySimpleCodeVo.getItem_code());
		farmdiaryVo.setArea(mySimpleCodeVo.getArea());
		
		int registFarmdiaryCnt = fsurpportService.registFarmdiary(farmdiaryVo);

		if (registFarmdiaryCnt != 1) {
			model.addAttribute("farmdiaryList", farmdiaryVo);
			logger.debug("일지 등록 실패");
			return "redirect:/fsurpport/fsurpportInsert";
		}

		if (registFarmdiaryCnt == 1) {
			logger.debug("영농일지 등록 성공");
		}

		return "redirect:/fsurpport/main?user_id="+farmdiaryVo.getWriter();
	}

	// ggy_20210304 : 농업지원-영농일지 내 일지 수정을 위한 진입페이지
	@RequestMapping("ModifyView")
	public String ModifyView() {

		return "tiles.fsurpport.fsurpportModify";
	}

	/* 시설관리 영역 */

	// KJH_20210302
	// 농업지원 - 시설관리 관리중인 시설 리스트 조회페이지
	@RequestMapping("facilityList")
	public String facilityList(Model model) {

		List<FmanageVo> fmanageList = fsurpportService.myfmanageList();

		model.addAttribute("fmanageList", fmanageList);

		return "tiles.fsurpport.facilityList";
	}

//	 KJH_20210308 수정
//	 농업양식 - 시설관리 관리중인 시설 상세 조회페이지
	@RequestMapping("facilityInfo")
	public String facility(Model model, FmanageVo fmanage) {

		FmanageVo fvo = fsurpportService.fmanageInfo(fmanage.getManage_no());

		// KJH_20210308 측정 정보 조회 수정
		FhistoryVo fhistoryVo = new FhistoryVo();
		fhistoryVo.setManage_no(fvo.getManage_no());
		fhistoryVo.setHistory_no(fvo.getHistory_no());
		MsrrecVo mvo = fsurpportService.latelyData(fhistoryVo);

		model.addAttribute("fmanage", fvo);
		model.addAttribute("msrrec", mvo);

		return "tiles.fsurpport.facilityInfo";
	}

	// KJH_20210302
	// 농업양식 - 시설관리 관리중인 시설 등록 페이지
	@RequestMapping("facilityInsert")
	public String facilityInsert() {

		return "tiles.fsurpport.facilityInsert";
	}

	// KJH_20210302
	// 농업양식 - 시설관리 관리중인 시설 업데이트 페이지
	@RequestMapping("facilityupdate")
	public String facilityupdate() {

		return "tiles.fsurpport.facilityupdate";
	}
}
