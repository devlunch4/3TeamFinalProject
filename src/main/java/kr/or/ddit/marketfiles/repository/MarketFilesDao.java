package kr.or.ddit.marketfiles.repository;

import java.util.List;

import kr.or.ddit.farm.model.MarketFilesVo;

public interface MarketFilesDao {
	
			// 20210310_SHS - 마켓 파일 리스트 조회
			List<MarketFilesVo> selectfiles();
			
			// 20210310_SHS - 마켓 파일 등록
			int registerfiles(MarketFilesVo mkVo);
}
