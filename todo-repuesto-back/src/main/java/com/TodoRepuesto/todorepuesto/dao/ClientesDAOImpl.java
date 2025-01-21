package com.TodoRepuesto.todorepuesto.dao;

import com.TodoRepuesto.todorepuesto.dto.Clientes;
import com.TodoRepuesto.todorepuesto.mapper.ClientesMapper;
import com.TodoRepuesto.todorepuesto.util.DaoUtil;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;

@Repository
public class ClientesDAOImpl implements ClientesDAO {
    private static final String INSERT ="INSERT INTO tod_clientes (tod_c_nombre, tod_t_documento, tod_n_documento, tod_n_telefonico, tod_sexo,tod_d_cliente,tod_estado, dtfechacreacion) VALUES (?,?,?,?,?,?,?, NOW())";
    private static final String UPDATE ="UPDATE tod_clientes SET tod_c_nombre =?, tod_t_documento =?, tod_n_documento =?, tod_n_telefonico=?, tod_sexo =?,tod_d_cliente =?,tod_estado =? WHERE nmid = ?";
    private static final String SELECT ="SELECT *FROM tod_clientes";
    private static final String SELECTBYID = SELECT + " WHERE nmid = ?";

    private static final String DELETE = "DELETE FROM tod_clientes WHERE nmid = ?";
    JdbcTemplate jdbcTemplate;


    public ClientesDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);

    }

    @Override
    public List<Clientes> getAll() { return jdbcTemplate.query(SELECT, new ClientesMapper());}

    @Override
    public Clientes getById(int nmid){
        try{
            return jdbcTemplate.queryForObject(SELECTBYID, new ClientesMapper(),nmid);
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public Clientes insert(Clientes entity){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT, new String[]{"nmdato"});
            DaoUtil.setPrepareStatement(ps, new Object[]{
                    entity.getTod_c_nombre(),
                    entity.getTod_t_documento(),
                    entity.getTod_n_documento(),
                    entity.getTod_n_telefonico(),
                    entity.getTod_sexo(),
                    entity.getTod_d_cliente(),
                    entity.getTod_estado()
            });

            return ps;
        }, keyHolder);
        entity.setNmid(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return entity;
    }
    @Override
    public Boolean delete(int nmid) {
        return jdbcTemplate.update(DELETE,
                nmid
        )>0;
    }

    @Override
    public Clientes update(Clientes entity){
        jdbcTemplate.update(UPDATE,
                entity.getTod_c_nombre(),
                entity.getTod_t_documento(),
                entity.getTod_n_documento(),
                entity.getTod_n_telefonico(),
                entity.getTod_sexo(),
                entity.getTod_d_cliente(),
                entity.getTod_estado(),
                entity.getNmid());
        return entity;
    }



}

/** `tod_pago` varchar(3) NOT NULL COMMENT 'E para efectivo ; T para transaccion',
 `tod_estado` varchar(3) NOT NULL COMMENT 'P para procesada ; S para sin procesar' **/
