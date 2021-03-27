package kr.or.ddit.api;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.codes.service.CodesService;
import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.fdata.service.FdataService;
import kr.or.ddit.fsurpport.service.FsurpportService;
import kr.or.ddit.user.service.UserService;

@RequestMapping("/xml")
@RestController
public class RespXml {
	// 필요한 스프링 빈 호출
	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "fdataService")
	private FdataService fdataService;

	@Resource(name = "fsurpportService")
	private FsurpportService fsurpportService;

	@Resource(name = "codesService")
	private CodesService codesService;
	
	// XML 데이터 만들어 주기
	@RequestMapping(value = "/sendxml", method = RequestMethod.GET)
	@ResponseBody
	public List<XFarmdiaryVo> sendxml() {


		List<XFarmdiaryVo> farmCount = new ArrayList<XFarmdiaryVo>();
		List<FarmdiaryVo> farm = fdataService.farmCount();
		for(int i = 0; i < farm.size(); i++) {
			XFarmdiaryVo Vo = new XFarmdiaryVo();	
			Vo.setContent(farm.get(i).getContent());
			Vo.setYield(farm.get(i).getYield());
			
			farmCount.add(Vo);
		}

		
		return farmCount;
	}
	
//	@RequestMapping(value = "/sendxml/{selec}/{sdate}/{edate}", method = RequestMethod.GET)
//	@ResponseBody
//	public XFarmdiaryVo sendxml(String selec, String sdate, String edate) {
//
//		logger.debug("IN ratio()");
//		List<FarmdiaryVo> farmCount = new ArrayList<FarmdiaryVo>();
//		logger.debug("edate value : {}", edate);
//
//		if (selec == null || selec.equals("all") || sdate == null || sdate == "") {
//			farmCount = fdataService.farmCount();
//			return "/ajax/mainratio";
//		} else if (selec.equals("week")) {
//			try {
//				String[] dt = sdate.split("~");
//				String sd = dt[0];
//				String ed = dt[1];
//
//				FarmdiaryVo vo = new FarmdiaryVo();
//				vo.setB_type_code(sd);
//				vo.setW_step_code(ed);
//				model.addAttribute("choice", sdate);
//				farmCount = fdataService.datefarmCount(vo);
//			} catch (Exception e) {
//				model.addAttribute("farmCount", farmCount);
//				return "/ajax/mainratio";
//			}
//		} else if (selec.equals("month")) {
//
//			FarmdiaryVo vo = new FarmdiaryVo();
//			vo.setB_type_code(sdate + "-01");
//
//			String[] dt = edate.split("-");
//			int eyy = Integer.parseInt(dt[0]);// 2021
//			int emm = Integer.parseInt(dt[1]) + 1;// 04
//			if (emm > 12) {
//				emm = 1;
//				eyy += 1;
//			}
//			String edt = "" + eyy + "-" + emm + "-01";
//			vo.setW_step_code(edt);
//			model.addAttribute("choice", sdate + "~" + edate);
//			farmCount = fdataService.datefarmCount(vo);
//		} else if (selec.equals("year")) {
//			FarmdiaryVo vo = new FarmdiaryVo();
//			vo.setB_type_code(sdate + "-01-01");
//			String edt = "" + (Integer.parseInt(edate));
//			vo.setW_step_code(edt + "-12-31");
//			farmCount = fdataService.datefarmCount(vo);
//			model.addAttribute("choice", sdate + "~" + edt);
//		}
//		model.addAttribute("farmCount", farmCount);
//		
//		return "/ajax/mainratio";
//	}

}
