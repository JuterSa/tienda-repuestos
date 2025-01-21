package com.TodoRepuesto.todorepuesto.dao;

import com.TodoRepuesto.todorepuesto.dto.Productos;

import java.util.List;

public interface ProductosDAO {
    List<Productos> getAll();

    Productos getById(int nmid);

    Productos insert(Productos entity);

    Productos update(Productos entity);
    Boolean delete(int nmid);
}
