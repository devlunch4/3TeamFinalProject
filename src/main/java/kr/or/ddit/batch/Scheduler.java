package kr.or.ddit.batch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kr.or.ddit.batch.model.StandarditemcodeVo;
import kr.or.ddit.batch.service.SdCodeService;
import kr.or.ddit.finfo.web.FinfoController;

// cron 스케줄러 클래스임을 선언하는 어노테이션.
@Component
public class Scheduler {
	private static final Logger logger = LoggerFactory.getLogger(Scheduler.class);
	
	@Resource(name = "sdCodeService")
	private SdCodeService sdCodeService;
	
// cron 문법으로 스케줄러가 실행되는 주기를 설정.(아래의 cron 스케줄 문법에 자세한 설명)
	@Scheduled(cron = "30 * * * * *")
	public void run() throws IOException{
		
		StandarditemcodeVo Vo = new StandarditemcodeVo();

		String path = "C:\\Users\\PC-12\\git\\3TeamFinalProject\\src\\main\\webapp\\resources"; // 현재폴더의 디렉토리 가지고 오기.
		File file = new File(path + "\\농림축산식품부_표준코드2.csv"); // 현재 폴더의 디렉토리에 파일 저장해놓고 경로 지정.

		BufferedReader br = new BufferedReader(new BufferedReader(new FileReader(file))); // 버퍼리더 만들기.

		String line = "";

		logger.debug("ok");
		sdCodeService.allsdcodeDelete();
		logger.debug("o?");
		while ((line = br.readLine()) != null) { // 한 라인씩 읽어오기.
//			System.out.println(line);
			if(line.indexOf("어비") == -1 && line.indexOf("LCLASSCODE") == -1) {
			String lines[] = line.split(",");
			
			Vo.setLclasscode(lines[0]);
			Vo.setLclassname(lines[1]);
			Vo.setMclasscode(lines[2]);
			Vo.setMclassname(lines[3]);
			Vo.setSclasscode(lines[4]);
			Vo.setSclassname(lines[5]);
			
			sdCodeService.sdcodeInsert(Vo);
		}
			
		}
		logger.debug("o");
	}
}