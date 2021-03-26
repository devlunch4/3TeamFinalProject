package kr.or.ddit.fsurpport.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.common.model.FilesVo;
import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.farm.model.FhistoryVo;
import kr.or.ddit.farm.model.FmanageVo;
import kr.or.ddit.farm.model.MsrequipVo;
import kr.or.ddit.farm.model.MsrrecVo;
import kr.or.ddit.farm.model.MySimpleCodeVo;
import kr.or.ddit.fdata.service.FdataService;
import kr.or.ddit.fsurpport.service.FsurpportService;
import kr.or.ddit.user.model.UserVo;

@RequestMapping("fsurpport")
@Controller
public class FsurpportController {

	private static final Logger logger = LoggerFactory.getLogger(FsurpportController.class);

	@Resource(name = "fsurpportService")
	private FsurpportService fsurpportService;

	@Resource(name = "fdataService")
	private FdataService fdataService;

	public FsurpportController() {
		logger.debug("fsurpport 진입");
	}

	// ggy_20210302 : 농업지원-영농일지 내 일지 페이징 목록조회를 위한 진입페이지
	@RequestMapping("main")
	public String main(String user_id, Model model) {
		logger.debug("/finalProject/main 진입");
		if (user_id != null) {
			model.addAttribute("farmdiaryList", fsurpportService.selectAllFsurpportList(user_id));
		}
//		model.addAttribute("workstepsList", fsurpportService.selectAllW_step_codeList());
		model.addAttribute("itemsList", fsurpportService.selectAllItem_codeList());
		return "tiles.fsurpport.fsurpportMain";
	}

