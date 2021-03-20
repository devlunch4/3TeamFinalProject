package kr.or.ddit.batch.repository;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.batch.model.StandarditemcodeVo;

@Repository("sdCodeDao")
public class SdCodeDaoImpl implements SdCodeDao{

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate tempplate;
	
	@Override
	public int sdcodeInsert(StandarditemcodeVo Vo) {
		return tempplate.insert("codes.sdcodeInsert",Vo);
	}

	@Override
	public int allsdcodeDelete() {
		return tempplate.delete("codes.allsdcodeDelete");
	}

}
