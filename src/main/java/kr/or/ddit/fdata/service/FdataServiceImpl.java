package kr.or.ddit.fdata.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.fdata.repository.FdataDaoImpl;

@Service("fdataService")
public class FdataServiceImpl implements FdataService{
	
	@Resource(name = "fdataDao")
	private FdataDaoImpl fdataDao;
		
	//20210302_KJH
	//codes 리스트 전체조회
	@Override
	public List<CodesVo> selectcodes() {
		
		return fdataDao.selectcodes();
	}

}
