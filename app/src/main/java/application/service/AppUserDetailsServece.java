package application.service;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetaisService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import application.repository.UserRepository;

@Service


public class AppUserDetailsService implements UserDetaisService{
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException{
        User user = userRepo.findByUsername(username);
        if(user== null){
            throw new UsernameNotFoundException("Usuário Não Encontrado");
        }
        UserDetails = 
        org.springframework.security.core.userdetails.User.builder()
        .username(user.getUsername());
        .password(user.getPassword())
        .roles("USER")
        .build();

    return userDetails;
    
    }

}