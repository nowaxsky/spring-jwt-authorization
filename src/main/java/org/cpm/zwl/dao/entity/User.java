package org.cpm.zwl.dao.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.cpm.zwl.dao.audit.DateAudit;
import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "T_USERS")
public class User extends DateAudit implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -7036364716966549707L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;

  @NotBlank
  @Size(max = 15)
  private String username;
 
  @NotBlank
  @Size(max = 100)
  private String password;
  
  @NotBlank
  @Size(max = 40)
  private String name;
  
  @NaturalId
  @NotBlank
  @Column(name = "EMAIL")
  @Email
  private String email;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "T_USER_ROLES", joinColumns = @JoinColumn(name = "USER_ID"),
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
