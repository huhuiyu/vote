package top.huhuiyu.vote.service;

import java.text.SimpleDateFormat;

import top.huhuiyu.vote.model.DataModel;
import top.huhuiyu.vote.utils.JsonMessage;

/**
 * -数据访问服务
 * 
 * @author DarkKnight
 *
 */
public interface DataService {
  public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMdd");
  public static final String DATA_FILE = "/data.json";
  public static final String VOTE_FILE = "/vote.data";
  public static final String IPS_FILE = "/ips.data";

  /**
   * -获取标兵信息
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage getBiaoBingInfo(DataModel model) throws Exception;

  /**
   * -按照id获取标兵信息
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage getBiaoBingById(DataModel model) throws Exception;

  /**
   * -标兵投票
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage voteBiaoBing(DataModel model) throws Exception;
}
