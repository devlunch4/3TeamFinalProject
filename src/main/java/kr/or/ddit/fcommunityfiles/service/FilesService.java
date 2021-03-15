package kr.or.ddit.fcommunityfiles.service;

import java.util.List;

import kr.or.ddit.farm.model.FilesVo;

public interface FilesService {

	// 20210310_SHS - 파일 리스트 조회
	List<FilesVo> selectfiles();

	// 20210310_SHS - 미니장터 게시글 작성
	int registerfiles(FilesVo filesVo);
	
	// 20210313_SHS - 파일 조회
	FilesVo selectonefiles(int file_path);
}
