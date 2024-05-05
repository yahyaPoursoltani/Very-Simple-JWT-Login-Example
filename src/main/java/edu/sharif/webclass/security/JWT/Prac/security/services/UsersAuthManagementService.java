package edu.sharif.webclass.security.JWT.Prac.security.services;

import edu.sharif.webclass.security.JWT.Prac.models.EndUser;
import edu.sharif.webclass.security.JWT.Prac.repositories.EndUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UsersAuthManagementService implements UserDetailsService {
    public EndUserRepository endUserRepository;

    public UsersAuthManagementService(EndUserRepository endUserRepository){
        this.endUserRepository = endUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<EndUser> endUserOptional= endUserRepository.findEndUserByUserName(username);
        if(endUserOptional.isPresent()){
            EndUser foundUser = endUserOptional.get();
            return User.withUsername(foundUser.getUserName())
                    .password(foundUser.getPassword())
                    .roles(foundUser.getRole())
                    .build();
        }else{
            throw new UsernameNotFoundException("We have No User with Username " + username);
        }

    }
}
