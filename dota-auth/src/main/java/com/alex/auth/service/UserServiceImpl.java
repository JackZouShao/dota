package com.alex.auth.service;

import cn.hutool.core.collection.CollUtil;
import com.alex.auth.domain.SecurityUser;
import com.alex.common.constants.MessageConstant;
import com.alex.common.domin.UserDTO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 加载用户信息类, 具体应该调用用户模块
 *
 * @version 1.0.0
 * @className UserServiceImpl.java
 * @author: yz
 * @date: 2022/1/23 22:56
 */
//@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {

    private List<UserDTO> userList;

    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initData(){
        String password = passwordEncoder.encode("5545125");
        userList = new ArrayList<>();
        userList.add(new UserDTO(1L,"macro", password, CollUtil.toList("ADMIN")));
        userList.add(new UserDTO(2L,"andy", password, CollUtil.toList("ADMIN")));

    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        List<UserDTO> findUserList = userList.stream()
                .filter(user -> StringUtils.equals(userName, user.getUsername()))
                .collect(Collectors.toList());
        if(CollUtil.isEmpty(findUserList)){
            throw new UsernameNotFoundException("username null");
        }
        SecurityUser securityUser = new SecurityUser(findUserList.get(0));
        if (!securityUser.isEnabled()) {
            throw new DisabledException(MessageConstant.ACCOUNT_DISABLED);
        } else if (!securityUser.isAccountNonLocked()) {
            throw new LockedException(MessageConstant.ACCOUNT_LOCKED);
        } else if (!securityUser.isAccountNonExpired()) {
            throw new AccountExpiredException(MessageConstant.ACCOUNT_EXPIRED);
        } else if (!securityUser.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException(MessageConstant.CREDENTIALS_EXPIRED);
        }
        return securityUser;
    }
}
