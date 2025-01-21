package com.TodoRepuesto.todorepuesto.dto;

import com.TodoRepuesto.todorepuesto.util.MessagesConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Data
public class Productos implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int nmid;

    private String tod_nombre;

    private String tod_descripcion;

    private Long tod_codigo_barra;

    private double tod_valor_unitario;

    private double tod_valor_iva;

    private double tod_valor_total;

    private int tod_stock;

    @Size(max = 3,message = MessagesConstants.MAX_VALIDATION_FIELD+" (3)")
    private String cd_estado;

    private int nmid_proveedor;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dtfechacreacion;

    @JsonIgnore
    public void setProductosFromRs(ResultSet rs) throws SQLException {
        nmid = rs.getInt("nmid");
        tod_nombre= rs.getString("tod_nombre");
        tod_descripcion = rs.getString("tod_descripcion");
        tod_codigo_barra = rs.getLong("tod_codigo_barra");
        tod_valor_unitario = rs.getDouble("tod_valor_unitario");
        tod_valor_iva = rs.getDouble("tod_valor_iva");
        tod_valor_total = rs.getDouble("tod_valor_total");
        tod_stock = rs.getInt("tod_stock");
        //dtfechacreacion = UtilDate.getLocalDate(rs.getDate("dtfechacreacion"));
    }

}
