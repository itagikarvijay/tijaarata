/**
 * 
 */
package com.tijaarata.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @author User
 *
 */
//@Aspect
//@Configuration
public class AfterAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@After(value ="execution(* com.tijaarata.*.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info("after execution of {}", joinPoint);
	}

}
