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
public class Clientes implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private int nmid;
    //@Size(max = 10,message = MessagesConstants.MAX_VALIDATION_FIELD+" (10)")
    private String tod_c_nombre;

    private String tod_t_documento;
    private Long tod_n_documento ;
   // @Size(max = 150,message = MessagesConstants.MAX_VALIDATION_FIELD+" (150)")
    private Long tod_n_telefonico;
    //@Size(max = 150,message = MessagesConstants.MAX_VALIDATION_FIELD+" (150)")
    private String dsciudad;
    @Size(max = 3,message = MessagesConstants.MAX_VALIDATION_FIELD+" (3)")
    private String tod_sexo;
    @Size(max = 3,message = MessagesConstants.MAX_VALIDATION_FIELD+" (3)")
    private String tod_estado;
    private String tod_d_cliente;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dtfechacreacion;

    @JsonIgnore
    public void setClientesFromRs(ResultSet rs) throws SQLException {
        nmid = rs.getInt("nmid");
        tod_c_nombre= rs.getString("tod_c_nombre");
        tod_t_documento = rs.getString("tod_t_documento");
        tod_n_documento = rs.getLong("tod_n_documento");
        tod_n_telefonico = rs.getLong("tod_n_telefonico");
        tod_sexo = rs.getString("tod_sexo");
        tod_d_cliente = rs.getString("tod_d_cliente ");
        tod_estado = rs.getString("tod_estado");
        //dtfechacreacion = UtilDate.getLocalDate(rs.getDate("dtfechacreacion"));
    }
    //nmid, tod_c_nombre, tod_t_documento, tod_n_documento, tod_n_telefonico, tod_sexo,tod_d_cliente,tod_estado
}
