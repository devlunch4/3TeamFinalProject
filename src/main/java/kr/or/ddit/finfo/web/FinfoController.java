package kr.or.ddit.finfo.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.common.model.FilesVo;
import kr.or.ddit.farm.model.GardenguideVo;
import kr.or.ddit.farm.model.GuideSqlVo;
import kr.or.ddit.farm.model.ItemmanualVo;
import kr.or.ddit.finfo.service.FinfoServiceImpl;
import kr.or.ddit.fsurpport.service.FsurpportServiceImpl;

/**
 * 
 * @author KWS 농업정보 부분 컨트롤러
 *
 */
@RequestMapping("finfo")
@Controller
public class FinfoController {
	private static final Logger logger = LoggerFactory.getLogger(FinfoController.class);

	// 필요한 스프링 빈 호출
	@Resource(name = "finfoService")
	private FinfoServiceImpl finfoService;

	@Resource(name = "fsurpportService")
	private FsurpportServiceImpl fsurpportService;

	// KWS 텃밭 가이드 (재배정보 진입) 조회 20210305 TEST OK
	@RequestMapping("gardenguides")
	public String gardenguides(Model model, @RequestParam(defaultValue = "ㄱ") String chosung,
			@RequestParam(defaultValue = "0") int xguide_code) {
		logger.debug("IN gardenguides()");
		logger.debug("초성 : {}", chosung);
		logger.debug("xguide_code : {}", xguide_code);

		String[] chosungArr = { "ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ" };
		model.addAttribute("chosungArr", chosungArr);

		String[] chosungArrMatch = { "가", "나", "다", "라", "마", "바", "사", "아", "자", "차", "카", "타", "파", "하" };
		String sqlwhere1 = "";
		String sqlwhere2 = "";

		// 마지막 'ㅎ'인 제외 검색
		for (int i = 0; i < chosungArrMatch.length - 1; i++) {
			if (chosung.equals(chosungArr[i])) {
				sqlwhere1 = chosungArrMatch[i];
				sqlwhere2 = chosungArrMatch[i + 1];
				logger.debug("검색 where 조건1: {}, {}", sqlwhere1, sqlwhere2);
			}
		}
		// 마지막 'ㅎ'인 경우 검색
		if (chosung.equals("ㅎ")) {
			sqlwhere1 = "하";
			sqlwhere2 = "힣";
			logger.debug("검색 where 조건1: {}, {}", sqlwhere1, sqlwhere2);
		}
		logger.debug("검색 where 조건 최종: {}, {}", sqlwhere1, sqlwhere2);
		GuideSqlVo guideSqlVo = new GuideSqlVo(sqlwhere1, sqlwhere2);
		// 초성 글자 보내기
		model.addAttribute("chosung", chosung);
		// 초성 검색 관련 이름 리스트 보내기
		List<GardenguideVo> gardenguidesList = finfoService.selectGuideList(guideSqlVo);

		// 검색 조건시 조회 리스트가 없는 경우 처리.
		if (gardenguidesList.size() == 0) {
			logger.debug("값 확인1 gardenguidesList.size(): {}", gardenguidesList.size());
			xguide_code = 0;
		}
		if (gardenguidesList.size() != 0 && xguide_code == 0) {
			logger.debug("값 확인2 gardenguidesList.size() : {}", gardenguidesList.size());
			xguide_code = Integer.parseInt(gardenguidesList.get(0).getGuide_code());
		}
		model.addAttribute("gardenguidesList", gardenguidesList);

		// 해당 가이드 글번호 보내기
		model.addAttribute("xguide_code", xguide_code);
		// 헤당 가이드 글 보내기
		GardenguideVo gardenguidesVo = finfoService.selectGuide(xguide_code);
		model.addAttribute("gardenguidesVo", gardenguidesVo);
		return "tiles.finfo.gardenguides";
	}

	// KWS 텃밭 가이드 등록페이지이동 (재배정보 등록페이지 진입)
	@RequestMapping("gardenguidesInsert") // get TEST OK
	public String gardenguidesInsert(Model model) {
		logger.debug("IN gardenguidesInsert()");
		return "tiles.finfo.gardenguidesInsert";
	}

