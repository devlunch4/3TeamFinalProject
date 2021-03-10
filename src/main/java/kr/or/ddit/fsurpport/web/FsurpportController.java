package kr.or.ddit.fsurpport.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;

//import org.apache.poi.ss.usermodel.Font;
import com.itextpdf.text.Font;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.xwpf.usermodel.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

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
		
		if ( file_file.getSize() > 0 ) {
			
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
	
			logger.debug("registFilesCnt : " + registFilesCnt);
	
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
		header.add("f_diary_no");
		header.add("writer");
		header.add("my_simple_code");
		header.add("content");
		header.add("reg_dt");
		header.add("weather");
		header.add("low_temp");
		header.add("high_temp");
		header.add("rainfall");
		header.add("humid");
		header.add("yield");
		header.add("area");
		header.add("file_nm");
		header.add("b_type_code");
		header.add("w_step_code");
		header.add("item_code");

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
	@RequestMapping("farmdiaryListPDF")
	public void farmdiaryListPDF(String user_id, HttpServletResponse response, Model model) throws Exception  {
		
		logger.debug("farmdiaryListPDF 진입");
		
		//		List<FarmdiaryVo> farmdiaryList = fsurpportService.selectAllFsurpportList(user_id);
		
		String result = ""; // 초기값이 null이 들어가면 오류가 발생될수 있기 때문에 공백을 지정
		 
        try {
            Document document = new Document(); // pdf문서를 처리하는 객체
 
            PdfWriter pdfWriter = PdfWriter.getInstance(document, response.getOutputStream());
            // pdf파일의 저장경로를 d드라이브의 sample.pdf로 한다는 뜻
 
            document.open(); // 웹페이지에 접근하는 객체를 연다
 
            BaseFont baseFont = BaseFont.createFont("c:/windows/fonts/malgun.ttf", BaseFont.IDENTITY_H,
                    BaseFont.EMBEDDED);
            // pdf가 기본적으로 한글처리가 안되기 때문에 한글폰트 처리를 따로 해주어야 한다.
            // createFont메소드에 사용할 폰트의 경로 (malgun.ttf)파일의 경로를 지정해준다.
            // 만약에 이 경로에 없을 경우엔 java파일로 만들어서 집어넣어야 한다.
 
            Font font = new Font(baseFont, 12); // 폰트의 사이즈를 12픽셀로 한다.
 
            PdfPTable table = new PdfPTable(4); // 4개의 셀을 가진 테이블 객체를 생성 (pdf파일에 나타날 테이블)
            Chunk chunk = new Chunk("영농일지 리스트", font); // 타이틀 객체를 생성 (타이틀의 이름을 장바구니로 하고 위에 있는 font를 사용)
            Paragraph ph = new Paragraph(chunk);
            ph.setAlignment(Element.ALIGN_CENTER);
            document.add(ph); // 문단을 만들어서 가운데 정렬 (타이틀의 이름을 가운데 정렬한다는 뜻)
 
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE); // 줄바꿈 (왜냐하면 타이틀에서 두줄을 내린후에 셀(테이블)이 나오기 때문)
 
            PdfPCell cell1 = new PdfPCell(new Phrase("f_diary_no", font)); // 셀의 이름과 폰트를 지정해서 셀을 생성한다.
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 셀의 정렬방식을 지정한다. (가운데정렬)
 
            PdfPCell cell2 = new PdfPCell(new Phrase("writer", font));
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
 
            PdfPCell cell3 = new PdfPCell(new Phrase("my_simple_code", font));
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
 
//            PdfPCell cell4 = new PdfPCell(new Phrase("content", font));
//            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell5 = new PdfPCell(new Phrase("reg_dt", font));
            cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell6 = new PdfPCell(new Phrase("weather", font));
            cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell7 = new PdfPCell(new Phrase("low_temp", font));
            cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell8 = new PdfPCell(new Phrase("high_temp", font));
            cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell9 = new PdfPCell(new Phrase("rainfall", font));
            cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell10 = new PdfPCell(new Phrase("humid", font));
            cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell11 = new PdfPCell(new Phrase("yield", font));
            cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell12 = new PdfPCell(new Phrase("area", font));
            cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell13 = new PdfPCell(new Phrase("file_nm", font));
            cell13.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell14 = new PdfPCell(new Phrase("b_type_code", font));
            cell14.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell15 = new PdfPCell(new Phrase("w_step_code", font));
            cell15.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell16 = new PdfPCell(new Phrase("item_code", font));
            cell16.setHorizontalAlignment(Element.ALIGN_CENTER);
 
            table.addCell(cell1); // 그리고 테이블에 위에서 생성시킨 셀을 넣는다.
            table.addCell(cell2);
            table.addCell(cell3);
//            table.addCell(cell4);
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
 
//            List<CartDTO> items = cartService.listCart("park"); // 서비스로부터 id값을 매개값으로 주어서 장바구니목록을 가져온다.
            List<FarmdiaryVo> farmdiaryList = fsurpportService.selectAllFsurpportList(user_id);
 
//            for (int i = 0; i < farmdiaryList.size(); i++) {
           	for (FarmdiaryVo f : farmdiaryList) {
//                CartDTO dto = farmdiaryList.get(i); // 레코드에 값들을 꺼내서 dto에 저장
//            	FarmdiaryVo dto = farmdiaryList.get(i); // 레코드에 값들을 꺼내서 dto에 저장
//                PdfPCell cellProductName = new PdfPCell(new Phrase(farmdiaryList.get(i).getF_diary_no(), font)); // 반복문을 사용해서 상품정보를 하나씩
                                                                                                    // 출력해서 셀에 넣고 테이블에
                                                                                                    // 저장한다.
                PdfPCell f_diary_no = new PdfPCell(new Phrase(Integer.toString(f.getF_diary_no()), font));
                PdfPCell writer = new PdfPCell(new Phrase(f.getWriter(), font));
                PdfPCell my_simple_code = new PdfPCell(new Phrase(Integer.toString(f.getMy_simple_code()), font));
//                PdfPCell content = new PdfPCell(new Phrase(f.getContent(), font));
                
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
                
 
//                PdfPCell cellPrice = new PdfPCell(new Phrase("" + dto.getPrice(), font));
//                // Phrase타입은 숫자형(int형 같은타입)으로 하면 에러가 발생되기 때문에 dto앞에 공백("")주어서 String타입으로 변경한다.
// 
//                PdfPCell cellAmount = new PdfPCell(new Phrase("" + dto.getAmount(), font));
//                // Phrase타입은 숫자형(int형 같은타입)으로 하면 에러가 발생되기 때문에 dto앞에 공백("")주어서 String타입으로 변경한다.
// 
//                PdfPCell cellMoney = new PdfPCell(new Phrase("" + dto.getMoney(), font));
//                // Phrase타입은 숫자형(int형 같은타입)으로 하면 에러가 발생되기 때문에 dto앞에 공백("")주어서 String타입으로 변경한다.
 
                table.addCell(f_diary_no); // 셀의 데이터를 테이블에 저장한다. (장바구니안에 들어있는 갯수만큼 테이블이 만들어진다)
                table.addCell(writer);
                table.addCell(my_simple_code);
//                table.addCell(content);
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
            result = "pdf 파일이 생성되었습니다.";
 
        } catch (Exception e) {
            e.printStackTrace();
            result = "pdf 파일 생성 실패...";
        }
        
        logger.debug("종료");
        
//        return "redirect:/fsurpport/main?user_id="+user_id;
		
        
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
