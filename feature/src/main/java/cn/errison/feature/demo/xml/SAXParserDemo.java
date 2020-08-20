package cn.errison.feature.demo.xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXParserDemo {


   public static void main(String[] args) {

      try {
         SAXParserFactory factory = SAXParserFactory.newInstance();
         SAXParser saxParser = factory.newSAXParser();
         UserHandler userhandler = new UserHandler();
         saxParser.parse(SAXParserDemo.class.getClassLoader().getResourceAsStream("students.xml"), userhandler);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}