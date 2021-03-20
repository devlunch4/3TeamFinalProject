package kr.or.ddit.batch.service;

import kr.or.ddit.batch.model.StandarditemcodeVo;

public interface SdCodeService {

	int sdcodeInsert(StandarditemcodeVo Vo);
	
	int allsdcodeDelete();
}
