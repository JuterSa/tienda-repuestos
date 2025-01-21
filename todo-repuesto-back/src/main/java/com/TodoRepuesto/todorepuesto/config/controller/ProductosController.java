package com.TodoRepuesto.todorepuesto.config.controller;

import com.TodoRepuesto.todorepuesto.config.controller.errors.ApplicationCustomException;
import com.TodoRepuesto.todorepuesto.dto.Clientes;
import com.TodoRepuesto.todorepuesto.dto.Productos;
import com.TodoRepuesto.todorepuesto.services.ClientesService;
import com.TodoRepuesto.todorepuesto.services.ProductosService;
import com.TodoRepuesto.todorepuesto.util.MessagesConstants;
import com.TodoRepuesto.todorepuesto.util.ResponseMessage;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductosController {
    private final Logger log = LoggerFactory.getLogger(ProductosController.class);

    private static final String ENITY_NAME = "tod_productos";


    private final ProductosService productosService;
    //private final Servicios clienteServices;

    public ProductosController(ProductosService productosService) {
        this.productosService = productosService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/productos")
    public ResponseEntity<ResponseMessage<List<Productos>>> getAllProductos(){
        log.debug("REST para obtener todos los productos");
        System.out.println("Obteniendo productos");

        return ResponseEntity.ok( new ResponseMessage<>(0,null, productosService.findAll()));
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/productos")
    public ResponseEntity<ResponseMessage<Productos>> createClientes(@Valid @RequestBody Productos productos) throws ApplicationCustomException {
        log.debug("REST request to save productos : {}", productos);
        Productos productosFind = productosService.findOne(productos.getNmid());
        if(productosFind != null){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, ENITY_NAME));
        }
        Productos result = productosService.save(productos); //2
        System.out.println(result);
        return ResponseEntity.ok( new ResponseMessage<>(0,"Producto agregado con exito", result));

    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/productos")
    public ResponseEntity<ResponseMessage<Productos>> updateClientes(@Valid @RequestBody Productos productos) throws ApplicationCustomException {
        log.debug("REST request to save productos : {}", productos);
        Productos productosFind = productosService.findOne(productos.getNmid());
        if(productosFind.getNmid() == 0){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, ENITY_NAME));
        }
        Productos result = productosService.update(productos); //2
        System.out.println(result);
        System.out.println("Estado: " + ResponseEntity.ok().toString());
        return ResponseEntity.ok( new ResponseMessage<>(0,"Producto actualizado con exito", result));

    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/productos/{nmid}")
    public ResponseEntity<ResponseMessage<Productos>> delete(@PathVariable int nmid) {
        log.debug("REST request to delete clientes : {}", nmid);
        productosService.delete(nmid);
        return ResponseEntity.ok(new ResponseMessage<>(0, "Producto eliminado con exito", null) );
    }
}
