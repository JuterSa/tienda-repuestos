package com.TodoRepuesto.todorepuesto.services;

import com.TodoRepuesto.todorepuesto.dao.ClientesDAO;
import com.TodoRepuesto.todorepuesto.dto.Clientes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ClientesServiceImpl implements ClientesService {
    private final Logger log = LoggerFactory.getLogger(ClientesServiceImpl.class);

    private final ClientesDAO clienteDao;

    public ClientesServiceImpl(ClientesDAO clienteDao) {
        this.clienteDao = clienteDao;
    }

    public Clientes save(Clientes tod_clientes) {
        log.debug("Request to insert raf_bitacora: {}", tod_clientes);
        return clienteDao.insert(tod_clientes);
    }

    public Clientes update(Clientes tod_clientes) {
        log.debug("Request to get all raf_bitacora : {}", tod_clientes);
        return clienteDao.update(tod_clientes);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Clientes> findAll() {
        log.debug("Request to get all raf_cliente");
        return clienteDao.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Clientes findOne(int nmid) {
        log.debug("Request to get raf_cliente : {}", nmid);
        return clienteDao.getById(nmid);
    }
    @Override
    public void delete(int nmid) {
        log.debug("Request to delete raf_cliente : {}", nmid);
        clienteDao.delete(nmid);
    }
}
