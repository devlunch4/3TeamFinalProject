package kr.or.ddit.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("test")
@Controller
public class testController {

	//테스트 - 부트스트랩 잘 열리는지 컨트롤러
	@RequestMapping("test404")
	public String test404() {
		return "tiles.bootstrap_view.404";
	}
	
	@RequestMapping("testCharts")
	public String testCharts() {
		return "tiles.bootstrap_view.charts";
	}

	@RequestMapping("testSidenav")
	public String testsidenav() {
		return "tiles.bootstrap_view.layout-sidenav-light";
	}
	
	@RequestMapping("testLayout")
	public String testlayout() {
		return "tiles.bootstrap_view.layout-static";
	}
	
	@RequestMapping("testTables")
	public String testtables() {
		return "tiles.bootstrap_view.tables";
	}
	
}
