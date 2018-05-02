package org.cpm.zwl.bean;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.cpm.zwl.dao.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * Spring Security will use the information stored in the JwtUser object to perform authentication
 * and authorization.
 */
public class JwtUser implements UserDetails {

  /**
   * 
   */
  private static final long serialVersionUID = 299812439523611812L;

  private Long userId;

  private String name;

  private String username;

  @JsonIgnore
  private String email;

  @JsonIgnore
  private String password;

  private Collection<? extends GrantedAuthority> authorities;

  public JwtUser(Long userId, String name, String username, String email, String password,
      Collection<? extends GrantedAuthority> authorities) {
    this.userId = userId;
    this.name = name;
    this.username = username;
    this.email = email;
    this.password = password;
    this.authorities = authorities;
  }

  public static JwtUser create(User user) {
    List<GrantedAuthority> authorities = user.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getRoleId())).collect(Collectors.toList());

    return new JwtUser(user.getUserId(), user.getName(), user.getUsername(), user.getEmail(),
        user.getPassword(), authorities);
  }

  public Long getUserId() {
    return userId;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
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
    return true;
  }

}
