package com.guorui.springmvc.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class Spitter {

	@NotNull
	@Size(min = 2, max = 10)
	private String firstName;
	@NotNull
	@Size(min = 2, max = 10)
	private String lastName;
	@NotNull
	@Size(min = 5, max = 10)
	private String username;
	@NotNull
	@Size(min = 5, max = 10)
	private String password;

	public Spitter() {
	}

	public Spitter(String firstName, String lastName, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that, "username");
	}

}
