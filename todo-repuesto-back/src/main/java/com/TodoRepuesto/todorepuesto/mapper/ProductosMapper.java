package com.TodoRepuesto.todorepuesto.mapper;


import com.TodoRepuesto.todorepuesto.dto.Productos;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductosMapper implements RowMapper<Productos> {
    @Override
    public Productos mapRow(ResultSet resultSet, int i) throws SQLException {
        //tod_nombre, tod_descripcion, tod_codigo_barra, tod_valor_unitario, tod_valor_iva, tod_valor_total, tod_stock, cdestado, nmid_proveedor,
        Productos entity = new Productos();
        entity.setNmid(resultSet.getInt("nmid"));
        entity.setTod_nombre(resultSet.getString("tod_nombre"));
        entity.setTod_descripcion(resultSet.getString("tod_descripcion"));
        entity.setTod_codigo_barra(resultSet.getLong("tod_codigo_barra"));
        entity.setTod_valor_unitario(resultSet.getDouble("tod_valor_unitario"));
        entity.setTod_valor_iva(resultSet.getDouble("tod_valor_iva"));
        entity.setTod_valor_total(resultSet.getDouble("tod_valor_total"));
        entity.setTod_stock(resultSet.getInt("tod_stock"));
        entity.setCd_estado(resultSet.getString("cdestado"));
        entity.setNmid_proveedor(resultSet.getInt("nmid_proveedor"));
        return entity;
    }
}
