package com.simplilearn.accounts.entity;

import java.util.Date;

public class Account {

	// properties
	private int id;
	private String username;
	private String password;
	private String email;
	private boolean enabled;
	private Date createAt;

	// get & set methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	// constructor
	public Account() {
		super();
	}

	public Account(int id, String username, String password, String email, boolean enabled, Date createAt) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.createAt = createAt;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", enabled=" + enabled + ", createAt=" + createAt + "]";
	}
}
