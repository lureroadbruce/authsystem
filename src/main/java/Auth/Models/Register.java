package Auth.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import Auth.Comment.Matches;

@Entity // This tells Hibernate to make a table out of this class
@Matches(field="password", verifyField="confirmPassword",message = "密码必须一致")
public class Register {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=2, max=30)
    private String name;
    
    @NotNull
    @Email
    private String email;

    
    @Size (min=6, max=20)
    private String password;
    
    @Size (min=6, max=20)
    private String confirmPassword;
    
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
	
	
	public String getconfirmPassword() {
		return confirmPassword;
	}

	public void setconfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}