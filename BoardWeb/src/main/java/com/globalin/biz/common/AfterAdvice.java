package com.globalin.biz.common;

public class AfterAdvice {

	public void finallyLog() {
		System.out.println("[사후처리] 비스니스 로직 수행 후 무조건 동작.....");
	}
}
