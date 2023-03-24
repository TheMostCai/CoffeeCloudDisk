package com.coffee.coffeeclouddisk.handler;

import com.alibaba.fastjson2.JSON;
import com.coffee.coffeeclouddisk.entity.DirectoryMeta;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author Nebula
 * @Description TODO
 * @date 2023/3/23 15:52
 */
@MappedJdbcTypes({JdbcType.VARCHAR})
@MappedTypes({DirectoryMeta.class})
public class MapHandler extends BaseTypeHandler<Map<String,Number>> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Map parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, JSON.toJSONString(parameter));
    }

    @Override
    public Map<String,Number> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return JSON.parseObject(rs.getString(columnName), Map.class);
    }

    @Override
    public Map<String,Number> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return JSON.parseObject(rs.getString(columnIndex), Map.class);
    }

    @Override
    public Map<String,Number> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return JSON.parseObject(cs.getString(columnIndex), Map.class);
    }
}
