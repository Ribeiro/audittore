package br.com.gigio.audittore.audit.aspectj.interceptors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;
import br.com.gigio.audittore.audit.aspectj.interfaces.Audittable;

@Service
@Aspect
public class AuditInterceptor {
    @Before(value = "br.com.gigio.audittore.audit.aspectj.managers.AuditManager.auditLog()"
            		+ "&& target(bean) "
            		+ "&& @annotation(br.com.gigio.audittore.audit.aspectj.interfaces.Audittable)"
            		+ "&& @annotation(logme)", argNames = "bean,logme")
    public void log(JoinPoint jp, Object bean, Audittable logme) {

        System.out.println(String.format("Log Message: %s", logme.message()));
        System.out.println(String.format("Bean Called: %s", bean.getClass()
                .getName()));
        System.out.println(String.format("Method Called: %s", jp.getSignature()
                .getName()));

    }
    
}