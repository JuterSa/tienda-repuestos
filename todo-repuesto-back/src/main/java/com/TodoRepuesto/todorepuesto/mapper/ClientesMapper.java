package com.TodoRepuesto.todorepuesto.mapper;

import com.TodoRepuesto.todorepuesto.dto.Clientes;
import com.TodoRepuesto.todorepuesto.util.UtilDate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientesMapper implements RowMapper<Clientes> {
    @Override
    public Clientes mapRow(ResultSet resultSet, int i) throws SQLException {
        //nmid, tod_c_nombre, tod_t_documento, tod_n_documento, tod_n_telefonico, tod_sexo,tod_d_cliente,tod_estado
        Clientes entity = new Clientes();
        entity.setNmid( resultSet.getInt("nmid"));
        entity.setTod_c_nombre(resultSet.getString("tod_c_nombre"));
        entity.setTod_t_documento(resultSet.getString("tod_t_documento"));
        entity.setTod_n_documento(resultSet.getLong("tod_n_documento"));
        entity.setTod_n_telefonico(resultSet.getLong("tod_n_telefonico"));
        entity.setTod_sexo(resultSet.getString("tod_sexo"));
        entity.setTod_d_cliente(resultSet.getString("tod_d_cliente"));
        entity.setTod_estado(resultSet.getString("tod_estado"));
        entity.setDtfechacreacion(UtilDate.getLocalDate(resultSet.getDate("dtfechacreacion")));
        return entity;
    }
}
