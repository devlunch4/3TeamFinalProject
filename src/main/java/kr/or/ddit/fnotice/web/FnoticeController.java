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

	// 20210311 모든 공지사항 조회하는거 (수정/경찬)
	@RequestMapping(path = "noticesView", method = RequestMethod.GET)
	public String allNoticeList(Model model) {

		List<FnoticeVo> noticeList = fnoticeService.selectAllNoticeList();

		model.addAttribute("noticeList", noticeList);

		return "tiles.fcommunity.noticesMain";
	}

	// 20210315 공지사항 상세정보 (경찬)
	@RequestMapping("noticesInfoView")
	public String noticesInfoView(Model model, int notice_no) {

		FnoticeVo notice = fnoticeService.selcetNotice(notice_no);

		model.addAttribute("notice", notice);
		return "tiles.fcommunity.noticesInfo";
	}

	// 20210315 공지사항 수정 (경찬)
	@RequestMapping("noticesModify")
	public String noticesModify(Model model) {

		logger.debug("IN noticesModify()");

		return "tiles.fcommunity.noticesModify";
	}

	// 20210315 공지사항 삭제 (경찬)
	@RequestMapping("noticesDelete")
	public String noticesDelete(int notice_no, Model model) {

		logger.debug("노틱스 번호는 : {}", notice_no);

		List<FnoticeVo> noticeList = fnoticeService.selectAllNoticeList();

		fnoticeService.deletenotice(notice_no);

		model.addAttribute("noticeList", noticeList);

		return "tiles.fcommunity.noticesMain";
	}

	// 20210316 공지사항 등록 (경찬)
	@RequestMapping("insertNotice")
	public String insertNotice(FnoticeVo noticeVO, Model model) {
		
		
		return "";
	}

}
