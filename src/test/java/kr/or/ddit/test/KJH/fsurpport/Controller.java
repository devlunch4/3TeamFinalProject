package kr.or.ddit.test.KJH.fsurpport;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import kr.or.ddit.fdata.service.FdataServiceImpl;
import kr.or.ddit.fsurpport.service.FsurpportService;
import kr.or.ddit.test.config.WebTestConfig;
import kr.or.ddit.user.model.UserVo;

public class Controller extends WebTestConfig{
	
	@Resource(name = "fsurpportService")
	private FsurpportService fsurpportService;

	@Resource(name = "fdataService")
	private FdataServiceImpl fdataService;

	@Test
	public void fmanageList() throws Exception{
		mockMvc.perform(get("/fsurpport/fmanageList"))
		.andExpect(status().isOk())
		.andExpect(view().name("tiles.fsurpport.fmanageList"));
	}
	
	@Test
	public void fmanage() throws Exception{
		UserVo user = new UserVo();
		user.setUser_id("brown");
		
		MockHttpSession session = new MockHttpSession();
	    session.setAttribute("S_USER", user);
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    request.setSession(session);
	    RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		mockMvc.perform(get("/fsurpport/fmanageInfo").session(session)
				.param("manage_no", "2"))
		.andExpect(status().isOk())
		.andExpect(view().name("tiles.fsurpport.fmanageInfo"));
	}
	
	@Test
	public void fmanageInsertPage() throws Exception{
		UserVo user = new UserVo();
		user.setUser_id("brown");
		
		MockHttpSession session = new MockHttpSession();
	    session.setAttribute("S_USER", user);
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    request.setSession(session);
	    RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		mockMvc.perform(get("/fsurpport/fmanageInsertPage").session(session))
		.andExpect(status().isOk())
		.andExpect(view().name("tiles.fsurpport.fmanageInsert"));
	}
	
	@Test
	public void fmanageInsert() throws Exception{
		UserVo user = new UserVo();
		user.setUser_id("brown");

		MockHttpSession session = new MockHttpSession();
	    session.setAttribute("S_USER", user);
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    request.setSession(session);
	    RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		mockMvc.perform(get("/fsurpport/fmanageInsert").session(session)
				.param("owner", "brown")
				.param("location", "test")
				.param("info", "test")
				.param("item_code", "111")
				.param("msr_code", "uno04"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/fsurpport/fmanageList"));
	}
	
	@Test
	public void fmanageUpdateget() throws Exception{
		mockMvc.perform(get("/fsurpport/fmanageUpdate")
				.param("manage_no", "1"))
		.andExpect(status().isOk())
		.andExpect(view().name("tiles.fsurpport.fmanageUpdate"));
	}
	
	@Test
	public void fmanageUpdatepost() throws Exception{

		mockMvc.perform(post("/fsurpport/fmanageUpdate")
				.param("manage_no", "1")
				.param("location", "uptest")
				.param("info", "uptest")
				.param("item_code", "111"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/fsurpport/fmanageInfo?manage_no=1"));
	}
	
	
	@Test
	public void fmanagedelete() throws Exception{

		mockMvc.perform(get("/fsurpport/fmanageDelete")
				.param("manage_no", "1"))
		.andExpect(status().isFound())
		.andExpect(view().name("redirect:/fsurpport/fmanageList"));
	}
	
	@Test
	public void msrequipChangex() throws Exception{

		mockMvc.perform(get("/fsurpport/msrequipChange")
				.param("manage_no", "1"))
		.andExpect(status().isFound())
		.andExpect(view().name("redirect:/fsurpport/fmanageInfo?manage_no=1"));
	}
	
	@Test
	public void msrequipChange() throws Exception{

		mockMvc.perform(get("/fsurpport/msrequipChange")
				.param("manage_no", "1")
				.param("msr_code", "uno04"))
		.andExpect(status().isFound())
		.andExpect(view().name("redirect:/fsurpport/fmanageInfo?manage_no=1"));
	}
	
	
	@Test
	public void myYieldall() throws Exception{
		
		UserVo user = new UserVo();
		user.setUser_id("brown");
		
		MockHttpSession session = new MockHttpSession();
	    session.setAttribute("S_USER", user);
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    request.setSession(session);
	    RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		mockMvc.perform(get("/fsurpport/myYield").session(session)
				.param("selec", "all"))
		.andExpect(status().isOk())
		.andExpect(view().name("tiles.fanalysis.myYield"));
	}
	
	@Test
	public void myYieldweek() throws Exception{
		UserVo user = new UserVo();
		user.setUser_id("brown");
		
		MockHttpSession session = new MockHttpSession();
	    session.setAttribute("S_USER", user);
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    request.setSession(session);
	    RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	    
		mockMvc.perform(get("/fsurpport/myYield").session(session)
				.param("selec", "week")
				.param("sdate", "2021-02-28~2021-03-06")
				.param("edate",""))
		.andExpect(status().isOk())
		.andExpect(view().name("tiles.fanalysis.myYield"));
	}
	
	@Test
	public void myYieldweekx() throws Exception{
		UserVo user = new UserVo();
		user.setUser_id("brown");
		
		MockHttpSession session = new MockHttpSession();
	    session.setAttribute("S_USER", user);
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    request.setSession(session);
	    RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	    
		mockMvc.perform(get("/fsurpport/myYield").session(session)
				.param("selec", "week")
				.param("sdate", "2021-02-1-03-06")
				.param("edate",""))
		.andExpect(status().isOk())
		.andExpect(view().name("tiles.fanalysis.myYield"));
	}
	
	@Test
	public void myYieldmonth() throws Exception{
		UserVo user = new UserVo();
		user.setUser_id("brown");
		
		MockHttpSession session = new MockHttpSession();
	    session.setAttribute("S_USER", user);
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    request.setSession(session);
	    RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	    
		mockMvc.perform(get("/fsurpport/myYield").session(session)
				.param("selec", "month")
				.param("sdate", "2021-12")
				.param("edate","2021-12"))
		.andExpect(status().isOk())
		.andExpect(view().name("tiles.fanalysis.myYield"));
	}
	
	@Test
	public void myYieldyear() throws Exception{
		UserVo user = new UserVo();
		user.setUser_id("brown");
		
		MockHttpSession session = new MockHttpSession();
	    session.setAttribute("S_USER", user);
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    request.setSession(session);
	    RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	    
		mockMvc.perform(get("/fsurpport/myYield").session(session)
				.param("selec", "year")
				.param("sdate", "2020")
				.param("edate","2021"))
		.andExpect(status().isOk())
		.andExpect(view().name("tiles.fanalysis.myYield"));
	}
	
//	@Test
//	public void myYield() throws Exception{
//
//		mockMvc.perform(get("/fsurpport/myYield")
//				.param("selec", "1")
//				.param("msr_code", "uno04"))
//		.andExpect(status().isFound())
//		.andExpect(view().name("redirect:/fsurpport/fmanageInfo?manage_no=1"));
//	}
	
	
	
	
}
