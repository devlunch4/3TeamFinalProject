package kr.or.ddit.finfo.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.farm.model.GardenguidesVo;
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

	// KWS 텃밭 가이드 (재배정보 진입)
	@RequestMapping("gardenguides")
	public String gardenguides(Model model, @RequestParam(defaultValue = "1") int xgrdgd_code) {
		logger.debug("IN gardenguides()");
		GardenguidesVo gardenguidesVo = finfoService.selectGuide(xgrdgd_code);
		model.addAttribute("gardenguidesVo", gardenguidesVo);
		return "tiles.finfo.gardenguides";
	}

	// KWS 텃밭 가이드 등록페이지이동 (재배정보 등록페이지 진입)
	@RequestMapping("gardenguidesInsert") // get
	public String gardenguidesInsert(Model model) {
		logger.debug("IN gardenguidesInsert()");
		return "tiles.finfo.gardenguidesInsert";
	}

	// KWS 텃밭 가이드 등록페이지완료 (재배정보 등록완료)
	@RequestMapping(path = "gardenguidesInsertBtn", method = { RequestMethod.POST })
	public String gardenguidesInsertBtn(Model model, GardenguidesVo gardenguidesVo, MultipartFile file_nm2) {
		logger.debug("IN gardenguidesInsertBtn()");
		logger.debug("Vo : {}", gardenguidesVo);
		logger.debug("file_nm: {}", file_nm2.getOriginalFilename());
		return "tiles.finfo.gardenguides";
	}

	// KWS 텃밭 가이드 수정페이지 이동 (재배정보 수정 페이지 진입)20210305
	@RequestMapping(path = "gardenguidesUpdate", method = { RequestMethod.POST })
	public String gardenguidesUpdate(Model model, GardenguidesVo gardenguidesVo, MultipartFile file_nm2) {
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
	public String gardenguidesUpdateBtn(Model model, GardenguidesVo gardenguidesVo, MultipartFile file_nm2) {
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
	@RequestMapping("fcltmngView")
	public String fcltmngView(Model model) {

		return "tiles.finfo.fcltmngMain";
	}

}
