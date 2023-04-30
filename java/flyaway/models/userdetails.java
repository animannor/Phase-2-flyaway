package flyaway.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userdatails")
public class userdetails {
	
	@Id
	@Column(name = "email")
	private String email;	
	@Column(name="password")
	private String password;
	
	
	
	public userdetails() {
		
		// TODO Auto-generated constructor stub
	}



	public userdetails(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "userdetails [email=" + email + ", password=" + password + "]";
	}

	
}
