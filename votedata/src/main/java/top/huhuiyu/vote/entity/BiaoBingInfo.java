package top.huhuiyu.vote.entity;

import java.util.List;

import top.huhuiyu.vote.base.BaseEntity;

/**
 * -标兵列表
 * 
 * @author DarkKnight
 *
 */
public class BiaoBingInfo extends BaseEntity {
  private static final long serialVersionUID = -1885027416328535681L;
  private Integer id;
  private String title;
  private List<BiaoBing> biaobings;
  private Integer selectedId = -1;

  public BiaoBingInfo() {
  }

  public BiaoBingInfo(Integer id, String title, List<BiaoBing> biaobings) {
    this.id = id;
    this.title = title;
    this.biaobings = biaobings;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<BiaoBing> getBiaobings() {
    return biaobings;
  }

  public void setBiaobings(List<BiaoBing> biaobings) {
    this.biaobings = biaobings;
  }

  public Integer getSelectedId() {
    return selectedId;
  }

  public void setSelectedId(Integer selelectId) {
    this.selectedId = selelectId;
  }
  
}
