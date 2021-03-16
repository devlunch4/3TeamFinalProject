package kr.or.ddit.fcommunityfiles.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.farm.model.FilesVo;
import kr.or.ddit.fcommunityfiles.repository.FilesDao;

@Service("filesService")
public class FilesServiceImpl implements FilesService {

	@Resource(name = "filesDao")
	private FilesDao dao;

	// 20210310 SHS - Files 리스트 조회
	@Override
	public List<FilesVo> selectfiles() {

		return dao.selectfiles();
	}

	// 20210310 SHS - Files 등록 하기
	@Override
	public int registerfiles(FilesVo filesVo) {

		return dao.registerfiles(filesVo);
	}

	@Override
	public FilesVo selectonefiles(int file_no) {
		
		return dao.selectonefiles(file_no);
	}

}
