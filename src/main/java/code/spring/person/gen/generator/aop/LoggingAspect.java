package code.spring.person.gen.generator.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
// @Component
public class LoggingAspect {

	private int indent = 0;

	@Before("execution(* code.spring.person.gen.generator.impl.*.generate*(..))")
	public void logBefore(JoinPoint joinPoint) {
		String typeName = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println(getTabs() + " -> " + typeName + "." + methodName + "(" + getArgs(args) + ")");
		indent++;
	}

	@After("execution(* code.spring.person.gen.generator.impl.*.generate*(..))")
	public void logAfter(JoinPoint joinPoint) {
		indent--;
		String typeName = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println(getTabs() + " <- " + typeName + "." + methodName + "(...)");
	}

	private String getTabs() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < indent; i++) {
			sb.append("  ");
		}
		return sb.toString();
	}

	private String getArgs(Object[] args) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < args.length; i++) {
			sb.append(args[i].toString());
			sb.append(", ");
		}
		return sb.toString();
	}
}
