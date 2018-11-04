package top.huhuiyu.vote.base;

/**
 * model层（获取客户端数据）基础类
 *
 * @author DarkKnight
 *
 */
public abstract class BaseModel extends BaseEntity {

  private static final long serialVersionUID = -9188998793975747208L;

  private String token;

  public BaseModel() {
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

}
