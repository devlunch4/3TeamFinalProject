package kr.or.ddit.fsurpport.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.fsurpport.service.FsurpportService;

@RequestMapping("fsurpport")
@Controller
public class FsurpportController {

	private static final Logger logger = LoggerFactory.getLogger(FsurpportController.class);

	@Resource(name = "fsurpportService")
	private FsurpportService fsurpportService;

	// ggy_20210302 : 농업지원-영농일지 내 일지 페이징 목록조회를 위한 진입페이지
	@RequestMapping("main")
	public String main( Model model ) {
		
		logger.debug("/finalProject/main 진입");
		
		model.addAttribute("farmdiaryList", fsurpportService.selectAllFsurpportList());
		model.addAttribute("workstepsList", fsurpportService.selectAllWstep_codeList());
		model.addAttribute("itemsList", fsurpportService.selectAllItem_codeList());
		
		return "tiles.fsurpport.fsurpportMain";
	}
//	@RequestMapping("main")
//	public String main( 
//			@RequestParam( defaultValue = "1") int page, 
//			@RequestParam( defaultValue = "5" )int pageSize,
//			Model model) {
//		
//		logger.debug("/finalProject/main 진입");
//		
//		PageVo pageVo = new PageVo(page, pageSize);
////		
//		model.addAllAttributes(fsurpportService.selectPagingFarmdiary(pageVo));
//		model.addAttribute("workstepsList", fsurpportService.selectAllWstep_codeList());
//		model.addAttribute("itemsList", fsurpportService.selectAllItem_codeList());
//		
//		return "tiles.fsurpport.fsurpportMain";
//	}

	// ggy_20210303 : 농업지원-영농일지 내 일지 목록 검색
	@RequestMapping("searchAllFsurpportList")
	public String searchAllFsurpportList(
			HttpServletRequest req,
			@RequestParam( defaultValue = "1") int page, 
			@RequestParam( defaultValue = "5" )int pageSize,
			Model model) {
		logger.debug("in searchAllFsurpportList()");
		
		FarmdiaryVo farmdiaryVo = new FarmdiaryVo();

		if (req.getParameter("startDate") != null) {
			farmdiaryVo.setStartDate(req.getParameter("startDate").replace("-", ""));
		} else {
			model.addAttribute("farmdiaryList", fsurpportService.searchAllFarmdiaryPagingList(farmdiaryVo));
			model.addAttribute("workstepsList", fsurpportService.selectAllWstep_codeList());
			model.addAttribute("itemsList", fsurpportService.selectAllItem_codeList());
			return "tiles.fsurpport.fsurpportMain";
		}

		if (req.getParameter("endDate") != null) {
			farmdiaryVo.setEndDate(req.getParameter("endDate").replace("-", ""));
		} else {
			model.addAttribute("farmdiaryList", fsurpportService.searchAllFarmdiaryPagingList(farmdiaryVo));
			model.addAttribute("workstepsList", fsurpportService.selectAllWstep_codeList());
			model.addAttribute("itemsList", fsurpportService.selectAllItem_codeList());

			return "tiles.fsurpport.fsurpportMain";
		}

		if (req.getParameter("item_code") != null) {
			farmdiaryVo.setItem_code("0");
		} else {
			farmdiaryVo.setItem_code(req.getParameter("item_code"));
		}

		if (req.getParameter("wstep_code") != null) {
			farmdiaryVo.setWstep_code("0");
		} else {
			farmdiaryVo.setWstep_code(req.getParameter("wstep_code"));
		}
		
			
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
	
	// ggy_20210302 : 농업지원-영농일지 내 일지 간편등록를 위한 진입페이지
	@RequestMapping("simpleInsertView")
	public String simpleInsertView() {
		
		return "tiles.fsurpport.fsurpportSimpleInsert";
	}
	
	

}
