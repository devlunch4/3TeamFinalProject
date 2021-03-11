package kr.or.ddit.fsurpport.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.common.model.FilesVo;
import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.farm.model.FhistoryVo;
import kr.or.ddit.farm.model.FmanageVo;
import kr.or.ddit.farm.model.MsrequipVo;
import kr.or.ddit.farm.model.MsrrecVo;
import kr.or.ddit.farm.model.MySimpleCodeVo;
import kr.or.ddit.fdata.service.FdataServiceImpl;
import kr.or.ddit.fsurpport.service.FsurpportService;
import kr.or.ddit.user.model.UserVo;

@RequestMapping("fsurpport")
@Controller
public class FsurpportController {

	private static final Logger logger = LoggerFactory.getLogger(FsurpportController.class);

	@Resource(name = "fsurpportService")
	private FsurpportService fsurpportService;
	
	@Resource(name = "fdataService")
	private FdataServiceImpl fdataService;
	
	public FsurpportController() {
		logger.debug("fsurpport 진입");
	}
	

	// ggy_20210302 : 농업지원-영농일지 내 일지 페이징 목록조회를 위한 진입페이지
	@RequestMapping("main")
	public String main(String user_id, Model model) {

		logger.debug("/finalProject/main 진입");
		
		if(user_id != null) {
			model.addAttribute("farmdiaryList", fsurpportService.selectAllFsurpportList(user_id));
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
			logger.debug("item : "+req.getParameter("item_code"));
		} else {
			logger.debug("-3");
			farmdiaryVo.setItem_code("");
			logger.debug("item : "+req.getParameter("item_code"));
		}

		if (req.getParameter("writer") != null && !req.getParameter("writer").equals("")) {
			logger.debug("4");
			farmdiaryVo.setWriter(req.getParameter("writer"));
			logger.debug("writer : "+req.getParameter("writer"));
		} else {
			logger.debug("-4");
			farmdiaryVo.setWriter("");
			logger.debug("writer : "+req.getParameter("writer"));
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

	
	// ggy_20210309 : 농업지원-영농일지 간편등록 목록 선택시 값 자동으로 배치
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
	public String ModifyView( String writer, int f_diary_no, int my_simple_code, Model model) {
		
		MySimpleCodeVo mySimpleCodeVo = new MySimpleCodeVo();
		
		mySimpleCodeVo.setOwner(writer);
		mySimpleCodeVo.setMy_simple_code(my_simple_code);
		
		if(writer != null) {
			model.addAttribute("selectMySimpleCodeInfo", fsurpportService.selectMySimpleCodeInfo(mySimpleCodeVo));
			model.addAttribute("farmdiaryList", fsurpportService.selectFarmdiaryInfo(f_diary_no));
			model.addAttribute("mySimpleCodeList", fsurpportService.selectMySimpleCodeList(writer));
			model.addAttribute("workstepsList", fsurpportService.selectAllW_step_codeList());
			model.addAttribute("itemsList", fsurpportService.selectAllItem_codeList());
			model.addAttribute("b_typeList", fsurpportService.selectAllB_type_codeList());
			
		}
		
		return "tiles.fsurpport.fsurpportModify";
	}
	
	
	// ggy_20210309 : 농업지원-영농일지 내 일지 내용 수정후 수정 완료
	@RequestMapping(path = "modifyFarmdiary", method = { RequestMethod.POST })
	public String modifyFarmdiary( HttpServletRequest req, MultipartFile file_file, Model model) {
		
		logger.debug("modifyFarmdiary 진입 ");
		
		FarmdiaryVo farmdiaryVo = new FarmdiaryVo();
		
		
		MySimpleCodeVo mySimpleCodeVo1 = new MySimpleCodeVo();
		mySimpleCodeVo1.setOwner(req.getParameter("writer"));
		logger.debug("writer : "+req.getParameter("writer"));
		
		mySimpleCodeVo1.setMy_simple_code(Integer.parseInt(req.getParameter("my_simple_code")));
		logger.debug("my_simple_code : "+req.getParameter("my_simple_code"));
		
		mySimpleCodeVo1 = fsurpportService.selectMySimpleCode_noInfo(mySimpleCodeVo1);
		
		farmdiaryVo.setF_diary_no( Integer.parseInt(req.getParameter("f_diary_no")) );
		logger.debug("f_diary_no : "+req.getParameter("f_diary_no"));
		
		farmdiaryVo.setWriter(req.getParameter("writer"));
		logger.debug("writer : "+req.getParameter("writer"));
		
		farmdiaryVo.setMy_simple_code( Integer.parseInt(req.getParameter("my_simple_code")) );
		logger.debug("my_simple_code : "+req.getParameter("my_simple_code"));
		
		farmdiaryVo.setContent(req.getParameter("content"));
		logger.debug("content : "+req.getParameter("content"));
		
		farmdiaryVo.setWeather(req.getParameter("weather"));
		logger.debug("weather : "+req.getParameter("weather"));
		
		farmdiaryVo.setLow_temp( Integer.parseInt(req.getParameter("low_temp")) );
		logger.debug("low_temp : "+req.getParameter("low_temp"));
		
		farmdiaryVo.setHigh_temp( Integer.parseInt(req.getParameter("high_temp")) );
		logger.debug("high_temp : "+req.getParameter("high_temp"));
		
		farmdiaryVo.setRainfall( Integer.parseInt(req.getParameter("rainfall")) );
		logger.debug("rainfall : "+req.getParameter("rainfall"));
		
		farmdiaryVo.setHumid( Integer.parseInt(req.getParameter("humid")) );
		logger.debug("humid : "+req.getParameter("humid"));
		
		farmdiaryVo.setYield( Integer.parseInt(req.getParameter("yield")) );
		logger.debug("yield : "+req.getParameter("yield"));
		
		farmdiaryVo.setArea( Integer.parseInt(req.getParameter("area")) );
		logger.debug("area : "+req.getParameter("area"));
		
		farmdiaryVo.setB_type_code(mySimpleCodeVo1.getB_type_code());
		logger.debug("b_type_code : "+mySimpleCodeVo1.getB_type_code());
		
		farmdiaryVo.setW_step_code(req.getParameter("w_step_code"));
		logger.debug("w_step_code : "+req.getParameter("w_step_code"));
		
		farmdiaryVo.setItem_code(mySimpleCodeVo1.getItem_code());
		logger.debug("item_code : "+mySimpleCodeVo1.getItem_code());
		
		
		FilesVo filesVo = new FilesVo(); 
		
		if(req.getParameter("file_nm") != null && !req.getParameter("file_nm").equals("") ) {
			
			logger.debug("값 있다.");
			
			
			FarmdiaryVo farmdiaryVo1 = new FarmdiaryVo();
			
			farmdiaryVo1 = fsurpportService.selectFarmdiaryInfo(farmdiaryVo.getF_diary_no());
			
			farmdiaryVo.setFile_no(farmdiaryVo1.getFile_no());
			logger.debug("file_no : "+farmdiaryVo1.getFile_no());
			
			
			
		}
		
		
		else {
			//if(file_file !=null && !file_file.equals(""))
			
			logger.debug("새파일 등록이전에 첨부파일만 삭제인지 확인");
			
			logger.debug("file : "+file_file.getOriginalFilename());
			
			if(file_file.getOriginalFilename().equals("")) {
				
				logger.debug("file_file는 '' ");
			}
			
			if(req.getParameter("file_nm").equals("") && file_file.getOriginalFilename().equals("") || file_file.getOriginalFilename() == null ) {
				
				logger.debug("첨부파일 없애서 파일 번호 없애기");
				
				FarmdiaryVo farmdiaryVo2 = new FarmdiaryVo();
				
				farmdiaryVo2 = fsurpportService.selectFarmdiaryInfo(farmdiaryVo.getF_diary_no());
				
				farmdiaryVo.setFile_no(farmdiaryVo2.getFile_no());
				logger.debug("file_no : "+farmdiaryVo2.getFile_no());
				
				int deleteCnt = 0;
				if(farmdiaryVo2.getFile_no() > 0) {
					
					deleteCnt = fsurpportService.deleteFile_no(farmdiaryVo2.getFile_no());
					
					logger.debug("deleteCnt : "+deleteCnt);
					
					if(deleteCnt == 1) {
						farmdiaryVo.setFile_no(0);
						logger.debug("file_no : "+farmdiaryVo.getFile_no());
					}
				}
				
				
			} else {
				logger.debug("파일 등록 시작.");
			
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
					model.addAttribute("farmdiaryList"+ farmdiaryVo);
					logger.debug("파일 등록 실패");
					return "redirect:/fsurpport/fsurpportInsert";
				}
	
				filesVo = fsurpportService.selectFilesInfo(registFilesCnt);
				
				farmdiaryVo.setFile_no(filesVo.getFile_no());
			}
			
		}
		
		logger.debug("수정전 file_no 값 : "+ farmdiaryVo.getFile_no());
		logger.debug("수정 시작 : ");
		
		int modifyCnt = fsurpportService.modifyFarmdiaryInfo(farmdiaryVo);
		
		logger.debug("수정후 값 : "+modifyCnt);
		
		if (modifyCnt == 1) {
			
			logger.debug("수정 완료 ");
			logger.debug("f_diary_no : "+farmdiaryVo.getF_diary_no());
			
			return "redirect:/fsurpport/infoView?f_diary_no="+farmdiaryVo.getF_diary_no();
		}
		else {
			logger.debug("수정 실패");
			
			MySimpleCodeVo mySimpleCodeVo = new MySimpleCodeVo();
			mySimpleCodeVo.setOwner(farmdiaryVo.getWriter());
			mySimpleCodeVo.setMy_simple_code(farmdiaryVo.getMy_simple_code());
			
			model.addAttribute("selectMySimpleCodeInfo", fsurpportService.selectMySimpleCodeInfo(mySimpleCodeVo));
			model.addAttribute("farmdiaryList", fsurpportService.selectFarmdiaryInfo(farmdiaryVo.getF_diary_no()));
			model.addAttribute("mySimpleCodeList", fsurpportService.selectMySimpleCodeList(farmdiaryVo.getWriter()));
			model.addAttribute("workstepsList", fsurpportService.selectAllW_step_codeList());
			model.addAttribute("itemsList", fsurpportService.selectAllItem_codeList());
			model.addAttribute("b_typeList", fsurpportService.selectAllB_type_codeList());
			
			return "tiles.fsurpport.fsurpportModify";
		}
		
	}
	
	// ggy_20210309 : 농업지원-영농일지 내 일지 삭제
	@RequestMapping("deleteFarmdiary")
	public String deleteFarmdiary( String writer, int f_diary_no ) {
		
		logger.debug("deleteFarmdiary 진입");
		
		FarmdiaryVo farmdiaryVo = new FarmdiaryVo();
		farmdiaryVo.setWriter(writer);
		farmdiaryVo.setF_diary_no(f_diary_no);
		
		logger.debug("deleteFarmdiary 삭제 시작전 ");
		
		int deleteCnt = fsurpportService.deleteFarmdiary(farmdiaryVo);
		
		logger.debug("deleteCnt : "+deleteCnt);
		
		if (deleteCnt == 1) {
			return "redirect:/fsurpport/main?user_id="+writer;
		}else {	
			return "redirect:/fsurpport/infoView?f_diary_no="+f_diary_no;
		}
		
	}
	
	/* 시설관리 영역 */

	// KJH_20210302
	// 농업지원 - 시설관리 관리중인 시설 리스트 조회페이지
	@RequestMapping("fmanageList")
	public String fmanageList(Model model) {

		List<FmanageVo> fmanageList = fsurpportService.myfmanageList();

		model.addAttribute("fmanageList", fmanageList);

		return "tiles.fsurpport.fmanageList";
	}

//	 KJH_20210308 수정
//	 농업양식 - 시설관리 관리중인 시설 상세 조회페이지
	@RequestMapping("fmanageInfo")
	public String fmanage(Model model, FmanageVo fmanage) {

		
		FmanageVo fvo = fsurpportService.fmanageInfo(fmanage.getManage_no());

		// KJH_20210308 측정 정보 조회 수정
		FhistoryVo fhistoryVo = new FhistoryVo();
		fhistoryVo.setManage_no(fvo.getManage_no());
		fhistoryVo.setHistory_no(fvo.getHistory_no());
		MsrrecVo mvo = fsurpportService.latelyData(fhistoryVo);

		model.addAttribute("fmanage", fvo);
		model.addAttribute("msrrec", mvo);

		return "tiles.fsurpport.fmanageInfo";
	}

	// KJH_20210302
	// 농업양식 - 시설관리 관리중인 시설 등록 페이지
	@RequestMapping("fmanageInsertPage")
	public String fmanageInsertPage(Model model, HttpSession session) {
		String itemcategorycode = "100";
		String itemcode = "111";
		
		UserVo userVo = new UserVo();

		userVo = (UserVo) session.getAttribute("S_USER");
		List<MsrequipVo> myList = fsurpportService.msrList(userVo.getUser_id());
		
		List<MsrequipVo> okList = new ArrayList<MsrequipVo>();
		
		for(int i = 0; i < myList.size(); i++) {
			MsrequipVo vo = new MsrequipVo();
			vo.setMsr_code(myList.get(i).getMsr_code());
			vo.setOwner(userVo.getUser_id());
			int count = fsurpportService.availableList(vo);
			if(count == 0) {
				vo.setMsr_code(myList.get(i).getMsr_code());
				vo.setOwner(userVo.getUser_id());
				vo.setMsr_nm(myList.get(i).getMsr_nm());
				vo.setUse_yn(myList.get(i).getUse_yn());
				okList.add(vo);
			}
		}
		
		model.addAttribute("itemcategorycode", itemcategorycode);
		model.addAttribute("itemcode", itemcode);
		
		model.addAttribute("codesList", fsurpportService.selectAllItem_codeList());
		model.addAttribute("okList",okList);
		return "tiles.fsurpport.fmanageInsert";
	}
	
	
	//20210311 시설 등록하기
	@RequestMapping("fmanageInsert")
	public String fmanageInsert(Model model, HttpSession session, FmanageVo fmanageVo, String msr_code) {
		
		if(msr_code == null || msr_code == "") {
			msr_code = "x";
		}
		logger.debug("vo : {}",fmanageVo);
		logger.debug("msr_code : {}",msr_code);
		
		fsurpportService.insertFmanage(fmanageVo);
		System.out.println(fmanageVo.getManage_no());
		
		FhistoryVo fhistoryVo = new FhistoryVo();
		fhistoryVo.setManage_no(fmanageVo.getManage_no());
		fhistoryVo.setMsr_code(msr_code);
		fsurpportService.insertFhistory(fhistoryVo);

		
		return "redirect:/fsurpport/fmanageList";
	}
	
	
	// KJH_20210302
	// 농업양식 - 시설관리 관리중인 시설 업데이트 페이지
	@RequestMapping("fmanageUpdate")
	public String fmanageupdate(Model model, String manage_no) {
		
		FmanageVo fvo = fsurpportService.updatefmanageInfo(manage_no);
		CodesVo cvo = fdataService.selectCode(fvo.getItem_code());
		
		

		model.addAttribute("fmanage", fvo);
		model.addAttribute("itemcategorycode", cvo.getParent_code());
		model.addAttribute("itemcode", fvo.getItem_code());
		
		model.addAttribute("codesList", fsurpportService.selectAllItem_codeList());

		return "tiles.fsurpport.fmanageUpdate";
	}
	
	// ggy_20210309 : 파일 경로
	@RequestMapping("filePath")
	public void profile( HttpServletResponse resp, String file_nm, HttpServletRequest req ) {
		
		logger.debug("filePath 진입");
		resp.setContentType("image");
		
		// userid 파라미터를 이용하여
		// userService 객체를 통해 사용자의 사진 파일 이름을 획득
		// 파일 입출력을 통해 사진을 읽어들여 resp객체의 outputStream으로 응답 생성
		
		String path = "";
		if(file_nm==null && !file_nm.equals("")) {
			logger.debug("file_nm이 null");
			
			path = req.getServletContext().getRealPath("c:\\fdown\\unknown.png");
			logger.debug("path : "+path);
		} else {
			
			logger.debug("file_nm이 null 아니다.");
			path = "c:\\fdown\\"+file_nm;
			logger.debug("path : "+path);
		}
		
		logger.debug("path : {}",path);
		
		
		try {
			
			FileInputStream fis = new FileInputStream(path);
			ServletOutputStream sos = resp.getOutputStream();
			
			byte[] buff = new byte[512];
			
			while(fis.read(buff) != -1) {
				
				sos.write(buff);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}
