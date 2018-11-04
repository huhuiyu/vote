package top.huhuiyu.vote.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * MyUtils-工具包
 *
 * @author DarkKnight
 *
 */
public class MyUtils {

  /**
   * - 回车换行
   */
  public static final String CRLF = String.format("%n");

  /**
   * isEmpty-判断是否是null或者是全部都是空白字符
   *
   * @param value
   * @return
   */
  public static boolean isEmpty(String value) {
    return value == null || "".equals(value.trim());
  }

  /**
   * trim-去掉头尾空白字符，null值也會返回成空字符串
   *
   * @param value
   * @return
   */
  public static String trim(String value) {
    if (isEmpty(value)) {
      return "";
    }
    return value.trim();
  }

  /**
   * -获取请求的客户端ip地址
   * 
   * @return
   */
  public static String getIpAddr() {
    String unknown = "unknown";
    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
    String ipAddress = null;
    try {
      ipAddress = request.getHeader("x-forwarded-for");
      if (ipAddress == null || ipAddress.length() == 0 || unknown.equalsIgnoreCase(ipAddress)) {
        ipAddress = request.getHeader("Proxy-Client-IP");
      }
      if (ipAddress == null || ipAddress.length() == 0 || unknown.equalsIgnoreCase(ipAddress)) {
        ipAddress = request.getHeader("WL-Proxy-Client-IP");
      }
      if (ipAddress == null || ipAddress.length() == 0 || unknown.equalsIgnoreCase(ipAddress)) {
        ipAddress = request.getRemoteAddr();
        String local = "127.0.0.1";
        if (local.equals(ipAddress)) {
          // 根据网卡取本机配置的IP
          InetAddress inet = null;
          try {
            inet = InetAddress.getLocalHost();
          } catch (UnknownHostException e) {
            e.printStackTrace();
          }
          ipAddress = inet.getHostAddress();
        }
      }
      // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
      // "***.***.***.***".length()
      int iplength = 15;
      String split = ".";
      if (ipAddress != null && ipAddress.length() > iplength) {
        if (ipAddress.indexOf(split) > 0) {
          ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
        }
      }
    } catch (Exception e) {
      ipAddress = "";
    }
    return ipAddress;
  }
}
