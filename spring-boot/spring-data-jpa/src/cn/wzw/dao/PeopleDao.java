package cn.wzw.dao;

import org.springframework.data.repository.CrudRepository;

import cn.wzw.pojo.People;

/**
 * 使用CRUDRepository，此接口完成CRUD基本操作
 * @author wangzhiwen
 *
 */
public interface PeopleDao extends CrudRepository<People, Integer> {

}
