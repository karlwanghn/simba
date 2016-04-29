package com.caozj.framework.util.common;

import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * fastjson工具类
 * 
 * @author caozj
 *
 */
public class FastJsonUtil {

	private FastJsonUtil() {

	}

	/**
	 * Object -> json
	 * 
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		return JSON.toJSONString(obj, true);
	}

	/**
	 * json -> Object
	 * 
	 * @param <T>
	 * @param content
	 * @param valueType
	 * @return
	 */
	public static <T> T toObject(String content, Class<T> valueType) {
		return JSON.parseObject(content, valueType);
	}

	/**
	 * json -> List
	 * 
	 * @param <T>
	 * @param content
	 * @param valueType
	 * @return
	 */
	public static <T> List<T> toList(String content, Class<T> valueType) {
		return JSON.parseArray(content, valueType);
	}
}
