package org.cpm.zwl.dao.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_ROLE")
public class Role implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -1039350368526825334L;

  @Id
  @Column(name = "ROLE_ID")
  private String roleId;

  @Column(name = "ROLE_NAME")
  private String roleName;

  @ManyToMany(mappedBy = "roles")
  private Set<User> users;

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public Set<User> getUsers() {
    return users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }
}
