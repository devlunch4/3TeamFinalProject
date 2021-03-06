package kr.or.ddit.fanalysis.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.fanalysis.service.FanalysisServiceImpl;
import kr.or.ddit.farm.model.MsrequipVo;
import kr.or.ddit.farm.model.MsrrecVo;
import kr.or.ddit.fsurpport.service.FsurpportServiceImpl;
import kr.or.ddit.user.model.UserVo;

@RequestMapping("fanalysis")
@Controller
public class FanalysisController {

	@Resource(name = "fsurpportService")
	private FsurpportServiceImpl fsurpportService;

	@Resource(name = "fanalysisService")
	private FanalysisServiceImpl fanalysisService;

	// 20210304_KJH 내 시설 관측정보 조회
	@RequestMapping(path = "myfanalysisInfo", method = { RequestMethod.GET })
	public String myfanalysisInfo(Model model, HttpSession session) {

		UserVo userVo = new UserVo();

		userVo = (UserVo) session.getAttribute("S_USER");
		System.out.println(userVo.getUser_id());

		List<MsrequipVo> msrequipList = fsurpportService.msrequipList(userVo.getUser_id());

		System.out.println(msrequipList.size());

		MsrrecVo msrrecVo = new MsrrecVo();
		msrrecVo.setMsr_code(msrequipList.get(0).getMsr_code());
		msrrecVo.setMsr_no(0);
		String msr_code = msrequipList.get(0).getMsr_code();

		System.out.println(msrrecVo.getMsr_temp());
//		msrrecVo = fanalysisService.myfanalysisInfo(msrrecVo);
		List<MsrrecVo> msrrecList = new ArrayList<MsrrecVo>();
		msrrecList.add((MsrrecVo) fanalysisService.myfanalysisInfo(msrrecVo));

		model.addAttribute("msr_code", msr_code);
		model.addAttribute("msrequipList", msrequipList);
		model.addAttribute("msrrecVo", msrrecList);
		return "tiles.fanalysis.myfanalysisInfo";
	}

	// 20210304_KJH 내 시설 관측정보 조회
	@RequestMapping(path = "myfanalysisInfo", method = { RequestMethod.POST })
	public String semyfanalysisInfo(Model model, String msr_code, String week, String month, String day,
			HttpSession session) {
		Date date1 = new Date();
		UserVo userVo = new UserVo();
		model.addAttribute("sedate", date1);

		userVo = (UserVo) session.getAttribute("S_USER");

		List<MsrequipVo> msrequipList = fsurpportService.msrequipList(userVo.getUser_id());

		MsrrecVo msrrecVo = new MsrrecVo();
		msrrecVo.setMsr_code(msr_code);
		msrrecVo.setMsr_no(1);

		Calendar getToday = Calendar.getInstance();
		Calendar cmpDate = Calendar.getInstance();
		List<MsrrecVo> msrrecList = new ArrayList<MsrrecVo>();
		if (week != null && week != "") {
			for (int i = 0; i < Integer.parseInt(week) + 1; i++) {
				msrrecVo.setMsr_no(i);
				msrrecList.add((MsrrecVo) fanalysisService.myfanalysisInfo(msrrecVo));
			}
		} else if (month != null && month != "") {
			for (int i = 0; i < Integer.parseInt(month) + 1; i++) {
				msrrecVo.setMsr_no(i);
				msrrecList.add((MsrrecVo) fanalysisService.myfanalysisInfo(msrrecVo));
			}
		} else if (day != null && day != "") {
			try {

				Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(day);
				getToday.setTime(date1);
				cmpDate.setTime(date2);

				model.addAttribute("sedate", date2);
				long diffSec = (getToday.getTimeInMillis() - cmpDate.getTimeInMillis()) / 1000;
				int diffDays = (int) (diffSec / (24 * 60 * 60));
				System.out.println(diffDays);
				for (int i = 0; i < diffDays + 1; i++) {
					msrrecVo.setMsr_no(i);
					msrrecList.add((MsrrecVo) fanalysisService.myfanalysisInfo(msrrecVo));
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			msrrecList.add((MsrrecVo) fanalysisService.myfanalysisInfo(msrrecVo));
		}

		model.addAttribute("msr_code", msr_code);
		model.addAttribute("msrequipList", msrequipList);
		model.addAttribute("msrrecVo", msrrecList);
 
		return "tiles.fanalysis.myfanalysisInfo";
	}
	
	
	// 20210305_KJH 내 시설 실시간 관측 조회
//	@RequestMapping(path = "mymaxmsrrecList", method = { RequestMethod.GET })
//	public String mymaxmsrrecList(Model model , HttpSession session) {
//		
//		UserVo userVo = new UserVo();
//
//		userVo = (UserVo) session.getAttribute("S_USER");
//		List<MsrequipVo> msrequipList = fsurpportService.msrequipList(userVo.getUser_id());
//		
//		List<MyMaxMrrecListVo> maxmrrecList = new ArrayList<MyMaxMrrecListVo>();
//		
//		MsrrecVo msrrecVo = new MsrrecVo();
//		for(int i = msrequipList.size()-1; i >= 0; i-- ) {
//			String msrcode = msrequipList.get(i).getMsr_code();
//			msrrecVo.setMsr_code(msrcode);
//			maxmrrecList.add(fanalysisService.mymaxmsrrecList(msrrecVo));
//		}
//		
//		model.addAttribute("maxmrrecList",maxmrrecList);
//		return "tiles.fanalysis.mymaxmsrrecList";
//	}
}
