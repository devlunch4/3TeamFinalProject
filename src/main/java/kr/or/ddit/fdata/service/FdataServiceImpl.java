package kr.or.ddit.fdata.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.fdata.repository.FdataDaoImpl;

@Service("fdataService")
public class FdataServiceImpl implements FdataService{
	
	@Resource(name = "fdataDao")
	private FdataDaoImpl fdataDao;
	

}
