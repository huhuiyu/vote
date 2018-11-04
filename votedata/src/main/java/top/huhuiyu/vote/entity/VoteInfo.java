package top.huhuiyu.vote.entity;

import top.huhuiyu.vote.base.BaseEntity;

/**
 * -投票统计信息
 * 
 * @author DarkKnight
 *
 */
public class VoteInfo extends BaseEntity {
  private static final long serialVersionUID = -3543868964793824812L;
  public static final String BIAOBING = "biaobing";
  public static final String BINGSAO = "bingsao";
  private String type = BIAOBING;
  private Integer id;
  private int count;

  public VoteInfo() {
  }

  public VoteInfo(String type, Integer id, int count) {
    this.type = type;
    this.id = id;
    this.count = count;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

}
