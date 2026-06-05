package org.example.tliaswebmanagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tliaswebmanagement.pojo.EmpExpr;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    void insertBatch(List<EmpExpr> exprList);

    void deleteByEmpIds(List<Integer> empIds);
}
