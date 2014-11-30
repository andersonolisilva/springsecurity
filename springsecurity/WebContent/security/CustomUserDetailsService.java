package security;

import org.springframework.dao.DataAccessException;
import org.springframework.jmx.export.MBeanExportException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import springsecurity.dao.UserDao;
import springsecurity.modelo.User;

@Component
public class CustomUserDetailsService implements UserDetailsService {  
  
    private UserDao userDao = new UserDao();//Seu dao aqui  
  
    @Override  
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {  
        try {  
            User user = userDao.findByLogin(username);//seu metodo que faz uma consulta por login e retorna um objeto User  
            return user;  
        } catch (MBeanExportException e) {  
            throw new UsernameNotFoundException("User not found: " + username);  
        }  
    }  
}
