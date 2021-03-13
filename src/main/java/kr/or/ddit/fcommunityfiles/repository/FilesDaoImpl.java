package kr.or.ddit.fcommunityfiles.repository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.farm.model.FilesVo;

@Repository("filesDao")
public class FilesDaoImpl implements FilesDao {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate template;

	// 20210310 SHS - Files 리스트 조회
	@Override
	public List<FilesVo> selectfiles() {
		return template.selectList("files.selectfiles");
	}

	// 20210310 SHS - Files 등록 하기
	@Override
	public int registerfiles(FilesVo filesVo) {
		return template.insert("files.registerfiles", filesVo);
	}

	@Override
	public FilesVo selectonefiles(String file_path) {
		
		return template.selectOne(file_path);
	}

}
