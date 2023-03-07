package com.globalin.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		
		String method = pjp.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		//System.out.println("[BEFORE] : 비즈니스 로직 메소드 수행 전에 처리할 내용...");
		Object returnObj = pjp.proceed();
		//System.out.println("[AFTER] : 비즈니스 로직 메소드 수행 후에 처리할 내용...");
		stopWatch.stop();
		
		System.out.println(method+"() 메소드 실행 시간 : " + stopWatch.getTotalTimeMillis()+"(ms)초");
		
		return returnObj;
	}
}
