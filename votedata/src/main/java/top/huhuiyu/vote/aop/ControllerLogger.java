package top.huhuiyu.vote.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import top.huhuiyu.vote.base.BaseAop;
import top.huhuiyu.vote.utils.MyUtils;

/**
 * - 控制器日志切面
 *
 * @author DarkKnight
 *
 */
@Aspect
@Component
public class ControllerLogger extends BaseAop {

  private static final Logger log = LoggerFactory.getLogger(ControllerLogger.class);

  @Before("controllerPointcut()")
  public void beforeController(JoinPoint jp) {
    log.debug(String.format("进入：%s", jp.getSignature()));
    StringBuilder sb = new StringBuilder();
    Object[] args = jp.getArgs();
    for (Object arg : args) {
      sb.append(arg).append(MyUtils.CRLF);
    }
    if (sb.length() > 0) {
      log.debug(String.format("参数列表：%n%s", sb));
    } else {
      log.debug("没有参数");
    }
  }

  @After("controllerPointcut()")
  public void afterController(JoinPoint jp) {
    log.debug(String.format("%s执行完毕", jp.getSignature()));
  }

  @AfterReturning(pointcut = "controllerPointcut()", returning = "result")
  public void afterControllerReturning(JoinPoint jp, Object result) {
    log.debug(String.format("%s的返回值%s", jp.getSignature(), result));
  }

}
