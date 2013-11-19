package br.com.gigio.audittore.audit.aspectj.interceptors;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.gigio.audittore.audit.aspectj.domain.RequestHeaders;
import br.com.gigio.audittore.audit.aspectj.interfaces.Audittable;

@Service
@Aspect
public class AuditInterceptor {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Before(value = "br.com.gigio.audittore.audit.aspectj.managers.AuditManager.auditLog()"
            		+ "&& target(bean) "
            		+ "&& @annotation(br.com.gigio.audittore.audit.aspectj.interfaces.Audittable)"
            		+ "&& @annotation(logme)", argNames = "bean,logme")
    public void log(JoinPoint jp, Object bean, Audittable logme) {
    	HttpServletRequest request = (HttpServletRequest)jp.getArgs()[0];
    	logger.info("Request IP Address: " + request.getRemoteAddr());
    	logger.info("Request Headers: " + getParameterNamesFrom(request));
    	logger.info("Request SessionID: " + request.getRequestedSessionId());
    	logger.info("Request URL: " + request.getRequestURL());
    	logger.info("Request URI: " + request.getRequestURI());
    	logger.info("Request contextPath: " + request.getContextPath());
    	logger.info(String.format("Log Message: %s", logme.message()));
    	logger.info(String.format("Bean Called: %s", bean.getClass().getName()));
    	logger.info(String.format(String.format("Method Called: %s", jp.getSignature().getName())));

    }
    
    private Map<String, Object> getParameterNamesFrom(HttpServletRequest request){
    	RequestHeaders requestHeaders = new RequestHeaders(request);
    	return requestHeaders.getMimeHeaders();
    }
    
}