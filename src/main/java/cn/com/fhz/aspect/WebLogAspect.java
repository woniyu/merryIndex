package cn.com.fhz.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by hzfang on 2017/12/7.
 */
@Aspect
@Order(5)
@Component
public class WebLogAspect {


    private Logger logger = Logger.getLogger(getClass());

    ThreadLocal<Long> startTime  = new ThreadLocal<>();

    //    @Pointcut("execution(public * cn.com.fhz.controller..*.*(..))")
    @Pointcut("execution(public * cn.com.fhz.controller..*.*(..))")
    public void WebLog(){}

    @Before("WebLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{

        startTime.set(System.currentTimeMillis());

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = requestAttributes.getRequest();

        // 记录下请求内容
        logger.info("URL:\t"+request.getRequestURI());
        logger.info("HTTP_METHOD:\t"+request.getMethod());
        logger.info("IP:\t"+request.getRemoteHost());
        logger.info("CLASS_METHOD:\t"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info("args:\t"+ Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret",pointcut = "WebLog()")
    public void doAfterReturning(Object ret)throws Throwable{
        //处理完成，返回内容
        logger.info("RESPONSE"+ret);
        logger.info("耗时:\t"+(System.currentTimeMillis()-startTime.get()));

    }


}
