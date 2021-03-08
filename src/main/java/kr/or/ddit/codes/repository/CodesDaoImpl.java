package kr.or.ddit.codes.repository;

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
	public CodesVo allCodes( ) {
		return tempplate.selectOne("codes.selectAllCodes");
	}
	
}
