INSERT INTO tod_clientes (nmid, tod_c_nombre, tod_t_documento, tod_n_documento, tod_n_telefonico, tod_sexo,tod_d_cliente,tod_estado, dtfechacreacion, dtfechamodificacion) VALUES
(1,'Saul Julio Teran','CC',1003097593,3125069656,'M','Rio en Medio- Broqueles - Moñitos','A',now(),now()),
(2,'Selene Julio Teran','CC',1063721922,3125069656,'F','Rio en Medio- Broqueles - Moñitos','A',now(),now());

INSERT INTO tod_proveedor(nmid,tod_p_nombre, tod_t_documento, tod_n_documento, tod_n_telefonico, tod_c_electronico, tod_direccion, dtfechacreacion, dtfechamodificacion) VALUES
 (1,'Jose Jose Julio','CC',103075689,312506,'Josejose@outlook.com','Kansas City-Los Angeles',now(),now()),
 (2,'Yamaha Automovilistic','NI',6789949643,3125069,'Josejose@outlook.com','Kansas City-Los Angeles',now(),now());

INSERT INTO tod_productos (nmid, tod_nombre, tod_descripcion, tod_codigo_barra, tod_valor_unitario, tod_valor_iva, tod_valor_total, tod_stock, cdestado, nmid_proveedor, dtfechacreacion, dtfechamodificacion)
 VALUES (1,'Farola Discover-100','Farola con 200w de energia', 12345678,50000,19,20000,10,'D',1,now(),now()),
        (2,'Suspension Discover-100','Suspension con doble agarre', 6785489,150000,019,0,10,'D',2,now(),now());

INSERT INTO tod_ventas(nmid, nmid_producto, tod_cantidad, tod_p_unitario, tod_total_venta, nmid_promocion,tod_estado, dtfechacreacion, dtfechamodificacion) VALUES
  (1,1,3,58000,174000,1,'S',now(), now());

INSERT INTO promociones (nmid, tod_nombre, tod_descripcion, dtfechainicio, dtfechafinal, tipo_promocion, tod_descuento, tod_estado, dtfechacreacion, dtfechamodificacion ) VALUES
(1, 'Oferta especial de navidad','No se', now(), now(), 'Normal', 3000, 'D', now(), now());

INSERT INTO tod_usuarios(nmid,tod_p_nombre, tod_t_documento, tod_n_documento, tod_n_telefonico, tod_c_electronico,tod_contra_acceso, tod_direccion, tod_cajero, dtfechacreacion, dtfechamodificacion) VALUES
   (1,'Saul Julio Teran','CC',103075689,3125069657,'Sajute99@outlook.com','Viviana2003','Kansas City- Los Angeles','Vendedor 1', now(),now()),
   (2,'Juter Sa','CC',6789949643,3125069657,'Josejose@outlook.com','Viviana2003','Kansas City- Los Angeles','Vendedor 2', now(),now());

INSERT INTO tod_ventas_clientes (nmid, nmid_cliente, nmid_venta, nmid_usuario, dtfechacreacion, dtfechamodificacion) VALUES
 (1, 2, 1, 2, now(), now());