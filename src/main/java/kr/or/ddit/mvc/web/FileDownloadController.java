package kr.or.ddit.mvc.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserServiceImpl;

@RequestMapping("file")
@Controller
public class FileDownloadController {

	@Resource(name = "userService")
	private UserServiceImpl userService;

	@RequestMapping("/fileDownloadView")
	public String fileDownloadView(String userid, Model model) {

		UserVo userVo = userService.selectUser(userid);
		/*
		 * model.addAttribute("realFilename", userVo.getRealfilename());
		 * model.addAttribute("filename", userVo.getFilename());
		 */

		return "fd";
	}
	/*
	 * UPDATE users SET filename='test.jpg', realfilename='d:\\upload\test.jpg'
	 * WHERE userid = 'sally'; commit;
	 */

	@RequestMapping("fileDownload")
	public void fileDownload(HttpServletResponse response, String userid) {
		UserVo userVo = userService.selectUser(userid);

		// d:\\upload\\sally.png
//
//		String realFilename = userVo.getRealfilename();
//		String filename = userVo.getFilename();
//
//		// 파일 다운로드 구현 header 사용
//
//		response.setHeader("Content-Disposition", "attachement; filename=" + filename);
//
//		ServletOutputStream sos;
//		try {
//			sos = response.getOutputStream();
//			// ? 파일을 읽어온뒤 브라우저에 출력
//			// FileInputStream fis = new FileInputStream(new File(realFilename));
//			byte[] buf = new byte[512];
//			while (fis.read(buf) != -1) {
//				sos.write(buf);
//			}
//			fis.close();
//			sos.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
