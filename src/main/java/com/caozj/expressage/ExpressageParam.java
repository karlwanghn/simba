package com.caozj.expressage;

import java.util.HashMap;
import java.util.Map;

/**
 * 快递查询参数对象
 * 
 * @author caozj
 *
 */
public class ExpressageParam {

  /**
   * 身份授权key
   */
  private String id;

  /**
   * 要查询的快递公司代码，不支持中文
   */
  private String com;

  /**
   * 要查询的快递单号，请勿带特殊符号，不支持中文（大小写不敏感）
   */
  private String nu;

  /**
   * 返回类型： 0：返回json字符串， 1：返回xml对象， 2：返回html对象， 3：返回text文本。 如果不填，默认返回json字符串。
   */
  private String show = "0";

  /**
   * 返回信息数量： 1:返回多行完整的信息， 0:只返回一行信息。 不填默认返回多行。
   */
  private String muti = "1";

  /**
   * 排序： desc：按时间由新到旧排列， asc：按时间由旧到新排列。 不填默认返回倒序（大小写不敏感）
   */
  private String order = "desc";

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCom() {
    return com;
  }

  public void setCom(String com) {
    this.com = com;
  }

  public String getNu() {
    return nu;
  }

  public void setNu(String nu) {
    this.nu = nu;
  }

  public String getShow() {
    return show;
  }

  public void setShow(String show) {
    this.show = show;
  }

  public String getMuti() {
    return muti;
  }

  public void setMuti(String muti) {
    this.muti = muti;
  }

  public String getOrder() {
    return order;
  }

  public void setOrder(String order) {
    this.order = order;
  }

  public Map<String, String> toMap() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("id", id);
    map.put("com", com);
    map.put("nu", nu);
    map.put("show", show);
    map.put("muti", muti);
    map.put("order", order);
    return map;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("ExpressageParam [id=");
    builder.append(id);
    builder.append(", com=");
    builder.append(com);
    builder.append(", nu=");
    builder.append(nu);
    builder.append(", show=");
    builder.append(show);
    builder.append(", muti=");
    builder.append(muti);
    builder.append(", order=");
    builder.append(order);
    builder.append("]");
    return builder.toString();
  }

}
