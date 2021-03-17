package kr.or.ddit.fcommunity.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.fcommunity.service.FcommunityService;

@RequestMapping("fcommunity")
@Controller
public class FcommunityController {

	private static final Logger logger = LoggerFactory.getLogger(FcommunityController.class);

	@Resource(name = "FcommuintyService")
	private FcommunityService commuityService;

	// --------------------------문의사항

	// 20210309_LYS_Q&A : 커뮤니티 문의사항 페이지 진입
	@RequestMapping(path = "qnaView")
	public String qnaView() {
		logger.debug("IN minimarketView()");

		return "tiles.fcommunity.qnaMain";

	}

}
