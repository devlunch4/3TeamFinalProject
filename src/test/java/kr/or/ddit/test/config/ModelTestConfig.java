package kr.or.ddit.test.config;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//설정 정보를 넘겨주기
@ContextConfiguration(locations = { "classpath:/kr/or/ddit/config/spring/datasource-context.xml",
		"classpath:/kr/or/ddit/config/spring/root-context.xml" })
public class ModelTestConfig {

	// sercive,repository ==> root-context.xml

	@Ignore
	@Test
	public void dummy() {

	}
}
