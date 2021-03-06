package kr.or.ddit.qna.web;

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
import kr.or.ddit.user.model.UserVo;

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

	// 20210317_LYS_Q&A4 : 문의게시판 상세조회 페이지 진입
	@RequestMapping(path = "detailView", method = RequestMethod.GET)
	public String DetailView(Model model, int qna_no) {
		logger.debug("IN DetailView() 문의사항 상세조회 페이지 진입 & 글번호 : {}", qna_no);

		// 문의게시판 상세페이지 이동시 조회수 상승 쿼리문 실행
		qnaService.updateHitCnt(qna_no);

		// qna_no를 파라미터로 상세조회 페이지 진입할때 쿼리문 실행
		QnaVo qnaVo = (QnaVo) qnaService.selectOneListQna(qna_no);
		logger.debug("IN DetailView() qnaVo : {}", qnaVo);

		// qnaInfoBody.jsp에서 qnaVo 가져오기위해서
		model.addAttribute("qna", qnaVo);
		logger.debug("IN DetailView() 문의사항 상세조회 페이지 qna_no : {}", qna_no);

		return "tiles.fcommunity.qnaInfo";
	}

	// 20210317_LYS_Q&A4 : 문의게시판 글 등록페이지 진입
	@RequestMapping(path = "qnaRegistView", method = RequestMethod.GET)
	public String QnaRegistView(HttpSession session) {
		logger.debug("IN QnaRegistView() 문의게시판 등록 페이지 진입");

		UserVo dbUser = (UserVo) session.getAttribute("S_USER");

		if (dbUser != null) {
			return "tiles.fcommunity.qnaRegist";
		} else {
			return "redirect:/qna/view";
		}
	}

	// 20210317_LYS_Q&A4 : 문의게시판 글 등록
	@RequestMapping(path = "qnaRegist", method = RequestMethod.POST)
	public String QnaRegist(QnaVo qnaVo, Model model) {
		logger.debug("IN QnaRegist() 문의게시판 등록 / qnaVo : {}", qnaVo);
		logger.debug("content : {}", qnaVo.getContent());

		if (qnaVo.getTitle().equals("")) {
			model.addAttribute("msg", "제목을 입력해주세요.");
			model.addAttribute("url", "/qna/qnaRegistView");
			return "alert";
		}

		if (qnaVo.getContent().equals("")) {
			model.addAttribute("msg", "내용을 입력해주세요.");
			model.addAttribute("url", "/qna/qnaRegistView");
			return "alert";
		}

		int qnaRegistCnt = qnaService.insertQna(qnaVo);

		if (qnaRegistCnt == 1) {
			logger.debug("등록 완료");
			return "redirect:/qna/view";
		} else {
			return "tiles.fcommunity.qnaRegistView";
		}
	}

	// 20210322_LYS 문의게시판 답글 등록 페이지 진입- 관리자용
	@RequestMapping(path = "qnaRegistAdminReplyView", method = RequestMethod.GET)
	public String QnaRegistAdminReplyView(Model model, HttpSession session, int qna_no) {
		logger.debug("IN QnaRegistAdminReplyView() 문의게시판 관리자용 답글 등록 페이지 진입 qna_no : {}", qna_no);

		UserVo dbUser = (UserVo) session.getAttribute("S_USER");
		
		QnaVo qnaVo = (QnaVo) qnaService.selectOneListQna(qna_no);
		logger.debug("IN QnaRegistAdminReplyView() qnaVo : {}", qnaVo);

		model.addAttribute("qna", qnaVo);
		model.addAttribute("qna_no", qna_no);

		if (dbUser != null) {
			return "tiles.fcommunity.qnaRegistAdminReply";
		} else {
			return "redirect:/qna/view";
		}
	}

	// 20210322_LYS 문의게시판 답글 등록- 관리자용
	@RequestMapping(path = "qnaRegistAdminReply", method = RequestMethod.POST)
	public String QnaRegistAdminReply(Model model, QnaVo qnaVo) {
		logger.debug("IN QnaRegistAdminReply() 문의게시판 답글 등록 / qnaVo : {}", qnaVo);

		logger.debug("content : {}", qnaVo.getContent());

		int qnaRegistAdminReplyCnt = qnaService.insertQnaAdminReply(qnaVo);

		logger.debug("IN QnaRegistAdminReply() 문의게시판 답글 등록 / qnaRegistAdminReplyCnt : {}", qnaRegistAdminReplyCnt);
		if (qnaRegistAdminReplyCnt == 1) {
			logger.debug("답글 등록 완료");
			return "redirect:/qna/view";
		} else {
			return "tiles.fcommunity.qnaRegistAdminReplyView";
		}
	}

	// 20210319_LYS_Q&A5 문의게시판 게시글 수정페이지 진입
	@RequestMapping(path = "qnaModifyView", method = RequestMethod.GET)
	public String QnaModifyView(Model model, int qna_no) {
		logger.debug("IN QnaModify() 문의게시판 게시글 수정페이지");

		// qna_no를 파라미터로 상세조회 페이지 진입할때 쿼리문 실행
		QnaVo qnaVo = (QnaVo) qnaService.selectOneListQna(qna_no);
		logger.debug("IN DetailView() qnaVo : {}", qnaVo);

		// qnaModifyBody.jsp에서 qnaVo 가져오기위해서
		model.addAttribute("qna", qnaVo);
		logger.debug("IN DetailView() 문의사항 수정페이지 qna_no : {}", qna_no);

		return "tiles.fcommunity.qnaModify";
	}

	// 20210319_LYS_Q&A5 문의게시판 게시글 수정
	@RequestMapping(path = "qnaModify", method = RequestMethod.POST)
	public String QnaModify(Model model, QnaVo qnaVo) {
		logger.debug("IN QnaModify() 문의게시판 게시글 수정페이지");

		int qnaModifyCnt = qnaService.updateQna(qnaVo);

		if (qnaModifyCnt == 1) {
			logger.debug("수정 완료");
			return "redirect:/qna/view";
		} else {
			logger.debug("수정 실패");
			return "tiles.fcommunity.qnaModify";
		}
	}

	// 20210319_LYS_Q&A5 문의게시판 게시글 삭제
	@RequestMapping(path = "qnaDelete")
	public String QnaDelete(int qna_no) {

		int qnaDeleteCnt = qnaService.updateUseynToN(qna_no);

		if (qnaDeleteCnt == 1) {
			logger.debug("삭제 완료");
			return "redirect:/qna/view";
		} else {
			logger.debug("삭제 실패");
			return "tiles.fcommunity.qnaInfo";
		}
	}

}
