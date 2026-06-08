package org.example.tliaswebmanagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tliaswebmanagement.pojo.EmpExpr;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    //批量新增员工表达式数据 sql语句已经配置在EmpExprMapper.xml中
    void insertBatch(List<EmpExpr> exprList);

    //根据员工ID删除员工表达式数据 sql语句已经配置在EmpExprMapper.xml中
    void deleteByEmpIds(List<Integer> empIds);
}
