package top.huhuiyu.vote.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.vote.utils.JsonMessage;

/**
 * -首页控制器
 * 
 * @author DarkKnight
 *
 */
@RestController
public class IndexController {

  private static final Logger log = LoggerFactory.getLogger(IndexController.class);

  @RequestMapping("")
  public JsonMessage index() throws Exception {
    log.debug(System.getProperty("user.dir"));
    return JsonMessage.getSuccess("欢迎使用投票系统");
  }
}
