package kr.or.ddit.fdata.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.farm.model.ItemsVo;

@Repository("fdataDao")
public class FdataDaoImpl implements FdataDao{
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate tempplate;

	@Override
	public List<ItemsVo> selectItems(int category_code) {
		// TODO Auto-generated method stub
		return tempplate.selectList("items.selectItems",category_code);
	}

}
