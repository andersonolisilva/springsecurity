package springsecurity.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

@Entity  
@Table  
public class Role implements java.io.Serializable, GrantedAuthority {/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //é bom implementar o GrantedAuthority na sua classe Role tb  
    private Long id;  
    private String name;  
  
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@Transient  
    public String getAuthority() {  
        return this.name;  
    }  
    @Transient  
    public int compareTo(Object o) {  
        return this.compareTo(o);  
    } 
}