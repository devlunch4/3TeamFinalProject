package kr.or.ddit.mvc.web;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.user.model.UsersVo;

@RequestMapping("mvc")
@Controller
public class MvcController {
	private static final Logger logger = LoggerFactory.getLogger(MvcController.class);

	// jsp 생성 (폴더/파일명/ 내용은 나중에
	// test 코드 작성
	@RequestMapping("fileupload/view")
	public String fileuploadView() {
		logger.debug("INN MvcController.fileuploadView()");
		return "file/view";
	}

	@RequestMapping("fileupload/upload")
	public String fileupload(String userid, MultipartFile picture) {
		logger.debug("INN MvcController.fileupload()");
		logger.debug("userid: {}", userid);
		logger.debug("filesize: {}, name: {} originalFileName: {}", picture.getSize(), picture.getName(),
				picture.getOriginalFilename());
		try {
			picture.transferTo(new File("d:\\upload\\" + picture.getOriginalFilename()));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "file/view";
	}

	@RequestMapping("multi/view")
	public String multiView() {
		logger.debug("INN MvcController.multiView()");
		return "multi/view";
	}

	//@RequestMapping("multi/param")
	public String multiParam(String[] userid) {
		logger.debug("userid:{}", (Object) userid);
		return "multi/view";
	}
	
	@RequestMapping("multi/param")
	public String multiParam(UsersVo usersVo) {
		logger.debug("usersVoList:{}", usersVo);
		return "multi/view";
	}
	
}
