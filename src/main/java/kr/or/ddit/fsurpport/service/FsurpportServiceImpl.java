package kr.or.ddit.fsurpport.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.fsurpport.repository.FsurpportDao;

@Service("fsurpportService")
public class FsurpportServiceImpl implements FsurpportService{
	
	private static final Logger logger = LoggerFactory.getLogger(FsurpportServiceImpl.class);
	
	
	@Resource(name="fsurpportDao")
	private FsurpportDao fsurpportDao;
	
	public FsurpportServiceImpl() {}
	
	public FsurpportServiceImpl(FsurpportDao fsurpportDao) {
		this.fsurpportDao = fsurpportDao;
	}
	
	
	
}
