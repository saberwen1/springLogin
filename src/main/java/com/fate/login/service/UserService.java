package com.fate.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @Author: fate
 * @Date: 2019/3/18 13:05
 * @Version 1.0
 */
@Service
public class UserService implements UserDetailsService, SocialUserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User(username,passwordEncoder.encode("1"), AuthorityUtils.createAuthorityList("admin","guest"));
    }

    @Override
    public SocialUserDetails loadUserByUserId(String uid) throws UsernameNotFoundException {
        return new SocialUser(uid,passwordEncoder.encode("1"), AuthorityUtils.createAuthorityList("admin","guest"));
    }
}
