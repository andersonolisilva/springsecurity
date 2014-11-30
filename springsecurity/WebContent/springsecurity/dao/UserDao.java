package springsecurity.dao;

import java.util.ArrayList;
import java.util.List;

import springsecurity.modelo.Role;
import springsecurity.modelo.User;

public class UserDao {

	User usuario = new User();
	List<Role> roles = new ArrayList<Role>();
	
	public UserDao(){
		usuario.setId(new Long(1));
		usuario.setLogin("ande");
		usuario.setPassword("ande");
		
		Role role = new Role();
		role.setName("ROLE_USER");
		role.setId(new Long(1));
		
		roles.add(role);
		usuario.setRoles(roles);
		
	}
	public User findByLogin(String nome){
		return this.usuario;
	}
}