	// 추가 수정 20210308 KWS 완료
	// KWS 텃밭 가이드 등록페이지완료 (재배정보 등록완료) TEST OK
	@RequestMapping(path = "gardenguidesInsertBtn", method = { RequestMethod.POST })
	public String gardenguidesInsertBtn(Model model, GardenguideVo gardenguidesVo, MultipartFile file_nm2) {
		logger.debug("IN gardenguidesInsertBtn()");

		// 파일 하드 저장 시작
		logger.debug("NEW 파일 정보 file_nm2: {}", file_nm2.getOriginalFilename());
		try {
			file_nm2.transferTo(new File("c:\\fdown\\guide_img\\" + gardenguidesVo.getItem_code() + ".jpg"));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 파일 하드 저장 끝 추후 테이블 수정요망>>파일테이블 미사용

		// 신규 정보 저장시작
		logger.debug("NEW 입력된 정보gardenguidesVo : {}", gardenguidesVo);
		logger.debug("실제 저장 경로 c:\\fdown\\guide_img\\{}.jpg", gardenguidesVo.getItem_code());

		// Files 테이블에 넣고 해당 번호 출력.후 setFile_no 설정 필요
		// 실제론 해당 경로 저장. filetable 미사용
		gardenguidesVo.setFile_no(0);
		logger.debug("test-value// setting file_no: {}", 0);

		// Insert 수행
		int insertGuide = finfoService.insertGuide(gardenguidesVo);
		logger.debug("NEW 신규 텃밭가이드 저장 완료 : {}", insertGuide);
		// 신규 정보 저장 끝

		///////////////////////////////////////////////////
		// 가이드 페이지로 이동
		String[] chosungArr = { "ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ" };
		model.addAttribute("chosungArr", chosungArr);

		//
		// 초성 글자 보내기
		model.addAttribute("chosung", "ㄱ");
		// 초성 검색 관련 이름 리스트 보내기
		GuideSqlVo guideSqlVo = new GuideSqlVo("가", "나");
		List<GardenguideVo> gardenguidesList = finfoService.selectGuideList(guideSqlVo);
		model.addAttribute("gardenguidesList", gardenguidesList);

		// 해당 가이드 글번호 보내기
		model.addAttribute("xguide_code", 1);
		// 헤당 가이드 글 보내기
		GardenguideVo gardenguidesVo1 = finfoService.selectGuide(1);
		model.addAttribute("gardenguidesVo", gardenguidesVo1);
		return "tiles.finfo.gardenguides";
	}

	// KWS 텃밭 가이드 수정페이지 이동 (재배정보 수정 페이지 진입)20210305+20210308
	@RequestMapping(path = "gardenguidesUpdate", method = { RequestMethod.POST })
	public String gardenguidesUpdate(Model model, int xguide_code) {
		logger.debug("IN gardenguidesUpdate()");
		// 해당 가이드 글번호 보내기
		model.addAttribute("xguide_code", xguide_code);
		GardenguideVo gardenguidesVo = finfoService.selectGuide(xguide_code);
		model.addAttribute("gardenguidesVo", gardenguidesVo);
		return "tiles.finfo.gardenguidesUpdate";
	}

	// KWS 텃밭 가이드 수정페이지완료 (재배정보 수정완료)20210305+20210308
	@RequestMapping(path = "gardenguidesUpdateBtn", method = { RequestMethod.POST })
	public String gardenguidesUpdateBtn(Model model, GardenguideVo gardenguidesVo, MultipartFile file_nm2) {
		logger.debug("IN gardenguidesUpdateBtn()");
		logger.debug("Vo : {}", gardenguidesVo);
		logger.debug("수정할 파일명 file_nm: {}", file_nm2.getOriginalFilename());
		if (file_nm2.getSize() > 0) {
			logger.debug("수정파일 등록 확인 및 저장 시작");
			// 파일 하드 저장 시작
			logger.debug("수정될 파일 정보 file_nm2: {}", file_nm2.getOriginalFilename());
			try {
				file_nm2.transferTo(new File("c:\\fdown\\guide_img\\" + gardenguidesVo.getItem_code() + ".jpg"));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			logger.debug("수정파일 등록 확인 및 저장 수행 완료");
			// 파일 하드 저장 끝 추후 테이블 수정요망>>파일테이블 미사용
		}

		// update 수행
		int updateGuide = finfoService.updateGuide(gardenguidesVo);
		logger.debug("NEW 신규 텃밭가이드 수정 완료 : {}", updateGuide);

		// 초성 세팅
		String[] chosungArr = { "ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ" };
		model.addAttribute("chosungArr", chosungArr);

		// 송신 set
		int xguide_code = Integer.parseInt(gardenguidesVo.getGuide_code());
		model.addAttribute("xguide_code", xguide_code);
		GardenguideVo gardenguidesVo1 = finfoService.selectGuide(xguide_code);
		model.addAttribute("gardenguidesVo", gardenguidesVo1);
		logger.debug("~~~텃밭가이드 수정 완료");
		return "tiles.finfo.gardenguides";
	}

	// KWS 텃밭 가이드 삭제처리 (use_yn : y>>>N) 20210308 TEST OK
	@RequestMapping(path = "gardenguidesDelete", method = { RequestMethod.POST })
	public String gardenguideDelete(Model model, int xguide_code, GardenguideVo gardenguidesVo) {
		logger.debug("IN gardenguidesDelete()");
		logger.debug("삭제처리될 xguide_code : {}", xguide_code);
		int updateGuide = finfoService.deleteGuide(gardenguidesVo);
		logger.debug("use_yn: N처리 : {}", updateGuide);
		return "redirect:/finfo/gardenguides";
	}

	// 20210309 KWS 텃밭 가이드 목록으로 모두보기 TEST OK
	@RequestMapping(path = "gardenguidesAll", method = { RequestMethod.GET })
	public String gardenguidesAll(Model model, GardenguideVo gardenguidesVo) {
		logger.debug("IN gardenguidesAll()");
		List<GardenguideVo> guidelists = finfoService.selectGuideAll();
		model.addAttribute("guidelists", guidelists);
		return "tiles.finfo.gardenguidesall";
	}

	//////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////

	// 20210312 KWS 제철정보 페이지 이동 GET
	@RequestMapping(path = "seasonInfos", method = { RequestMethod.GET })
	public String seasionInfos(Model model) {
		logger.debug("IN seasonInfos()");

		// 봄
		List<GardenguideVo> springlist = finfoService.selectSeasons("%봄%");
		logger.debug("봄검색 첫번째 인덱스: {}", springlist.get(0));
		model.addAttribute("springlist", springlist);
		// 여름
		List<GardenguideVo> summerlist = finfoService.selectSeasons("%여름%");
		model.addAttribute("summerlist", summerlist);
		// 가을
		List<GardenguideVo> autumnlist = finfoService.selectSeasons("%가을%");
		model.addAttribute("autumnlist", autumnlist);
		// 겨울
		List<GardenguideVo> winterlist = finfoService.selectSeasons("%겨울%");
		model.addAttribute("winterlist", winterlist);

		return "tiles.finfo.seasoninfos";
	}

	//////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////

	// ggy_20210304 : 농업정보 - 품종정보 진입
	@RequestMapping("raceInfosView")
	public String raceInfosView(Model model) {

		return "tiles.finfo.raceInfosMain";
	}

	// ggy_20210304 : 농업정보 - 주간 농사정보 진입

	@RequestMapping("weeklyFarmInfosView")
	public String fmanageView(Model model) {

		return "tiles.finfo.weeklyFarmInfosMain";
	}

	// 20210315_ggy : 농업정보 - 품목별영농매뉴얼 진입
	@RequestMapping("itemFarmManualsView")
	public String itemFarmManualsView(Model model) {

		model.addAttribute("itemClassList", finfoService.itemClassList());

		return "tiles.finfo.itemFarmManualsMain";
	}

	// 20210315_ggy : 농업정보 - 품목별영농매뉴얼 진입
	@RequestMapping("itemManualsList")
	public String itemManualsList(String code_no, Model model) {

		logger.debug("itemManualsList 진입");

		model.addAttribute("itemClassList", finfoService.itemClassList());
		model.addAttribute("itemList", finfoService.itemFarmManualsList(code_no));
		model.addAttribute("selectItemCode_ode_no", code_no);
		model.addAttribute("selectItemmanualFilenmList", finfoService.selectItemmanualFilenmList());

		return "tiles.finfo.itemFarmManualsMain";
	}

	// 20210316_ggy : 농업정보 - 품목별영농메뉴얼 업로드 진입
	@RequestMapping("registItemMenualView")
	public String registItemMenualView(String user_id, Model model) {

		logger.debug("registItemMenualView 진입");
		logger.debug("user_id 값 :{} ", user_id);

		if (!user_id.equals("admin")) {
			logger.debug("관리자가 아님");
			return "redirect:/finfo/itemFarmManualsView";
		}

		model.addAttribute("itemClassList", finfoService.itemClassList());

		return "tiles.finfo.registItemFarmManual";

	}

	// 20210316_ggy : 농업정보 - 품목별영농메뉴얼 등록을 위한 품목 분류 조회
	@RequestMapping("registSelectItemList")
	public String registSelectItemList(String code_no, Model model) {

		logger.debug("registSelectItemList 진입");

		model.addAttribute("itemClassList", finfoService.itemClassList());
		model.addAttribute("itemList", finfoService.itemFarmManualsList(code_no));
		model.addAttribute("selectItemCode_ode_no", code_no);

		return "tiles.finfo.registItemFarmManual";
	}

	// 20210316_ggy : 농업정보 - 품목별영농메뉴얼 등록
	@RequestMapping("registItemMenual")
	public String registItemMenual(HttpServletRequest req, MultipartFile file_file, Model model) {

		logger.debug("registItemMenual 진입");

		ItemmanualVo itemmanualVo = new ItemmanualVo();

		itemmanualVo.setIfm_nm(req.getParameter("ifm_nm"));
		itemmanualVo.setItem_code(req.getParameter("item_code"));
		itemmanualVo.setWriter(req.getParameter("writer"));

		FilesVo filesVo = new FilesVo();

		if (file_file.getSize() > 0) {

			logger.debug("file 있다.");

			String path = "c:\\fdown\\finfomunal\\";

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

			itemmanualVo.setFile_no(registFilesCnt);

		} else {
			logger.debug("파일없다.");
			itemmanualVo.setFile_no(0);
		}

		int registCnt = finfoService.registItemMenual(itemmanualVo);
		logger.debug("registCnt : {}", registCnt);

		return "redirect:/finfo/itemFarmManualsView";

	}

	// 20210316_ggy : 농업정보 - 품목별영농메뉴얼 다운로드
	@RequestMapping("filePath")
	public void profile(HttpServletResponse resp, String file_nm, HttpServletRequest req) throws IOException {

		// 파일을 저장했던 위치에서 첨부파일을 읽어 byte[]형식으로 변환한다.
		byte fileByte[] = org.apache.commons.io.FileUtils
				.readFileToByteArray(new File("c:\\fdown\\finfomunal\\" + file_nm));

		resp.setContentType("application/octet-stream");
		resp.setContentLength(fileByte.length);
		resp.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(file_nm, "UTF-8") + "\";");
		resp.getOutputStream().write(fileByte);
		resp.getOutputStream().flush();
		resp.getOutputStream().close();

	}
	
	// 20210317_ggy : 농업정보- 품목별영농메뉴얼-수정진입
	@RequestMapping("modifyItemMenualView")
	public String modifyItemMenualView(int manual_code, Model model) {
		
		logger.debug("modifyItemMenualView 진입");
		
		model.addAttribute("itemMenualInfo", finfoService.selectModifyItemMenualInfo(manual_code));
		
		return "tiles.finfo.modifyItemMenual";
	}
	
	// ggy_20210317 : 농업정보- 품목별영농메뉴얼-수정진입 및 수정 완료
	@RequestMapping(path = "modifyItemMenual", method = { RequestMethod.POST })
	public String modifyItemMenual(HttpServletRequest req, MultipartFile file_file, Model model) {

		logger.debug("modifyItemMenual 진입 ");

		ItemmanualVo itemmanualVo = new ItemmanualVo();

		itemmanualVo.setManual_code(Integer.parseInt(req.getParameter("manual_code")));
		logger.debug("manual_code : " + req.getParameter("manual_code"));

		itemmanualVo.setWriter(req.getParameter("writer"));
		logger.debug("writer : " + req.getParameter("writer"));

		itemmanualVo.setIfm_nm(req.getParameter("ifm_nm"));
		logger.debug("ifm_nm : " + req.getParameter("ifm_nm"));
		
		itemmanualVo.setFile_no(Integer.parseInt(req.getParameter("file_no")));
		logger.debug("file_no : " + req.getParameter("file_no"));

		FilesVo filesVo = new FilesVo();

		if (req.getParameter("file_nm") != null && !req.getParameter("file_nm").equals("")) {

			logger.debug("값 있다.");

			logger.debug("file_no : " + itemmanualVo.getFile_no());

		}

		else {

			logger.debug("새파일 등록이전에 첨부파일만 삭제인지 확인");

			logger.debug("file : " + file_file.getOriginalFilename());

			if (file_file.getOriginalFilename().equals("")) {

				logger.debug("file_file는 '' ");
			}

			if (req.getParameter("file_nm").equals("") && file_file.getOriginalFilename().equals("")
					|| file_file.getOriginalFilename() == null) {

				logger.debug("첨부파일 없애서 파일 번호 없애기");

				logger.debug("file_no : " + itemmanualVo.getFile_no());

				int deleteCnt = 0;
				if (itemmanualVo.getFile_no() > 0) {

					deleteCnt = fsurpportService.deleteFile_no(itemmanualVo.getFile_no());

					logger.debug("deleteCnt : " + deleteCnt);

					if (deleteCnt == 1) {
						itemmanualVo.setFile_no(0);
						logger.debug("file_no : " + itemmanualVo.getFile_no());
					}
				}

			} else {
				logger.debug("파일 등록 시작.");

				String upload_path = "c:\\fdown\\finfomunal\\";

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
					model.addAttribute("farmdiaryList" + itemmanualVo);
					logger.debug("파일 등록 실패");
					return "redirect:/fsurpport/fsurpportInsert";
				}

				filesVo = fsurpportService.selectFilesInfo(registFilesCnt);

				itemmanualVo.setFile_no(filesVo.getFile_no());
			}

		}

		logger.debug("수정전 file_no 값 : " + itemmanualVo.getFile_no());
		logger.debug("수정 시작 : ");

		int modifyCnt = finfoService.modifyItemMenualInfo(itemmanualVo);

		logger.debug("수정후 값 : " + modifyCnt);

		if (modifyCnt == 1) {

			logger.debug("수정 완료 ");

			return "redirect:/finfo/itemFarmManualsView";
		} else {
			logger.debug("수정 실패");
			
			model.addAttribute("itemMenualInfo", finfoService.selectModifyItemMenualInfo(itemmanualVo.getManual_code()));

			return "tiles.finfo.modifyItemMenual";
		}

	}
	
