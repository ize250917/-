package org.example.tliaswebmanagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.tliaswebmanagement.pojo.Clazz;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface ClazzMapper {

    public List<Clazz> list(String name, LocalDate begin, LocalDate end);

    void delete(Integer id);

    void insert(Clazz clazz);

    Clazz get(Integer id);

    void update(Clazz clazz);
}
