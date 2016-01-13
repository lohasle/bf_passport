package com.sz.weizy.passport.dao.mapper;

import com.sz.weizy.passport.dao.entities.SnsUserEventLog;
import com.sz.weizy.passport.dao.entities.SnsUserEventLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SnsUserEventLogMapper {
    int countByExample(SnsUserEventLogExample example);

    int deleteByExample(SnsUserEventLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SnsUserEventLog record);

    int insertSelective(SnsUserEventLog record);

    List<SnsUserEventLog> selectByExample(SnsUserEventLogExample example);

    SnsUserEventLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SnsUserEventLog record, @Param("example") SnsUserEventLogExample example);

    int updateByExample(@Param("record") SnsUserEventLog record, @Param("example") SnsUserEventLogExample example);

    int updateByPrimaryKeySelective(SnsUserEventLog record);

    int updateByPrimaryKey(SnsUserEventLog record);
}