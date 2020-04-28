package com.ningyuanlong.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

/**
 * Created by Tony on 2020/4/25.
 */
public class UserPrincipal extends User {

    private static final long serialVersionUID = -4735218819792872573L;

    private String username;

    private String picture;

    public UserPrincipal(String username, String nickname, String password) {
        super(username, nickname, password);
    }

    public UserPrincipal(String username, String password, List<SimpleGrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UserPrincipal(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

}
