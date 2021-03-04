package kr.or.ddit.fsurpport.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.farm.model.FcltmngVo;
import kr.or.ddit.fsurpport.service.FsurpportService;

@RequestMapping("fsurpport")
@Controller
public class FsurpportController {

	private static final Logger logger = LoggerFactory.getLogger(FsurpportController.class);

	@Resource(name = "fsurpportService")
	private FsurpportService fsurpportService;

	// ggy_20210302 : 농업지원-영농일지 내 일지 페이징 목록조회를 위한 진입페이지
	@RequestMapping("main")
	public String main(Model model) {

		logger.debug("/finalProject/main 진입");

		model.addAttribute("farmdiaryList", fsurpportService.selectAllFsurpportList());
		model.addAttribute("workstepsList", fsurpportService.selectAllWstep_codeList());
		model.addAttribute("itemsList", fsurpportService.selectAllItem_codeList());

		return "tiles.fsurpport.fsurpportMain";
	}

	// ggy_20210303 : 농업지원-영농일지 내 일지 목록 검색
	@RequestMapping(path = "searchAllFsurpportList", method = { RequestMethod.POST })
	public String searchAllFsurpportList(HttpServletRequest req, Model model) {
		logger.debug("searchAllFsurpportList 진입");

		FarmdiaryVo farmdiaryVo = new FarmdiaryVo();

		if (req.getParameter("startDate") != null && !req.getParameter("startDate").equals("")) {
			logger.debug("1");
			farmdiaryVo.setStartDate(req.getParameter("startDate").replace("-", ""));
		} else {
			logger.debug("-1");
			farmdiaryVo.setStartDate("");
		}

		if (req.getParameter("endDate") != null && !req.getParameter("endDate").equals("")) {
			logger.debug("2");
			farmdiaryVo.setEndDate(req.getParameter("endDate").replace("-", ""));
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

		if (req.getParameter("wstep_code") != null && !req.getParameter("wstep_code").equals("")) {
			logger.debug("4");
			farmdiaryVo.setWstep_code(req.getParameter("wstep_code"));
		} else {
			logger.debug("-4");
			farmdiaryVo.setWstep_code("");
		}

		if (farmdiaryVo.getStartDate() != null && !farmdiaryVo.getStartDate().equals("")
				&& farmdiaryVo.getEndDate() != null && !farmdiaryVo.getEndDate().equals("")) {
			logger.debug("값 있으니 searchAllFarmdiaryList로 DB 조회");
			model.addAttribute("farmdiaryList", fsurpportService.searchAllFarmdiaryList(farmdiaryVo));

			model.addAttribute("workstepsList", fsurpportService.selectAllWstep_codeList());
			model.addAttribute("itemsList", fsurpportService.selectAllItem_codeList());

			return "tiles.fsurpport.fsurpportMain";
		} else {
			logger.debug("값 없으니 redirect main");
			return "redirect:/fsurpport/main";
		}
	}

	// ggy_20210302 : 농업지원-영농일지 내 일지 등록을 위한 진입페이지
	@RequestMapping("insertView")
	public String insertView() {

		return "tiles.fsurpport.fsurpportInsert";
	}

	// ggy_20210302 : 농업지원-영농일지 내 일지 상세조회를 위한 진입페이지
	@RequestMapping("infoView")
	public String infoView() {

		return "tiles.fsurpport.fsurpportInfo";
	}

	// ggy_20210302 : 농업지원-영농일지 내 일지 간편등록를 위한 진입페이지
	@RequestMapping("simpleInsertView")
	public String simpleInsertView() {

		return "tiles.fsurpport.fsurpportSimpleInsert";
	}
	
	// ggy_20210304 : 농업지원-영농일지 내 일지 수정을 위한 진입페이지
	@RequestMapping("ModifyView")
	public String ModifyView() {
		
		return "tiles.fsurpport.fsurpportModify";
	}
	
	
	
	
	
	
	

	/* 시설관리 영역 */

	// KJH_20210302
	// 농업양식 - 시설관리 관리중인 시설 리스트 조회페이지
	@RequestMapping("facilityList")
	public String facilityList(Model model) {

		List<FcltmngVo> fcltmngList = fsurpportService.myfcltmngList();

		model.addAttribute("fcltmngList", fcltmngList);

		return "tiles.fsurpport.facilityList";
	}

	// KJH_20210302
	// 농업양식 - 시설관리 관리중인 시설 상세 조회페이지
	@RequestMapping("facilityInfo")
	public String facility(Model model, FcltmngVo facility) {
		logger.debug(facility.getControl_no());
		FcltmngVo vo = fsurpportService.fcltmngInfo(facility.getControl_no());

		model.addAttribute("facility", vo);

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
