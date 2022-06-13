package com.pcwk.ehr.anno.service;

import java.sql.SQLException;

import com.pcwk.ehr.anno.domain.AnnoVO;

public interface AnnoService {
	
	public AnnoVO doSelectOne(Object inVO)throws SQLException;
	
	
	
}
