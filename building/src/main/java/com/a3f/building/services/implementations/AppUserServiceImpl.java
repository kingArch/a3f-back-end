package com.a3f.building.services.implementations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.a3f.building.entities.UserEntity;
import com.a3f.building.entities.UserRepository;
import com.a3f.building.services.interfaces.AppUserService;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.agent.builder.AgentBuilder.FallbackStrategy.Simple;

@Service
@Slf4j
public class AppUserServiceImpl implements AppUserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserEntity saveUserEntity(UserEntity user) {
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserEntity getUser(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(String id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        log.info("GONE GONE");
        log.info(user.getUsername());
        log.info(user.getPassword());
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("USERX");
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authority);
        return new User(user.getUsername(), user.getPassword(), authorities);
    }

}
