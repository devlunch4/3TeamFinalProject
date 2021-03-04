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
	
	
	//20210304_KJH 내 시설 관측정보 조회
	@RequestMapping(path = "myfanalysisInfo" , method = { RequestMethod.GET })
	public String myfanalysisInfo(Model model, HttpSession session) {
		
		UserVo userVo = new UserVo();
		
		userVo = (UserVo) session.getAttribute("S_USER");
		System.out.println(userVo.getUser_id());
		
		List<MsrequipVo> msrequipList = 
				fsurpportService.msrequipList(userVo.getUser_id());
		
		
		System.out.println(msrequipList.size());
		
		MsrrecVo msrrecVo = new MsrrecVo();
		msrrecVo.setMsr_code(msrequipList.get(0).getMsr_code());
		msrrecVo.setMsr_no(1);

		System.out.println(msrrecVo.getMsr_temp());
//		msrrecVo = fanalysisService.myfanalysisInfo(msrrecVo);
		List<MsrrecVo> msrrecList = new ArrayList<MsrrecVo>();
		msrrecList.add((MsrrecVo)fanalysisService.myfanalysisInfo(msrrecVo));
		
		
		
		model.addAttribute("msrequipList",msrequipList);
		model.addAttribute("msrrecVo",msrrecList);
		return "tiles.fanalysis.myfanalysisInfo";
	}
	
	//20210304_KJH 내 시설 관측정보 조회
	@RequestMapping(path = "myfanalysisInfo" , method = { RequestMethod.POST })
	public String semyfanalysisInfo(Model model,String MSR_CODE, String mm,String dd,String selectdate,HttpSession session) {
		
		UserVo userVo = new UserVo();
		
		userVo = (UserVo) session.getAttribute("S_USER");
		System.out.println(userVo.getUser_id());
		
		List<MsrequipVo> MsrequipList = 
				fsurpportService.msrequipList(userVo.getUser_id());
		
		
		System.out.println(MsrequipList.size());
		
		MsrrecVo msrrecVo = new MsrrecVo();
		msrrecVo.setMsr_code(MsrequipList.get(0).getMsr_code());
		msrrecVo.setMsr_no(1);
		
		Calendar getToday = Calendar.getInstance();
		Calendar cmpDate = Calendar.getInstance();
		
		if(mm != null) {
			msrrecVo.setMsr_no(Integer.parseInt(mm));
		}else if(dd != null) {
			msrrecVo.setMsr_no(Integer.parseInt(dd));
		}else if(selectdate != null) {
			try {
				Date date1 = new Date();
				Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(selectdate);
				getToday.setTime(date1);
				cmpDate.setTime(date2);
				
				long diffSec = (getToday.getTimeInMillis() - cmpDate.getTimeInMillis()) / 1000;
				int diffDays = (int) (diffSec / (24*60*60));
				msrrecVo.setMsr_no(diffDays);
			
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		
		
		return "tiles.fanalysis.myfanalysisInfo";
	}

}
