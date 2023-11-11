package org.dawin.service;

import java.util.List;

import org.dawin.config.RootConfig;
import org.dawin.config.SecurityConfig;
import org.dawin.domain.AlarmVO;
import org.dawin.domain.Criteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class, SecurityConfig.class })
@Log4j
public class AlaramServiceTest {

	@Autowired
	private AlarmService service;

//	@Test
	public void testGetList() {

		List<AlarmVO> list = service.getList();

		for (AlarmVO alarm : list) {
			log.info(alarm);
		}

	}
	
//	@Test
	public void testGet() {
		log.info(service.get("Russia"));
	}
	
	@Test
	public void testGetListLvl() {

		List<AlarmVO> list = service.getListLvl(3L);

		for (AlarmVO alarm : list) {
			log.info(alarm);
		}

	}
	
	
}