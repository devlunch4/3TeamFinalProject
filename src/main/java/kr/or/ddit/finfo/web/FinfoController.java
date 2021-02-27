package kr.or.ddit.finfo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 
 * @author KWS
 * 농업정보 부분 컨트롤러
 *
 */
@RequestMapping("finfo")
@Controller
public class FinfoController {
	private static final Logger logger = LoggerFactory.getLogger(FinfoController.class);

	
	@RequestMapping("gardenguides") //텃밭 가이드 (재배정보 진입)
	public String gardenguides(Model model) {
		logger.debug("IN gardenguides()");
		return "tiles.finfo.gardenguides";
	}

}
