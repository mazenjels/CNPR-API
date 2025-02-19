package com.hoja.cnprapi.models;

import java.util.Date;



import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "vw_user",schema = "public")
public class ViewUser {

	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;
	
	@Column(name="account_expired")
	private boolean accountExpired = true;
	
	@Column(name="account_locked")
	private boolean accountLocked= true;
	
	@Column(name = "failed_attempt")
    private int failedAttempt = 0;
     
    @Column(name = "lock_time")
    private Date lockTime;
	
    @Column(name = "enabled")
	private boolean enabled=true;
    
	@Column(name="credentials_expired")
	private boolean credentialsExpired;
	

	@Column(name = "is_mobile_user")
	private boolean mobileUser = false;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isAccountExpired() {
		return accountExpired;
	}

	public void setAccountExpired(boolean accountExpired) {
		this.accountExpired = accountExpired;
	}

	public boolean isAccountLocked() {
		return accountLocked;
	}

	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	public int getFailedAttempt() {
		return failedAttempt;
	}

	public void setFailedAttempt(int failedAttempt) {
		this.failedAttempt = failedAttempt;
	}

	public Date getLockTime() {
		return lockTime;
	}

	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}

	public boolean isCredentialsExpired() {
		return credentialsExpired;
	}

	public void setCredentialsExpired(boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}
	
	public boolean isMobileUser() {
		return mobileUser;
	}

	public void setMobileUser(boolean mobileUser) {
		this.mobileUser = mobileUser;
	}

}
