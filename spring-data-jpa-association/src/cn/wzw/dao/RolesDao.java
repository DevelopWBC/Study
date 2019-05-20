package cn.wzw.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.wzw.pojo.Roles;

public interface RolesDao extends JpaRepository<Roles, Integer>,JpaSpecificationExecutor<Roles>{

}
