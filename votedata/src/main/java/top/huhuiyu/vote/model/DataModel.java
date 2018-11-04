package top.huhuiyu.vote.model;

import top.huhuiyu.vote.base.BaseModel;
import top.huhuiyu.vote.entity.BiaoBing;

/**
 * data model
 * 
 * @author DarkKnight
 *
 */
public class DataModel extends BaseModel {

  private static final long serialVersionUID = 8106776420172205249L;
  private BiaoBing biaoBing = new BiaoBing();

  public DataModel() {
  }

  public BiaoBing getBiaoBing() {
    return biaoBing;
  }

  public void setBiaoBing(BiaoBing biaoBing) {
    this.biaoBing = biaoBing;
  }

}
