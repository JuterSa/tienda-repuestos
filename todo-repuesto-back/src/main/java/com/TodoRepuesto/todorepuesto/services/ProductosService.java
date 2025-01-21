package com.TodoRepuesto.todorepuesto.services;

import com.TodoRepuesto.todorepuesto.dto.Clientes;
import com.TodoRepuesto.todorepuesto.dto.Productos;

import java.util.List;

public interface ProductosService {
    Productos save(Productos application); //1

    Productos update(Productos application);

    List<Productos> findAll();

    Productos findOne(int nmid);

    void delete(int nmid);
}
