package kr.or.ddit.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

//파일 다운로드 (우리는 사진정보)
//controller에서 개발자가 model 객체에 realfilename = 실제 디스크에 저장된 경로와 파일명을,
//filename = 업로드 당시의 파일명을 속성을 저장
public class FileDownloadView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// d:\\upload\\sally.png
		String realFilename = (String) model.get("realFilename");
		String filename = (String) model.get("filename");

		// 파일 다운로드 구현 header 사용
		response.setHeader("Content-Disposition", "attachement; filename=" + filename);

		// ? 파일을 올릴떄 사용
		ServletOutputStream sos = response.getOutputStream();

		// ? 파일을 읽어온뒤 브라우저에 출력
		FileInputStream fis = new FileInputStream(new File(realFilename));
		byte[] buf = new byte[512];
		while (fis.read(buf) != -1) {
			sos.write(buf);
		}
		fis.close();
		sos.close();

	}

}
