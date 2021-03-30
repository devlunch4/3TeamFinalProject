package kr.or.ddit.fdata.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
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

import kr.or.ddit.codes.service.CodesService;
import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.fdata.service.FdataService;
import kr.or.ddit.fsurpport.service.FsurpportService;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.web.UserController;

@RequestMapping("main")
@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	// 필요한 스프링 빈 호출
	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "fdataService")
	private FdataService fdataService;

	@Resource(name = "fsurpportService")
	private FsurpportService fsurpportService;

	@Resource(name = "codesService")
	private CodesService codesService;

	@RequestMapping("main2")
	public String main2(Model model) {
		return "tiles.main.main2";
	}
	
	@RequestMapping("info")
	public String info(Model model) {
		return "tiles.main.info";
	}

	// 20210301KJH
	// 인기작물 크롤링 test ok
	@RequestMapping("mainpopularity")
	public String mainpopularity(Model model) {
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
		return "/ajax/mainpopularity";
	}

	// 20210302KJH
	// 품목별 비율 통계 페이지 test ok
	@RequestMapping("mainratio")
	public String mainratio(Model model, String selec, String sdate, String edate) {
		logger.debug("IN ratio()");
		List<FarmdiaryVo> farmCount = new ArrayList<FarmdiaryVo>();
		logger.debug("edate value : {}", edate);

		if (selec == null || selec.equals("all") || sdate == null || sdate == "") {
			farmCount = fdataService.farmCount();
			model.addAttribute("farmCount", farmCount);
			model.addAttribute("choice", "전체기간");
			return "/ajax/mainratio";
		} else if (selec.equals("week")) {
			try {
				String[] dt = sdate.split("~");
				String sd = dt[0];
				String ed = dt[1];

				FarmdiaryVo vo = new FarmdiaryVo();
				vo.setB_type_code(sd);
				vo.setW_step_code(ed);
				model.addAttribute("choice", sdate);
				farmCount = fdataService.datefarmCount(vo);
			} catch (Exception e) {
				model.addAttribute("farmCount", farmCount);
				return "/ajax/mainratio";
			}
		} else if (selec.equals("month")) {

			FarmdiaryVo vo = new FarmdiaryVo();
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
			model.addAttribute("choice", sdate + "~" + edate);
			farmCount = fdataService.datefarmCount(vo);
		} else if (selec.equals("year")) {
			FarmdiaryVo vo = new FarmdiaryVo();
			vo.setB_type_code(sdate + "-01-01");
			String edt = "" + (Integer.parseInt(edate));
			vo.setW_step_code(edt + "-12-31");
			farmCount = fdataService.datefarmCount(vo);
			model.addAttribute("choice", sdate + "~" + edt);
		}
		model.addAttribute("farmCount", farmCount);
		return "/ajax/mainratio";
	}

	@RequestMapping("mainquote")
	public String mainuote(Model model, CodesVo codesVo, String sdate) {

		logger.debug("In main()");
		// KJH - 메인으로 가면서 크롤링하여 시세분석값을 가져옴
		String itemcategorycode = "100";
		String itemcode = "111";
		Date date = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		String mydate = transFormat.format(date);
		if (sdate != null) {
			mydate = sdate;
		}
		if (codesVo.getCode_no() != null) {
			itemcategorycode = codesVo.getParent_code();
			itemcode = codesVo.getCode_no();
		}
		// Jsoup라이브러리를 사용한 크롤링
		Document doc;
		try {
			doc = Jsoup.connect("https://www.kamis.or.kr/customer/price/wholesale/item.do?action=priceinfo&regday="
					+ mydate + "&itemcategorycode=" + itemcategorycode + "&itemcode=" + itemcode
					+ "&kindcode=&productrankcode=0&convert_kg_yn=N").get();
			int docsize = (doc.select("tr").get(12)).select("td").size();

			List<String> target = new ArrayList<String>();
			target.add(((doc.select("tr").get(11)).select("th").get(1)).text());
			target.add(((doc.select("tr").get(11)).select("th").get(docsize - 4)).text());
			target.add(((doc.select("tr").get(11)).select("th").get(docsize - 3)).text());
			target.add(((doc.select("tr").get(11)).select("th").get(docsize - 2)).text());
			target.add(((doc.select("tr").get(11)).select("th").get(docsize - 1)).text());

			List<String> average = new ArrayList<String>();
			average.add(((doc.select("tr").get(12)).select("td").get(1)).text());
			average.add(((doc.select("tr").get(12)).select("td").get(docsize - 4)).text());
			average.add(((doc.select("tr").get(12)).select("td").get(docsize - 3)).text());
			average.add(((doc.select("tr").get(12)).select("td").get(docsize - 2)).text());
			average.add(((doc.select("tr").get(12)).select("td").get(docsize - 1)).text());

			List<String> maxvalue = new ArrayList<String>();
			maxvalue.add(((doc.select("tr").get(13)).select("td").get(1)).text());
			maxvalue.add(((doc.select("tr").get(13)).select("td").get(docsize - 4)).text());
			maxvalue.add(((doc.select("tr").get(13)).select("td").get(docsize - 3)).text());
			maxvalue.add(((doc.select("tr").get(13)).select("td").get(docsize - 2)).text());
			maxvalue.add(((doc.select("tr").get(13)).select("td").get(docsize - 1)).text());

			List<String> minvalue = new ArrayList<String>();
			minvalue.add(((doc.select("tr").get(14)).select("td").get(1)).text());
			minvalue.add(((doc.select("tr").get(13)).select("td").get(docsize - 4)).text());
			minvalue.add(((doc.select("tr").get(14)).select("td").get(docsize - 3)).text());
			minvalue.add(((doc.select("tr").get(14)).select("td").get(docsize - 2)).text());
			minvalue.add(((doc.select("tr").get(14)).select("td").get(docsize - 1)).text());

			List<String> flrate = new ArrayList<String>();
			flrate.add(((doc.select("tr").get(15)).select("td").get(1)).text());
			flrate.add(((doc.select("tr").get(15)).select("td").get(docsize - 4)).text());
			flrate.add(((doc.select("tr").get(15)).select("td").get(docsize - 3)).text());
			flrate.add(((doc.select("tr").get(15)).select("td").get(docsize - 2)).text());
			flrate.add(((doc.select("tr").get(15)).select("td").get(docsize - 1)).text());

			model.addAttribute("target", target);
			model.addAttribute("average", average);
			model.addAttribute("maxvalue", maxvalue);
			model.addAttribute("minvalue", minvalue);
			model.addAttribute("flrate", flrate);

			model.addAttribute("itemcategorycode", itemcategorycode);
			model.addAttribute("itemcode", itemcode);
			model.addAttribute("mydate", mydate);
		} catch (IOException e1) {
		}
		List<CodesVo> codesList = fdataService.selectAllCodes();
		model.addAttribute("codesList", codesList);

		return "/ajax/mainquote";
	}

}
