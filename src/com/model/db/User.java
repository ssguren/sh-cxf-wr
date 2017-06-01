package com.model.db;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_user"
    ,schema="dbo"
    ,catalog="ZSXL"
)

public class User extends org.springframework.orm.hibernate3.support.HibernateDaoSupport implements java.io.Serializable,Comparable<User> {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = -5430024497275022838L;
	private Integer id;
     private String name;
     private String userAccount;
     private String password;


    // Constructors

    /** default constructor */
    public User() {
    }

    
    /** full constructor */
    public User(String name, String userAccount, String password) {
        this.name = name;
        this.userAccount = userAccount;
        this.password = password;
    }

   
    // Property accessors
    @Id @GeneratedValue
    
    @Column(name="id", unique=true, nullable=false)

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="name")

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="user_account")

    public String getUserAccount() {
        return this.userAccount;
    }
    
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }
    
    @Column(name="password")

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }


	public int compareTo(User o) {
		if(!this.id.equals(o.id)){
			return this.id.compareTo(o.id);
		}else{
			return this.name.compareTo(o.name);
		}
	}


   








}