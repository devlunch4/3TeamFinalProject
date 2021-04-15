package kr.or.ddit.fnotice.web;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.farm.model.FnoticeVo;
import kr.or.ddit.notice.service.FnoticeService;

@RequestMapping("fnotice")
@Controller
public class FnoticeController {

	private static final Logger logger = LoggerFactory.getLogger(FnoticeController.class);

	@Resource(name = "FnoticeService")
	private FnoticeService fnoticeService;

	// 20210311 모든 공지사항 조회하는거 (수정/경찬) + 로거추가KWS
	@RequestMapping(path = "noticesView", method = RequestMethod.GET)
	public String allNoticeList(Model model) {
		logger.debug("IN allNoticeList");
		List<FnoticeVo> noticeList = fnoticeService.selectAllNoticeList();
		model.addAttribute("noticeList", noticeList);
		return "tiles.fcommunity.noticesMain";
	}

	// 20210315 공지사항 상세정보 (경찬) + 로거추가KWS
	@RequestMapping("noticesInfoView")
	public String noticesInfoView(Model model, int notice_no) {
		logger.debug("IN noticesInfoView");
		FnoticeVo notice = fnoticeService.selcetNotice(notice_no);
		model.addAttribute("notice", notice);
		return "tiles.fcommunity.noticesInfo";
	}

	// 20210315 공지사항 수정 (경찬) + 로거추가KWS
	@RequestMapping("noticesModify")
	public String noticesModify(Model model, int notice_no) {
		logger.debug("IN noticesModify()");
		FnoticeVo notice = fnoticeService.selcetNotice(notice_no);
		model.addAttribute("notice", notice);
		return "tiles.fcommunity.noticesModify";
	}

	// 20210319 공지사항 수정 (경찬) + 로거추가KWS
	@RequestMapping("noticesModify2")
	public String noticesModify2(FnoticeVo notice, int notice_no) {
		logger.debug("IN noticesModify2()");
		notice = fnoticeService.selcetNotice(notice_no);
		return "tiles.fcommunity.noticesMain";
	}

	// 20210315 공지사항 삭제 (경찬)+ 로거추가KWS
	@RequestMapping("noticesDelete")
	public String noticesDelete(int notice_no, Model model) {
		logger.debug("IN noticesDelete()");
		logger.debug("노틱스 번호는 : {}", notice_no);
		List<FnoticeVo> noticeList = fnoticeService.selectAllNoticeList();
		fnoticeService.deletenotice(notice_no);
		model.addAttribute("noticeList", noticeList);
		return "tiles.fcommunity.noticesMain";
	}

	// 20210316 공지사항 등록 (경찬)+ 로거추가KWS
	@RequestMapping("insertNotice")
	public String insertNotice() {
		logger.debug("IN insertNotice()");
		return "tiles.fcommunity.noticeRegist";
	}

	// 20210316 공지사항 등록 (경찬)+ 로거추가KWS
	@RequestMapping("insertNotice2")
	public String insertNotice2(FnoticeVo noticeVO, Model model) {
		logger.debug("IN insertNotice2()");
		// KWS20210331 기존 경찬 코드 오류 수정
		fnoticeService.insertNotice(noticeVO);
		List<FnoticeVo> noticeList = fnoticeService.selectAllNoticeList();
		model.addAttribute("noticeList", noticeList);
		return "tiles.fcommunity.noticesMain";
	}
}
