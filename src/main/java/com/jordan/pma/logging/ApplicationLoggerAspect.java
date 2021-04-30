package com.jordan.pma.logging;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationLoggerAspect {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("within(com.jordan.pma.controllers..*)"
			+ "|| within(com.jordan.pma.dao..*)"
			+ "|| within(com.jordan.pma.service..*)")
	public void definePackagePointCuts() {
		//empty method to name the location specified in pointcut
	}
	
//	@After("definePackagePointCuts()")
//	public void log() {
//		log.debug("------------------------------------------------------------");
//		log.info("---------------------==----------");
//	}
	
	@Around("definePackagePointCuts()")
	public Object logAround(ProceedingJoinPoint jp) {
		log.debug("\n \n");
		log.debug("***************Before Method Execution********** \n {}.{} () with arguments [s]={}",
				jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
		log.debug("------------------------------------------------\n\n");
		
		Object o=null;
		try {
			o = jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.debug("***************After Method Execution********** \n {}.{} () with arguments [s]={}",
				jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
		log.debug("------------------------------------------------\n\n");
		
		return o;
	}
	
	
	
	
	
	
	
	
}
