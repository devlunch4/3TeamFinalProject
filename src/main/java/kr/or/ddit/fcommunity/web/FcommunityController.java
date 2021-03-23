package kr.or.ddit.fcommunity.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.common.model.FilesVo;
import kr.or.ddit.farm.model.MarketFilesVo;
import kr.or.ddit.farm.model.MiniMarketVo;
import kr.or.ddit.fcommunity.service.FcommunityService;
import kr.or.ddit.fsurpport.service.FsurpportService;

// 20210318_ggy : 미니장터 controller 생성
@RequestMapping("fcommunity")
@Controller
public class FcommunityController {
	
	private static final Logger logger = LoggerFactory.getLogger(FcommunityController.class);
	
	@Resource(name = "fcommunityService")
	private FcommunityService fcommunityService;
	
	@Resource(name = "fsurpportService")
	private FsurpportService fsurpportService;
	
	// 20210318_ggy : 미니장터 조회
	@RequestMapping("miniMarketView")
	public String miniMarketView(MiniMarketVo miniMarketVo, Model model) {
		
		logger.debug("IN miniMarketView()");
		
		
		model.addAttribute("miniMarketList", fcommunityService.selectAllMiniMarketList(miniMarketVo));
		model.addAttribute("itemList", fcommunityService.selectItemList());
		
		if(miniMarketVo.getItem_code() != null && !miniMarketVo.getItem_code().equals("")) {
			logger.debug("miniMarketVo.getItem_code()의 값 : {}", miniMarketVo.getItem_code());
			model.addAttribute("selectItemCodeValue", miniMarketVo.getItem_code());
			model.addAttribute("selectTitleValue", miniMarketVo.getTitle());
		}
		
		return "tiles.fcommunity.miniMarketMain";
	}
	
	// 20210318_ggy : 미니장터 상세 조회
	@RequestMapping("miniMarketInfoView")
	public String miniMarketInfoView( String writer, int market_no, Model model) {
		
		logger.debug("selectMiniMarketInfo 진입");
		
		MiniMarketVo miniMarketVo = new MiniMarketVo();
		miniMarketVo.setMarket_no(market_no);
		miniMarketVo.setWriter(writer);
		
		fcommunityService.addHitMiniMarket(market_no);
		
		model.addAttribute("miniMarketInfo", fcommunityService.miniMarketInfo(miniMarketVo));
		model.addAttribute("marketFileList",  fcommunityService.selectMarketFileList(market_no));
		
		return "tiles.fcommunity.miniMarketInfo";
	}
	
	// 20210318_ggy : 미니장터 게시글 등록을 위한 진입
	@RequestMapping("registMiniMarketView")
	public String registMiniMarketView(Model model) {

		logger.debug("registMiniMarketView 진입");
		
		model.addAttribute("miniMarketList", fcommunityService.selectMiniMarketList());
		model.addAttribute("itemList", fcommunityService.selectItemList());
		
		return "tiles.fcommunity.registMiniMarket";
	}
	
	// 20210318_ggy : 미니장터 게시글 등록
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
		
