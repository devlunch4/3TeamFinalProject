package kr.or.ddit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.servlet.view.AbstractView;

import kr.or.ddit.user.model.UserVo;

public class ExcelDownloadView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setContentType("application/vnd.ms-excel; charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename=text.xlsx");
		// Header : List<String>
		// data : List<UserVo>

		List<String> header = (List<String>) model.get("header");
		List<UserVo> data = (List<UserVo>) model.get("data");

		// excel 파일 생성
		XSSFWorkbook book = new XSSFWorkbook();
		// 시트생성 ss
		Sheet sheet = book.createSheet("users");
		// row / col 생성
		int rownum = 0;
		int colnum = 0;
		Row row = sheet.createRow(rownum++); // row 가로 만들기

		// 향상된 for 문 만큼 넣기
		for (String h : header) {
			Cell cell = row.createCell(colnum++); // cell 세로 만들기
			cell.setCellValue(h);
		}

		// data는 나중에
		data.size();

//		for (UserVo d : data) {
//			row = sheet.createRow(rownum++);
//			colnum = 0;
//			Cell cell = row.createCell(colnum++);
//			cell.setCellValue(d.getUserid());
//			cell = row.createCell(colnum++);
//			cell.setCellValue(d.getUsernm());
//			cell = row.createCell(colnum++);
//			cell.setCellValue(d.getAlias());
//		}

		// 강사 방법
		for (UserVo d : data) {
			colnum = 0;
			Row r = sheet.createRow(rownum++);
			r.createCell(colnum++).setCellValue(d.getUserid());
			r.createCell(colnum++).setCellValue(d.getUsernm());
			r.createCell(colnum++).setCellValue(d.getAlias());
		}

		book.write(response.getOutputStream());
	}
}
