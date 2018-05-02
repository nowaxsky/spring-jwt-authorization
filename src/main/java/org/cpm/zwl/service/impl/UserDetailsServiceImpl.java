package org.cpm.zwl.service.impl;

import org.cpm.zwl.bean.JwtUser;
import org.cpm.zwl.dao.entity.User;
import org.cpm.zwl.dao.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * To authenticate a User or perform various role-based checks, Spring security needs to load users
 * details somehow.
 * 
 * @author CPM
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

    // Let people login with either username or email
    User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
        .orElseThrow(() -> new UsernameNotFoundException(
            "User not found with username or email : " + usernameOrEmail));

    return JwtUser.create(user);
  }

  // This method is used by JWTAuthenticationFilter
  public UserDetails loadUserByUserId(Long userId) {
    User user = userRepository.findByUserId(userId)
        .orElseThrow(() -> new UsernameNotFoundException("User not found with userId : " + userId));

    return JwtUser.create(user);
  }

}
