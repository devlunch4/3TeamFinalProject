package kr.or.ddit.batch.repository;

import kr.or.ddit.batch.model.StandarditemcodeVo;

public interface SdCodeDao {

	// 2021 03 20 KJH code insert test ok
	int sdcodeInsert(StandarditemcodeVo Vo);

	// 2021 03 20 KJH code delete test ok
	int allsdcodeDelete();
}
