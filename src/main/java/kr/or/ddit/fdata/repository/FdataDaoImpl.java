package kr.or.ddit.fdata.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.CodesVo;

@Repository("fdataDao")
public class FdataDaoImpl implements FdataDao{
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate tempplate;

	//20210302_KJH
	//codes 리스트 전체조회
	@Override
	public List<CodesVo> selectcodes() {
		// TODO Auto-generated method stub
		return tempplate.selectList("codes.selectcodes");
	}

}