		miniMarketVo.setWriter(req.getParameter("writer"));
		miniMarketVo.setTitle(req.getParameter("title"));
		miniMarketVo.setMobile(req.getParameter("mobile"));
		miniMarketVo.setHead_code(req.getParameter("head_code"));
		miniMarketVo.setItem_code(req.getParameter("item_code"));
		miniMarketVo.setContent(req.getParameter("content"));
		miniMarketVo.setPrice(req.getParameter("price"));
		
		
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
					miniMarketVo.setThumbnail(0);
			}

			int registFilesCnt = fsurpportService.registFiles(filesVo);

			logger.debug("registFilesCnt : " + registFilesCnt);
			logger.debug("registFilesCnt 결과값 문자 확인 : "+Integer.toString(registFilesCnt));
			
			miniMarketVo.setThumbnail(registFilesCnt);
			

		} else {
			logger.debug("파일없다.");
			miniMarketVo.setThumbnail(0);
		}
		
		
		// 게시글 등록 후 게시글 번호 가져오기
		int registPostCnt = fcommunityService.registMiniMarketPost(miniMarketVo);
		
		MarketFilesVo marketFilesVo = new MarketFilesVo();
		
		// 첨부파일 등록 부분 
		if (file_file1.getSize() > 0) {

			logger.debug("file1 있다.");

			String path = "c:\\fdown\\miniMarket\\";

			try {

				file_file1.transferTo(new File(path + file_file1.getOriginalFilename()));

				filesVo.setFile_nm("");
				filesVo.setFile_nm(file_file1.getOriginalFilename());
				filesVo.setFile_path(path + filesVo.getFile_nm());
				
				int registFilesCnt = fsurpportService.registFiles(filesVo);
				
				logger.debug("registFilesCnt : " + registFilesCnt);
				marketFilesVo.setFile_no(registFilesCnt);
				
				marketFilesVo.setMarket_no(registPostCnt);
				
				logger.debug("등록전 값 게기글 번호 : {}, 파일 번호 : {}", marketFilesVo.getMarket_no(), marketFilesVo.getFile_no());
				int registmarketfilesCnt =  fcommunityService.registmarketfiles(marketFilesVo);
				
				logger.debug("file_file1 등록 : "+ registmarketfilesCnt);
			} catch (IllegalStateException | IOException e) {
				filesVo.setFile_nm("");
			}
			
		} else {
			logger.debug("첨부 파일없다.");
		}
		
		if (file_file2.getSize() > 0) {

			logger.debug("file2 있다.");

			String path = "c:\\fdown\\miniMarket\\";

			try {

				file_file2.transferTo(new File(path + file_file2.getOriginalFilename()));

				filesVo.setFile_nm("");
				filesVo.setFile_nm(file_file2.getOriginalFilename());
				filesVo.setFile_path(path + filesVo.getFile_nm());
				
				int registFilesCnt = fsurpportService.registFiles(filesVo);

				logger.debug("registFilesCnt : " + registFilesCnt);
				marketFilesVo.setFile_no(registFilesCnt);
				
				marketFilesVo.setMarket_no(registPostCnt);
				
				logger.debug("등록전 값 게기글 번호 : {}, 파일 번호 : {}", marketFilesVo.getMarket_no(), marketFilesVo.getFile_no());
				int registmarketfilesCnt =  fcommunityService.registmarketfiles(marketFilesVo);
				
				logger.debug("file_file2 등록 : "+ registmarketfilesCnt);
				
			} catch (IllegalStateException | IOException e) {
				filesVo.setFile_nm("");
			}

		
			
		} else {
			logger.debug("첨부 파일없다.");
		}
		
		if (file_file3.getSize() > 0) {

			logger.debug("file3 있다.");

			String path = "c:\\fdown\\miniMarket\\";

			try {

				file_file3.transferTo(new File(path + file_file3.getOriginalFilename()));

				filesVo.setFile_nm("");
				filesVo.setFile_nm(file_file3.getOriginalFilename());
				filesVo.setFile_path(path + filesVo.getFile_nm());
				
				int registFilesCnt = fsurpportService.registFiles(filesVo);

				logger.debug("registFilesCnt : " + registFilesCnt);
				marketFilesVo.setFile_no(registFilesCnt);
				
				marketFilesVo.setMarket_no(registPostCnt);
				
				logger.debug("등록전 값 게기글 번호 : {}, 파일 번호 : {}", marketFilesVo.getMarket_no(), marketFilesVo.getFile_no());
				int registmarketfilesCnt =  fcommunityService.registmarketfiles(marketFilesVo);
				
				logger.debug("file_file3 등록 : "+ registmarketfilesCnt);
				
			} catch (IllegalStateException | IOException e) {
				filesVo.setFile_nm("");
			}

			
		} else {
			logger.debug("첨부 파일없다.");
		}
		
		logger.debug("미니장터 게시글 등록 종료");
		
		return"redirect:/fcommunity/miniMarketView";
	}	
	
	// ggy_20210320 : 파일 경로
	@RequestMapping("filePath")
	public void profile(HttpServletResponse resp, String file_nm, HttpServletRequest req) {

		logger.debug("filePath 진입");
		resp.setContentType("image");

		// userid 파라미터를 이용하여
		// userService 객체를 통해 사용자의 사진 파일 이름을 획득
		// 파일 입출력을 통해 사진을 읽어들여 resp객체의 outputStream으로 응답 생성

		String path = "";
		if (file_nm == null && !file_nm.equals("")) {
			logger.debug("file_nm이 null");

			path = req.getServletContext().getRealPath("c:\\fdown\\unknown.png");
			logger.debug("path : " + path);
		} else {

			logger.debug("file_nm이 null 아니다.");
			path = "c:\\fdown\\" + file_nm;
			logger.debug("path : " + path);
		}

		logger.debug("path : {}", path);

		try {

			FileInputStream fis = new FileInputStream(path);
			ServletOutputStream sos = resp.getOutputStream();

			byte[] buff = new byte[512];

			while (fis.read(buff) != -1) {

				sos.write(buff);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	// 20210322_ggy : 미니장터 게시글 수정을 위한 진입 및 상세 조회
	@RequestMapping("modifyMiniMarketView")
	public String modifyMiniMarketView(String writer, int market_no, Model model) {

		logger.debug("modifyMiniMarketView 진입");

		MiniMarketVo miniMarketVo = new MiniMarketVo();
		miniMarketVo.setMarket_no(market_no);
		miniMarketVo.setWriter(writer);

		fcommunityService.addHitMiniMarket(market_no);

		model.addAttribute("miniMarketInfo", fcommunityService.miniMarketInfo(miniMarketVo));
//		model.addAttribute("marketFileList", fcommunityService.selectMarketFileList(market_no));
		model.addAttribute("itemList", fcommunityService.selectItemList());
		model.addAttribute("miniMarketList", fcommunityService.selectMiniMarketList());

		List<MarketFilesVo> marketFileList = new ArrayList<MarketFilesVo>();
		MarketFilesVo marketFilesVoList = new MarketFilesVo();
		marketFileList = fcommunityService.selectMarketFileList(market_no);
		
		logger.debug("modifyMiniMarketView에 리스트 값 세기전");
		
		if(marketFileList.size() < 3) {
			logger.debug("marketFileList의 사이즈는 3 이하이다.");
			if(marketFileList.size() == 2) {
				logger.debug("marketFileList의 사이즈는 2 이다.");
				marketFilesVoList.setFile_nm("");
				marketFileList.add(marketFilesVoList);
				logger.debug("리스트 값 확인 : {}", marketFileList.size());
			} else if(marketFileList.size() == 1) {
				logger.debug("marketFileList의 사이즈는 1 이다.");
				marketFilesVoList.setFile_nm("");
				marketFileList.add(marketFilesVoList);
				marketFileList.add(marketFilesVoList);
				logger.debug("리스트 값 확인 : {}", marketFileList.size());
				
			} else if(marketFileList.size() == 0) {
				logger.debug("marketFileList의 사이즈는 0 이다.");
				marketFilesVoList.setFile_nm("");
				marketFileList.add(marketFilesVoList);
				marketFileList.add(marketFilesVoList);
				marketFileList.add(marketFilesVoList);
				logger.debug("리스트 값 확인 : {}", marketFileList.size());
				
			}
			
		}
		
		model.addAttribute("marketFileList", marketFileList);
		
		
		return "tiles.fcommunity.modifyMiniMarket";
	}
	
	// 20210323_ggy : 미니장터 게시글 수정
	@RequestMapping(path = "modifyMiniMarket", method = { RequestMethod.POST })
	public String modifyMiniMarket(
			HttpServletRequest req, 
			MultipartFile thumbnail_file, 
			MultipartFile file_file1, 
			MultipartFile file_file2, 
			MultipartFile file_file3, 
			Model model) {
		
		logger.debug("modifyMiniMarket 진입");
		
		// 게시글 번호
		int market_no_value = Integer.parseInt(req.getParameter("market_no"));
		
		MiniMarketVo miniMarketVo = new MiniMarketVo();
		
		miniMarketVo.setMarket_no(market_no_value);
		miniMarketVo.setWriter(req.getParameter("writer"));
		miniMarketVo.setTitle(req.getParameter("title"));
		miniMarketVo.setMobile(req.getParameter("mobile"));
		miniMarketVo.setHead_code(req.getParameter("head_code"));
		miniMarketVo.setItem_code(req.getParameter("item_code"));
		miniMarketVo.setContent(req.getParameter("content"));
		miniMarketVo.setPrice(req.getParameter("price"));
		
		
		FilesVo filesVo = new FilesVo();
		
		// 썸네일 부분
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
				miniMarketVo.setThumbnail(0);
			}
			
			
			Map<String, String> map = new HashMap<String, String>();
	        map.put("file_nm", filesVo.getFile_nm());
	        map.put("market_no", Integer.toString(market_no_value));
	        
	        logger.debug("검색전 값 확인 1 : {}, 2 : {} ", map.get("file_nm"), map.get("market_no"));
	        
	        int selectCnt = fcommunityService.selectThumbnailFileNo(map);
	        
	        if(selectCnt >= 1) {
	        	logger.debug("이미 있는 썸네일 파일");
	        	logger.debug("썸네일 파일 번호 : "+selectCnt);
	        	miniMarketVo.setThumbnail(selectCnt);
	        }else {
	        	
	        	logger.debug("썸네일 파일 새로 등록되서 등록 절차 시작");
			
	        	int registFilesCnt = fsurpportService.registFiles(filesVo);
	        	logger.debug("registFilesCnt : " + registFilesCnt);
	        	logger.debug("registFilesCnt 결과값 문자 확인 : " + Integer.toString(registFilesCnt));
	        	
	        	miniMarketVo.setThumbnail(registFilesCnt);
	        }


		} else {
			logger.debug("파일없다.");
			
			if(req.getParameter("thumbnail_file_check") != null && !req.getParameter("thumbnail_file_check").equals("")) {
				
				logger.debug("썸네일이 바뀌지 않음");
				
				Map<String, String> map = new HashMap<String, String>();
		        map.put("file_nm", req.getParameter("thumbnail_file_check"));
		        map.put("market_no", Integer.toString(market_no_value));
		        
		        logger.debug("검색전 값 확인 1 : {}, 2 : {} ", map.get("file_nm"), map.get("market_no"));
		        
		        int selectCnt = fcommunityService.selectThumbnailFileNo(map);
		        miniMarketVo.setThumbnail(selectCnt);
			} else {
				logger.debug("썸네일 파일도 없다.");
				miniMarketVo.setThumbnail(0);
			}
		}
		
		
		// 첨부파일1 있는지 확인
		if (req.getParameter("file_nm1") != null && !req.getParameter("file_nm1").equals("")) {

			logger.debug("file_nm1 값 있다.");


		} else {

			if (req.getParameter("file_nm1").equals("")) {

				logger.debug("file_nm1의 첨부파일 없다.");

				MarketFilesVo marketFilesVo = new MarketFilesVo();
				
				if(!req.getParameter("file_no_check1").equals("") 
						&& req.getParameter("file_no_check1") != null) {
					
					int file_no1 = Integer.parseInt(req.getParameter("file_no_check1"));
					logger.debug("file_no_check1의 값 : "+file_no1);
					
					if(file_no1 > 0) { 
						logger.debug("file_no1 값 있어서 삭제 작업 들어감");
						marketFilesVo = fcommunityService.selectMarketFilesInfo(file_no1);
					}
	
					int deleteMiniMarketFilesCnt = fcommunityService.deleteMiniMarketFiles(marketFilesVo.getFile_record_no());
	
					if (deleteMiniMarketFilesCnt == 1) {
						logger.debug("file_nm1의 첨부파일 삭제");
					}
				}
			}

			if (file_file1.getSize() > 0) {

				logger.debug("첨부파일 등록 시작");

				MarketFilesVo marketFilesVo1 = new MarketFilesVo();

				// 첨부파일 등록 부분

				logger.debug("file1 있다.");

				String path = "c:\\fdown\\miniMarket\\";

				try {

					file_file1.transferTo(new File(path + file_file1.getOriginalFilename()));

					filesVo.setFile_nm("");
					filesVo.setFile_nm(file_file1.getOriginalFilename());
					filesVo.setFile_path(path + filesVo.getFile_nm());

					int registFilesCnt = fsurpportService.registFiles(filesVo);

					logger.debug("registFilesCnt : " + registFilesCnt);
					marketFilesVo1.setFile_no(registFilesCnt);

					marketFilesVo1.setMarket_no(market_no_value);

					logger.debug("등록전 값 게기글 번호 : {}, 파일 번호 : {}", marketFilesVo1.getMarket_no(),
							marketFilesVo1.getFile_no());
					int registmarketfilesCnt = fcommunityService.registmarketfiles(marketFilesVo1);

					logger.debug("file_file1 등록 : " + registmarketfilesCnt);
				} catch (IllegalStateException | IOException e) {
					filesVo.setFile_nm("");
				}

			} else {
				logger.debug("첨부 파일없다.");
			}

		}
		
		// 첨부파일2 있는지 확인
		if (req.getParameter("file_nm2") != null && !req.getParameter("file_nm2").equals("")) {
			
			logger.debug("file_nm2 값 있다.");
			
			
		} else {
			
			if (req.getParameter("file_nm2").equals("")) {
				
				logger.debug("file_nm2의 첨부파일 없다.");
				
				MarketFilesVo marketFilesVo = new MarketFilesVo();
				
				if(!req.getParameter("file_no_check2").equals("") 
						&& req.getParameter("file_no_check2") != null) {
					int file_no2 = Integer.parseInt(req.getParameter("file_no_check2"));
					logger.debug("file_no_check2의 값 : "+file_no2);
					
					if(file_no2 > 0) { 
						logger.debug("file_no2 값 있어서 삭제 작업 들어감");
						marketFilesVo = fcommunityService.selectMarketFilesInfo(file_no2);
					}
					
					int deleteMiniMarketFilesCnt = fcommunityService
							.deleteMiniMarketFiles(marketFilesVo.getFile_record_no());
					
					if (deleteMiniMarketFilesCnt == 1) {
						logger.debug("file_nm2의 첨부파일 삭제");
					}
				
				}
			}
			
			if (file_file2.getSize() > 0) {
				
				logger.debug("첨부파일2 등록 시작");
				
				MarketFilesVo marketFilesVo1 = new MarketFilesVo();
				
				// 첨부파일2 등록 부분
				
				logger.debug("file_file2 있다.");
				
				String path = "c:\\fdown\\miniMarket\\";
				
				try {
					
					file_file2.transferTo(new File(path + file_file2.getOriginalFilename()));
					
					filesVo.setFile_nm("");
					filesVo.setFile_nm(file_file2.getOriginalFilename());
					filesVo.setFile_path(path + filesVo.getFile_nm());
					
					int registFilesCnt = fsurpportService.registFiles(filesVo);
					
					logger.debug("registFilesCnt : " + registFilesCnt);
					marketFilesVo1.setFile_no(registFilesCnt);
					
					marketFilesVo1.setMarket_no(market_no_value);
					
					logger.debug("file_file2 등록전 값 게기글 번호 : {}, 파일 번호 : {}", marketFilesVo1.getMarket_no(),
							marketFilesVo1.getFile_no());
					int registmarketfilesCnt = fcommunityService.registmarketfiles(marketFilesVo1);
					
					logger.debug("file_file2 등록 : " + registmarketfilesCnt);
				} catch (IllegalStateException | IOException e) {
					filesVo.setFile_nm("");
				}
				
			} else {
				logger.debug("첨부 파일없다.");
			}
			
		}
		
		// 첨부파일3 있는지 확인
		if (req.getParameter("file_nm3") != null && !req.getParameter("file_nm3").equals("")) {
			
			logger.debug("file_nm3 값 있다.");
			
			
		} else {
			
			if (req.getParameter("file_nm3").equals("")) {
				
				logger.debug("file_nm3의 첨부파일 없다.");
				
				MarketFilesVo marketFilesVo = new MarketFilesVo();
				
				if(!req.getParameter("file_no_check3").equals("") 
						&& req.getParameter("file_no_check3") != null) {
				
					int file_no3 = Integer.parseInt(req.getParameter("file_no_check3"));
					logger.debug("file_no_check3의 값 : "+file_no3);
					
					if(file_no3 > 0) { 
						logger.debug("file_no3 값 있어서 삭제 작업 들어감");
						marketFilesVo = fcommunityService.selectMarketFilesInfo(file_no3);
					}
					
					int deleteMiniMarketFilesCnt = fcommunityService
							.deleteMiniMarketFiles(marketFilesVo.getFile_record_no());
					
					if (deleteMiniMarketFilesCnt == 1) {
						logger.debug("file_nm3의 첨부파일 삭제");
					}
				}
			}
			
			if (file_file3.getSize() > 0) {
				
				logger.debug("첨부파일3 등록 시작");
				
				MarketFilesVo marketFilesVo1 = new MarketFilesVo();
				
				// 첨부파일3 등록 부분
				
				logger.debug("file_file3 있다.");
				
				String path = "c:\\fdown\\miniMarket\\";
				
				try {
					
					file_file3.transferTo(new File(path + file_file3.getOriginalFilename()));
					
					filesVo.setFile_nm("");
					filesVo.setFile_nm(file_file3.getOriginalFilename());
					filesVo.setFile_path(path + filesVo.getFile_nm());
					
					int registFilesCnt = fsurpportService.registFiles(filesVo);
					
					logger.debug("registFilesCnt : " + registFilesCnt);
					marketFilesVo1.setFile_no(registFilesCnt);
					
					marketFilesVo1.setMarket_no(market_no_value);
					
					logger.debug("file_file3 등록전 값 게기글 번호 : {}, 파일 번호 : {}", marketFilesVo1.getMarket_no(),
							marketFilesVo1.getFile_no());
					int registmarketfilesCnt = fcommunityService.registmarketfiles(marketFilesVo1);
					
					logger.debug("file_file3 등록 : " + registmarketfilesCnt);
				} catch (IllegalStateException | IOException e) {
					filesVo.setFile_nm("");
				}
				
			} else {
				logger.debug("첨부 파일없다.");
			}
			
		}
		
		logger.debug("미니장터 게시글 수정 시작전");
		logger.debug("미니장터 게시글 수정 시작전 값 : {}",miniMarketVo);
		
		int modifyMiniMarketInfoCnt = fcommunityService.modifyMiniMarketInfo(miniMarketVo);
		
		if(modifyMiniMarketInfoCnt == 1) {
			logger.debug("미니장터 게시글 수정됨");
		}
		
		logger.debug("미니장터 게시글 수정 종료");
		
		return"redirect:/fcommunity/miniMarketInfoView?writer="+req.getParameter("writer")+"&market_no="+market_no_value;
	}
	
	// 20210323_ggy : 미니장터 게시글 삭제
	@RequestMapping(path = "deleteMiniMarketPost", method = { RequestMethod.GET })
	public String deleteMiniMarketPost(
			String writer, int market_no ) {
		
		logger.debug("deleteMiniMarketPost 진입");
		
		Map<String, String> map = new HashMap<String, String>();
        map.put("writer", writer);
        map.put("market_no", Integer.toString(market_no));
        
        logger.debug("지우기전 값 확인 writer : {}, market_no : {} ", map.get("writer"), map.get("market_no"));
		
		int deleteCnt =  fcommunityService.deleteMiniMarketPost(map);
		
		if(deleteCnt==1) {
			logger.debug("삭제 완료");
		}
		
		return"redirect:/fcommunity/miniMarketView";
	}
	
	
	
	
	
}
