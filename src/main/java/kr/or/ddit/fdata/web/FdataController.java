package kr.or.ddit.fdata.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.farm.model.MsrrecVo;
import kr.or.ddit.fdata.service.FdataService;
import kr.or.ddit.finfo.service.FinfoService;

@RequestMapping("fdata")
@Controller
public class FdataController {

	private static final Logger logger = LoggerFactory.getLogger(FdataController.class);

	@Resource(name = "fdataService")
	private FdataService fdataService;

	@Resource(name = "finfoService")
	private FinfoService finfoService;

	// 20210301KJH
	// 인기작물 크롤링 test ok
	@RequestMapping("popularity")
	public String popularity(Model model) {
		logger.debug("IN popularity()");
		List<CodesVo> mostfileList = new ArrayList<CodesVo>();
		Document doc;
		try {
			doc = Jsoup.connect("https://www.agrion.kr/portal/fdp/fpi/selectFrmprdPcInfo.do").post();
			doc.select("div[class=list]");
			String most1 = doc.select("div[class=list]").select("a").text();
			String[] most2 = most1.split(" ");
			List<String> most = new ArrayList<String>();
			for (int i = 0; i < most2.length; i++) {
				most.add(most2[i]);
				mostfileList.add(fdataService.selectCode(most2[i]));
			}
			model.addAttribute("most", most2);
		} catch (IOException e) {
		}
		model.addAttribute("mostfileList", mostfileList);
		return "tiles.fdata.popularity";
	}

	// 20210312_KJH 검색된 인기작물의 정보 페이지로 이동 test ok
	@RequestMapping("popularityselect")
	public String popularityselect(Model model, String Item_code) {
		logger.debug("IN popularityselect()");
		String guide_code = finfoService.guide_codeselect(Item_code).getGuide_code();
		int xguide_code = Integer.parseInt(guide_code);
		return "redirect:/finfo/gardenguides?xguide_code=" + xguide_code;
	}

	// 20210302KJH
	// 품목별 비율 통계 페이지 test ok
	@RequestMapping("ratio")
	public String ratio(Model model, String selec, String sdate, String edate) {
		logger.debug("IN ratio()");
		List<FarmdiaryVo> farmCount = new ArrayList<FarmdiaryVo>();
		logger.debug("edate value : {}", edate);
		
		FarmdiaryVo vo = new FarmdiaryVo();
		
		if (selec == null || selec.equals("all") || sdate == null || sdate == "") {
			farmCount = fdataService.datefarmCount(vo);
			model.addAttribute("farmCount", farmCount);
			model.addAttribute("choice","전체기간");
			return "tiles.fdata.ratio";
		} else if (selec.equals("week")) {
			try {
				String[] dt = sdate.split("~");
				String sd = dt[0];
				String ed = dt[1];

				vo.setB_type_code(sd);
				vo.setW_step_code(ed);
				model.addAttribute("choice",sdate);
				farmCount = fdataService.datefarmCount(vo);
			} catch (Exception e) {
				model.addAttribute("farmCount", farmCount);
				return "tiles.fdata.ratio";
			}
		} else if (selec.equals("month")) {
			
			vo.setB_type_code(sdate + "-01");

			String[] dt = edate.split("-");
			int eyy = Integer.parseInt(dt[0]);// 2021
			int emm = Integer.parseInt(dt[1]) + 1;// 04
			if (emm > 12) {
				emm = 1;
				eyy += 1;
			}
			String edt = "" + eyy + "-" + emm + "-01";
			vo.setW_step_code(edt);
			model.addAttribute("choice",sdate+"~"+edate);
		} 
		
		else if (selec.equals("year")) {
			vo.setB_type_code(sdate + "-01-01");
			String edt = "" + (Integer.parseInt(edate));
			vo.setW_step_code(edt + "-12-31");
			model.addAttribute("choice",sdate+"~"+edt);
		}
		farmCount = fdataService.datefarmCount(vo);
		
		model.addAttribute("farmCount", farmCount);
		model.addAttribute("selec",selec);
		model.addAttribute("sdate",sdate);
		model.addAttribute("edate",edate);
		return "tiles.fdata.ratio";
	}
	
	// 20210330_KJH 측정값 insert
	@RequestMapping("addData")
	public String addData(Model model, MsrrecVo msrrecVo) {
		logger.debug("측정값 insert : {}",msrrecVo);
		
		fdataService.addData(msrrecVo);
		
		return null;
	}
}
