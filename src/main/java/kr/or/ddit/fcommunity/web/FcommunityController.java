package kr.or.ddit.fcommunity.web;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.farm.model.FcommunityVo;
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
	// 20210311 모든 공지사항 조회하는거 수정 (경찬)
	@RequestMapping(path = "noticesView", method = RequestMethod.GET)
	public String allNoticeList(Model model) {
		List<FnoticeVo> noticeList = fnoticeService.selectAllNoticeList();
		logger.debug("노틱스리스트 : {} ", noticeList);
		model.addAttribute("noticeList", noticeList);
		return "tiles.fcommunity.noticesMain";
	}

	// ggy_20210304 : 커뮤니티 공지사항 상세정보 진입
	@RequestMapping("noticesInfoView")
	public String noticesInfoView(Model model, RedirectAttributes ra) {

		logger.debug("IN noticesInfoView()");

		return "tiles.fcommunity.noticesInfo";
	}

	// ggy_20210304 : 커뮤니티 공지사항 수정 진입
	@RequestMapping("noticesModify")
	public String noticesModify(Model model) {

		logger.debug("IN noticesModify()");

		return "tiles.fcommunity.noticesModify";
	}

	// ggy_20210304 : 커뮤니티 미니장터 진입
	@RequestMapping("minimarketView")
	public String minimarketView(Model model) {

		logger.debug("정보", commuityService.selectmarket());
		model.addAttribute("noticelist", commuityService.selectmarket());

		logger.debug("IN minimarketView()");

		return "tiles.fcommunity.minimarketMain";
	}

	// ggy_20210304 : 커뮤니티 미니장터 상세정보 진입
	@RequestMapping("minimarketInfoView")
	public String minimarketInfoView(Model model, int market_no) {

		model.addAttribute("detaillist", commuityService.selectonemarket(market_no));

		logger.debug("IN minimarketInfoView()");
		logger.debug("{}", market_no);

		return "tiles.fcommunity.minimarketInfo";
	}

	// ggy_20210304 : 커뮤니티 미니장터 수정 페이지 진입
	@RequestMapping("minimarketModifyView")
	public String minimarketModify(Model model) {

		logger.debug("IN minimarketModifyView()");

		return "tiles.fcommunity.minimarketModify";
	}

	// ggy_20210304 : 커뮤니티 미니장터 글 작성 페이지 진입
	@RequestMapping("minimarketRegistView")
	public String minimarketRegistView(Model model) {

		logger.debug("IN minimarketRegistView()");

		return "tiles.fcommunity.minimarketRegist";
	}

	// shs_20210309 : 커뮤니티 미니장터 글 작성
	@RequestMapping(path = "minimarketRegist", method = RequestMethod.POST)
	public String minimarketRegist(Model model, FcommunityVo coVo) {

		logger.debug("IN minimarketRegistView()");

		return "tiles.fcommunity.minimarketRegist";
	}

}
