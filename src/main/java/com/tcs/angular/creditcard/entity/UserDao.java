package com.tcs.angular.creditcard.entity;


import javax.persistence.*;

@Entity
@Table(name = "Userdata")
public class UserDao {
	
	@Id
    @Column(name="username")
    private String username;
	
    @Column(name="password")
    private String password;
    

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

	public UserDao(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public UserDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
