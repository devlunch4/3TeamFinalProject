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

import kr.or.ddit.fanalysis.model.MyMaxMrrecListVo;
import kr.or.ddit.fanalysis.service.FanalysisServiceImpl;
import kr.or.ddit.farm.model.FhistoryVo;
import kr.or.ddit.farm.model.FmanageVo;
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

	// 20210308_KJH 내 시설 관측정보 조회 수정
	@RequestMapping(path = "myfanalysisInfo", method = { RequestMethod.GET })
	public String myfanalysisInfo(Model model, HttpSession session) {

		UserVo userVo = new UserVo();

		userVo = (UserVo) session.getAttribute("S_USER");
		System.out.println(userVo.getUser_id());

		List<MsrequipVo> msrequipList = fsurpportService.msrequipList(userVo.getUser_id());

		System.out.println(msrequipList.size());

		MyMaxMrrecListVo MyMaxMrrecListVo = new MyMaxMrrecListVo();
		MyMaxMrrecListVo.setManage_no(msrequipList.get(0).getMsr_code());
		MyMaxMrrecListVo.setNumber(0);

//		msrrecVo = fanalysisService.myfanalysisInfo(msrrecVo);
		List<MyMaxMrrecListVo> mmmList = new ArrayList<MyMaxMrrecListVo>();
		mmmList.add(fanalysisService.myfanalysisInfo(MyMaxMrrecListVo));

		model.addAttribute("selec", msrequipList.get(0).getMsr_code());

		model.addAttribute("manage_no", msrequipList.get(0).getMsr_code());
		model.addAttribute("msrequipList", msrequipList);
		model.addAttribute("mmmList", mmmList);
		return "tiles.fanalysis.myfanalysisInfo";
	}

	// 20210308_KJH 내 시설 관측정보 조회 수정
	@RequestMapping(path = "myfanalysisInfo", method = { RequestMethod.POST })
	public String myfanalysisInfo(Model model, HttpSession session, String week, String month, String day,
			String selec) {

		UserVo userVo = new UserVo();

		userVo = (UserVo) session.getAttribute("S_USER");
		System.out.println(userVo.getUser_id());

		List<MsrequipVo> msrequipList = fsurpportService.msrequipList(userVo.getUser_id());

		System.out.println(msrequipList.size());

		MyMaxMrrecListVo MyMaxMrrecListVo = new MyMaxMrrecListVo();
		MyMaxMrrecListVo.setManage_no(selec);
		MyMaxMrrecListVo.setNumber(0);

		List<MyMaxMrrecListVo> mmmList = new ArrayList<MyMaxMrrecListVo>();
		if (week != null && week.equals("7")) {
			for (int i = 0; i < 7; i++) {
				MyMaxMrrecListVo.setNumber(i);
				mmmList.add(fanalysisService.myfanalysisInfo(MyMaxMrrecListVo));
			}
			;
		}

		if (month != null && month.equals("30")) {
			for (int i = 0; i < 30; i++) {
				MyMaxMrrecListVo.setNumber(i);
				mmmList.add(fanalysisService.myfanalysisInfo(MyMaxMrrecListVo));
			}
			;
		}
		if (day != null && day.length() > 0) {

			Calendar getToday = Calendar.getInstance();
			getToday.setTime(new Date()); // 금일 날짜

			Date date;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(day);
				Calendar cmpDate = Calendar.getInstance();
				cmpDate.setTime(date); // 특정 일자

				long diffSec = (getToday.getTimeInMillis() - cmpDate.getTimeInMillis()) / 1000;
				int diffDays = (int) diffSec / (24 * 60 * 60); // 일자수 차이

				for (int i = 0; i < diffDays; i++) {
					MyMaxMrrecListVo.setNumber(i);
					mmmList.add(fanalysisService.myfanalysisInfo(MyMaxMrrecListVo));
				}
				;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		model.addAttribute("selec", selec);
		model.addAttribute("manage_no", msrequipList.get(0).getMsr_code());
		model.addAttribute("msrequipList", msrequipList);
		model.addAttribute("mmmList", mmmList);
		return "tiles.fanalysis.myfanalysisInfo";
	}

	// 20210305_KJH 내 시설 실시간 관측 조회
	@RequestMapping(path = "mymaxmsrrecList", method = { RequestMethod.GET })
	public String mymaxmsrrecList(Model model, HttpSession session) {

		UserVo userVo = new UserVo();

		userVo = (UserVo) session.getAttribute("S_USER");
		List<MsrequipVo> msrequipList = fsurpportService.msrequipList(userVo.getUser_id());

		List<MyMaxMrrecListVo> maxmrrecList = new ArrayList<MyMaxMrrecListVo>();

		FhistoryVo fhistoryVo = new FhistoryVo();

		for (int i = 0; i < msrequipList.size(); i++) {
			String msrcode = msrequipList.get(i).getMsr_code();
			fhistoryVo.setManage_no(msrcode);
			maxmrrecList.add(fanalysisService.mymaxmsrrecList(fhistoryVo));
		}

		model.addAttribute("maxmrrecList", maxmrrecList);
		return "tiles.fanalysis.mymaxmsrrecList";
	}
}
