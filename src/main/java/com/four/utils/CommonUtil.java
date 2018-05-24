package com.four.utils;

import java.util.ArrayList;
import java.util.List;

public class CommonUtil {
	//返回集合
  public static List getidList(String ids){
	  String[] split = ids.split(",");
		List list = new ArrayList(); 
		for (int i = 0; i < split.length; i++) {
			list.add(split[i]);
		}
		return list;
  }
  //
}
