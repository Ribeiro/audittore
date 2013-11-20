package br.com.gigio.audittore.audit.aspectj.domain;

import javax.servlet.http.HttpServletRequest;

public final class AuditDataBuilder {
	
	private AuditDataBuilder(){
		
	}
	
	public static AuditData build(HttpServletRequest request){
		return new AuditData(request);
	}

}