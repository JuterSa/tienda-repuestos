package com.TodoRepuesto.todorepuesto.dao;

import com.TodoRepuesto.todorepuesto.dto.Productos;
import com.TodoRepuesto.todorepuesto.mapper.ClientesMapper;
import com.TodoRepuesto.todorepuesto.mapper.ProductosMapper;
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
public class ProductosDAOImpl implements ProductosDAO {
    private static final String INSERT ="INSERT INTO tod_productos (tod_nombre, tod_descripcion, tod_codigo_barra, tod_valor_unitario, tod_valor_iva, tod_valor_total, tod_stock, cdestado, nmid_proveedor, dtfechacreacion) VALUES (?,?,?,?,?,?,?,?,?,NOW())";
    private static final String UPDATE ="UPDATE tod_productos SET tod_nombre =?, tod_descripcion =?, tod_codigo_barra =?, tod_valor_unitario=?, tod_valor_iva =?, tod_valor_total =?,tod_stock =?, cdestado = ? WHERE nmid = ?";
    private static final String SELECT ="SELECT *FROM tod_productos";
    private static final String SELECTBYID = SELECT + " WHERE nmid = ?";

    private static final String DELETE = "DELETE FROM tod_productos WHERE nmid = ?";
    JdbcTemplate jdbcTemplate;


    public ProductosDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);

    }

    @Override
    public List<Productos> getAll() { return jdbcTemplate.query(SELECT, new ProductosMapper());}

    @Override
    public Productos getById(int nmid){
        try{
            return jdbcTemplate.queryForObject(SELECTBYID, new ProductosMapper(),nmid);
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public Productos insert(Productos entity){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT, new String[]{"nmdato"});
            DaoUtil.setPrepareStatement(ps, new Object[]{
                    entity.getTod_nombre(),
                    entity.getTod_descripcion(),
                    entity.getTod_codigo_barra(),
                    entity.getTod_valor_unitario(),
                    entity.getTod_valor_iva(),
                    entity.getTod_valor_total(),
                    entity.getTod_stock(),
                    entity.getCd_estado(),
                    entity.getNmid_proveedor()
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
    public Productos update(Productos entity){
        jdbcTemplate.update(UPDATE,
                entity.getTod_nombre(),
                entity.getTod_descripcion(),
                entity.getTod_codigo_barra(),
                entity.getTod_valor_unitario(),
                entity.getTod_valor_iva(),
                entity.getTod_valor_total(),
                entity.getTod_stock(),
                entity.getCd_estado(),
                entity.getNmid());
        return entity;
    }
}
