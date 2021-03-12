package kr.or.ddit.test.KJH.fanalysis;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import kr.or.ddit.test.config.WebTestConfig;
import kr.or.ddit.user.model.UserVo;

public class Controller extends WebTestConfig{

	@Test
	public void popularityget() throws Exception{
		UserVo user = new UserVo();
		user.setUser_id("brown");
		
		MockHttpSession session = new MockHttpSession();
	    session.setAttribute("S_USER", user);
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    request.setSession(session);
	    RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	    
		mockMvc.perform(get("/fanalysis/myfanalysisInfo").session(session))
		.andExpect(status().isOk())
		.andExpect(view().name("tiles.fanalysis.myfanalysisInfo"));
	}
	
	
	@Test
	public void popularitypostweek() throws Exception{
		UserVo user = new UserVo();
		user.setUser_id("brown");
		
		MockHttpSession session = new MockHttpSession();
	    session.setAttribute("S_USER", user);
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    request.setSession(session);
	    RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	    
		mockMvc.perform(post("/fanalysis/myfanalysisInfo")
				.session(session)
				.param("selec","week")
				.param("week", "7")
				)
		.andExpect(status().isOk())
		.andExpect(view().name("tiles.fanalysis.myfanalysisInfo"));
	}
	
	@Test
	public void popularitypostmonth() throws Exception{
		UserVo user = new UserVo();
		user.setUser_id("brown");
		
		MockHttpSession session = new MockHttpSession();
	    session.setAttribute("S_USER", user);
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    request.setSession(session);
	    RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	    
		mockMvc.perform(post("/fanalysis/myfanalysisInfo").session(session)
				.param("month", "30")
				.param("selec","month"))
		.andExpect(status().isOk())
		.andExpect(view().name("tiles.fanalysis.myfanalysisInfo"));
	}
	
	@Test
	public void popularitypost() throws Exception{
		UserVo user = new UserVo();
		user.setUser_id("brown");
		
		MockHttpSession session = new MockHttpSession();
	    session.setAttribute("S_USER", user);
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    request.setSession(session);
	    RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	    
		mockMvc.perform(post("/fanalysis/myfanalysisInfo").session(session)
				.param("day", "2021-03-01")
				.param("selec","day"))
		.andExpect(status().isOk())
		.andExpect(view().name("tiles.fanalysis.myfanalysisInfo"));
	}
	
	@Test
	public void mymaxmsrrecList() throws Exception{
		UserVo user = new UserVo();
		user.setUser_id("brown");
		
		MockHttpSession session = new MockHttpSession();
	    session.setAttribute("S_USER", user);
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    request.setSession(session);
	    RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	    
		mockMvc.perform(get("/fanalysis/mymaxmsrrecList").session(session)
				)
		.andExpect(status().isOk())
		.andExpect(view().name("tiles.fanalysis.mymaxmsrrecList"));
	}
	
	

}
