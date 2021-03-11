package kr.or.ddit.fdata.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.CodesVo;
import kr.or.ddit.farm.model.FarmdiaryVo;
import kr.or.ddit.fdata.repository.FdataDaoImpl;

@Service("fdataService")
public class FdataServiceImpl implements FdataService {

	@Resource(name = "fdataDao")
	private FdataDaoImpl fdataDao;

	// 20210302_KJH
	// codes 리스트 전체조회
	@Override
	public List<CodesVo> selectAllCodes() {
		return fdataDao.selectAllCodes();
	}

	@Override
	public CodesVo selectCode(String str) {
		// TODO Auto-generated method stub
		return fdataDao.selectCode(str);
	}

	@Override
	public List<FarmdiaryVo> farmCount() {
		// TODO Auto-generated method stub
		return fdataDao.farmCount();
	}

	// 20210310_KJH 날짜조건 품목비율
	@Override
	public List<FarmdiaryVo> datefarmCount(FarmdiaryVo vo) {
		// TODO Auto-generated method stub
		return fdataDao.datefarmCount(vo);
	}

}