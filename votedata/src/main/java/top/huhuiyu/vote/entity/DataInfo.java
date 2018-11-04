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

}
