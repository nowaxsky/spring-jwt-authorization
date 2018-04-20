package org.cpm.zwl.dao.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_USER_DETAIL")
public class UserDetail implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 5851407897867688612L;

  @Id
  @Column(name = "USER_ID")
  private String userId;
  
  @Column(name = "USERNAME")
  private String username;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
  
}