	// 20210317_ggy : 농업정보-품목별 영농 메뉴얼 삭제
	@RequestMapping("deleteItemMenualInfo")
	public String deleteItemMenualInfo(int manual_code, String writer, Model model ) {
		
		logger.debug("deleteItemMenualInfo 진입");
		
		logger.debug("manual_code : {}, writer : {}", manual_code ,writer);
		
		ItemmanualVo itemmanualVo = new ItemmanualVo();
		itemmanualVo.setManual_code(manual_code);
		itemmanualVo.setWriter(writer);
		
		logger.debug("itemmanualVo의 manual_code : {}, writer : {}", itemmanualVo.getManual_code() , itemmanualVo.getWriter());
		
		int deleteCnt = finfoService.deleteItemMenualInfo(itemmanualVo);
		
		if(deleteCnt == 1) {
			logger.debug("삭제 성공");
		} else {
			logger.debug("삭제 실패");
		}
		return"redirect:/finfo/itemFarmManualsView";
		
	}
	
	
	//////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////
	// 이미지파일 보기
	// localhost/finfo/guideimg
	@RequestMapping("guideimg") // 가이드 이미지 보기 KWS 20210309 TEST OK
	public void guideimg(int guide_code, HttpServletRequest req, HttpServletResponse resp) {
		// 이미지로 설정
		logger.debug("~~~~~ 수행 진입 guideimg()");
		resp.setContentType("image");

		GardenguideVo gardenguidesVo = finfoService.selectGuide(guide_code);

		String path = "";
		String chkint = gardenguidesVo.getItem_code();
		if (chkint == null) {
			path = "C:\\fdown\\guide_img\\unknown.jpg";
		} else {
			path = "C:\\fdown\\guide_img\\" + gardenguidesVo.getItem_code() + ".jpg";
		}
		logger.debug("경로 확인 path : {} ", path);

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
		logger.debug("수행 완료 guideimg()");
	}

}
