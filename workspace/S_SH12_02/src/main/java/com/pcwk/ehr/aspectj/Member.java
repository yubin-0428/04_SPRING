package com.pcwk.ehr.aspectj;

public interface Member {

	int doSave();
	
	int doUpdate();
	
	int delete();
	
	void doRetrieve(int age);
	
}
