package org.cpm.zwl.dao.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "T_USER")
public class User implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -7036364716966549707L;

  @Id
  @SequenceGenerator(name = "sequence", sequenceName = "t_user_user_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
  @Column(name = "USER_ID")
  private Long userId;

  @Column(name = "USERNAME")
  private String username;
 
  @Column(name = "PASSWORD")
  private String password;
  
  @Column(name = "NAME")
  private String name;
  
  @Column(name = "EMAIL")
  private String email;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "T_USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"),
  inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
  private Set<Role> roles;
  
  public User() {
    super();
  }

  public User(String username, String password, String name, String email) {
    super();
    this.username = username;
    this.password = password;
    this.name = name;
    this.email = email;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

}
