package kr.or.ddit.batch.repository;

import kr.or.ddit.batch.model.StandarditemcodeVo;

public interface SdCodeDao {

	int sdcodeInsert(StandarditemcodeVo Vo);

	int allsdcodeDelete();
}
