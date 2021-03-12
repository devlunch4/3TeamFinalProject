package kr.or.ddit.finfo.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;

import kr.or.ddit.test.config.WebTestConfig;

public class FinfoControllerTest_KWS extends WebTestConfig {

	@Test // KWS 텃밭 가이드 (재배정보 진입) 조회 테스트 20210311
	public void gardenguidesTest() throws Exception {
		mockMvc.perform(get("/finfo/gardenguides")).andExpect(view().name("tiles.finfo.gardenguides"))
				.andExpect(status().isOk()).andExpect(model().attributeExists("chosungArr")).andDo(print());
	}

	@Test // KWS 텃밭 가이드 (재배정보 진입) 조회 테스트 20210311 ㅎ 인 경우
	public void gardenguidesTest2() throws Exception {
		mockMvc.perform(get("/finfo/gardenguides").param("chosung", "ㅎ"))
				.andExpect(view().name("tiles.finfo.gardenguides")).andExpect(status().isOk())
				.andExpect(model().attributeExists("chosungArr")).andDo(print());
	}

	@Test // KWS 텃밭 가이드 (재배정보 진입) 조회 테스트 20210311 ㄴ 인 경우
	public void gardenguidesTest3() throws Exception {
		mockMvc.perform(get("/finfo/gardenguides").param("chosung", "ㄴ"))
				.andExpect(view().name("tiles.finfo.gardenguides")).andExpect(status().isOk())
				.andExpect(model().attributeExists("chosungArr")).andDo(print());
	}

	@Test // KWS 텃밭 가이드 등록페이지이동 테스트 (재배정보 등록페이지 진입) 20210311
	public void gardenguidesInsertTest() throws Exception {
		mockMvc.perform(get("/finfo/gardenguidesInsert")).andExpect(view().name("tiles.finfo.gardenguidesInsert"))
				.andExpect(status().isOk()).andDo(print());
	}

	// guideimg
	@Test // KWS 텃밭 가이드 이미지 보기 불러오기 테스트 20210311
	public void guideimgTest() throws Exception {
		mockMvc.perform(get("/finfo/guideimg?guide_code=0")).andExpect(status().isOk()).andDo(print());
	}
	
	@Test // KWS 텃밭 가이드 수정페이지 이동 테스트 20210311
	public void gardenguidesUpdateTest() throws Exception {
		mockMvc.perform(post("/finfo/gardenguidesUpdate").param("xguide_code", "0"))
				.andExpect(view().name("tiles.finfo.gardenguidesUpdate")).andExpect(status().isOk())
				.andExpect(model().attributeExists("xguide_code","gardenguidesVo")).andDo(print());
	}

}
