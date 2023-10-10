
package com.slokam.scriptone.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

   private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution (*  com.slokam.script.*.*.* (..))")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().toString();
		
		LOGGER.trace("Entered into the method "+methodName+ "in the "+ className );
		
	}
	@After("execution (*  com.slokam.script.*.*.* (..))")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().toString();
		
		LOGGER.trace("Exit from the method "+methodName+ "in the "+ className );
		

	}
}
