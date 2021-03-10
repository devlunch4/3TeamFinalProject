package kr.or.ddit.marketfiles.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.farm.model.MarketFilesVo;
import kr.or.ddit.marketfiles.repository.MarketFilesDaoImpl;

@Service("marketfilesService")
public class MarketFilesServiceImpl implements MarketFilesService{
	
	@Resource(name = "marketfilesDao")
	private MarketFilesDaoImpl dao;

	@Override
	public List<MarketFilesVo> selectfiles() {
		return dao.selectfiles();
	}

	@Override
	public int registerfiles(MarketFilesVo mkVo) {
		return dao.registerfiles(mkVo);
	}
	
	
}
