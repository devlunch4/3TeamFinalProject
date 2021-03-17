package kr.or.ddit.qna.web;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.qna.service.QnaService;

@RequestMapping("qna")
@Controller
public class QnaController {

	private static final Logger logger = LoggerFactory.getLogger(QnaController.class);

	@Resource(name = "QnaService")
	private QnaService qnaService;

	// 20210309_LYS_Q&A : 커뮤니티 문의사항 페이지 진입
	@RequestMapping(path = "view")
	public String view(String user_id, Model model) {
		logger.debug("IN View() Q&A");
		
		/*if(user_id != null) {*/
			model.addAttribute("qna", qnaService.selectAllQna());
//		}
		return "tiles.fcommunity.qnaMain";
	}

}
