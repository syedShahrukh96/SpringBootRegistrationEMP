package com.shahrukh.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomLogAspect {
	
	Logger logger = LoggerFactory.getLogger(CustomLogAspect.class);
	
	@Before(value = "execution(* com.shahrukh.controller.*.*(..))")
	public void before(JoinPoint joinPoint) {
		System.out.println("Before: "+ joinPoint.getSignature());
		logger.info("Info: ");
		logger.error("Error: ");
		logger.trace("Trace: ");
		logger.warn("Warn: ");
		logger.debug("Debug: ");
	}
	
	@After(value ="execution(* com.shahrukh.controller.*.*(..))")
	public void after(JoinPoint joinPoint) {
		System.out.println("After: "+ joinPoint.getSignature());
	}
	
	@AfterReturning(value = "execution(* com.shahrukh.controller.*.*(..))", returning = "result")
	public void afterReturn(JoinPoint joinPoint, Object result) {
		System.out.println("After Return: "+result);
	}
	
	@AfterThrowing(value = "execution(* com.shahrukh.controller.*.*(..))", throwing = "error")
	public void afterThrow(JoinPoint joinPoint, Throwable error) {
		System.out.println("After Throw: "+error);
	}
	
	@Around(value ="execution(* com.shahrukh.controller.*.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("Around start: "+joinPoint.getSignature());
		Object result = joinPoint.proceed();
		System.out.println("Around End: "+ joinPoint.getSignature());
		return result;
	}

}
