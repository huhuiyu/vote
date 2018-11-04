package top.huhuiyu.vote.entity;

import top.huhuiyu.vote.base.BaseEntity;

/**
 * -标兵
 * 
 * @author DarkKnight
 *
 */
public class BiaoBing extends BaseEntity {

  private static final long serialVersionUID = -8803009966159522575L;

  private Integer id;
  private String num;
  private String name;
  private String info;
  private String image;
  private AddInfo addInfo;
  private int stars = 0;

  public BiaoBing() {
  }

  public BiaoBing(Integer id, String num, String name, String info, String image) {
    this.id = id;
    this.num = num;
    this.name = name;
    this.info = info;
    this.image = image;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNum() {
    return num;
  }

  public void setNum(String num) {
    this.num = num;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public AddInfo getAddInfo() {
    return addInfo;
  }

  public void setAddInfo(AddInfo addInfo) {
    this.addInfo = addInfo;
  }

  public int getStars() {
    return stars;
  }

  public void setStars(int stars) {
    this.stars = stars;
  }

}
