package br.com.globalpoints.helpdesk.business.users.models;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {
    private static final long serialVersionUID = -5633143017697897133L;

    private String id;
    private String buId;
    private String username;
    private String role;

    public UserPrincipal(String id, String buId, String username, String role) {
        this.id = id;
        this.buId = buId;
        this.username = username;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new LinkedList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        return authorities;
    }

    public UUID getId() {
        return UUID.fromString(id);
    }

    public UUID getBuId() {
        return UUID.fromString(buId);
    }

    public String getRole() {
        return role;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
