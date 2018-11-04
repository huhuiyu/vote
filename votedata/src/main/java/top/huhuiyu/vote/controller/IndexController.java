package top.huhuiyu.vote.controller;

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
  @RequestMapping("")
  public JsonMessage index() throws Exception {
    return JsonMessage.getSuccess("欢迎使用投票系统");
  }
}
