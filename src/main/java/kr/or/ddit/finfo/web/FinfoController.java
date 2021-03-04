package kr.or.ddit.finfo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.farm.model.GardenguidesVo;

/**
 * 
 * @author KWS 농업정보 부분 컨트롤러
 *
 */
@RequestMapping("finfo")
@Controller
public class FinfoController {
	private static final Logger logger = LoggerFactory.getLogger(FinfoController.class);

	// KWS 텃밭 가이드 (재배정보 진입)
	@RequestMapping("gardenguides") 
	public String gardenguides(Model model) {
		logger.debug("IN gardenguides()");
		return "tiles.finfo.gardenguides";
	}

	// KWS 텃밭 가이드 등록페이지이동 (재배정보 등록페이지 진입)
	@RequestMapping("gardenguidesInsert") 
	public String gardenguidesInsert(Model model) {
		logger.debug("IN gardenguidesInsert()");
		return "tiles.finfo.gardenguidesInsert";
	}
	
	// KWS 텃밭 가이드 등록페이지완료  (재배정보 등록페이지 진입)
	@RequestMapping(path = "gardenguidesInsertBtn", method = { RequestMethod.POST }) 
	public String gardenguidesInsertBtn(Model model, GardenguidesVo gardenguidesVo, MultipartFile file_nm2) {
		logger.debug("IN gardenguidesInsertBtn()");
		logger.debug("Vo : {}",gardenguidesVo);
		logger.debug("file_nm: {}",file_nm2.getOriginalFilename());
		return "tiles.finfo.gardenguides";
	}
	
	//KWS 텃밭 가이드 수정 (재배정보 수정 페이지 진입)
	
	
	// ggy_20210304 : 농업정보 - 품종정보 진입
	@RequestMapping("raceInfosView") 
	public String raceInfosView(Model model) {
		
		return "tiles.finfo.raceInfosMain";
	}
	
	// ggy_20210304 : 농업정보 - 주간 농사정보 진입
	@RequestMapping("weeklyFarmInfosView") 
	public String fcltmngView(Model model) {
		
		return "tiles.finfo.weeklyFarmInfosMain";
	}
	
	// ggy_20210304 : 농업정보 - 품목별영농매뉴얼 진입
	@RequestMapping("itemFarmManualsView") 
	public String itemFarmManualsView(Model model) {
		
		return "tiles.finfo.itemFarmManualsMain";
	}
	
	

}
