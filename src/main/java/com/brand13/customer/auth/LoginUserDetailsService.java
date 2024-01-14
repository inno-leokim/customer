package com.brand13.customer.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.brand13.customer.domain.User;
import com.brand13.customer.repository.UserRepository;

@Service
public class LoginUserDetailsService implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User userEntity = userRepository.findByUsername(username);
        
        if(userEntity != null){
            return new LoginUserDetails(userEntity);
        }

        return null;
        
    }
}
