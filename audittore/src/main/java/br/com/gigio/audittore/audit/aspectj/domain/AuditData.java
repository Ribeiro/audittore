package br.com.gigio.audittore.audit.aspectj.domain;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.util.Assert;

public class AuditData {
	private final User user;
	private final Request request;
	private final List<String> janusHeaders = Arrays.asList("janus_principalid", "janus_user_entitlements", "janus_firstname", "janus_lastname", "janus_email", "janus_sid");
	private final Map<String, String> userData = new HashMap<String, String>();
	
	public AuditData(HttpServletRequest request) {
		this.user = buildUserFrom(request);
		this.request = buildRequestFrom(request);
	}
	
	private Request buildRequestFrom(HttpServletRequest request){
		return new Request(request.getRemoteAddr(), request.getHeader("user-agent"), request.getHeader("host"), request.getRequestedSessionId(), request.getRequestURL().toString(), request.getRequestURI());
		
	}
	
	@SuppressWarnings("rawtypes")
	private User buildUserFrom(HttpServletRequest request){
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			if (janusHeaders.contains(headerName)) {
				this.userData.put(headerName, request.getHeader(headerName));
				
			}

		}
		Assert.notEmpty(userData);
		return new User(userData);
	}
	
	public User getUser() {
		return user;
	}
	
	public Request getRequest() {
		return request;
	}

	@Override
	public String toString() {
		return "AuditData [user=" + user + ", request=" + request + "]";
	}

}