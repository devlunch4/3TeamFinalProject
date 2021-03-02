package kr.or.ddit.fdata.repository;

import java.util.List;

import kr.or.ddit.farm.model.ItemsVo;

public interface FdataDao {
	
	List<ItemsVo> selectItems (int category_code);

}
