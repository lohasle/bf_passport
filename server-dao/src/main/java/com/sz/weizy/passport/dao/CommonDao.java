package com.sz.weizy.passport.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by lohas https:github.com/lohasle on 2015/11/26 0026.
 */
@Component
public class CommonDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    /**
     * 添加或者修改
     *
     * @param sql
     * @param params
     * @return
     */
    public long merge(String sql, Object[] params) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, params);
        Number number = generatedKeyHolder.getKey();
        return number.longValue();
    }

    /**
     * 删除
     *
     * @param sql
     * @param params
     */
    public void delete(String sql, Object[] params) {
        jdbcTemplate.update(sql, params);
    }

    /**
     * 取得单个对象
     *
     * @return
     */
    public <T> T get(String sql, RowMapper<T> rowMapper, Object... params) {
        return jdbcTemplate.queryForObject(sql, rowMapper, params);
    }

}
