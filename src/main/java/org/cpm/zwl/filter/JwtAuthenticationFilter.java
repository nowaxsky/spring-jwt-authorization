package org.cpm.zwl.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.cpm.zwl.security.JwtTokenProvider;
import org.cpm.zwl.service.impl.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * JWTAuthenticationFilter gets the JWT token from the request, validates it, loads the user
 * associated with the token, and passes it to Spring Security.
 * 
 * 1. Read JWT authentication token from the Authorization header of all the requests.
 * 
 * 2. Validate the token.
 * 
 * 3. Load the user details associated with that token.
 * 
 * 4. Sets the user details in Spring Security’s SecurityContext. Spring Security uses the user
 * details to perform authorization checks. We can also access the user details stored in the
 * SecurityContext in our controllers to perform our business logic.
 * 
 * @author CPM
 *
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  @Autowired
  private JwtTokenProvider tokenProvider;

  @Autowired
  private UserDetailsServiceImpl userDetailsService;

  private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    try {
      String jwt = getJwtFromRequest(request);

      if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
        Long userId = tokenProvider.getUserIdFromJwt(jwt);
        logger.info("user id: " + userId);

        /*
         * Note that you could also encode the user's username and roles inside JWT claims and
         * create the UserDetails object by parsing those claims from the JWT. That would avoid the
         * following database hit. It's completely up to you.
         */
        UserDetails userDetails = userDetailsService.loadUserByUserId(userId);
        UsernamePasswordAuthenticationToken authentication =
            new UsernamePasswordAuthenticationToken(userDetails, null,
                userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    } catch (Exception ex) {
      logger.error("Could not set user authentication in security context", ex);
    }

    filterChain.doFilter(request, response);
  }

  private String getJwtFromRequest(HttpServletRequest request) {
    String bearerToken = request.getHeader("Authorization");
    if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
      logger.info("bearer token: " + bearerToken.substring(7, bearerToken.length()));
      return bearerToken.substring(7, bearerToken.length());
    }
    return null;
  }
}
