package top.huhuiyu.vote.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import top.huhuiyu.vote.entity.AddInfo;
import top.huhuiyu.vote.entity.BiaoBing;
import top.huhuiyu.vote.entity.BiaoBingInfo;
import top.huhuiyu.vote.entity.DataInfo;
import top.huhuiyu.vote.entity.VoteInfo;
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
  private static volatile Map<String, List<VoteInfo>> voteInfos = new HashMap<>();

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
   * -加载投票数据
   */
  @SuppressWarnings("unchecked")
  private static synchronized void loadVoteData() {
    try {
      // 数据为空就读取
      if (!voteInfos.isEmpty()) {
        return;
      }
      File dataFile = new File(System.getProperty("user.dir") + VOTE_FILE);

      if (!dataFile.exists()) {
        // 文件不存在就初始化
        loadData();
        List<BiaoBingInfo> list = dataInfo.getBiaobingInfos();
        List<VoteInfo> vis = new ArrayList<>();
        for (BiaoBingInfo biaoBingInfo : list) {
          for (BiaoBing biaoBing : biaoBingInfo.getBiaobings()) {
            vis.add(new VoteInfo(VoteInfo.BIAOBING, biaoBing.getId(), 0));
          }
        }
        voteInfos.put(VoteInfo.BIAOBING, vis);
        list = dataInfo.getBingsaoInfos();
        vis = new ArrayList<>();
        for (BiaoBingInfo biaoBingInfo : list) {
          for (BiaoBing biaoBing : biaoBingInfo.getBiaobings()) {
            vis.add(new VoteInfo(VoteInfo.BINGSAO, biaoBing.getId(), 0));
          }
        }
        voteInfos.put(VoteInfo.BINGSAO, vis);
        saveVoteData();
      } else {
        // 否则就读取
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(System.getProperty("user.dir") + VOTE_FILE)));
        voteInfos = (Map<String, List<VoteInfo>>) ois.readObject();
        ois.close();
      }
      log.debug(voteInfos.toString());
    } catch (Exception ex) {
      throw new RuntimeException("读取投票文件发生错误。" + ex.getMessage());
    }
  }

  /**
   * -保存投票数据
   * 
   * @throws Exception
   */
  private static synchronized void saveVoteData() throws Exception {
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(System.getProperty("user.dir") + VOTE_FILE)));
    oos.writeObject(voteInfos);
    oos.flush();
    oos.close();
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

  /**
   * -获取int数组
   * 
   * @param ids
   * @return
   * @throws Exception
   */
  private static List<Integer> getIds(String ids) throws Exception {
    String[] sids = ids.split(",");
    Integer[] ints = new Integer[sids.length];
    for (int i = 0; i < ints.length; i++) {
      ints[i] = Integer.parseInt(sids[i]);
    }
    List<Integer> list = Arrays.asList(ints);
    Collections.sort(Arrays.asList(ints));
    return list;
  }

  @Override
  public JsonMessage getBiaoBingInfo(DataModel model) throws Exception {
    loadData();
    loadVoteData();
    List<BiaoBingInfo> list = dataInfo.getBiaobingInfos();
    return JsonMessage.getSuccess("").put("list", list);
  }

  @Override
  public JsonMessage getBiaoBingById(DataModel model) throws Exception {
    return JsonMessage.getSuccess("").put("biaobing", find(model.getBiaoBing()));
  }

  @Override
  public synchronized JsonMessage voteBiaoBing(DataModel model) throws Exception {
    loadVoteData();
    List<VoteInfo> vis = voteInfos.get(VoteInfo.BIAOBING);
    List<Integer> ids = getIds(model.getSelectedIds());
    for (Integer id : ids) {
      for (VoteInfo voteInfo : vis) {
        if (voteInfo.getId().equals(id)) {
          voteInfo.setCount(voteInfo.getCount() + 1);
        }
      }
    }
    saveVoteData();
    return JsonMessage.getSuccess("投票成功");
  }

}
