package org.star4j.elasticsearch.operate;

import org.star4j.elasticsearch.util.ElasticSearchImp;
import java.util.Map;

/**
 * @Author: WuYL
 * @Description: ElasticSearch操作类
 * @Date: Created on 2017/8/16
 * @Modified By:
 */
public class ElasticCUDHelper {

	/**
	 * 将一个Map格式的数据（key,value）插入索引（指定_id，一般是业务数据的id，及elasticSearch和关系型数据使用同一个id，方便同关系型数据库互动）
	 * 
	 * @param type 类型（对应数据库表）
	 * @param docId id，对应elasticSearch中的_id字段
	 * @param mapParam Map格式的数据
	 * @return
	 */
	public static boolean addDoc(String type, String docId, Map<String, String> mapParam) {
		return ElasticSearchImp.addMapDocToIndex(type, docId, mapParam);
	}

	/**
	 * 将一个Map格式的数据（key,value）插入索引 （使用默认_id）
	 * 
	 * @param type 类型（对应数据库表）
	 * @param mapParam Map格式的数据
	 * @return
	 */
	public static boolean addDoc(String type, Map<String, String> mapParam) {
		return ElasticSearchImp.addMapDocToIndex(type, null, mapParam);
	}

	/**
	 * 将一个实体存入到默认索引的类型中（默认_id）
	 * 
	 * @param type 类型（对应数据库表）
	 * @param entity 要插入的实体
	 * @param methodNameParm 需要将实体中哪些属性作为字段
	 * @return
	 */
	public static boolean addDoc(String type, Object entity, String... methodNameParm) {
		return ElasticSearchImp.addEntityDoc(type, null, entity, methodNameParm);
	}

	/**
	 * 将一个实体存入到默认索引的类型中（指定_id，一般是业务数据的id，及elasticSearch和关系型数据使用同一个id，方便同关系型数据库互动）
	 *
	 * @param type 类型（对应数据库表）
	 * @param docId id，对应elasticSearch中的_id字段
	 * @param entity 要插入的实体
	 * @param methodNameParm 需要将实体中哪些属性作为字段
	 * @return
	 */
	public static boolean addDoc(String type, String docId, Object entity, String... methodNameParm) {
		return ElasticSearchImp.addEntityDoc(type, docId, entity, methodNameParm);
	}

	/**
	 * 删除文档
	 * 
	 * @param type 类型（对应数据库表）
	 * @param docId 类型中id
	 * @return
	 */
	public static boolean deleteDoc(String type, String docId) {
		return ElasticSearchImp.deleteDoc(type, docId);
	}

	/**
	 * 修改文档
	 * 
	 * @param type 类型
	 * @param docId 文档id
	 * @param updateParam 需要修改的字段和值
	 * @return
	 */
	public static boolean updateDoc(String type, String docId, Map<String, String> updateParam) {
		return ElasticSearchImp.updateDoc(type, docId, updateParam);
	}

	/**
	 * 修改文档
	 *
	 * @param type 类型
	 * @param docId 文档id
	 * @param updateParam 需要修改的字段和值
	 * @return
	 */
	public static boolean updateDoc(String type, String docId, Object entity) {
		return ElasticSearchImp.updateDoc(type, docId, entity);
	}
}
