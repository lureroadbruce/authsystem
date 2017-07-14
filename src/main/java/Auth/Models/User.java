package Auth.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import Auth.Models.Register;
import Auth.Comment.MD5Util;

@Entity // This tells Hibernate to make a table out of this class
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	@Size(min = 2, max = 30)
	private String name;

	@NotNull
	@Email
	private String email;

	private String password;

	private int enabled = 1;

	private int status = 2;

	private java.util.Date createtime;

	private java.util.Date updatetime;
	
	

	public User(User user) {
		this.id = user.id;
		this.name = user.name;
		this.email = user.email;
		this.password = user.password;
		this.enabled = user.enabled;
		this.status = user.status;
	}

	public User() {
	}
	
	public User(long id,String name,String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	
	public void setStatus(int value) {
		this.status = value;
	}
	public int getStatus() {
		return this.status;
	}
	
	public void setCreatetime(java.util.Date value) {
		this.createtime = value;
	}
	public java.util.Date getCreatetime() {
		return this.createtime;
	}
	
	public void setUpdatetime(java.util.Date value) {
		this.updatetime = value;
	}
	public java.util.Date getUpdatetime() {
		return this.updatetime;
	}
	
	
	public void setFromRegister(Register register) {
		this.name = register.getName();
		this.email = register.getEmail();
		this.password = register.getPassword();
	}

}