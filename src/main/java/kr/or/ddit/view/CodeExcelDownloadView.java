package kr.or.ddit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.AbstractView;

import kr.or.ddit.common.model.CodesVo;

public class CodeExcelDownloadView extends AbstractView {
	private static final Logger logger = LoggerFactory.getLogger(CodeExcelDownloadView.class);

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.debug("CodeExcelDownloadView lender");
		response.setContentType("application/vnd.ms-excel; charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename=text.xlsx");
		// Header : List<String>
		// data : List<UserVo>
		List<String> header = (List<String>) model.get("header");
		List<CodesVo> data = (List<CodesVo>) model.get("data");
		// excel 파일 생성
		XSSFWorkbook book = new XSSFWorkbook();
		// 시트생성
		Sheet sheet = book.createSheet("codes");
		// row / col 생성
		int rownum = 0;
		int colnum = 0;
		Row row = sheet.createRow(rownum++); // row 가로 만들기
		for (String h : header) {
			Cell cell = row.createCell(colnum++); // cell 세로 만들기
			cell.setCellValue(h);
		}
		data.size();
		for (CodesVo d : data) {
			colnum = 0;
			Row r = sheet.createRow(rownum++);
			r.createCell(colnum++).setCellValue(d.getCode_no());
			r.createCell(colnum++).setCellValue(d.getCode_nm());
			r.createCell(colnum++).setCellValue(d.getParent_code());
			r.createCell(colnum++).setCellValue(d.getUse_yn());
		}
		book.write(response.getOutputStream());
	}
}
