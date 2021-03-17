package kr.or.ddit.qna.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.farm.model.QnaVo;
import kr.or.ddit.qna.service.QnaService;

@RequestMapping("qna")
@Controller
public class QnaController {

	private static final Logger logger = LoggerFactory.getLogger(QnaController.class);

	@Resource(name = "QnaService")
	private QnaService qnaService;

	// 20210309_LYS_Q&A : 커뮤니티 문의사항 페이지 진입
	@RequestMapping(path = "view")
	public String View(String user_id, Model model) {
		logger.debug("IN View() Q&A");
		
		model.addAttribute("qnaList", qnaService.selectAllQna());
		return "tiles.fcommunity.qnaMain";
	}
	
	
	//20210317_LYS_Q&A4 : 문의게시판 상세조회 페이지 진입
	@RequestMapping(path = "detailView", method = RequestMethod.GET)
	public String DetailView(Model model, int qna_no) {
		logger.debug("IN DetailView() 문의사항 상세조회 페이지");
		
		//qna_no를 파라미터로 상세조회 페이지 진입할때 쿼리문 실행
		QnaVo qnaVo = (QnaVo)qnaService.selectOneListQna(qna_no);
		logger.debug("IN DetailView() qnaVo : {}", qnaVo);
		
		//qnaInfoBody.jsp에서 qnaVo 가져오기위해서
		model.addAttribute("qna", qnaVo);
		logger.debug("IN DetailView() 문의사항 상세조회 페이지 qna_no : {}", qna_no);
		
		return "tiles.fcommunity.qnaInfo";
	}
	

}
