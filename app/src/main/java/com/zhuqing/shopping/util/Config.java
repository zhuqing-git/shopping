package com.zhuqing.shopping.util;

import com.zhuqing.shopping.LoginActivity;

public class Config {


    //editor.putBoolean("verification", true);




   public enum Sort{
      shuben ,shouji,diannao,shuma,meizhuang,yundong,xihu,dianqi;
   }
   public static int  getCommodyNumber=10;

  public static  int GetSortNumber(String topic)
  {
     int result=0;
   switch (topic)
   {
      case "书本":
         result=1;
         break;
      case "手机":
         result=2;
         break;
      case "电脑":
         result=3;
         break;
      case "数码":
         result=4;
         break;
      case "美妆":
         result=5;
         break;
      case "运动":
         result=6;
         break;
      case "洗护":
         result=7;
         break;
      case "电器":
         result=8;
         break;

     default:
        result=0;
         break;

   }


    return result;
  }
}
