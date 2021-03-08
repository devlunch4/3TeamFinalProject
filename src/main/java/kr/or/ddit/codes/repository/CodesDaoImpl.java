package kr.or.ddit.codes.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.farm.model.MsrrecVo;

@Repository("codesDao")
public class CodesDaoImpl implements CodesDao {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate tempplate;

	// 모든 코드정보 조회 03/06 (경찬)
	@Override
	public List<CodesVo> allCodes() {
		return tempplate.selectList("codes.selectAllCodes");
	}

	// 해당 코드상세 정보 조회 03/08 (경찬)
	@Override
	public CodesVo selectCodes(String code_seq) {
		return tempplate.selectOne("codes.selectCodes", code_seq);
	}
	
	// 해당 코드 정보수정 03/08 (경찬)
	@Override
	public CodesVo modifyCode(CodesVo codesVo) {
		return tempplate.selectOne("codes.modifyCode", codesVo);
	}

}
