package kr.or.ddit.fsurpport.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.common.model.FilesVo;
import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.farm.model.FmanageVo;
import kr.or.ddit.farm.model.MsrequipVo;
import kr.or.ddit.farm.model.MsrrecVo;

@Repository("fsurpportDao")
public class FsurpportDaoImpl implements FsurpportDao {

	private static final Logger logger = LoggerFactory.getLogger(FsurpportDaoImpl.class);

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate template;

	// ggy_20210303 : 등록된 영농일지 전체 리스트 조회
	@Override
	public List<FarmdiaryVo> selectAllFsurpportList() {
		return template.selectList("fsurpports.selectAllFsurpportList");
	}

	// ggy_20210303 : 등록된 품목 코드 리스트 조회
	@Override
	public List<CodesVo> selectAllItem_codeList() {
		return template.selectList("fsurpports.selectAllItem_codeList");
	}

	// ggy_20210303 : 등록된 작업단계 리스트 조회
	@Override
	public List<CodesVo> selectAllWstep_codeList() {
		return template.selectList("fsurpports.selectAllWstep_codeList");
	}
	
	// ggy_20210305 : 등록된 사업유형 리스트 조회
	@Override
	public List<CodesVo> selectAllBtype_codeList() {
		return template.selectList("fsurpports.selectAllBtype_codeList");
	}

	// ggy_20210303 : 등록된 일지 조건 검색
	@Override
	public List<FarmdiaryVo> searchAllFarmdiaryList(FarmdiaryVo farmdiaryVo) {
		return template.selectList("fsurpports.searchAllFarmdiaryList", farmdiaryVo);
	}
	
	
	// ggy_20210305 : 해당 일지 정보 조회
	@Override
	public FarmdiaryVo selectFarmdiaryInfo(int fdiary_no) {
		return template.selectOne("fsurpports.selectFarmdiaryInfo", fdiary_no);
	}
	
	// ggy_20210305 : 영농일지 등록때 파일 있으면 파일 등록
	@Override
	public int registFiles(FilesVo filesVo) {
		return template.insert("fsurpports.registFiles", filesVo);
	}
	
	// ggy_20210305 : 영농일지 등록을 위한 등록된 파일 정보 가져오기
	@Override
	public FilesVo selectFilesInfo(String file_nm) {
		return template.selectOne("fsurpports.selectFilesInfo", file_nm);
	}
	
	// ggy_20210305 : 영농일지 등록
	@Override
	public int registFarmdiary(FarmdiaryVo farmdiaryVo) {
		return template.insert("fsurpports.registFarmdiary", farmdiaryVo);
	}
	
	
	
	
	
	/* 시설관리 영역 */

	// 20210302_KJH 시설리스트 조회
	@Override
	public List<FmanageVo> myfmanageList() {
		return template.selectList("fmanage.myfmanageList");
	}
	// 20210302_KJH 시설 상세조회
	@Override
	public FmanageVo fmanageInfo(String str) {
		return template.selectOne("fmanage.fmanageInfo", str);
	}

	// 20210304_KJH 시설 최근 측정정보 조회
	@Override
	public MsrrecVo latelyData(String msr_code) {
		return template.selectOne("fmanage.latelyData",msr_code);
	}
	// 20210304_KJH 보유 장비 조회
	@Override
	public List<MsrequipVo> msrequipList(String owner) {
		return template.selectList("fmanage.msrequipList",owner);
	}

		
	// 등록된 시설 카운트 03/04 (경찬)
	@Override
	public int fmanageCount(String user_id) {
		return template.selectOne("fmanage.fmanageCount", user_id);
	}
	
	// 등록된 일지 카운트 03/04 (경찬)
	@Override
	public int fsurCount(String user_id) {
		return template.selectOne("fsurpports.fsurCount", user_id);
	}


}
