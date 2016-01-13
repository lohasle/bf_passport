package com.sz.weizy.passport.dao.mapper;

import com.sz.weizy.passport.dao.entities.SnsUser;
import com.sz.weizy.passport.dao.entities.SnsUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SnsUserMapper {
    int countByExample(SnsUserExample example);

    int deleteByExample(SnsUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SnsUser record);

    int insertSelective(SnsUser record);

    List<SnsUser> selectByExample(SnsUserExample example);

    SnsUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SnsUser record, @Param("example") SnsUserExample example);

    int updateByExample(@Param("record") SnsUser record, @Param("example") SnsUserExample example);

    int updateByPrimaryKeySelective(SnsUser record);

    int updateByPrimaryKey(SnsUser record);

    /**
     * 根据用户名或者电话号码来查找用户
     * @return
     */
    SnsUser qrySnsUserByNameOrPhone(@Param("keyStr") String keyStr);
}