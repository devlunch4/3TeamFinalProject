package kr.or.ddit.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.codes.service.CodesService;
import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.farm.model.MsrrecVo;
import kr.or.ddit.fdata.service.FdataService;
import kr.or.ddit.fsurpport.service.FsurpportService;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.web.UserController;

@RequestMapping("api")
@Controller
public class Api {

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

	@RequestMapping(value = "/list/{selec}/{sdate}/{edate}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody() // JSON
	public List<Map> home(@PathVariable String selec, String sdate, String edate) {

		logger.debug("IN ratio()");
		logger.debug("edate value : {}", edate);
		List<Map> listlist = new ArrayList<Map>();
		List<FarmdiaryVo> farmCount = new ArrayList<FarmdiaryVo>();

		if (selec == null || selec.equals("all") || sdate == null || sdate == "") {
			farmCount = fdataService.farmCount();

			for (int i = 0; i < farmCount.size(); i++) {
				Map<String, String> maps = new HashMap<String, String>();
				maps.put("content", farmCount.get(i).getContent());
				maps.put("yield", Integer.toString(farmCount.get(i).getYield()));

				listlist.add(maps);
			}
			return listlist;
		} else if (selec.equals("week")) {
			try {
				String[] dt = sdate.split("~");
				String sd = dt[0];
				String ed = dt[1];

				FarmdiaryVo vo = new FarmdiaryVo();
				vo.setB_type_code(sd);
				vo.setW_step_code(ed);
				farmCount = fdataService.datefarmCount(vo);

				for (int i = 0; i < farmCount.size(); i++) {
					Map<String, String> maps = new HashMap<String, String>();
					maps.put("content", farmCount.get(i).getContent());
					maps.put("yield", Integer.toString(farmCount.get(i).getYield()));

					listlist.add(maps);
				}
			} catch (Exception e) {
				return listlist;
			}
			return listlist;
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
			farmCount = fdataService.datefarmCount(vo);

			for (int i = 0; i < farmCount.size(); i++) {
				Map<String, String> maps = new HashMap<String, String>();
				maps.put("content", farmCount.get(i).getContent());
				maps.put("yield", Integer.toString(farmCount.get(i).getYield()));

				listlist.add(maps);
			}

			return listlist;

		} else if (selec.equals("year")) {
			FarmdiaryVo vo = new FarmdiaryVo();
			vo.setB_type_code(sdate + "-01-01");
			String edt = "" + (Integer.parseInt(edate));
			vo.setW_step_code(edt + "-12-31");
			farmCount = fdataService.datefarmCount(vo);

			for (int i = 0; i < farmCount.size(); i++) {
				Map<String, String> maps = new HashMap<String, String>();
				maps.put("content", farmCount.get(i).getContent());
				maps.put("yield", Integer.toString(farmCount.get(i).getYield()));

				listlist.add(maps);
			}

			return listlist;
		} else {
			farmCount = fdataService.farmCount();

			for (int i = 0; i < farmCount.size(); i++) {
				Map<String, String> maps = new HashMap<String, String>();
				maps.put("content", farmCount.get(i).getContent());
				maps.put("yield", Integer.toString(farmCount.get(i).getYield()));

				listlist.add(maps);
			}
			return listlist;
		}

	}
	
	//api 홈페이지 호출
	@RequestMapping("apiData")
	public String addData(Model model) {
		logger.debug("api 페이지");
		
		return "tiles.api.api";
	}
}
