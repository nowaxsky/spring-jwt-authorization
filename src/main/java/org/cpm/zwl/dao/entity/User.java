package org.cpm.zwl.dao.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_USER")
public class User implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -7036364716966549707L;

  @Id
  @Column(name = "USER_ID")
  private String userId;

  @Column(name = "PASSWORD")
  private String password;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
