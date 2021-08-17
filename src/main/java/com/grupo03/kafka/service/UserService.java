package com.grupo03.kafka.service;

import com.grupo03.kafka.model.MyUser;
import com.grupo03.kafka.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    MyUserRepository myUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> myUser = myUserRepository.findByUsername(username);
        return new User(myUser.get().getUsername(), myUser.get().getPassword(), new ArrayList<>());
    }

}