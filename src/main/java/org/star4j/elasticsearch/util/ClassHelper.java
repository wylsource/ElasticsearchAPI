package org.star4j.elasticsearch.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: WuYL
 * @Description: 操作 Class 文件助手类
 * @Date: Created on 2017/8/16
 * @Modified By:
 */
public class ClassHelper {
    /**
     * java读取实体类中的属性类型
     * @param model
     * @return
     * @throws Exception
     */
    public static Map<String,String> getModelAttriButeType(Object model) throws Exception{
        Field[] field = model.getClass().getDeclaredFields();        //获取实体类的所有属性，返回Field数组
        Map<String,String> map = new HashMap<String, String>();
        for(int j=0 ; j<field.length ; j++){     //遍历所有属性
            String name = field[j].getName();    //获取属性的名字

            //System.out.print("attribute name:"+name);
            name = name.substring(0,1).toUpperCase()+name.substring(1); //将属性的首字符大写，方便构造get，set方法
            String type = field[j].getGenericType().toString();    //获取属性的类型
              /*if(type.equals("class java.lang.String")){   //如果type是类类型，则前面包含"class "，后面跟类名
                  Method m = model.getClass().getMethod("get"+name);
                  String value = (String) m.invoke(model);    //调用getter方法获取属性值
                  if(value != null){

                      System.out.println("attribute value:"+value);
                  }
              }*/
            type = type.replace("class ", "");
            //System.out.println("=>:"+type);
            map.put(name, type);

        }
        return map;
    }

    public static String[] getModelAttriButeNames(Object model){
        Field[] fields = model.getClass().getDeclaredFields();
        String[] attriButeNames = new String[fields.length];
        for(int j=0 ; j<fields.length ; j++){
            String name = fields[j].getName();
            attriButeNames[j] = name;
        }
        return attriButeNames;
    }

    public static String[] getModelGetMethodNames(Object model){
        String[] attriButeNames = getModelAttriButeNames(model);
        String[] getMethodNames = new String[attriButeNames.length];
        for(int j=0 ; j<attriButeNames.length ; j++){
            getMethodNames[j] = "get" +StringUtil.firstToUpper(attriButeNames[j]);
        }
        return getMethodNames;
    }
}
