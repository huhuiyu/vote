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
  public static final String VISTORS_FILE = "/vistors.data";

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

  /**
   * -首页数据
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage getIndexRule(DataModel model) throws Exception;

  /**
   * -获取军嫂信息
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage getBingSaoInfo(DataModel model) throws Exception;

  /**
   * -按照id获取军嫂信息
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage getBingSaoById(DataModel model) throws Exception;

  /**
   * -军嫂投票
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage voteBingSao(DataModel model) throws Exception;

  /**
   * -投票管理信息
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage voteInfoView(DataModel model) throws Exception;
}
