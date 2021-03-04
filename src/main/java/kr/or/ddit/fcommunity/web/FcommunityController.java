package kr.or.ddit.fcommunity.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("fcommunity")
@Controller
public class FcommunityController {
	
	private static final Logger logger = LoggerFactory.getLogger(FcommunityController.class);
	
	// ggy_20210304 : 커뮤니티 공지사항 진입
	@RequestMapping("noticesView") 
	public String noticesView(Model model) {
		
		logger.debug("IN noticesView()");
		
		return "tiles.fcommunity.noticesMain";
	}
	
	// ggy_20210304 : 커뮤니티 공지사항 상세정보 진입
	@RequestMapping("noticesInfoView") 
	public String noticesInfoView(Model model) {
		
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
		
		logger.debug("IN minimarketView()");
		
		return "tiles.fcommunity.minimarketMain";
	}
	
	// ggy_20210304 : 커뮤니티 미니장터 상세정보 진입
	@RequestMapping("minimarketInfoView")
	public String minimarketInfoView(Model model) {

		logger.debug("IN noticesInfoView()");

		return "tiles.fcommunity.minimarketInfo";
	}
	
	// ggy_20210304 : 커뮤니티 미니장터 수정 페이지 진입
	@RequestMapping("minimarketModifyView")
	public String minimarketModify퍋ㅈ(Model model) {
		
		logger.debug("IN noticesInfoView()");
		
		return "tiles.fcommunity.minimarketModify";
	}
	
	// ggy_20210304 : 커뮤니티 미니장터 글 작성 페이지 진입
	@RequestMapping("minimarketRegistView")
	public String minimarketRegist퍋ㅈ(Model model) {
		
		logger.debug("IN noticesInfoView()");
		
		return "tiles.fcommunity.minimarketRegist";
	}
	
	
	
}
