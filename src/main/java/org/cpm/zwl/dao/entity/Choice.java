//package org.cpm.zwl.dao.entity;
//
//import java.io.Serializable;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import javax.validation.constraints.Size;
//import org.hibernate.validator.constraints.NotBlank;
//
//@Entity
//@Table(name = "T_CHOICES")
//public class Choice implements Serializable {
//  /**
//  * 
//  */
//  private static final long serialVersionUID = 2789420848075393399L;
//
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private Long id;
//
//  @NotBlank
//  @Size(max = 40)
//  private String text;
//
//  @ManyToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "poll_id", nullable = false)
//  private Poll poll;
//
//  public Long getId() {
//    return id;
//  }
//
//  public void setId(Long id) {
//    this.id = id;
//  }
//
//  public String getText() {
//    return text;
//  }
//
//  public void setText(String text) {
//    this.text = text;
//  }
//
//  public Poll getPoll() {
//    return poll;
//  }
//
//  public void setPoll(Poll poll) {
//    this.poll = poll;
//  }
//
//}
