package kr.or.ddit.fdata.service;

import java.util.List;

import kr.or.ddit.farm.model.ItemsVo;

public interface FdataService {
	
	List<ItemsVo> selectItems (int category_code);

}
