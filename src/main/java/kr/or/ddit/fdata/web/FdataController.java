package kr.or.ddit.fdata.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.fdata.service.FdataServiceImpl;

@RequestMapping("fdata")
@Controller
public class FdataController {
	
	@Resource(name = "fdataService")
	private FdataServiceImpl fdataService;
	
	//20210301KJH
	//인기작물 크롤링
	@RequestMapping("popularity")
	public String popularity(Model model) {
		List<CodesVo> mostfileList = new ArrayList<CodesVo>();
		Document doc;
		try {
			doc = 
			Jsoup.connect("https://www.agrion.kr/portal/fdp/fpi/selectFrmprdPcInfo.do").post();
			doc.select("div[class=list]");
		    
//		    average.add(((doc.select("tr").get(12)).select("td").get(1)).text());
			
			System.out.println(doc.select("div[class=list]").select("a").get(1));
			String most1 = doc.select("div[class=list]").select("a").text();
			String[] most2 = most1.split(" ");
			
			List<String> most = new ArrayList<String>();
			for(int i = 0; i < most2.length; i++) {
			most.add(most2[i]);
			System.out.println(most2[i]);
			mostfileList.add(fdataService.selectCode(most2[i]));
			}
			
			model.addAttribute("most",most2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		FarmdiaryVo fm = new FarmdiaryVo();

		model.addAttribute("mostfileList",mostfileList);
		return "tiles.fdata.popularity";
	}
	
	//20210302KJH
	//품목별 비율 통계 페이지
	@RequestMapping("ratio")
	public String ratio(Model model,String selec,
			String sdate,String edate) {
		List<FarmdiaryVo> farmCount = new ArrayList<FarmdiaryVo>();

		if(selec == null || selec.equals("all") || sdate == null || edate == null) {
		farmCount = fdataService.farmCount();
		model.addAttribute("farmCount",farmCount);
		return "tiles.fdata.ratio";
		}
		
		else if(selec.equals("week")) {
			try {
				
				String[] dt  = sdate.split("~");
				String sd = dt[0];
				String ed = dt[1];
				
				FarmdiaryVo vo = new FarmdiaryVo();
				vo.setB_type_code(sd);
				vo.setW_step_code(ed);
				
				farmCount = fdataService.datefarmCount(vo);
			} catch (Exception e) {
				model.addAttribute("farmCount",farmCount);
				return "tiles.fdata.ratio";
			}
		}
		else if(selec.equals("month")) {
			FarmdiaryVo vo = new FarmdiaryVo();
			vo.setB_type_code(sdate+"-01");
			
			String[] dt = edate.split("-");
			int eyy = Integer.parseInt(dt[0]);//2021
			int emm = Integer.parseInt(dt[1])+1;//04
			if(emm > 12) {
				emm = 1;
				eyy += 1; 
			}
			String edt = ""+eyy+"-"+emm+"-01";
			vo.setW_step_code(edt);
			System.out.println(""+sdate+""+eyy);
			
			farmCount = fdataService.datefarmCount(vo);
		}
		else if(selec.equals("year")) {
			FarmdiaryVo vo = new FarmdiaryVo();
			vo.setB_type_code(sdate+"-01-01");
			String edt = ""+(Integer.parseInt(edate));
			vo.setW_step_code(edt+"-12-31");
			farmCount = fdataService.datefarmCount(vo);
		}
		
		
		model.addAttribute("farmCount",farmCount);
		return "tiles.fdata.ratio";
	}
	
}
