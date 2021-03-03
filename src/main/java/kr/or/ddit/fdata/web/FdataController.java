package kr.or.ddit.fdata.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
			}
			
			model.addAttribute("most",most2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		String fileurl = "https://www.kamis.or.kr/customer/board/board_file.do?brdno=4&brdctsno=430442&brdctsfileno=14921";
//		
//		try(InputStream in = new URL(fileurl).openStream()){
//		     Files.copy(in, Paths.get("D:\\upload\\fileTest.xls"),     StandardCopyOption.REPLACE_EXISTING);
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return "tiles.fdata.popularity";
	}
	
	//20210302KJH
	//품목별 비율 통계 페이지
	@RequestMapping("ratio")
	public String ratio(Model model) {
		
		return "tiles.fdata.ratio";
	}
	
}
