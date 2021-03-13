package kr.or.ddit.finfo.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockMultipartFile;

import kr.or.ddit.test.config.WebTestConfig;

public class FinfoControllerTest_KWS extends WebTestConfig {

	@Test // KWS 텃밭 가이드 (재배정보 진입) 조회 테스트 20210311
	public void gardenguidesTest() throws Exception {
		mockMvc.perform(get("/finfo/gardenguides")).andExpect(view().name("tiles.finfo.gardenguides"))
				.andExpect(status().isOk()).andExpect(model().attributeExists("chosungArr")).andDo(print());
	}

	@Test // KWS 텃밭 가이드 (재배정보 진입) 조회2 테스트 20210311 ㅎ 인 경우
	public void gardenguidesTest2() throws Exception {
		mockMvc.perform(get("/finfo/gardenguides").param("chosung", "ㅎ"))
				.andExpect(view().name("tiles.finfo.gardenguides")).andExpect(status().isOk())
				.andExpect(model().attributeExists("chosungArr")).andDo(print());
	}

	@Test // KWS 텃밭 가이드 (재배정보 진입) 조회3 테스트 20210311 ㄴ 인 경우
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

	@Test // KWS 텃밭 가이드 등록페이지이동 테스트 (재배정보 등록) 20210312
	public void gardenguidesInsertBtnTest() throws Exception {
		// 이미지파일 설정
		ClassPathResource resource = new ClassPathResource("test/test_mastercard.jpg");
		MockMultipartFile file_nm2 = new MockMultipartFile("file_nm2", "test_mastercard.jpg", "image/jpg",
				resource.getInputStream());
		// 등록수행
		mockMvc.perform(fileUpload("/finfo/gardenguidesInsertBtn").file(file_nm2).param("guide_code", "seq자동")
				.param("writer", "test").param("class_code", "과").param("item_code", "이름").param("difficulty", "1")
				.param("grow_start_time", "0월").param("grow_time", "0개월").param("origin", "우주")
				.param("temperature", "0도").param("damage", "0없음").param("season", "0계절").param("effect", "0효과")
				.param("ingredient", "0성분").param("plant_tip", "0팁").param("plant_content", "0내용").param("file_no", "0")
				.param("reg_dt", "20210303").param("use_yn", "Y")).andExpect(view().name("tiles.finfo.gardenguides"))
				.andExpect(status().isOk()).andExpect(model().attributeExists("chosungArr", "chosung",
						"gardenguidesList", "xguide_code", "gardenguidesVo"))
				.andDo(print());
	}

	@Test // KWS 텃밭 가이드 이미지 보기 불러오기 테스트 20210311
	public void guideimgTest() throws Exception {
		mockMvc.perform(get("/finfo/guideimg?guide_code=0")).andExpect(status().isOk()).andDo(print());
	}

	@Test // KWS 텃밭 가이드 수정페이지 이동 테스트 20210311
	public void gardenguidesUpdateTest() throws Exception {
		mockMvc.perform(post("/finfo/gardenguidesUpdate").param("xguide_code", "0"))
				.andExpect(view().name("tiles.finfo.gardenguidesUpdate")).andExpect(status().isOk())
				.andExpect(model().attributeExists("xguide_code", "gardenguidesVo")).andDo(print());
	}

	@Test // KWS 텃밭 가이드 수정페이지 수정 테스트 20210311
	public void gardenguidesUpdateBtnTest() throws Exception {
		// 이미지파일 설정
		ClassPathResource resource = new ClassPathResource("test/test_mastercard.jpg");
		MockMultipartFile file_nm2 = new MockMultipartFile("file_nm2", "test_mastercard.jpg", "image/jpg",
				resource.getInputStream());
		// 등록수행
		mockMvc.perform(fileUpload("/finfo/gardenguidesUpdateBtn").file(file_nm2).param("guide_code", "0")
				.param("writer", "test").param("class_code", "과").param("item_code", "이름").param("difficulty", "1")
				.param("grow_start_time", "0월").param("grow_time", "0개월").param("origin", "우주")
				.param("temperature", "0도").param("damage", "0없음").param("season", "0계절").param("effect", "0효과")
				.param("ingredient", "0성분").param("plant_tip", "0팁").param("plant_content", "0내용").param("file_no", "0")
				.param("reg_dt", "20210303").param("use_yn", "Y")).andExpect(view().name("tiles.finfo.gardenguides"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("chosungArr", "xguide_code", "gardenguidesVo")).andDo(print());
	}

	@Test // KWS 텃밭 가이드 삭제처리 테스트 20210311
	public void gardenguideDeleteTest() throws Exception {
		mockMvc.perform(post("/finfo/gardenguidesDelete").param("xguide_code", "0").param("guide_code", "0"))
				.andExpect(redirectedUrl("/finfo/gardenguides")).andExpect(status().is3xxRedirection()).andDo(print());
	}

	@Test // KWS 텃밭 가이드 관리자용 목록조회 테스트 20210311
	public void gardenguidesAllTest() throws Exception {
		mockMvc.perform(get("/finfo/gardenguidesAll")).andExpect(view().name("tiles.finfo.gardenguidesall"))
				.andExpect(status().isOk()).andExpect(model().attributeExists("guidelists")).andDo(print());
	}

}
