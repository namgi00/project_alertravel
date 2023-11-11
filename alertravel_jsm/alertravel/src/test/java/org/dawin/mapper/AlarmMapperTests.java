package org.dawin.mapper;

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
public class AlarmMapperTests {
	
	@Autowired
	private AlarmMapper mapper;
	
//	@Test
	public void testGetList() {
		List<AlarmVO> list = mapper.getList();
		for (AlarmVO b : list) {
			log.info(b.toString());
		}
	}
	
//	@Test
	public void testRead() {
		
		AlarmVO board = mapper.read("Russia");
		log.info(board);
	}
	
	@Test
	public void testGetListLvl() {
		List<AlarmVO> list = mapper.getListLvl(3L);
		for (AlarmVO x : list) {
			log.info(x.toString());
		}
	}
	
	
	
}