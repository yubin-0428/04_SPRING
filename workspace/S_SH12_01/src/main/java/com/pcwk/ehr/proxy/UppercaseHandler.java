package com.pcwk.ehr.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// 다이내믹 프록시로부터 요청을 전달 받으려면 InvocationHandler를 구현해야한다.
// 메소드는 invoke() 하나만 있다.

/*
 * 소스의 문제 해결
 * 1. toUpperCase() 메소드 중복발생.
 * 2. 인터페이스의 모드 메서드를 구현해야한다.
 */

public class UppercaseHandler implements InvocationHandler {
	final Logger LOG = LogManager.getLogger(getClass());
	Object target; // 모든 인터페이스를 수용 가능하도록 수정
	
	// 다이내믹 프로시로부터 전달받은 요청을 다시 타깃 오브젝트에 위임하기위해 주입받는다.
	public UppercaseHandler(Hello target) {
		this.target = target;
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		// 타깃으로 위임, 인터페이스의 메소드 호출에 모두 적용
		Object ret = (String)method.invoke(target, args);
		LOG.debug("++++++++++++++++++++++++++++++++++");
		LOG.debug("+invoke()+"+ method.getName());
		LOG.debug("++++++++++++++++++++++++++++++++++");
		
		// sayH인 경우만 대문자로 변환
		if(ret instanceof String && method.getName().startsWith("sayH")) {
			return ((String)ret).toUpperCase(); // 부가기능
		}else {
			return ret;
		}
	}
}
