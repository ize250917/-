package org.example.tliaswebmanagement.mapper;

import org.apache.ibatis.annotations.*;
import org.example.tliaswebmanagement.pojo.Dept;
import org.example.tliaswebmanagement.service.DeptService;

import java.util.List;

//操作部门表
@Mapper
public interface DeptMapper {
    //查询所有部门数据
    @Select("select id, name, create_time, update_time from dept order by update_time desc")
    List<Dept> findAll();

    // 根据id删除部门
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    //添加部门
    @Insert("insert into dept(name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);

    //根据id查询部门
    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept getInfo(Integer id);

    //修改部门
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
