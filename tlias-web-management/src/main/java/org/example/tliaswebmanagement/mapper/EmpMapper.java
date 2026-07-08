package org.example.tliaswebmanagement.mapper;
import org.apache.ibatis.annotations.*;

import org.example.tliaswebmanagement.pojo.Emp;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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

    // 分页查询（基于pageHelper） sql语句已经配置在EmpMapper.xml中
    public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);

    /**
     * 新增员工数据
     * @Options 开启自动获取主键值
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    //批量删除员工 sql语句已经配置在EmpMapper.xml中
    void deleteByIds(List<Integer> ids);

    //根据ID查询员工信息 sql语句已经配置在EmpMapper.xml中
    Emp getById(Integer id);

    //根据ID更新员工信息 sql语句已经配置在EmpMapper.
    void updateById(Emp emp);

    /**
     * 统计各个职位的员工人数
     */
    @MapKey("pos")
    List<Map<String, Object>> countEmpJobData();

    /**
     * 统计各个性别的员工人数
     */
    @MapKey("name")
    List<Map<String, Integer>> countEmpGenderData();

    /*
    * 查询所有班主任信息
    */
    @MapKey("id")
    List<Emp> allTeacherList(Integer job);

    @Select("select id, username, name from emp where username = #{username} and password = #{password}")
    Emp selectByUsernameandPassword(String username, String password);
}

    