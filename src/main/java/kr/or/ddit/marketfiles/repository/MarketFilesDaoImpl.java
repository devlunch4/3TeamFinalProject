package kr.or.ddit.marketfiles.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.farm.model.MarketFilesVo;

@Repository("marketfilesDao")
public class MarketFilesDaoImpl implements MarketFilesDao{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	@Override
	public List<MarketFilesVo> selectfiles() {
		// TODO Auto-generated method stub
		return template.selectList("marketfiles.selectfiles");
	}

	@Override
	public int registerfiles(MarketFilesVo mkVo) {
		return template.insert("marketfiles.registermarketfiles", mkVo);
	}
	
	
}
