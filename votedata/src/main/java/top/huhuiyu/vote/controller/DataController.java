package top.huhuiyu.vote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.vote.model.DataModel;
import top.huhuiyu.vote.service.DataService;
import top.huhuiyu.vote.utils.JsonMessage;

/**
 * -数据控制器
 * 
 * @author DarkKnight
 *
 */
@RestController
@RequestMapping("/data")
public class DataController {
  @Autowired
  private DataService dataService;

  @RequestMapping("/biaobingInfos")
  public JsonMessage biaobingInfos(DataModel model) throws Exception {
    return dataService.getBiaoBingInfo(model);
  }

  @RequestMapping("/queryBiaobingById")
  public JsonMessage queryBiaobingById(DataModel model) throws Exception {
    return dataService.getBiaoBingById(model);
  }

  @RequestMapping("/voteBiaoBing")
  public JsonMessage voteBiaoBing(DataModel model) throws Exception {
    return dataService.voteBiaoBing(model);
  }

  @RequestMapping("/getIndexRule")
  public JsonMessage getIndexRule(DataModel model) throws Exception {
    return dataService.getIndexRule(model);
  }

  @RequestMapping("/bingsaoInfos")
  public JsonMessage bingsaoInfos(DataModel model) throws Exception {
    return dataService.getBingSaoInfo(model);
  }

  @RequestMapping("/queryBingSaoById")
  public JsonMessage queryBingSaoById(DataModel model) throws Exception {
    return dataService.getBingSaoById(model);
  }

  @RequestMapping("/voteBingSao")
  public JsonMessage voteBingSao(DataModel model) throws Exception {
    return dataService.voteBingSao(model);
  }
}
