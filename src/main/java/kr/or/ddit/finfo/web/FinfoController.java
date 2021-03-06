package kr.or.ddit.finfo.web;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.farm.model.GardenguideVo;
import kr.or.ddit.farm.model.GuideSqlVo;
import kr.or.ddit.finfo.service.FinfoServiceImpl;

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

	// KWS 텃밭 가이드 (재배정보 진입) 수정 20210305
	@RequestMapping("gardenguides")
	public String gardenguides(Model model, @RequestParam(defaultValue = "ㄱ") String chosung,
			@RequestParam(defaultValue = "1") int xguide_code) {
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

		//
		// 초성 글자 보내기
		model.addAttribute("chosung", chosung);
		// 초성 검색 관련 이름 리스트 보내기
		List<GardenguideVo> gardenguidesList = finfoService.selectGuideList(guideSqlVo);
		model.addAttribute("gardenguidesList", gardenguidesList);

		// 해당 가이드 글번호 보내기
		model.addAttribute("xguide_code", xguide_code);
		// 헤당 가이드 글 보내기
		GardenguideVo gardenguidesVo = finfoService.selectGuide(xguide_code);
		model.addAttribute("gardenguidesVo", gardenguidesVo);
		return "tiles.finfo.gardenguides";
	}

	////////////////////

	// KWS 텃밭 가이드 등록페이지이동 (재배정보 등록페이지 진입)
	@RequestMapping("gardenguidesInsert") // get
	public String gardenguidesInsert(Model model) {
		logger.debug("IN gardenguidesInsert()");
		return "tiles.finfo.gardenguidesInsert";
	}

	// KWS 텃밭 가이드 등록페이지완료 (재배정보 등록완료)
	@RequestMapping(path = "gardenguidesInsertBtn", method = { RequestMethod.POST })
	public String gardenguidesInsertBtn(Model model, GardenguideVo gardenguidesVo, MultipartFile file_nm2) {
		logger.debug("IN gardenguidesInsertBtn()");
		logger.debug("Vo : {}", gardenguidesVo);
		logger.debug("file_nm: {}", file_nm2.getOriginalFilename());
		return "tiles.finfo.gardenguides";
	}

	// KWS 텃밭 가이드 수정페이지 이동 (재배정보 수정 페이지 진입)20210305
	@RequestMapping(path = "gardenguidesUpdate", method = { RequestMethod.POST })
	public String gardenguidesUpdate(Model model, GardenguideVo gardenguidesVo, MultipartFile file_nm2) {
		logger.debug("IN gardenguidesUpdate()");
		logger.debug("Vo : {}", gardenguidesVo);
		if (file_nm2 != null) {
			logger.debug("file_nm2: {}", file_nm2.getOriginalFilename());
		} else {
			logger.debug("file_nm2: null");
		}
		return "tiles.finfo.gardenguidesUpdate";
	}

	// KWS 텃밭 가이드 수정페이지완료 (재배정보 수정완료)20210305
	@RequestMapping(path = "gardenguidesUpdateBtn", method = { RequestMethod.POST })
	public String gardenguidesUpdateBtn(Model model, GardenguideVo gardenguidesVo, MultipartFile file_nm2) {
		logger.debug("IN gardenguidesUpdateBtn()");
		logger.debug("Vo : {}", gardenguidesVo);
		logger.debug("file_nm: {}", file_nm2.getOriginalFilename());
		return "tiles.finfo.gardenguides";
	}

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

	// ggy_20210304 : 농업정보 - 품목별영농매뉴얼 진입
	@RequestMapping("itemFarmManualsView")
	public String itemFarmManualsView(Model model) {

		return "tiles.finfo.itemFarmManualsMain";

	}
}
