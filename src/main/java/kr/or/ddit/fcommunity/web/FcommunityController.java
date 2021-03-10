package kr.or.ddit.fcommunity.web;

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

import kr.or.ddit.farm.model.FcommunityVo;
import kr.or.ddit.farm.model.FilesVo;
import kr.or.ddit.farm.model.MarketFilesVo;
import kr.or.ddit.fcommunity.service.FcommunityServiceImpl;
import kr.or.ddit.fcommunityfiles.service.FilesServiceImpl;
import kr.or.ddit.fileutill.FileUtil;
import kr.or.ddit.marketfiles.service.MarketFilesServiceImpl;

@RequestMapping("fcommunity")
@Controller
public class FcommunityController {
	
	private static final Logger logger = LoggerFactory.getLogger(FcommunityController.class);
	
	@Resource(name = "FcommuintyService")
	private FcommunityServiceImpl commuityService;
	
	@Resource(name = "filesService")
	private FilesServiceImpl filesService;
	
	@Resource(name = "marketfilesService")
	private MarketFilesServiceImpl marketfilesService;
	
	// ggy_20210304 : 커뮤니티 공지사항 진입
	@RequestMapping("noticesView") 
	public String noticesView(Model model) {
		
		
		logger.debug("IN noticesView()");
		
		return "tiles.fcommunity.noticesMain";
	}
	
	
	
	// ggy_20210304 : 커뮤니티 공지사항 상세정보 진입
	@RequestMapping("noticesInfoView") 
	public String noticesInfoView(Model model,RedirectAttributes ra) {
		
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
		
		logger.debug("정보",commuityService.selectmarket());
		model.addAttribute("noticelist", commuityService.selectmarket());
		
		logger.debug("IN minimarketView()");
		
		return "tiles.fcommunity.minimarketMain";
	}
	
	// ggy_20210304 : 커뮤니티 미니장터 상세정보 진입
	@RequestMapping("minimarketInfoView")
	public String minimarketInfoView(Model model, int market_no) {
		
		model.addAttribute("detaillist",commuityService.selectonemarket(market_no));
		
		logger.debug("IN minimarketInfoView()");
		logger.debug("{}",market_no);

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
		public String minimarketRegist(Model model, FcommunityVo coVo, FilesVo filesVo, MarketFilesVo mkVo ,MultipartFile file) {
			
			int MarketInsert = 0;
			int FilesInsert = 0;
			int MarketFilesInsert = 0;
			
			logger.debug("IN minimarketRegistView()");
			
			filesVo.setFile_nm(file.getOriginalFilename());
			filesVo.setFile_path(file.getOriginalFilename());
			
			try {
				String fileExtension = FileUtil.getFileExtension(file.getOriginalFilename());
				String realFileName = "c:\\fdown\\" + UUID.randomUUID().toString()+fileExtension;
				
				file.transferTo(new File(realFileName));
				filesVo.setFile_nm(file.getOriginalFilename());
				
				filesVo.setFile_path(file.getOriginalFilename());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			MarketInsert = commuityService.registermarket(coVo);
			FilesInsert = filesService.registerfiles(filesVo);
			MarketFilesInsert = marketfilesService.registerfiles(mkVo);
			
			
			return "tiles.fcommunity.minimarketRegist";
		}
	
	
	
}
