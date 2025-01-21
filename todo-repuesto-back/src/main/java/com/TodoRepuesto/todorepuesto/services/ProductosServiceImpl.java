package com.TodoRepuesto.todorepuesto.services;

import com.TodoRepuesto.todorepuesto.dao.ClientesDAO;
import com.TodoRepuesto.todorepuesto.dao.ProductosDAO;
import com.TodoRepuesto.todorepuesto.dto.Clientes;
import com.TodoRepuesto.todorepuesto.dto.Productos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductosServiceImpl implements ProductosService {

    private final Logger log = LoggerFactory.getLogger(ProductosServiceImpl.class);

    private final ProductosDAO productosDAO;

    public ProductosServiceImpl(ProductosDAO productosDAO) {
        this.productosDAO = productosDAO;
    }

    public Productos save(Productos tod_productos) {
        log.debug("Peticion para guardar un producto", tod_productos);
        return productosDAO.insert(tod_productos);
    }

    public Productos update(Productos tod_productos) {
        log.debug("Request to get all tod_productos : {}", tod_productos);
        return productosDAO.update(tod_productos);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Productos> findAll() {
        log.debug("Request to get all productos");
        return productosDAO.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Productos findOne(int nmid) {
        log.debug("Request to get producto : {}", nmid);
        return productosDAO.getById(nmid);
    }
    @Override
    public void delete(int nmid) {
        log.debug("Request to delete producto : {}", nmid);
        productosDAO.delete(nmid);
    }
}
