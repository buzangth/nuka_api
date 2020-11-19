package com.genetics.nuka_api.security;

import com.genetics.nuka_api.model.User;
import com.genetics.nuka_api.repositiry.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

import static com.genetics.nuka_api.security.ApplicationUserRole.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(ADMIN.name()));
        grantedAuthorities.add(new SimpleGrantedAuthority(BRANCH_MANAGER.name()));
        grantedAuthorities.add(new SimpleGrantedAuthority(TELLER.name()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), passwordEncoder.encode(user.getPassword()),
                grantedAuthorities);

    }

    @Transactional
    public User loadUserById(Long id) throws UsernameNotFoundException {
        User user = userRepository.getById(id);
        if(user == null);
        return user;
    }
}