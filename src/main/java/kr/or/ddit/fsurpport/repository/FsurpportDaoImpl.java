package kr.or.ddit.fsurpport.repository;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("fsurpportDao")
public class FsurpportDaoImpl implements FsurpportDao{
	
	private static final Logger logger = LoggerFactory.getLogger(FsurpportDaoImpl.class);
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
}
