package kr.or.ddit.fcommunity.web;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.common.model.FilesVo;
import kr.or.ddit.farm.model.MiniMarketVo;
import kr.or.ddit.fcommunity.service.FcommunityServiceImpl;
import kr.or.ddit.fsurpport.service.FsurpportServiceImpl;

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
	public String registMiniMarketView(Model model) {

		logger.debug("registMiniMarketView 진입");
		
		model.addAttribute("miniMarketList", fcommunityService.selectMiniMarketList());
		
		return "tiles.fcommunity.registMiniMarket";
	}
	
	// 20210318_ggy : 미니장터 게시글 등록을 위한 진입
	@RequestMapping(path = "registMiniMarket", method = { RequestMethod.POST })
	public String registMiniMarket(
			HttpServletRequest req, 
			MultipartFile thumbnail_file, 
			MultipartFile file_file1, 
			MultipartFile file_file2, 
			MultipartFile file_file3, 
			Model model) {
		
		logger.debug("registMiniMarket 진입");
		
		MiniMarketVo miniMarketVo = new MiniMarketVo();
		
		FilesVo filesVo = new FilesVo();
		
		
		// 썸네일 파일 등록
		if (thumbnail_file.getSize() > 0) {

			logger.debug("file 있다.");

			String path = "c:\\fdown\\miniMarket\\";

			try {

				thumbnail_file.transferTo(new File(path + thumbnail_file.getOriginalFilename()));

				filesVo.setFile_nm("");
				filesVo.setFile_nm(thumbnail_file.getOriginalFilename());
				filesVo.setFile_path(path + filesVo.getFile_nm());
				} catch (IllegalStateException | IOException e) {
					filesVo.setFile_nm("");
			}

			int registFilesCnt = fsurpportService.registFiles(filesVo);

			logger.debug("registFilesCnt : " + registFilesCnt);

			miniMarketVo.setThumbnail(path);

		} else {
			logger.debug("파일없다.");
			itemmanualVo.setFile_no(0);
		}


		return"tiles.fcommunity.registMiniMarket";
	}	
	
	
	
}
