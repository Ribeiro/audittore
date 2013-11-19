package br.com.gigio.audittore.audit.aspectj.domain;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public class RequestHeaders {

	private Map<String, Object> mimeHeaders;
	private final List<String> acceptedHeaders = Arrays.asList("accept-language", "user-agent", "host", "janus_sid");

	@SuppressWarnings("rawtypes")
	public RequestHeaders(HttpServletRequest request) {
		this.mimeHeaders = new HashMap<String, Object>();
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			if (acceptedHeaders.contains(headerName)) {
				this.mimeHeaders.put(headerName, request.getHeader(headerName));
			}

		}

	}

	public Map<String, Object> getMimeHeaders() {
		return mimeHeaders;
	}

}