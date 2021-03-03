package kr.or.ddit.fdata.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;


@Repository("fdataDao")
public class FdataDaoImpl implements FdataDao{
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate tempplate;


}
