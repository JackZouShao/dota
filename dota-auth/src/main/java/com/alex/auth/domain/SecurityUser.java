package com.alex.auth.domain;

import com.alex.common.domin.UserDTO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Slf4j
@Data
public class SecurityUser implements UserDetails {

    /**
     * ID
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户状态
     */
    private Boolean enabled;

    /**
     * 权限数据
     */
    private Collection<SimpleGrantedAuthority> authorities;

    public SecurityUser(UserDTO userDTO) {
        this.setId(userDTO.getId());
        this.setUsername(userDTO.getUsername());
        this.setPassword(userDTO.getPassword());
        if (userDTO.getRoles() != null) {
            authorities = new ArrayList<>();
            userDTO.getRoles().forEach(item -> authorities.add(new SimpleGrantedAuthority(item)));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        log.warn("isAccountNonExpired");
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        log.warn("isAccountNonLocked");
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        log.warn("isCredentialsNonExpired");
        return true;
    }

    @Override
    public boolean isEnabled() {
        log.warn("isEnabled");
        return true;
    }
}