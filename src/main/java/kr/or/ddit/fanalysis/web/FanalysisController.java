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
import kr.or.ddit.fanalysis.service.FanalysisService;

import kr.or.ddit.farm.model.FhistoryVo;
import kr.or.ddit.farm.model.FmanageVo;
import kr.or.ddit.farm.model.MsrequipVo;
import kr.or.ddit.farm.model.MsrrecVo;
import kr.or.ddit.fsurpport.service.FsurpportService;
import kr.or.ddit.user.model.UserVo;

@RequestMapping("fanalysis")
@Controller
public class FanalysisController {

	@Resource(name = "fsurpportService")
	private FsurpportService fsurpportService;

	@Resource(name = "fanalysisService")
	private FanalysisService fanalysisService;

	// 20210308_KJH 내 시설 관측정보 조회 수정 test ok
	@RequestMapping(path = "myfanalysisInfo", method = { RequestMethod.GET })
	public String myfanalysisInfo(Model model, HttpSession session) {

		UserVo userVo = new UserVo();

		userVo = (UserVo) session.getAttribute("S_USER");

		List<FmanageVo> fmanageList = fanalysisService.selectFmanage(userVo.getUser_id());
		if (fmanageList.size() == 0) {
			model.addAttribute("novalue", "측정값을 확인할 수 있는 시설이 없습니다.");
			return "tiles.fanalysis.myfanalysisInfo";
		}
		MsrrecVo msrrecVo = new MsrrecVo();
		msrrecVo.setMsr_code(fmanageList.get(0).getManage_no());
		msrrecVo.setMsr_no(0);

//		msrrecVo = fanalysisService.myfanalysisInfo(msrrecVo);
		List<MsrrecVo> mmmList = new ArrayList<MsrrecVo>();
		mmmList.add(fanalysisService.avgFmanage(msrrecVo));

		model.addAttribute("selec", fmanageList.get(0).getManage_no());
		model.addAttribute("fmanageList", fmanageList);
		model.addAttribute("mmmList", mmmList);
		return "tiles.fanalysis.myfanalysisInfo";
	}

	// 20210308_KJH 내 시설 관측정보 조회 수정 test ok
	@RequestMapping(path = "myfanalysisInfo", method = { RequestMethod.POST })
	public String myfanalysisInfo(Model model, HttpSession session, String week, String month, String day,
			String selec) {

		UserVo userVo = new UserVo();

		userVo = (UserVo) session.getAttribute("S_USER");

		List<FmanageVo> fmanageList = fanalysisService.selectFmanage(userVo.getUser_id());

		MsrrecVo msrrecVo = new MsrrecVo();
		msrrecVo.setMsr_code(selec);
		msrrecVo.setMsr_no(0);

		List<MsrrecVo> mmmList = new ArrayList<MsrrecVo>();
		if (week != null && week.equals("7")) {
			for (int i = 0; i < 7; i++) {
				msrrecVo.setMsr_no(i);
				mmmList.add(fanalysisService.avgFmanage(msrrecVo));
			}

		}

		if (month != null && month.equals("30")) {
			for (int i = 0; i < 30; i++) {
				msrrecVo.setMsr_no(i);
				mmmList.add(fanalysisService.avgFmanage(msrrecVo));
			}
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
					msrrecVo.setMsr_no(i);
					mmmList.add(fanalysisService.avgFmanage(msrrecVo));
				}
			} catch (ParseException e) {

			}

		}

		model.addAttribute("selec", selec);
		model.addAttribute("fmanageList", fmanageList);
		model.addAttribute("mmmList", mmmList);
		return "tiles.fanalysis.myfanalysisInfo";
	}

	// 20210305_KJH 내 시설 실시간 관측 조회 test ok
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

		model.addAttribute("tempList", fanalysisService.selectTempList());
		model.addAttribute("maxmrrecList", maxmrrecList);
		return "tiles.fanalysis.mymaxmsrrecList";
	}

	// 20210315_KJH 내 시설 실시간 관측 조회 ajax ok
	@RequestMapping(path = "mymaxmsrrecList", method = { RequestMethod.POST })
	public String mymaxmsrrecListpost(Model model, HttpSession session) {

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

		model.addAttribute("tempList", fanalysisService.selectTempList());
		model.addAttribute("maxmrrecList", maxmrrecList);
		return "/ajax/mymaxmsrrecList";
	}
}
