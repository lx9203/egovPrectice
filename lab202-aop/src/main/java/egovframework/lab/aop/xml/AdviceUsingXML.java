package egovframework.lab.aop.xml;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import egovframework.lab.aop.common.BizException;

public class AdviceUsingXML {
	private final Log sysoutLogger = LogFactory.getLog(AdviceUsingXML.class);
	
	public void beforeTargetMethod(JoinPoint thisJoinPoint) {
		sysoutLogger.debug("\nAdviceUsingXML.beforeTargetMethod executed.");
		
		@SuppressWarnings("unchecked")
		Class clazz = thisJoinPoint.getTarget().getClass();
		String className = thisJoinPoint.getSignature().getName();
		String methodName = thisJoinPoint.getSignature().getName();
		
		StringBuffer buf = new StringBuffer();
		buf.append("\n == AdviceUsingXML.beforeTargetMethod : [" + className + "." + methodName + "()] ==");
		Object[] arguments = thisJoinPoint.getArgs();
		int argCount = 0;
		for(Object obj : arguments){
			buf.append("\n = arg");
			buf.append(argCount++);
			buf.append(":");
			buf.append(ToStringBuilder.reflectionToString(obj));
		}
		
		Log logger = LogFactory.getLog(clazz);
		if(logger.isDebugEnabled())
			logger.debug(buf.toString());
	}
	
	public void afterTargerMethod(JoinPoint thisJoinPoint){
		sysoutLogger.debug("AdviceUsingXML.afterTargetMetgod excuted.");
	}
	
	@SuppressWarnings("unchecked")
	public void afterReturningTargetMethod(JoinPoint thisJoinPoint, Object retVal) {
		sysoutLogger.debug("AdviceUsingXML.afterReturningTargetMetgod excuted.");
		
		Class clazz = thisJoinPoint.getTarget().getClass();
		String className = thisJoinPoint.getTarget().getClass().getSimpleName();
		String methodName = thisJoinPoint.getSignature().getName();
		
		StringBuffer buf = new StringBuffer();
		buf.append("\n == AdviceusingXML.afterReturningTargetMethod : [" + className + "." + methodName + "()] ==");
		buf.append("\n");
		
		if(retVal instanceof List) {
			List resultList = (List) retVal;
			buf.append("resultList size : " + resultList.size() + "\n");
			for ( Object oneRow : resultList) { 
				buf.append(ToStringBuilder.reflectionToString(oneRow));
				buf.append("\n");
			}
		} else {
			buf.append(ToStringBuilder.reflectionToString(retVal));
		}
		
		Log logger = LogFactory.getLog(clazz);
		if(logger.isDebugEnabled())
			logger.debug(buf.toString());
	}
	
	public void afterThrowingTargetMethod(JoinPoint thisJoinPoint, Exception exception) throws Exception {
		sysoutLogger.debug("AdviceusingXML.afterThrowingTargetMethod executed");
		sysoutLogger.error("에러가 발생햇습니다.", exception);
		
		throw new BizException("에러가 발생했습니다.", exception);
	}
	
	public Object aroundTargetMethod(ProceedingJoinPoint thisJoinPoint) throws Throwable {
		sysoutLogger.debug("AdviceusingXML.aroundTargetMethod start.");
		long time1 = System.currentTimeMillis();
		Object retVal = thisJoinPoint.proceed();
		long time2 = System.currentTimeMillis();
		sysoutLogger.debug("AdviceusingXML.aroundTargetMethod end. Time(" + (time2 - time1) + ")");
		return retVal;
	}
	
}