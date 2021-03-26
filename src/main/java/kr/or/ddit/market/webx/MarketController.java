package kr.or.ddit.market.webx;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.farm.model.FilesVo;
import kr.or.ddit.farm.model.MarketVo;
import kr.or.ddit.fcommunityfiles.service.FilesService;
import kr.or.ddit.fileutill.FileUtil;
import kr.or.ddit.market.servicex.MarketService;
import kr.or.ddit.marketfiles.servicex.MarketFilesService;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserService;public class MarketController {

	private static final Logger logger = LoggerFactory.getLogger(MarketController.class);

	@Resource(name = "marketService")
	private MarketService marketService;

	@Resource(name = "filesService")
	private FilesService filesService;

	@Resource(name = "marketfilesService")
	private MarketFilesService marketfilesService;

	@Resource(name = "userService")
	private UserService userService;
	
	// ggy_20210304 : 커뮤니티 공지사항 진입
	@RequestMapping("noticesView")
	public String noticesView(Model model) {

		logger.debug("IN noticesView()");

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

		logger.debug("정보", marketService.selectmarket());
		model.addAttribute("noticelist", marketService.selectmarket());
		model.addAttribute("filelist",filesService.selectfiles());

		logger.debug("IN minimarketView()");

		return "tiles.fcommunity.minimarketMain";
	}
	
		// shs_20210313 : 미니장터 카테고리별 조회
		@RequestMapping(path = "minimarketkate", method = RequestMethod.POST)
		public String minimarketkate(Model model,int head_code) {
			
			model.addAttribute("noticelist",marketService.selectkate(head_code));
			model.addAttribute("filelist",filesService.selectfiles());
			model.addAttribute("returnHeadCode",head_code);

			return "tiles.fcommunity.minimarketMain";
		}

	// ggy_20210304 : 커뮤니티 미니장터 상세정보 진입
	@RequestMapping("minimarketInfoView")
	public String minimarketInfoView(Model model, int market_no) {

		model.addAttribute("detaillist", marketService.selectonemarket(market_no));
	

		logger.debug("IN minimarketInfoView()");
		logger.debug("{}", market_no);

		return "tiles.fcommunity.minimarketInfo";
	}

	// ggy_20210304 : 커뮤니티 미니장터 수정 페이지 진입
	@RequestMapping("minimarketModifyView")
	public String minimarketModifyView(Model model,int market_no) {

		model.addAttribute("detaillist1", marketService.selectonemarket(market_no));
		logger.debug("IN minimarketModifyView()");

		return "tiles.fcommunity.minimarketModify";
	}
	
		// ggy_20210304 : 커뮤니티 미니장터 수정완료
		@RequestMapping(path = "minimarketModify", method = RequestMethod.POST)
		public String minimarketModify(Model model, MarketVo coVo, FilesVo fileVo, MultipartFile file) {
				
			logger.debug("IN minimarketModifyView()");
			
			int marketcnt = 0;
			int filescnt = 0;

			logger.debug("IN minimarketRegistView()");
			fileVo.setFile_nm(file.getOriginalFilename());
			fileVo.setFile_path(file.getOriginalFilename());

			try {
				String fileExtension = FileUtil.getFileExtension(file.getOriginalFilename());
				String realFileName = "c:/upload/" + UUID.randomUUID().toString() + fileExtension;

				file.transferTo(new File(realFileName));
				fileVo.setFile_path(file.getOriginalFilename());

				fileVo.setFile_path(realFileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
			logger.debug("coVo : {}", coVo);
			marketcnt = marketService.modifymarket(coVo);
			logger.debug("쿼리문", filescnt);

			if (marketcnt == 1 && filescnt != 0) {
				logger.debug("업데이트 완료");
				return "redirect:/market/minimarketView";
			} else {
				return "tiles.fcommunity.minimarketModify";
			}

		}
		
	

	// ggy_20210304 : 커뮤니티 미니장터 글 작성 페이지 진입
	@RequestMapping("minimarketRegistView")
	public String minimarketRegistView(Model model) {
		
		

		logger.debug("IN minimarketRegistView()");
		model.addAttribute("market", marketService.selectmarket());

		return "tiles.fcommunity.minimarketRegist";
	}

	// shs_20210309 : 커뮤니티 미니장터 글 작성
	@RequestMapping(path = "minimarketRegist", method = RequestMethod.POST)
	public String minimarketRegist(Model model, MarketVo coVo, FilesVo fileVo, MultipartFile file) {

		int marketcnt = 0;
		int filescnt = 0;

		logger.debug("IN minimarketRegistView()");
		fileVo.setFile_nm(file.getOriginalFilename());
		fileVo.setFile_path(file.getOriginalFilename());

		try {
			String fileExtension = FileUtil.getFileExtension(file.getOriginalFilename());
			String realFileName = "c:/upload/" + UUID.randomUUID().toString() + fileExtension;

			file.transferTo(new File(realFileName));
			fileVo.setFile_path(file.getOriginalFilename());

			fileVo.setFile_path(realFileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.debug("coVo : {}", coVo);
		marketcnt = marketService.registermarket(coVo);
		filescnt = filesService.registerfiles(fileVo);
		logger.debug("쿼리문", filescnt);

		if (marketcnt == 1 && filescnt != 0) {
			logger.debug("업데이트 완료");
			return "redirect:/market/minimarketView";
		} else {
			return "tiles.fcommunity.minimarketRegist";
		}

	}

}
