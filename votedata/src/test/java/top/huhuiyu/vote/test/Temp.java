package top.huhuiyu.vote.test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import top.huhuiyu.vote.entity.BiaoBing;
import top.huhuiyu.vote.entity.BiaoBingInfo;
import top.huhuiyu.vote.entity.DataInfo;
import top.huhuiyu.vote.service.DataService;

/**
 * 
 * @author DarkKnight
 *
 */
public class Temp {
  public static void writeData() throws Exception {
    int groupbb = 10;
    int numsbb = 3;
    int numsbs = 20;
    int groupbs = 1;
    DataInfo dataInfo = new DataInfo();
    dataInfo.setTotalRule("首页显示的投票规则");
    dataInfo.setBiaobingRule("标兵的投票规则");
    dataInfo.setBingsaoRule("军嫂的投票规则");
    // ==================================================================
    List<BiaoBingInfo> biaoBingInfos = new ArrayList<>();
    int biaobingid = 0;
    for (int i = 1; i <= groupbb; i++) {
      List<BiaoBing> biaobings = new ArrayList<>();
      for (int j = 1; j <= numsbb; j++) {
        biaobingid++;
        biaobings.add(new BiaoBing(biaobingid, biaobingid + "号", "标兵" + biaobingid, "信息" + biaobingid, "images/biaobing001.jpg"));
      }
      BiaoBingInfo biaoBingInfo = new BiaoBingInfo(i, "某某标兵" + i, biaobings);
      biaoBingInfos.add(biaoBingInfo);
    }
    dataInfo.setBiaobingInfos(biaoBingInfos);

    // ==================================================================
    List<BiaoBingInfo> bingSaoInfos = new ArrayList<>();
    biaobingid = 0;
    for (int i = 1; i <= groupbs; i++) {
      List<BiaoBing> bingsaos = new ArrayList<>();
      for (int j = 1; j <= numsbs; j++) {
        biaobingid++;
        bingsaos.add(new BiaoBing(biaobingid, biaobingid + "号", "兵嫂" + biaobingid, "信息" + biaobingid, "images/bingsao001.jpg"));
      }
      BiaoBingInfo biaoBingInfo = new BiaoBingInfo(i, "标兵嫂" + i, bingsaos);
      bingSaoInfos.add(biaoBingInfo);
    }
    dataInfo.setBingsaoInfos(bingSaoInfos);

    JSON.writeJSONString(new FileOutputStream(System.getProperty("user.dir") + DataService.DATA_FILE), dataInfo, SerializerFeature.PrettyFormat);
    System.out.println("ok");
  }

  public static void readData() throws Exception {

    StringBuilder sb = new StringBuilder();
    Scanner scanner = new Scanner(new File(System.getProperty("user.dir") + DataService.DATA_FILE));
    while (scanner.hasNextLine()) {
      sb.append(scanner.nextLine());
    }
    scanner.close();
    DataInfo dataInfo = JSON.parseObject(sb.toString(), DataInfo.class);
    System.out.println(dataInfo);
  }

  public static void main(String[] args) throws Exception {
    Temp.writeData();
    // Temp.readData();
  }
}
