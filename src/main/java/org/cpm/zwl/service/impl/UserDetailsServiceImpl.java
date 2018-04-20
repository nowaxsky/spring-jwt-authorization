package org.cpm.zwl.service.impl;

import org.cpm.zwl.bean.JwtUser;
import org.cpm.zwl.dao.entity.User;
import org.cpm.zwl.dao.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    User user = userRepository.findByUserId(userId);

    if (user == null) {
      throw new UsernameNotFoundException(userId);
    }
    
    System.out.println("username: " + user.getUserId());
    System.out.println("password: " + user.getPassword());
    return new JwtUser(user);
  }

}
