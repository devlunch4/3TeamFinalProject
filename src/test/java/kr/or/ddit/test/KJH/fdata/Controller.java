package kr.or.ddit.test.KJH.fdata;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;

import kr.or.ddit.test.config.WebTestConfig;

public class Controller extends WebTestConfig{

	@Test
	public void popularity() throws Exception{
		mockMvc.perform(get("/fdata/popularity"))
		.andExpect(status().isOk())
		.andExpect(view().name("tiles.fdata.popularity"));
	}
	
	@Test
	public void ratioall() throws Exception{
		mockMvc.perform(get("/fdata/ratio"))
		.andExpect(status().isOk())
		.andExpect(view().name("tiles.fdata.ratio"));
	}
	
	@Test
	public void ratioweek() throws Exception{
		mockMvc.perform(get("/fdata/ratio")
				.param("selec", "week")
				.param("sdate", "2021-02-28~2021-03-06")
				.param("edate","")
				)
		.andExpect(status().isOk())
		.andExpect(view().name("tiles.fdata.ratio"));
	}
	
	@Test
	public void ratioweek2() throws Exception{
		mockMvc.perform(get("/fdata/ratio")
				.param("selec", "week")
				.param("sdate", "2021-08~23-06")
				.param("edate","")
				)
		.andExpect(status().isOk())
		.andExpect(view().name("tiles.fdata.ratio"));
	}
	
	@Test
	public void ratiomonth() throws Exception{
		mockMvc.perform(get("/fdata/ratio")
				.param("selec", "month")
				.param("sdate", "2020-01")
				.param("edate","2022-12")
				)
		.andExpect(status().isOk())
		.andExpect(view().name("tiles.fdata.ratio"));
	}
	
	@Test
	public void ratioyear() throws Exception{
		mockMvc.perform(get("/fdata/ratio")
				.param("selec", "year")
				.param("sdate", "2020")
				.param("edate","2022")
				)
		.andExpect(status().isOk())
		.andExpect(view().name("tiles.fdata.ratio"));
	}
	
	@Test
	public void popularityselect() throws Exception{
		mockMvc.perform(get("/fdata/popularityselect")
				.param("Item_code", "배추")
				)
		.andExpect(status().isFound())
		.andExpect(view().name("redirect:/finfo/gardenguides?xguide_code=12"));
	}
}
