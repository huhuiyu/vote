package top.huhuiyu.vote.entity;

import java.util.List;

import top.huhuiyu.vote.base.BaseEntity;

/**
 * data.json数据对象
 * 
 * @author DarkKnight
 *
 */
public class DataInfo extends BaseEntity {
  private static final long serialVersionUID = -1430208428623594013L;

  /**
   * -标兵列表
   */
  private List<BiaoBingInfo> biaobingInfos;

  /**
   * -兵嫂列表
   */
  private List<BiaoBingInfo> bingsaoInfos;

  private String totalRule="";
  private String biaobingRule="";
  private String bingsaoRule="";

  public DataInfo() {
  }

  public List<BiaoBingInfo> getBiaobingInfos() {
    return biaobingInfos;
  }

  public void setBiaobingInfos(List<BiaoBingInfo> biaobingInfos) {
    this.biaobingInfos = biaobingInfos;
  }

  public List<BiaoBingInfo> getBingsaoInfos() {
    return bingsaoInfos;
  }

  public void setBingsaoInfos(List<BiaoBingInfo> bingsaoInfos) {
    this.bingsaoInfos = bingsaoInfos;
  }

  public String getTotalRule() {
    return totalRule;
  }

  public void setTotalRule(String totalRule) {
    this.totalRule = totalRule;
  }

  public String getBiaobingRule() {
    return biaobingRule;
  }

  public void setBiaobingRule(String biaobingRule) {
    this.biaobingRule = biaobingRule;
  }

  public String getBingsaoRule() {
    return bingsaoRule;
  }

  public void setBingsaoRule(String bingsaoRule) {
    this.bingsaoRule = bingsaoRule;
  }
  
}
