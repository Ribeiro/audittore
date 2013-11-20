package br.com.gigio.audittore.audit.aspectj.interceptors;

import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.gigio.audittore.audit.aspectj.domain.AuditDataBuilder;
import br.com.gigio.audittore.audit.aspectj.interfaces.Audittable;

@Service
@Aspect
public class AuditInterceptor {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private HttpServletRequest request;
	
	@Autowired
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
    @Before(value = "br.com.gigio.audittore.audit.aspectj.managers.AuditManager.auditLog()"
            		+ "&& target(bean) "
            		+ "&& @annotation(br.com.gigio.audittore.audit.aspectj.interfaces.Audittable)"
            		+ "&& @annotation(logme)", argNames = "bean,logme")
    public void log(JoinPoint jp, Object bean, Audittable logme) {
    	logger.info(logme.message() + " - "+ AuditDataBuilder.build(request).toString());
//    	logger.info(String.format("Log Message: %s", logme.message()));
//    	logger.info(String.format("Bean Called: %s", bean.getClass().getName()));
//    	logger.info(String.format(String.format("Method Called: %s", jp.getSignature().getName())));

    }
    
}