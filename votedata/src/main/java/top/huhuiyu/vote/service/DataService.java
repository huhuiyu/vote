package top.huhuiyu.vote.service;

import top.huhuiyu.vote.model.DataModel;
import top.huhuiyu.vote.utils.JsonMessage;

/**
 * -数据访问服务
 * 
 * @author DarkKnight
 *
 */
public interface DataService {
  public static final String DATA_FILE = "/data.json";

  /**
   * 获取标兵信息
   * 
   * @param model
   * @return
   */
  JsonMessage getBiaoBingInfo(DataModel model);
}
