package kr.or.ddit.fcommunity.web;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.farm.model.FnoticeVo;
import kr.or.ddit.fcommunity.service.FcommunityService;
import kr.or.ddit.notice.service.FnoticeService;

@RequestMapping("fcommunity")
@Controller
public class FcommunityController {

	private static final Logger logger = LoggerFactory.getLogger(FcommunityController.class);

	@Resource(name = "FcommuintyService")
	private FcommunityService commuityService;

	@Resource(name = "FnoticeService")
	private FnoticeService fnoticeService;

	// ggy_20210304 : 커뮤니티 공지사항 진입
	// 20210311 모든 공지사항 조회하는거 (수정/경찬)
	@RequestMapping(path = "noticesView", method = RequestMethod.GET)
	public String allNoticeList(Model model) {

		List<FnoticeVo> noticeList = fnoticeService.selectAllNoticeList();

		model.addAttribute("noticeList", noticeList);

		return "tiles.fcommunity.noticesMain";
	}

	// ggy_20210304 : 커뮤니티 공지사항 상세정보 진입
	@RequestMapping("noticesInfoView")
	public String noticesInfoView(Model model, int notice_no) {

		FnoticeVo notice = fnoticeService.selcetNotice(notice_no);

		model.addAttribute("notice", notice);
		return "tiles.fcommunity.noticesInfo";
	}

	// ggy_20210304 : 커뮤니티 공지사항 수정 진입
	@RequestMapping("noticesModify")
	public String noticesModify(Model model) {

		logger.debug("IN noticesModify()");

		return "tiles.fcommunity.noticesModify";
	}

	// --------------------------문의사항

	// 20210309_LYS_Q&A : 커뮤니티 문의사항 페이지 진입
	@RequestMapping(path = "qnaView")
	public String qnaView() {
		logger.debug("IN minimarketView()");

		return "tiles.fcommunity.qnaMain";

	}

}
