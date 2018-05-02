package org.cpm.zwl.config;

import org.cpm.zwl.bean.JwtUser;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SpringSecurityAuditAware implements AuditorAware<Long> {

  @Override
  public Long getCurrentAuditor() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    if (authentication == null || !authentication.isAuthenticated()
        || authentication instanceof AnonymousAuthenticationToken) {
      return null;
    }

    JwtUser jwtUser = (JwtUser) authentication.getPrincipal();

    return jwtUser.getUserId();
  }

}
