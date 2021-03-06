package kr.or.ddit.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
		// 시트생성
		Sheet sheet = book.createSheet("users");

		// row / col 생성
		int rownum = 0;
		int colnum = 0;
		Row row = sheet.createRow(rownum++); // row 가로 만들기

		for (String h : header) {
			Cell cell = row.createCell(colnum++); // cell 세로 만들기
			cell.setCellValue(h);
		}

		data.size();

		for (UserVo d : data) {
			colnum = 0;
			Row r = sheet.createRow(rownum++);
			r.createCell(colnum++).setCellValue(d.getUser_id());
			r.createCell(colnum++).setCellValue(d.getUser_nm());
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			String dateToStr = dateFormat.format(d.getReg_dt());
			r.createCell(colnum++).setCellValue(dateToStr);
		}

		book.write(response.getOutputStream());
	}
}
