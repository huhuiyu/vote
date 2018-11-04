package top.huhuiyu.vote.entity;

import top.huhuiyu.vote.base.BaseEntity;

/**
 * -视图层附加信息
 * 
 * @author DarkKnight
 *
 */
public class AddInfo extends BaseEntity {
  private static final long serialVersionUID = -3728990814171284004L;

  private Integer pid;
  private String ptitle;

  public AddInfo() {
  }

  public Integer getPid() {
    return pid;
  }

  public void setPid(Integer pid) {
    this.pid = pid;
  }

  public String getPtitle() {
    return ptitle;
  }

  public void setPtitle(String ptitle) {
    this.ptitle = ptitle;
  }

}
