package org.example.tliaswebmanagement.mapper;

import org.apache.ibatis.annotations.Select;
import org.example.tliaswebmanagement.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface EmpMapper {
    /*

    // 分页查询（原始）
    //查询总记录数
    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
    public Long count();

    //查询所有员工及部门名称
    @Select("select e.*, d.name deptName from emp as e left join dept as d on e.dept_id = d.id " +
            "order by e.update_time desc limit #{start}, #{pageSize}")
    public List<Emp> list(Integer start, Integer pageSize);

    */

    // 分页查询（基于pageHelper）
    @Select("select e.*, d.name deptName from emp as e left join dept as d on e.dept_id = d.id")
    public List<Emp> list();

}