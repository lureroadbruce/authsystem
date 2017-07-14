package Auth.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	@Table(name="user_roles")
	public class UserRole {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	private Long role_id;
	
	private Long user_id;

	private String role; 
	
	public String getRole() {
	return role;
	}
	
	public void setRole(String role) {
	this.role = role;
	}
	
	public Long getUserId() {
	return user_id;
	}
	
	public void setUserId(Long user_id) {
	this.user_id = user_id;
	}
	
	public Long getRoleId() {
	return role_id;
	}
	
	public void setRroleId(Long role_id) {
	this.role_id = role_id;
	} 
	
	}