package springsecurity.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity  
@Table  
public class User implements java.io.Serializable, UserDetails {//vc precisa implementar o UserDetails na sua classe User  
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;  
    private String login;  
    private String password;  
    private boolean actived = true;  
    private List<Role> roles = new ArrayList<Role>();  

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    @Transient  
    public String getUsername() {  
        return this.login;  
    }  
    @Transient  
    public boolean isAccountNonExpired() {  
        return true;  
    }  
    @Transient  
    public boolean isAccountNonLocked() {  
        return true;  
    }  
    @Transient  
    public boolean isCredentialsNonExpired() {  
        return true;  
    }  
    @Transient  
    public boolean isEnabled() {  
        return (this.actived);  
    }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return (Collection<? extends GrantedAuthority>) this.roles;
	}
	
	@Override
	public String getPassword() {
		return this.password;
	}  

}