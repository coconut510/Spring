package org.kh.member.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	
	// 포인트컷 생성
	@Pointcut("execution(* org.kh.member.model.service..*ServiceImpl.*(..))")
	public void allPointcut() {}// 포인트컷의 ID 용도로 사용됨
	@Pointcut("execution(int org.kh.member.model.service.MemberServiceImpl.*Member(org.kh.member.model.vo.Member))")
	public void transactionPointcut() {}
	
	
	@Before("allPointcut()")// 어드바이스 시점 및 포인트컷 설정.
	public void printLog() {
		System.out.println("[공통 로그 - LogAdvice] : 비즈니스 로직 수행 전 로그 기록입니다.");
	}
	
	public void printTransactionLog() {
		System.out.println("[트랜잭션 로그 - LogAdvice] : 트랜잭션 처리 로그");
	}
	
	@Around("transactionPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		
		long now = System.currentTimeMillis();
		Date date = new Date(now);
		SimpleDateFormat sdf = new SimpleDateFormat("kk시 mm분 ss초");
		String getTime= sdf.format(date);
		
		System.out.println("[BEFORE"+getTime+"] : 비즈니스 메소드 수행 전 로그");
		Object returnObj = pjp.proceed();//Proceed 메소드를 바탕으로 전과 후로 나누어짐
		now = System.currentTimeMillis();
		date = new Date(now);
		sdf = new SimpleDateFormat("kk시 mm분 ss초");
		getTime= sdf.format(date);
		System.out.println("[AFTER"+getTime+"] : 비즈니스 메소드 수행 후 로그");
		
		System.out.println("==== 기타 정보 ====");
		Signature sig = pjp.getSignature();
		System.out.println(sig.getName());
		
		return returnObj;
	}
}
