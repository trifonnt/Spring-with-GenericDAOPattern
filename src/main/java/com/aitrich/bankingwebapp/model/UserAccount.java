package com.aitrich.bankingwebapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "useraccount")
public class UserAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "IS_DELETE")
	private Boolean is_Delete = false;

	@Column(name = "CREATED_DATE")
	private Date createddate;

	public UserAccount() {
		super();
	}

	public UserAccount(Long id, String username, String password,
			Boolean is_Delete, Date createddate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.is_Delete = is_Delete;
		this.createddate = createddate;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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

	public Boolean getIs_Delete() {
		return is_Delete;
	}
	public void setIs_Delete(Boolean is_Delete) {
		this.is_Delete = is_Delete;
	}

	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	@Override
	public String toString() {
		return "UserAccount ["
				+ "id=" + id
				+ ", username=" + username
				+ ", password=" + password
				+ ", is_Delete=" + is_Delete
				+ ", createddate=" + createddate + "]";
	}
}