package com.ningyuanlong.service;


import com.ningyuanlong.Repository.UserRepository;
import com.ningyuanlong.domain.User;
import com.ningyuanlong.domain.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tony on 2020/4/25.
 */
@Service
public class AnyUserDetailsService implements UserDetailsService {
    private final static String ROLE_TAG = "ROLE_USER";

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String u = username;
        User user = userRepository.findByUsername(u);
        if(user == null){
            System.out.println("用户不存在！");
            throw new UsernameNotFoundException("用户不存在！");
        }
        System.out.println("用户存在！");
        System.out.println("用户名是"+user.getUsername() + "密码是"+user.getPassword());
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        UserPrincipal userPrincipal = new UserPrincipal(username, user.getPassword(), authorities);
        userPrincipal.setUsername(user.getUsername());

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);

    }

}
