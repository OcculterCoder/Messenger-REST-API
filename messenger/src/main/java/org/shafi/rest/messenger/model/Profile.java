package org.shafi.rest.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public class Profile {
	
	private long id;
	private String firstName;
	private Date created;
	private String LastName;
	private String profileName;
	
	public Profile() {
		
	}
	
	public Profile(long id, String firstName, String lastName, String profileName) {
		super();
		this.id = id;
		this.firstName = firstName;
		LastName = lastName;
		this.profileName = profileName;
		this.created = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	
	
}
