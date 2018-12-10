package org.star4j.elasticsearch.search;

import org.star4j.elasticsearch.util.ElasticSearchImp;

import java.util.Map;


/**
 * @Author: WuYL
 * @Description: ElasticSearch 查询操作类
 * @Date: Created on 2017/8/16
 * @Modified By:
 */
public class ElasticQueryHelper {


	// --------------------以下是各种搜索方法--------------------------

	/**
	 * 高亮搜索
	 * 
	 * @param type 类型
	 * @param fieldName 段
	 * @param keyword 段值
	 * @return
	 */
	public static Map<String, Object> searchDocHighlight(String type, String fieldName, String keyword) {
		return ElasticSearchImp.searchDocHighlight(type, fieldName, keyword, 0, 10);
	}

	/**
	 * 高亮搜索
	 * 
	 * @param type 类型
	 * @param fieldName 段
	 * @param keyword 关键词
	 * @param from 开始行数
	 * @param size 每页大小
	 * @return
	 */
	public static Map<String, Object> searchDocHighlight(String type, String fieldName, String keyword, int from,
			int size) {
		return ElasticSearchImp.searchDocHighlight(type, fieldName, keyword, from, size);
	}

	/**
	 * or条件查询高亮
	 * 
	 * @param type 类型
	 * @param shouldMap or条件和值
	 * @return
	 */
	public static Map<String, Object> multiOrSearchDocHigh(String type, Map<String, String> shouldMap, int from,
			int size) {
		return ElasticSearchImp.multiOrSearchDocHigh(type, shouldMap, from, size);
	}

	/**
	 * 搜索
	 * 
	 * @param type 类型
	 * @param fieldName 待搜索的字段
	 * @param keyword 待搜索的关键词
	 */
	public static Map<String, Object> searchDoc(String type, String fieldName, String keyword) {
		return ElasticSearchImp.searchDoc(type, fieldName, keyword, 0, 10);
	}

	/**
	 * 多个条件进行or查询
	 * 
	 * @param type 类型
	 * @param shouldMap 进行or查询的段和值
	 * @return
	 */
	public static Map<String, Object> multiOrSearchDoc(String type, Map<String, String> shouldMap) {
		return ElasticSearchImp.multiOrSearchDoc(type, shouldMap, 0, 10);
	}

	/**
	 * 多个条件进行and查询
	 * 
	 * @param type 类型
	 * @param mustMap 进行and查询的段和值
	 * @return
	 */
	public static Map<String, Object> multiAndSearchDoc(String type, Map<String, String> mustMap) {
		return ElasticSearchImp.multiAndSearchDoc(type, mustMap, 0, 10);
	}
}
