package kr.or.ddit.api;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.api.model.XFarmdiaryVo;
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
	@RequestMapping(value = "/sendxml/{selec}/{sdate}/{edate}", method = RequestMethod.GET)
	@ResponseBody
	public List<XFarmdiaryVo> sendxml(@PathVariable String selec, String sdate, String edate) {

		
		List<XFarmdiaryVo> farm = new ArrayList<XFarmdiaryVo>();
		List<FarmdiaryVo> farmCount = fdataService.farmCount();
		
		
		if (selec == null || selec.equals("all") || sdate == null || sdate == "") {
		for(int i = 0; i < farmCount.size(); i++) {
			XFarmdiaryVo Vo = new XFarmdiaryVo();	
			Vo.setContent(farmCount.get(i).getContent());
			Vo.setYield(farmCount.get(i).getYield());
			
			farm.add(Vo);
		}
		return farm;
		}else if(selec.equals("week")){
			try {
				String[] dt = sdate.split("~");
				String sd = dt[0];
				String ed = dt[1];

				FarmdiaryVo vo = new FarmdiaryVo();
				vo.setB_type_code(sd);
				vo.setW_step_code(ed);
				farmCount = fdataService.datefarmCount(vo);
				
				for(int i = 0; i < farmCount.size(); i++) {
					XFarmdiaryVo Vo = new XFarmdiaryVo();	
					Vo.setContent(farmCount.get(i).getContent());
					Vo.setYield(farmCount.get(i).getYield());
					
					farm.add(Vo);
				}
				return farm;
			} catch (Exception e) {
				return farm;
		}
			
		}else{
			for(int i = 0; i < farmCount.size(); i++) {
				XFarmdiaryVo Vo = new XFarmdiaryVo();	
				Vo.setContent(farmCount.get(i).getContent());
				Vo.setYield(farmCount.get(i).getYield());
				farm.add(Vo);
			}
			return farm;
	}
	}
}