	// ggy_20210303 : 농업지원-영농일지 내 일지 목록 검색
	@RequestMapping(path = "searchAllFsurpportList", method = { RequestMethod.POST })
	public String searchAllFsurpportList(HttpServletRequest req, Model model) {
		logger.debug("searchAllFsurpportList 진입");
		logger.debug("값 확인 startDate : {}, endDate : {}", req.getParameter("startDate"), req.getParameter("endDate"));
		FarmdiaryVo farmdiaryVo = new FarmdiaryVo();
		FarmdiaryVo searchFarmdiaryValue_farmdiaryVo = new FarmdiaryVo();
		if (req.getParameter("startDate") != null && !req.getParameter("startDate").equals("")) {
			logger.debug("1");
			farmdiaryVo.setStartDate(req.getParameter("startDate").replace("-", ""));
			logger.debug("farmdiaryVo.getStartDate() : {} ", farmdiaryVo.getStartDate());
			searchFarmdiaryValue_farmdiaryVo.setStartDate(req.getParameter("startDate"));
		} else {
			logger.debug("-1");
			farmdiaryVo.setStartDate("");
		}

		if (req.getParameter("endDate") != null && !req.getParameter("endDate").equals("")) {
			logger.debug("2");
			farmdiaryVo.setEndDate(req.getParameter("endDate").replace("-", ""));
			logger.debug("farmdiaryVo.getEndDate() : {} ", farmdiaryVo.getEndDate());
			searchFarmdiaryValue_farmdiaryVo.setEndDate(req.getParameter("endDate"));
		} else {
			logger.debug("-2");
			farmdiaryVo.setEndDate("");
		}

		if (req.getParameter("item_code") != null && !req.getParameter("item_code").equals("")) {
			logger.debug("3");
			farmdiaryVo.setItem_code(req.getParameter("item_code"));
			logger.debug("item : " + req.getParameter("item_code"));
			searchFarmdiaryValue_farmdiaryVo.setItem_code(req.getParameter("item_code"));
		} else {
			logger.debug("-3");
			farmdiaryVo.setItem_code("");
			logger.debug("item : " + req.getParameter("item_code"));
		}

		if (req.getParameter("writer") != null && !req.getParameter("writer").equals("")) {
			logger.debug("4");
			farmdiaryVo.setWriter(req.getParameter("writer"));
			logger.debug("writer : " + req.getParameter("writer"));
			searchFarmdiaryValue_farmdiaryVo.setWriter(req.getParameter("writer"));
		} else {
			logger.debug("-4");
			farmdiaryVo.setWriter("");
			logger.debug("writer : " + req.getParameter("writer"));
		}
		model.addAttribute("searchFarmdiaryValue", searchFarmdiaryValue_farmdiaryVo);

		if (farmdiaryVo.getStartDate() != null && !farmdiaryVo.getStartDate().equals("")
				&& farmdiaryVo.getEndDate() != null && !farmdiaryVo.getEndDate().equals("")) {
			logger.debug("값 있으니 searchAllFarmdiaryList로 DB 조회");
			model.addAttribute("farmdiaryList", fsurpportService.searchAllFarmdiaryList(farmdiaryVo));
//			model.addAttribute("workstepsList", fsurpportService.selectAllW_step_codeList());
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
		logger.debug("내 영농일지 상세 조회 infoView 진입");
		model.addAttribute("farmdiaryList", fsurpportService.selectFarmdiaryInfo(f_diary_no));
		return "tiles.fsurpport.fsurpportInfo";
	}

	// ggy_20210308 : 농업지원-영농일지 내 일지 등록을 위한 진입페이지
	@RequestMapping("insertView")
	public String insertView(String owner, Model model) {
		logger.debug("영농일지 등록 insertView");
		model.addAttribute("mySimpleCodeList", fsurpportService.selectMySimpleCodeList(owner));
//		model.addAttribute("workstepsList", fsurpportService.selectAllW_step_codeList());
		model.addAttribute("itemsList", fsurpportService.selectAllItem_codeList());
		model.addAttribute("b_typeList", fsurpportService.selectAllB_type_codeList());
		return "tiles.fsurpport.fsurpportInsert";
	}

	// ggy_20210308 : 농업지원-영농일지 내 간편 등록 셋팅을 위해 간편 코드 조회
	@RequestMapping("selectMySimpleCodeInsertView")
	public String insertView(String owner, int my_simple_code, Model model) {
		logger.debug("내일지 간편 등록 조회 진입");
		MySimpleCodeVo mySimpleCodeVo = new MySimpleCodeVo();
		mySimpleCodeVo.setOwner(owner);
		mySimpleCodeVo.setMy_simple_code(my_simple_code);
		logger.debug("insertView 진입 user_id : " + mySimpleCodeVo.getOwner());
		logger.debug("my_simple_code : " + mySimpleCodeVo.getMy_simple_code());
		if (mySimpleCodeVo.getMy_simple_code() > 0) {
			model.addAttribute("selectMySimpleCodeInfo", fsurpportService.selectMySimpleCodeInfo(mySimpleCodeVo));
		}
		logger.debug("000");
		model.addAttribute("mySimpleCodeList", fsurpportService.selectMySimpleCodeList(mySimpleCodeVo.getOwner()));
		logger.debug("111");
//		model.addAttribute("workstepsList", fsurpportService.selectAllW_step_codeList());
		logger.debug("222");
		model.addAttribute("itemsList", fsurpportService.selectAllItem_codeList());
		logger.debug("333");
		model.addAttribute("b_typeList", fsurpportService.selectAllB_type_codeList());
		logger.debug("444");
		return "tiles.fsurpport.fsurpportInsert";
	}

	// ggy_20210315 : 농업지원-영농일지 간편등록 목록 선택시 값 자동으로 배치
	@RequestMapping("selectMySimpleCodeInfo")
	public String selectMySimpleCodeInfo(String user_id, int my_simple_code, Model model) {
		logger.debug("selectMySimpleCodeInfo 진입");
		MySimpleCodeVo mySimpleCodeVo = new MySimpleCodeVo();
		mySimpleCodeVo.setMy_simple_code(my_simple_code);
		mySimpleCodeVo.setOwner(user_id);
		logger.debug("selectMySimpleCodeInfo 진입 my_simple_code {}, user_id {} ", mySimpleCodeVo.getMy_simple_code(),
				mySimpleCodeVo.getOwner());
		model.addAttribute("mySimpleCodeList", fsurpportService.selectMySimpleCodeList(user_id));
		model.addAttribute("selectMySimpleCodeInfo", fsurpportService.selectMySimpleCodeInfo(mySimpleCodeVo));
		model.addAttribute("workstepsList", fsurpportService
				.selectAllW_step_codeList(fsurpportService.selectMySimpleCodeInfo(mySimpleCodeVo).getB_type_code()));
		model.addAttribute("itemsList", fsurpportService.selectAllItem_codeList());
		logger.debug("selectMySimpleCodeInfo item_code : {}, bsn_code : {}",
				fsurpportService.selectMySimpleCodeInfo(mySimpleCodeVo).getItem_code(),
				fsurpportService.selectMySimpleCodeInfo(mySimpleCodeVo).getB_type_code());
		return "tiles.fsurpport.fsurpportInsert";
	}

	// ggy_20210302 : 농업지원-영농일지 내 일지 간편등록를 위한 진입페이지
	@RequestMapping("simpleInsertView")
	public String simpleInsertView(Model model) {
		logger.debug("simpleInsertView 진입");
//		model.addAttribute("workstepsList", fsurpportService.selectAllW_step_codeList());
		model.addAttribute("itemsList", fsurpportService.selectAllItem_codeList());
		model.addAttribute("b_typeList", fsurpportService.selectAllB_type_codeList());
		return "tiles.fsurpport.fsurpportSimpleInsert";
	}

	// ggy_20210315 : 농업지원-영농일지 내 간편등록 작성한걸 등록
	@RequestMapping(path = "registMySimpleCode", method = { RequestMethod.POST })
	public String registMySimpleCode(MySimpleCodeVo mySimpleCodeVo, Model model) {
		logger.debug("registMySimpleCode 진입");
		String user_id = mySimpleCodeVo.getOwner();
		String b_type_code_nm = fsurpportService.selectB_type_code_no(mySimpleCodeVo.getB_type_code()).getCode_nm();
		String item_code_nm = fsurpportService.selectB_type_code_no(mySimpleCodeVo.getItem_code()).getCode_nm();
		int area = mySimpleCodeVo.getArea();
		String code_alias = b_type_code_nm + "-" + item_code_nm + "-" + area;
		mySimpleCodeVo.setCode_alias(code_alias);
		int registCnt = fsurpportService.registMySimpleCode(mySimpleCodeVo);
		logger.debug("registCnt :" + registCnt);
		if (registCnt == 1) {

			model.addAttribute("workstepsList", fsurpportService.selectAllW_step_codeList(b_type_code_nm));
			model.addAttribute("itemsList", fsurpportService.selectAllItem_codeList());
			model.addAttribute("mySimpleCodeList", fsurpportService.selectMySimpleCodeList(user_id));
			return "tiles.fsurpport.fsurpportInsert";
		} else {

//			model.addAttribute("workstepsList", fsurpportService.selectAllW_step_codeList());
			model.addAttribute("itemsList", fsurpportService.selectAllItem_codeList());
			return "tiles.fsurpport.fsurpportSimpleInsert";
		}

	}

	// ggy_20210308 : 농업지원-영농일지 내 일지 등록
	@RequestMapping(path = "registFarmdiary", method = { RequestMethod.POST })
	public String registFarmdiary(HttpServletRequest req, MultipartFile file_file, Model model) {

		logger.debug("registFarmdiary 진입");

		FarmdiaryVo farmdiaryVo = new FarmdiaryVo();

		farmdiaryVo.setArea(Integer.parseInt(req.getParameter("area")));
		farmdiaryVo.setB_type_code(req.getParameter("b_type_code"));
		farmdiaryVo.setContent(req.getParameter("content"));
		farmdiaryVo.setHigh_temp(Integer.parseInt(req.getParameter("high_temp")));
		farmdiaryVo.setHumid(Integer.parseInt(req.getParameter("humid")));
		farmdiaryVo.setItem_code(req.getParameter("item_code"));
		farmdiaryVo.setLow_temp(Integer.parseInt(req.getParameter("low_temp")));
		farmdiaryVo.setMy_simple_code(Integer.parseInt(req.getParameter("my_simple_code")));
		farmdiaryVo.setRainfall(Integer.parseInt(req.getParameter("rainfall")));
		farmdiaryVo.setW_step_code(req.getParameter("w_step_code"));
		farmdiaryVo.setWeather(req.getParameter("weather"));
		farmdiaryVo.setWriter(req.getParameter("writer"));
		farmdiaryVo.setYield(Integer.parseInt(req.getParameter("yield")));

		FilesVo filesVo = new FilesVo();

		if (file_file.getSize() > 0) {

			logger.debug("file 있다.");

			String path = "c:\\fdown\\";

			try {

				file_file.transferTo(new File(path + file_file.getOriginalFilename()));

				filesVo.setFile_nm("");
				filesVo.setFile_nm(file_file.getOriginalFilename());
				filesVo.setFile_path(path + filesVo.getFile_nm());
			} catch (IllegalStateException | IOException e) {
				filesVo.setFile_nm("");
			}

			int registFilesCnt = fsurpportService.registFiles(filesVo);

			logger.debug("registFilesCnt : {}", registFilesCnt);

			if (registFilesCnt < 1) {
				model.addAttribute("farmdiaryList", farmdiaryVo);
				logger.debug("파일 등록 실패");
				return "redirect:/fsurpport/fsurpportInsert";
			}

			filesVo = fsurpportService.selectFilesInfo(registFilesCnt);

			farmdiaryVo.setFile_no(filesVo.getFile_no());
		} else {
			logger.debug("파일없다.");
			farmdiaryVo.setFile_no(0);
		}

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

		return "redirect:/fsurpport/main?user_id=" + farmdiaryVo.getWriter();
	}

	// ggy_20210304 : 농업지원-영농일지 내 일지 수정을 위한 진입페이지
	@RequestMapping(path = "ModifyView", method = { RequestMethod.POST })
	public String ModifyView(String writer, int f_diary_no, int my_simple_code, Model model) {
		logger.debug("영농일지 수정 ModifyView 진입");
		MySimpleCodeVo mySimpleCodeVo = new MySimpleCodeVo();
		mySimpleCodeVo.setOwner(writer);
		mySimpleCodeVo.setMy_simple_code(my_simple_code);
		if (writer != null) {
			model.addAttribute("selectMySimpleCodeInfo", fsurpportService.selectMySimpleCodeInfo(mySimpleCodeVo));
			model.addAttribute("farmdiaryList", fsurpportService.selectFarmdiaryInfo(f_diary_no));
			model.addAttribute("mySimpleCodeList", fsurpportService.selectMySimpleCodeList(writer));
			logger.debug("ModifyView의 사업유형값 :{}",
					fsurpportService.selectMySimpleCodeInfo(mySimpleCodeVo).getB_type_code());
			model.addAttribute("workstepsList", fsurpportService.selectAllW_step_codeList(
					fsurpportService.selectMySimpleCodeInfo(mySimpleCodeVo).getB_type_code()));
			model.addAttribute("itemsList", fsurpportService.selectAllItem_codeList());
			model.addAttribute("b_typeList", fsurpportService.selectAllB_type_codeList());
		}
		return "tiles.fsurpport.fsurpportModify";
	}

	// ggy_20210309 : 농업지원-영농일지 내 일지 내용 수정후 수정 완료
	@RequestMapping(path = "modifyFarmdiary", method = { RequestMethod.POST })
	public String modifyFarmdiary(HttpServletRequest req, MultipartFile file_file, Model model) {
		logger.debug("modifyFarmdiary 진입 ");
		FarmdiaryVo farmdiaryVo = new FarmdiaryVo();
		MySimpleCodeVo mySimpleCodeVo1 = new MySimpleCodeVo();
		mySimpleCodeVo1.setOwner(req.getParameter("writer"));
		logger.debug("writer : {}", req.getParameter("writer"));
		mySimpleCodeVo1.setMy_simple_code(Integer.parseInt(req.getParameter("my_simple_code")));
		logger.debug("my_simple_code : {}", req.getParameter("my_simple_code"));
		mySimpleCodeVo1 = fsurpportService.selectMySimpleCode_noInfo(mySimpleCodeVo1);
		farmdiaryVo.setF_diary_no(Integer.parseInt(req.getParameter("f_diary_no")));
		logger.debug("f_diary_no {}: ", req.getParameter("f_diary_no"));
		farmdiaryVo.setWriter(req.getParameter("writer"));
		logger.debug("writer : {}", req.getParameter("writer"));
		farmdiaryVo.setMy_simple_code(Integer.parseInt(req.getParameter("my_simple_code")));
		logger.debug("my_simple_code : {}", req.getParameter("my_simple_code"));
		farmdiaryVo.setContent(req.getParameter("content"));
		logger.debug("content : {}", req.getParameter("content"));
		farmdiaryVo.setWeather(req.getParameter("weather"));
		logger.debug("weather : {}", req.getParameter("weather"));
		farmdiaryVo.setLow_temp(Integer.parseInt(req.getParameter("low_temp")));
		logger.debug("low_temp : {}", req.getParameter("low_temp"));
		farmdiaryVo.setHigh_temp(Integer.parseInt(req.getParameter("high_temp")));
		logger.debug("high_temp : {}", req.getParameter("high_temp"));
		farmdiaryVo.setRainfall(Integer.parseInt(req.getParameter("rainfall")));
		logger.debug("rainfall : {}", req.getParameter("rainfall"));
		farmdiaryVo.setHumid(Integer.parseInt(req.getParameter("humid")));
		logger.debug("humid : {}", req.getParameter("humid"));
		farmdiaryVo.setYield(Integer.parseInt(req.getParameter("yield")));
		logger.debug("yield : {}", req.getParameter("yield"));
		farmdiaryVo.setArea(Integer.parseInt(req.getParameter("area")));
		logger.debug("area : {}", req.getParameter("area"));
		farmdiaryVo.setB_type_code(mySimpleCodeVo1.getB_type_code());
		logger.debug("b_type_code : {}", mySimpleCodeVo1.getB_type_code());
		farmdiaryVo.setW_step_code(req.getParameter("w_step_code"));
		logger.debug("w_step_code : {}", req.getParameter("w_step_code"));
		farmdiaryVo.setItem_code(mySimpleCodeVo1.getItem_code());
		logger.debug("item_code : {}", mySimpleCodeVo1.getItem_code());
		FilesVo filesVo = new FilesVo();

		if (req.getParameter("file_nm") != null && !req.getParameter("file_nm").equals("")) {
			logger.debug("값 있다.");
			FarmdiaryVo farmdiaryVo1 = new FarmdiaryVo();
			farmdiaryVo1 = fsurpportService.selectFarmdiaryInfo(farmdiaryVo.getF_diary_no());
			farmdiaryVo.setFile_no(farmdiaryVo1.getFile_no());
			logger.debug("file_no : {}", farmdiaryVo1.getFile_no());
		} else {
			// if(file_file !=null && !file_file.equals(""))
			logger.debug("새파일 등록이전에 첨부파일만 삭제인지 확인");
			logger.debug("file : {}", file_file.getOriginalFilename());
			if (file_file.getOriginalFilename().equals("")) {
				logger.debug("file_file는 '' ");
			}
			if (req.getParameter("file_nm").equals("") && file_file.getOriginalFilename().equals("")
					|| file_file.getOriginalFilename() == null) {
				logger.debug("첨부파일 없애서 파일 번호 없애기");
				FarmdiaryVo farmdiaryVo2 = new FarmdiaryVo();
				farmdiaryVo2 = fsurpportService.selectFarmdiaryInfo(farmdiaryVo.getF_diary_no());
				farmdiaryVo.setFile_no(farmdiaryVo2.getFile_no());
				logger.debug("file_no : {}", farmdiaryVo2.getFile_no());
				int deleteCnt = 0;
				if (farmdiaryVo2.getFile_no() > 0) {
					deleteCnt = fsurpportService.deleteFile_no(farmdiaryVo2.getFile_no());
					logger.debug("deleteCnt : {}", deleteCnt);
					if (deleteCnt == 1) {
						farmdiaryVo.setFile_no(0);
						logger.debug("file_no : {}", farmdiaryVo.getFile_no());
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
				logger.debug("registFilesCnt : {}", registFilesCnt);
				if (registFilesCnt < 1) {
					model.addAttribute("farmdiaryList" + farmdiaryVo);
					logger.debug("파일 등록 실패");
					return "redirect:/fsurpport/fsurpportInsert";
				}
				filesVo = fsurpportService.selectFilesInfo(registFilesCnt);
				farmdiaryVo.setFile_no(filesVo.getFile_no());
			}
		}
		logger.debug("수정전 file_no 값 : {}", farmdiaryVo.getFile_no());
		logger.debug("수정 시작 ");
		int modifyCnt = fsurpportService.modifyFarmdiaryInfo(farmdiaryVo);
		logger.debug("수정후 값 : {}", modifyCnt);
		if (modifyCnt == 1) {
			logger.debug("수정 완료 ");
			logger.debug("f_diary_no : {}", farmdiaryVo.getF_diary_no());
			return "redirect:/fsurpport/infoView?f_diary_no=" + farmdiaryVo.getF_diary_no();
		} else {
			logger.debug("수정 실패");
			MySimpleCodeVo mySimpleCodeVo = new MySimpleCodeVo();
			mySimpleCodeVo.setOwner(farmdiaryVo.getWriter());
			mySimpleCodeVo.setMy_simple_code(farmdiaryVo.getMy_simple_code());
			model.addAttribute("selectMySimpleCodeInfo", fsurpportService.selectMySimpleCodeInfo(mySimpleCodeVo));
			model.addAttribute("farmdiaryList", fsurpportService.selectFarmdiaryInfo(farmdiaryVo.getF_diary_no()));
			model.addAttribute("mySimpleCodeList", fsurpportService.selectMySimpleCodeList(farmdiaryVo.getWriter()));
//			model.addAttribute("workstepsList", fsurpportService.selectAllW_step_codeList());
			model.addAttribute("itemsList", fsurpportService.selectAllItem_codeList());
			model.addAttribute("b_typeList", fsurpportService.selectAllB_type_codeList());
			return "tiles.fsurpport.fsurpportModify";
		}
	}

	// ggy_20210309 : 농업지원-영농일지 내 일지 삭제
	@RequestMapping(path = "deleteFarmdiary", method = { RequestMethod.POST })
	public String deleteFarmdiary(String writer, int f_diary_no) {
		logger.debug("deleteFarmdiary 진입");
		FarmdiaryVo farmdiaryVo = new FarmdiaryVo();
		farmdiaryVo.setWriter(writer);
		farmdiaryVo.setF_diary_no(f_diary_no);
		logger.debug("deleteFarmdiary 삭제 시작전 ");
		int deleteCnt = fsurpportService.deleteFarmdiary(farmdiaryVo);
		logger.debug("deleteCnt : {}", deleteCnt);
		if (deleteCnt == 1) {
			return "redirect:/fsurpport/main?user_id=" + writer;
		} else {
			return "redirect:/fsurpport/infoView?f_diary_no=" + f_diary_no;
		}
	}

	// ggy_20210310 : 농업지원-영농일지 일지 목록들 다운로드
	@RequestMapping("excelFamrdiaryList")
	public void excelFamrdiaryList(String user_id, HttpServletResponse response, Model model) throws IOException {
		response.setContentType("application/vnd.ms-excel; charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename=text.xlsx");
		List<FarmdiaryVo> data = fsurpportService.selectAllFsurpportList(user_id);
		// excel 파일 생성
		XSSFWorkbook book = new XSSFWorkbook();
		// 시트생성
		Sheet sheet = book.createSheet("farmdiary");

		List<String> header = new ArrayList<String>();
		header.add("영농일지번호");
		header.add("작성자");
		header.add("간편등록코드");
		header.add("내용");
		header.add("작성일자");
		header.add("날씨");
		header.add("최저온도");
		header.add("최고온도");
		header.add("강수량");
		header.add("습도");
		header.add("수확량");
		header.add("면적");
		header.add("첨부파일");
		header.add("사업유형");
		header.add("작업단계");
		header.add("품목유형");

		CellStyle rowStyle = book.createCellStyle();
		rowStyle.setAlignment(HorizontalAlignment.CENTER);
		rowStyle.setVerticalAlignment(VerticalAlignment.CENTER);

		rowStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
		rowStyle.setFillPattern(FillPatternType.BRICKS);

		XSSFFont headerFont = book.createFont();

		// row / col 생성
		int rownum = 0;
		int colnum = 0;
		Row row = sheet.createRow(rownum++); // row 가로 만들기

		for (String h : header) {
			Cell cell = row.createCell(colnum++); // cell 세로 만들기
			cell.setCellValue(h);

			cell.setCellStyle(rowStyle);
			headerFont.setFontName(h);
			headerFont.setColor(IndexedColors.GREEN.getIndex());
		}
		data.size();
		for (FarmdiaryVo d : data) {
			colnum = 0;
			Row r = sheet.createRow(rownum++);
			r.createCell(colnum++).setCellValue(d.getF_diary_no());
			r.createCell(colnum++).setCellValue(d.getWriter());
			r.createCell(colnum++).setCellValue(d.getMy_simple_code());
			r.createCell(colnum++).setCellValue(d.getContent());
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			String dateToStr = dateFormat.format(d.getReg_dt());
			r.createCell(colnum++).setCellValue(d.getWeather());
			r.createCell(colnum++).setCellValue(d.getLow_temp());
			r.createCell(colnum++).setCellValue(d.getHigh_temp());
			r.createCell(colnum++).setCellValue(d.getRainfall());
			r.createCell(colnum++).setCellValue(d.getHumid());
			r.createCell(colnum++).setCellValue(d.getYield());
			r.createCell(colnum++).setCellValue(d.getArea());
			r.createCell(colnum++).setCellValue(d.getFile_nm());
			r.createCell(colnum++).setCellValue(d.getB_type_code());
			r.createCell(colnum++).setCellValue(d.getW_step_code());
			r.createCell(colnum++).setCellValue(d.getItem_code());
			r.createCell(colnum++).setCellValue(dateToStr);
		}
		book.write(response.getOutputStream());
	}

	// ggy_20210310 : 농업지원-영농일지 일지 목록들 pdf 다운로드
	@RequestMapping("farmdiaryListPDF.pdf")
	public void farmdiaryListPDF(String user_id, HttpServletResponse response, Model model) throws Exception {
		logger.debug("farmdiaryListPDF 진입");
		try {
			Document document = new Document(); // pdf문서를 처리하는 객체

			PdfWriter pdfOpen = PdfWriter.getInstance(document, response.getOutputStream());

			document.open(); // 웹페이지에 접근하는 객체를 연다

			BaseFont baseFont = BaseFont.createFont("c:/windows/fonts/malgun.ttf", BaseFont.IDENTITY_H,
					BaseFont.EMBEDDED);
			// pdf가 기본적으로 한글처리가 안되기 때문에 한글폰트 처리를 따로 해주어야 한다.
			// createFont메소드에 사용할 폰트의 경로 (malgun.ttf)파일의 경로를 지정해준다.
			// 만약에 이 경로에 없을 경우엔 java파일로 만들어서 집어넣어야 한다.

			Font font = new Font(baseFont, 8); // 폰트의 사이즈를 12픽셀로 한다.

			PdfPTable table = new PdfPTable(15); // 4개의 셀을 가진 테이블 객체를 생성 (pdf파일에 나타날 테이블)
			Chunk chunk = new Chunk("영농일지 리스트", font); // 타이틀 객체를 생성 (타이틀의 이름을 장바구니로 하고 위에 있는 font를 사용)
			Paragraph ph = new Paragraph(chunk);
			ph.setAlignment(Element.ALIGN_CENTER);
			document.add(ph); // 문단을 만들어서 가운데 정렬 (타이틀의 이름을 가운데 정렬한다는 뜻)

			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE); // 줄바꿈 (왜냐하면 타이틀에서 두줄을 내린후에 셀(테이블)이 나오기 때문)

			PdfPCell cell1 = new PdfPCell(new Phrase("영농일지번호", font)); // 셀의 이름과 폰트를 지정해서 셀을 생성한다.
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 셀의 정렬방식을 지정한다. (가운데정렬)

			PdfPCell cell2 = new PdfPCell(new Phrase("작성자", font));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell3 = new PdfPCell(new Phrase("간편등록", font));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell5 = new PdfPCell(new Phrase("작성일자", font));
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell6 = new PdfPCell(new Phrase("날씨", font));
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell7 = new PdfPCell(new Phrase("최저온도", font));
			cell7.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell8 = new PdfPCell(new Phrase("최고온도", font));
			cell8.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell9 = new PdfPCell(new Phrase("강수량", font));
			cell9.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell10 = new PdfPCell(new Phrase("습도", font));
			cell10.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell11 = new PdfPCell(new Phrase("수확량", font));
			cell11.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell12 = new PdfPCell(new Phrase("면적", font));
			cell12.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell13 = new PdfPCell(new Phrase("첨부파일", font));
			cell13.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell14 = new PdfPCell(new Phrase("사업유형", font));
			cell14.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell15 = new PdfPCell(new Phrase("작업단계", font));
			cell15.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell16 = new PdfPCell(new Phrase("품목유형", font));
			cell16.setHorizontalAlignment(Element.ALIGN_CENTER);

			table.addCell(cell1); // 그리고 테이블에 위에서 생성시킨 셀을 넣는다.
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(cell5);
			table.addCell(cell6);
			table.addCell(cell7);
			table.addCell(cell8);
			table.addCell(cell9);
			table.addCell(cell10);
			table.addCell(cell11);
			table.addCell(cell12);
			table.addCell(cell13);
			table.addCell(cell14);
			table.addCell(cell15);
			table.addCell(cell16);

			List<FarmdiaryVo> farmdiaryList = fsurpportService.selectAllFsurpportList(user_id);

			for (FarmdiaryVo f : farmdiaryList) {

				PdfPCell f_diary_no = new PdfPCell(new Phrase(Integer.toString(f.getF_diary_no()), font));
				PdfPCell writer = new PdfPCell(new Phrase(f.getWriter(), font));
				PdfPCell my_simple_code = new PdfPCell(new Phrase(Integer.toString(f.getMy_simple_code()), font));

				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				String dateToStr = dateFormat.format(f.getReg_dt());
				PdfPCell reg_dt = new PdfPCell(new Phrase(dateToStr, font));

				PdfPCell weather = new PdfPCell(new Phrase(f.getWeather(), font));
				PdfPCell low_temp = new PdfPCell(new Phrase(Integer.toString(f.getLow_temp()), font));
				PdfPCell high_temp = new PdfPCell(new Phrase(Integer.toString(f.getHigh_temp()), font));
				PdfPCell rainfall = new PdfPCell(new Phrase(Integer.toString(f.getRainfall()), font));
				PdfPCell humid = new PdfPCell(new Phrase(Integer.toString(f.getHumid()), font));
				PdfPCell yield = new PdfPCell(new Phrase(Integer.toString(f.getYield()), font));
				PdfPCell area = new PdfPCell(new Phrase(Integer.toString(f.getArea()), font));
				PdfPCell file_nm = new PdfPCell(new Phrase(f.getFile_nm(), font));
				PdfPCell b_type_code = new PdfPCell(new Phrase(f.getB_type_code(), font));
				PdfPCell w_step_code = new PdfPCell(new Phrase(f.getW_step_code(), font));
				PdfPCell item_code = new PdfPCell(new Phrase(f.getItem_code(), font));

				table.addCell(f_diary_no); // 셀의 데이터를 테이블에 저장한다. (장바구니안에 들어있는 갯수만큼 테이블이 만들어진다)
				table.addCell(writer);
				table.addCell(my_simple_code);
				table.addCell(reg_dt);
				table.addCell(weather);
				table.addCell(low_temp);
				table.addCell(high_temp);
				table.addCell(rainfall);
				table.addCell(humid);
				table.addCell(yield);
				table.addCell(area);
				table.addCell(file_nm);
				table.addCell(b_type_code);
				table.addCell(w_step_code);
				table.addCell(item_code);
			}
			document.add(table); // 웹접근 객체에 table를 저장한다.
			document.close(); // 저장이 끝났으면 document객체를 닫는다.

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("종료");
	}

	/* 시설관리 영역 */

	// KJH_20210302
	// 농업지원 - 시설관리 관리중인 시설 리스트 조회페이지 ok
	@RequestMapping("fmanageList")
	public String fmanageList(Model model) {
		logger.debug(" 시설관리중인 시설 리스트 fmanageList 진입");
		List<FmanageVo> fmanageList = fsurpportService.myfmanageList();
		model.addAttribute("fmanageList", fmanageList);
		return "tiles.fsurpport.fmanageList";
	}

//	 KJH_20210308 수정
//	 농업양식 - 시설관리 관리중인 시설 상세 조회페이지 ok
	@RequestMapping(path = "fmanageInfo", method = { RequestMethod.POST })
	public String fmanage(Model model, FmanageVo fmanage, HttpSession session, String manage_no) {
		logger.debug(" 시설관리중인 시설 상세조회 fmanageInfo 진입");
		FmanageVo fvo = fsurpportService.fmanageInfo(manage_no);
		// KJH_20210308 측정 정보 조회 수정
		FhistoryVo fhistoryVo = new FhistoryVo();
		fhistoryVo.setManage_no(fvo.getManage_no());
		fhistoryVo.setHistory_no(fvo.getHistory_no());
		MsrrecVo mvo = fsurpportService.latelyData(fhistoryVo);
		UserVo userVo = new UserVo();
		userVo = (UserVo) session.getAttribute("S_USER");
		List<MsrequipVo> myList = fsurpportService.msrList(userVo.getUser_id());
		List<MsrequipVo> okList = new ArrayList<MsrequipVo>();
		for (int i = 0; i < myList.size(); i++) {
			MsrequipVo vo = new MsrequipVo();
			vo.setMsr_code(myList.get(i).getMsr_code());
			vo.setOwner(userVo.getUser_id());
			int count = fsurpportService.availableList(vo);
			if (count == 0) {
				vo.setMsr_code(myList.get(i).getMsr_code());
				vo.setOwner(userVo.getUser_id());
				vo.setMsr_nm(myList.get(i).getMsr_nm());
				vo.setUse_yn(myList.get(i).getUse_yn());
				okList.add(vo);
			}
		}
		model.addAttribute("okList", okList);
		model.addAttribute("fmanage", fvo);
		model.addAttribute("msrrec", mvo);
		return "tiles.fsurpport.fmanageInfo";
	}

//	 KJH_20210315
//	 농업양식 - 시설관리 관리중인 시설 상세 조회페이지 ajax
	@RequestMapping(path = "fmanageInfoajax", method = { RequestMethod.POST })
	public String fmanagepostajax(Model model, FmanageVo fmanage, HttpSession session) {
		logger.debug("관리중인 시설 상세조회 fmanageInfo 진입");
		FmanageVo fvo = fsurpportService.fmanageInfo(fmanage.getManage_no());
		// KJH_20210308 측정 정보 조회 수정
		FhistoryVo fhistoryVo = new FhistoryVo();
		fhistoryVo.setManage_no(fvo.getManage_no());
		fhistoryVo.setHistory_no(fvo.getHistory_no());
		MsrrecVo mvo = fsurpportService.latelyData(fhistoryVo);
		UserVo userVo = new UserVo();
		userVo = (UserVo) session.getAttribute("S_USER");
		List<MsrequipVo> myList = fsurpportService.msrList(userVo.getUser_id());
		List<MsrequipVo> okList = new ArrayList<MsrequipVo>();
		for (int i = 0; i < myList.size(); i++) {
			MsrequipVo vo = new MsrequipVo();
			vo.setMsr_code(myList.get(i).getMsr_code());
			vo.setOwner(userVo.getUser_id());
			int count = fsurpportService.availableList(vo);
			if (count == 0) {
				vo.setMsr_code(myList.get(i).getMsr_code());
				vo.setOwner(userVo.getUser_id());
				vo.setMsr_nm(myList.get(i).getMsr_nm());
				vo.setUse_yn(myList.get(i).getUse_yn());
				okList.add(vo);
			}
		}
		model.addAttribute("okList", okList);
		model.addAttribute("fmanage", fvo);
		model.addAttribute("msrrec", mvo);
		return "/ajax/ajaxfmanageInfo";
	}

	// KJH_20210302
	// 농업양식 - 시설관리 관리중인 시설 등록 페이지 ok
	@RequestMapping("fmanageInsertPage")
	public String fmanageInsertPage(Model model, HttpSession session) {
		logger.debug("관리중인 시설 등록 fmanageInsertPage 진입");
		String itemcategorycode = "100";
		String itemcode = "111";
		UserVo userVo = new UserVo();
		userVo = (UserVo) session.getAttribute("S_USER");
		List<MsrequipVo> myList = fsurpportService.msrList(userVo.getUser_id());
		List<MsrequipVo> okList = new ArrayList<MsrequipVo>();
		for (int i = 0; i < myList.size(); i++) {
			MsrequipVo vo = new MsrequipVo();
			vo.setMsr_code(myList.get(i).getMsr_code());
			vo.setOwner(userVo.getUser_id());
			int count = fsurpportService.availableList(vo);
			if (count == 0) {
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
		model.addAttribute("okList", okList);
		return "tiles.fsurpport.fmanageInsert";
	}

	// 20210311 시설 등록하기 ok
	@RequestMapping("fmanageInsert")
	public String fmanageInsert(Model model, HttpSession session, FmanageVo fmanageVo, String msr_code) {
		logger.debug("시설 등록 fmanageInsert");
		if (msr_code == null || msr_code.length() > 0) {
			msr_code = "X";
		}
		fsurpportService.insertFmanage(fmanageVo);
		FhistoryVo fhistoryVo = new FhistoryVo();
		fhistoryVo.setManage_no(fmanageVo.getManage_no());
		fhistoryVo.setMsr_code(msr_code);
		fsurpportService.insertFhistory(fhistoryVo);
		return "redirect:/fsurpport/fmanageList";
	}

	// KJH_20210302
	// 농업양식 - 시설관리 관리중인 시설 업데이트 페이지 ok
	@RequestMapping(path = "fmanageUpdatePage", method = { RequestMethod.POST })
	public String fmanageupdate(Model model, String manage_no) {
		logger.debug("시설 업데이트/수정 fmanageUpdatePage");
		FmanageVo fvo = fsurpportService.updatefmanageInfo(manage_no);
		CodesVo cvo = fdataService.selectCode(fvo.getItem_code());
		model.addAttribute("fmanage", fvo);
		model.addAttribute("itemcategorycode", cvo.getParent_code());
		model.addAttribute("itemcode", fvo.getItem_code());
		model.addAttribute("codesList", fsurpportService.selectAllItem_codeList());
		return "tiles.fsurpport.fmanageUpdate";
	}

	// KJH_20210311
	// 농업양식 - 시설관리 관리중인 시설 업데이트 ok
	@RequestMapping(path = "fmanageUpdate", method = { RequestMethod.POST })
	public String fmanageupdate(Model model, FmanageVo fmanageVo) {
		logger.debug(fmanageVo.getManage_no());
		fsurpportService.fmanageUpdate(fmanageVo);
		model.addAttribute("manage_no", fmanageVo.getManage_no());
		return "forward:/fsurpport/fmanageInfo";
	}

	// KJH_20210311
	// 농업양식 - 시설관리 관리중인 시설 삭제 ok
	@RequestMapping(path = "fmanageDelete", method = { RequestMethod.GET })
	public String fmanagedelete(Model model, FmanageVo fmanageVo) {
		logger.debug("시설 삭제 fmanageDelete");
		fsurpportService.fmanageDelete(fmanageVo);
		fsurpportService.fhistoryDelete(fmanageVo);
		return "redirect:/fsurpport/fmanageList";
	}

	// KJH_20210311
	// 농업양식 - 시설관리 관리중인 시설 장비변경 ok
	@RequestMapping(path = "msrequipChange", method = { RequestMethod.GET })
	public String msrequipChange(Model model, String manage_no, String msr_code) {
		logger.debug("시설 장비변경 msrequipChange");
		if (msr_code == null || msr_code.length() < 0) {
			msr_code = "X";
		}
		FmanageVo fmanageVo = new FmanageVo();
		fmanageVo.setManage_no(manage_no);
		fsurpportService.fhistoryDelete(fmanageVo);
		FhistoryVo fhistoryVo = new FhistoryVo();
		fhistoryVo.setManage_no(manage_no);
		fhistoryVo.setMsr_code(msr_code);
		fsurpportService.insertFhistory(fhistoryVo);
		return "redirect:/fsurpport/fmanageInfo?manage_no=" + manage_no;
	}

	// 20210311_KJH 내 수확량 조회 ok
	@RequestMapping(path = "myYield", method = { RequestMethod.GET })
	public String myYield(Model model, String selec, String sdate, String edate, HttpSession session) {
		logger.debug("내 수확량 조회 myYield");
		List<FarmdiaryVo> farmCount = new ArrayList<FarmdiaryVo>();
		UserVo userVo = new UserVo();
		userVo = (UserVo) session.getAttribute("S_USER");
		if (selec == null || selec.equals("all") || sdate == null || sdate == "") {
			FarmdiaryVo vo = new FarmdiaryVo();
			vo.setWriter(userVo.getUser_id());
			vo.setB_type_code("2000-01-01");
			vo.setW_step_code("5555-12-30");
			farmCount = fsurpportService.myYield(vo);
		}
		else if (selec.equals("week")) {
			try {
				String[] dt = sdate.split("~");
				String sd = dt[0];
				String ed = dt[1];
				FarmdiaryVo vo = new FarmdiaryVo();
				vo.setWriter(userVo.getUser_id());
				vo.setB_type_code(sd);
				vo.setW_step_code(ed);
				farmCount = fsurpportService.myYield(vo);
			} catch (Exception e) {
				model.addAttribute("farmCount", farmCount);
				return "tiles.fanalysis.myYield";
			}
		} else if (selec.equals("month")) {
			FarmdiaryVo vo = new FarmdiaryVo();
			vo.setWriter(userVo.getUser_id());
			vo.setB_type_code(sdate + "-01");
			String[] dt = edate.split("-");
			int eyy = Integer.parseInt(dt[0]);// 2021
			int emm = Integer.parseInt(dt[1]) + 1;// 04
			if (emm > 12) {
				emm = 1;
				eyy += 1;
			}
			String edt = "" + eyy + "-" + emm + "-01";
			vo.setW_step_code(edt);
			farmCount = fsurpportService.myYield(vo);
		} else if (selec.equals("year")) {
			FarmdiaryVo vo = new FarmdiaryVo();
			vo.setB_type_code(sdate + "-01-01");
			String edt = "" + (Integer.parseInt(edate));
			vo.setW_step_code(edt + "-12-31");
			vo.setWriter(userVo.getUser_id());
			farmCount = fsurpportService.myYield(vo);
		}
		model.addAttribute("farmCount", farmCount);
		return "tiles.fanalysis.myYield";
	}

	// KJH_20210317
	// 시설리스트 페이지
	@RequestMapping(path = "msrequipList", method = { RequestMethod.GET })
	public String msrequipList(Model model, HttpSession session, String check) {
		logger.debug("시설리스트 페이지 msrequipList");
		model.addAttribute("check", check);
		UserVo userVo = new UserVo();
		userVo = (UserVo) session.getAttribute("S_USER");
		if (userVo.user_id.equals("admin")) {
			model.addAttribute("msrList", fsurpportService.msrallList());
			return "tiles.fsurpport.msrequipList";
		} else {
			model.addAttribute("msrList", fsurpportService.msrList(userVo.user_id));
			return "tiles.fsurpport.msrequipList";
		}
	}

	// KJH_20210317
	// 장치 수정 ok
	@RequestMapping(path = "msrUpdate", method = { RequestMethod.GET })
	public String msrUpdate(Model model, HttpSession session, MsrequipVo msrequipVo) {
		logger.debug("장치 수정 msrUpdate");
		fsurpportService.msrUpdate(msrequipVo);
		return "redirect:/fsurpport/msrequipList";
	}

	// 20210317_KJH 사용자 장비 등록
	@RequestMapping(path = "msrSet", method = { RequestMethod.GET })
	public String msrSet(Model model, HttpSession session, MsrequipVo msrequipVo) {
		logger.debug("장비 등록 msrSet");
		UserVo userVo = new UserVo();
		userVo = (UserVo) session.getAttribute("S_USER");
		msrequipVo.setOwner(userVo.getUser_id());
		int cnt = fsurpportService.msrSelect(msrequipVo.getMsr_code());
		if (cnt == 1) {
			fsurpportService.msrSet(msrequipVo);
		} else {
			model.addAttribute("check", "해당 코드로 장비를 등록할 수 없습니다.");
		}
		return "redirect:/fsurpport/msrequipList";
	}

	// ggy_20210309 : 파일 경로
	@RequestMapping("filePath")
	public void profile(HttpServletResponse resp, String file_nm, HttpServletRequest req) {
		logger.debug("filePath 진입");
		resp.setContentType("image");
		// userid 파라미터를 이용하여
		// userService 객체를 통해 사용자의 사진 파일 이름을 획득
		// 파일 입출력을 통해 사진을 읽어들여 resp객체의 outputStream으로 응답 생성
		String path = "";
		if (file_nm == null && !file_nm.equals("")) {
			logger.debug("file_nm이 null");
			path = req.getServletContext().getRealPath("c:\\fdown\\unknown.png");
			logger.debug("path : {}", path);
		} else {
			logger.debug("file_nm이 null 아니다.");
			path = "c:\\fdown\\" + file_nm;
			logger.debug("path : {}", path);
		}
		logger.debug("path : {}", path);
		try {
			FileInputStream fis = new FileInputStream(path);
			ServletOutputStream sos = resp.getOutputStream();
			byte[] buff = new byte[512];
			while (fis.read(buff) != -1) {
				sos.write(buff);
			}
			fis.close();
			sos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
