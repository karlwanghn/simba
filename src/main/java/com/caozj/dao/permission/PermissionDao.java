package com.caozj.dao.permission;

import java.util.List;

import com.caozj.framework.util.jdbc.Pager;
import com.caozj.model.permission.Permission;

/**
 * 
 * 
 * @author caozj
 * 
 */
public interface PermissionDao {

	void add(Permission permission);

	void update(Permission permission);

	void delete(int id);

	List<Permission> listAll();

	int count();

	List<Permission> page(Pager page);

	Permission get(int id);

	Permission getBy(String field, Object value);

	Permission getByAnd(String field1, Object value1, String field2, Object value2);

	Permission getByOr(String field1, Object value1, String field2, Object value2);

	List<Permission> listBy(String field, Object value);

	List<Permission> listByAnd(String field1, Object value1, String field2, Object value2);

	List<Permission> listByOr(String field1, Object value1, String field2, Object value2);

	List<Permission> pageBy(String field, Object value, Pager page);

	List<Permission> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<Permission> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	int countBy(String field, Object value);

}
