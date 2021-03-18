package kr.or.ddit.fcommunity.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.farm.model.MiniMarketVo;
import kr.or.ddit.fcommunity.service.FcommunityServiceImpl;

// 20210318_ggy : 미니장터 controller 생성
@RequestMapping("fcommunity")
@Controller
public class FcommunityController {
	
	private static final Logger logger = LoggerFactory.getLogger(FcommunityController.class);
	
	@Resource(name = "fcommunityService")
	private FcommunityServiceImpl fcommunityService;
	
	// 20210318_ggy : 미니장터 조회
	@RequestMapping("miniMarketView")
	public String miniMarketView(Model model) {
		
		logger.debug("IN miniMarketView()");
		
		model.addAttribute("miniMarketList", fcommunityService.selectAllMiniMarketList());
		
		return "tiles.fcommunity.miniMarketMain";
	}
	
	// 20210318_ggy : 미니장터 상세 조회
	@RequestMapping("miniMarketInfoView")
	public String miniMarketInfoView( String writer, int market_no, Model model) {
		
		logger.debug("selectMiniMarketInfo 진입");
		
		MiniMarketVo miniMarketVo = new MiniMarketVo();
		miniMarketVo.setMarket_no(market_no);
		miniMarketVo.setWriter(writer);
		
//		model.addAttribute("miniMarketInfo", fcommunityService.miniMarketInfo());
		
		return "tiles.fcommunity.miniMarketInfo";
	}
	
	// 20210318_ggy : 미니장터 게시글 등록을 위한 진입
	@RequestMapping("registMiniMarketView")
	public String registMiniMarketView() {

		logger.debug("registMiniMarketView 진입");

		return "tiles.fcommunity.registMiniMarket";
	}
	
	
	
	
}
