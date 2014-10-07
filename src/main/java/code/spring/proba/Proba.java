package code.spring.proba;

import java.lang.reflect.AccessibleObject;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.aop.framework.ProxyFactoryBean;

public class Proba {

	public static void main(String[] args) {
		ProxyFactoryBean bean;
		JoinPoint joinPoint = null;
		Signature signature = joinPoint.getSignature();

	}
}
