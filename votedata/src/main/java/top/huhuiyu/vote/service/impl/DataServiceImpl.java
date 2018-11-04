package top.huhuiyu.vote.service.impl;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import top.huhuiyu.vote.entity.AddInfo;
import top.huhuiyu.vote.entity.BiaoBing;
import top.huhuiyu.vote.entity.BiaoBingInfo;
import top.huhuiyu.vote.entity.DataInfo;
import top.huhuiyu.vote.model.DataModel;
import top.huhuiyu.vote.service.DataService;
import top.huhuiyu.vote.utils.JsonMessage;

/**
 * 
 * @author DarkKnight
 *
 */
@Service
public class DataServiceImpl implements DataService {

  private static final Logger log = LoggerFactory.getLogger(DataServiceImpl.class);

  private static DataInfo dataInfo;
  private static long lastmodify = -1;

  public DataServiceImpl() {
  }

  /**
   * -加载数据
   */
  private static void loadData() {
    // 读取文件到datainfo
    try {
      log.debug("读取文件中");
      File dataFile = new File(System.getProperty("user.dir") + DATA_FILE);
      log.debug(String.format("最后修改时间:%s-%s", lastmodify, dataFile.lastModified()));
      if (lastmodify != dataFile.lastModified()) {
        lastmodify = dataFile.lastModified();
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(new File(System.getProperty("user.dir") + DATA_FILE));
        while (scanner.hasNextLine()) {
          sb.append(scanner.nextLine());
        }
        scanner.close();
        dataInfo = JSON.parseObject(sb.toString(), DataInfo.class);
      }

    } catch (Exception ex) {
      throw new RuntimeException("读取数据文件发生错误。" + ex.getMessage());
    }
  }

  /**
   * -按照id查询标兵
   * 
   * @param biaoBing
   * @return
   * @throws Exception
   */
  private BiaoBing find(BiaoBing biaoBing) throws Exception {
    loadData();
    if (biaoBing == null || biaoBing.getId() == null) {
      return null;
    }
    List<BiaoBingInfo> list = dataInfo.getBiaobingInfos();
    for (BiaoBingInfo biaoBingInfo : list) {
      List<BiaoBing> bblist = biaoBingInfo.getBiaobings();
      for (BiaoBing bb : bblist) {
        if (bb.getId().equals(biaoBing.getId())) {
          AddInfo addInfo = new AddInfo();
          addInfo.setPid(biaoBingInfo.getId());
          addInfo.setPtitle(biaoBingInfo.getTitle());
          bb.setAddInfo(addInfo);
          return bb;
        }
      }
    }
    return null;
  }

  @Override
  public JsonMessage getBiaoBingInfo(DataModel model) throws Exception {
    loadData();
    List<BiaoBingInfo> list = dataInfo.getBiaobingInfos();
    return JsonMessage.getSuccess("").put("list", list);
  }

  @Override
  public JsonMessage getBiaoBingById(DataModel model) throws Exception {
    return JsonMessage.getSuccess("").put("biaobing", find(model.getBiaoBing()));
  }

}
