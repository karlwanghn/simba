package com.caozj.test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.caozj.framework.util.common.XmlUtil;

public class TWebXML {

  public static void main(String[] args) throws ParserConfigurationException, SAXException,
      IOException, XPathExpressionException, TransformerException {
    String file =
        "D:\\local\\develop2.0\\SmartAs\\target\\depoly\\xxx-web\\src\\main\\webapp\\WEB-INF\\web.xml";
    Document doc = XmlUtil.parseXML(file);
    Element root = doc.getDocumentElement();
    Element node = (Element) XmlUtil.selectSingleNode("/web-app/resource-ref/res-ref-name", root);
    System.out.println(XmlUtil.toXml(node));
    node.setTextContent("testNode");
    System.out.println(XmlUtil.toXml(node));
    XmlUtil.saveXML(file, doc);
  }

}
