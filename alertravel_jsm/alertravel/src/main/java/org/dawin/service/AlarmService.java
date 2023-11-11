package org.dawin.service;

import java.util.List;
import org.dawin.domain.AlarmVO;
import org.dawin.domain.Criteria;

public interface AlarmService {
	
	public List<AlarmVO> getList();
	
	public List<AlarmVO> getListLvl(Long alarmLvl);
	
	public AlarmVO get(String countryEngNm);
	
}
