package br.com.gigio.audittore.audit.aspectj.domain;

public class Request {
	private final String ipAddress;
	private final String browser;
	private final String host;
	private final String sessionId;
	private final String requestURL;
	private final String requestURI;
	
	public Request(String ipAddress, String browser, String host,
			String sessionId, String requestURL, String requestURI) {
		this.ipAddress = ipAddress;
		this.browser = browser;
		this.host = host;
		this.sessionId = sessionId;
		this.requestURL = requestURL;
		this.requestURI = requestURI;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public String getBrowser() {
		return browser;
	}

	public String getHost() {
		return host;
	}

	public String getSessionId() {
		return sessionId;
	}

	public String getRequestURL() {
		return requestURL;
	}

	public String getRequestURI() {
		return requestURI;
	}

	@Override
	public String toString() {
		return "Request [ipAddress=" + ipAddress + ", browser=" + browser
				+ ", host=" + host + ", sessionId=" + sessionId
				+ ", requestURL=" + requestURL + ", requestURI=" + requestURI
				+ "]";
	}

}