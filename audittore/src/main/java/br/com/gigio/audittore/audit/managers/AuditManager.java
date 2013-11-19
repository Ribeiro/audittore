package br.com.gigio.audittore.audit.managers;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AuditManager {
       
       @Pointcut("bean(*Controller)")
       public void auditLog() {}

}
