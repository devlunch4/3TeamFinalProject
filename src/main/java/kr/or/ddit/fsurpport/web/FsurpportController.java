package kr.or.ddit.fsurpport.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.fsurpport.service.FsurpportServiceImpl;

@RequestMapping("fsurpport")
@Controller
public class FsurpportController {
	
	private static final Logger logger = LoggerFactory.getLogger(FsurpportController.class);
	
	@Resource(name="fsurpportService")
	private FsurpportServiceImpl fsurpportService;
	
	// 농업지원-영농일지 내 일지 목록조회를 위한 진입페이지
	@RequestMapping("main")
	public String main(Model model) {
		return "tiles.fsurpport.fsurpportMain";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}





