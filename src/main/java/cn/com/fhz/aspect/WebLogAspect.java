package cn.com.fhz.aspect;

import com.mongodb.BasicDBObject;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzfang on 2017/12/7.
 */
@Aspect
@Order(5)
@Component
public class WebLogAspect {


//    private Logger logger = Logger.getLogger(getClass());

    private Logger logger = Logger.getLogger("mongodb");

    ThreadLocal<Long> startTime  = new ThreadLocal<>();

    //    @Pointcut("execution(public * cn.com.fhz.controller..*.*(..))")
    @Pointcut("execution(public * cn.com.fhz.controller..*.*(..))")
    public void WebLog(){}

    @Before("WebLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{

        startTime.set(System.currentTimeMillis());

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = requestAttributes.getRequest();

//        // 记录下请求内容
//        logger.info("URL:\t"+request.getRequestURI());
//        logger.info("HTTP_METHOD:\t"+request.getMethod());
//        logger.info("IP:\t"+request.getRemoteHost());
//        logger.info("CLASS_METHOD:\t"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
//        logger.info("args:\t"+ Arrays.toString(joinPoint.getArgs()));
        // 获取要记录的日志内容
        BasicDBObject logInfo = getBasicDBObject(request, joinPoint);
        logger.info(logInfo);

    }

    private BasicDBObject getBasicDBObject(HttpServletRequest request, JoinPoint joinPoint) {
        // 基本信息
        BasicDBObject r = new BasicDBObject();
        r.append("requestURL", request.getRequestURL().toString());
        r.append("requestURI", request.getRequestURI());
        r.append("queryString", request.getQueryString());
        r.append("remoteAddr", request.getRemoteAddr());
        r.append("remoteHost", request.getRemoteHost());
        r.append("remotePort", request.getRemotePort());
        r.append("localAddr", request.getLocalAddr());
        r.append("localName", request.getLocalName());
        r.append("method", request.getMethod());
        r.append("headers", getHeadersInfo(request));
        r.append("parameters", request.getParameterMap());
        r.append("classMethod", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        r.append("args", Arrays.toString(joinPoint.getArgs()));
        return r;
    }

    /**
     * 获取头信息
     *
     * @param request
     * @return
     */
    private Map<String, String> getHeadersInfo(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }




//    @AfterReturning(returning = "ret",pointcut = "WebLog()")
//    public void doAfterReturning(Object ret)throws Throwable{
//        //处理完成，返回内容
//        logger.info("RESPONSE"+ret);
//        logger.info("耗时:\t"+(System.currentTimeMillis()-startTime.get()));
//
//    }


}
