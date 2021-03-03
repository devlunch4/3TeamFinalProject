package kr.or.ddit.fsurpport.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.farm.model.FcltmngVo;
import kr.or.ddit.fsurpport.service.FsurpportService;

@RequestMapping("fsurpport")
@Controller
public class FsurpportController {

	private static final Logger logger = LoggerFactory.getLogger(FsurpportController.class);

	@Resource(name = "fsurpportService")
	private FsurpportService fsurpportService;

	// ggy_20210227 : 농업지원-영농일지 내 일지 목록조회를 위한 진입페이지
	@RequestMapping("main")
	public String main(Model model) {

//		model.addAttribute("farmdiaryList",fsurpportService.selectAllFsurpportList());
//		model.addAttribute("workstepsList",fsurpportService.selectAllWorkstepsList());
//		model.addAttribute("itemsList",fsurpportService.selectAllItemsList());

		return "tiles.fsurpport.fsurpportMain";
	}

	// ggy_20210227 : 농업지원-영농일지 내 일지 목록 검색
	@RequestMapping("searchAllFsurpportList")
	public String searchAllFsurpportList(HttpServletRequest req, Model model) {
		logger.debug("in searchAllFsurpportList()");

		FarmdiaryVo farmdiaryVo = new FarmdiaryVo();

		if (req.getParameter("startDate") != null) {
			farmdiaryVo.setStartDate(req.getParameter("startDate").replace("-", ""));
		} else {
			model.addAttribute("farmdiaryList", fsurpportService.searchAllFsurpportList(farmdiaryVo));
			model.addAttribute("workstepsList", fsurpportService.selectAllWorkstepsList());
			model.addAttribute("itemsList", fsurpportService.selectAllItemsList());
			return "tiles.fsurpport.fsurpportMain";
		}

		if (req.getParameter("endDate") != null) {
			farmdiaryVo.setEndDate(req.getParameter("endDate").replace("-", ""));
		} else {
			model.addAttribute("farmdiaryList", fsurpportService.searchAllFsurpportList(farmdiaryVo));
			model.addAttribute("workstepsList", fsurpportService.selectAllWorkstepsList());
			model.addAttribute("itemsList", fsurpportService.selectAllItemsList());

			return "tiles.fsurpport.fsurpportMain";
		}

		if (req.getParameter("item_code") != null) {
			farmdiaryVo.setItem_code(0);
		} else {
			farmdiaryVo.setItem_code(Integer.parseInt(req.getParameter("item_code")));
		}

		if (req.getParameter("wstep_code") != null) {
			farmdiaryVo.setWstep_code(0);
		} else {
			farmdiaryVo.setWstep_code(Integer.parseInt(req.getParameter("wstep_code")));
		}

		model.addAttribute("farmdiaryList", fsurpportService.searchAllFsurpportList(farmdiaryVo));
		model.addAttribute("workstepsList", fsurpportService.selectAllWorkstepsList());
		model.addAttribute("itemsList", fsurpportService.selectAllItemsList());

		return "tiles.fsurpport.fsurpportMain";
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
	
	
	/*시설관리 영역*/
	
	//KJH_20210302
	//농업양식 - 시설관리 관리중인 시설 리스트 조회페이지
	@RequestMapping("facilityList")
	public String facilityList(Model model) {
		
		List<FcltmngVo> fcltmngList =  fsurpportService.myfcltmngList();
		
		model.addAttribute("fcltmngList", fcltmngList);

		return "tiles.fsurpport.facilityList";
	}
	
	//KJH_20210302
	//농업양식 - 시설관리 관리중인 시설 상세 조회페이지
	@RequestMapping("facilityInfo")
	public String facility(Model model, FcltmngVo facility) {
		logger.debug(facility.getControl_no());
		FcltmngVo vo = fsurpportService.fcltmngInfo(facility.getControl_no());
		
		model.addAttribute("facility", vo);

		return "tiles.fsurpport.facilityInfo";
	}
	
	//KJH_20210302
	//농업양식 - 시설관리 관리중인 시설 등록 페이지
	@RequestMapping("facilityInsert")
	public String facilityInsert() {

		return "tiles.fsurpport.facilityInsert";
	}
	
	//KJH_20210302
	//농업양식 - 시설관리 관리중인 시설 업데이트 페이지
	@RequestMapping("facilityupdate")
	public String facilityupdate() {

		return "tiles.fsurpport.facilityupdate";
	}
}
