package br.com.gigio.audittore.audit.aspectj.domain;

import java.util.Map;

public class User {
	private final String janusSID;
	private final String firstName;
	private final String lastName;
	private final String email;
	private final String janusPrincipalId;
	private final String janusEntitlements;
	
	public User(Map<String, String> userData){
		this.janusSID = userData.get("janus_sid");
		this.firstName = userData.get("janus_firstname");
		this.lastName = userData.get("janus_lastname");
		this.email = userData.get("janus_email");
		this.janusPrincipalId = userData.get("janus_principalid");
		this.janusEntitlements = userData.get("janus_user_entitlements");
	}

	public String getJanusSID() {
		return janusSID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getJanusPrincipalId() {
		return janusPrincipalId;
	}

	public String getJanusEntitlements() {
		return janusEntitlements;
	}

	@Override
	public String toString() {
		return "User [janusSID=" + janusSID + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email
				+ ", janusPrincipalId=" + janusPrincipalId
				+ ", janusEntitlements=" + janusEntitlements + "]";
	}

}