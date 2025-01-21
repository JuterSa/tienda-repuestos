CREATE TABLE IF NOT EXISTS  `tod_productos` (
  `nmid` int(11) NOT NULL AUTO_INCREMENT,
  `tod_nombre` varchar(200) NOT NULL,
  `tod_descripcion` varchar(30) NOT NULL,
  `tod_codigo_barra` bigint(22) NOT NULL,
  `tod_valor_unitario` decimal(7,0) DEFAULT 0.0,
  `tod_valor_iva` decimal (3,0) DEFAULT 0.0,
  `tod_valor_total` decimal(6,0) DEFAULT 0.0,
  `tod_stock` int NOT NULL,
  `cdestado` varchar(5) NOT NULL COMMENT 'D para disponible ; A para inactivo',
  `nmid_proveedor` int(11) NOT NULL,
  `dtfechacreacion` timestamp NOT NULL DEFAULT current_timestamp(),
  `dtfechamodificacion` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`nmid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS  `tod_proveedor` (
  `nmid` int(11) NOT NULL AUTO_INCREMENT,
  `tod_p_nombre` varchar(200) NOT NULL,
  `tod_t_documento` varchar(3) NOT NULL COMMENT 'CC para Cedula ciudadania ; CE Cedula extranjera; PA para pasaporte; NIT empresa',
  `tod_n_documento`  BIGINT(22) NOT NULL,
  `tod_n_telefonico`  BIGINT(22) NULL,
  `tod_c_electronico` varchar(50) NOT NULL,
  `tod_direccion` varchar(50) NOT NULL,
  `dtfechacreacion` timestamp NOT NULL DEFAULT current_timestamp(),
  `dtfechamodificacion` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`nmid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS  `tod_usuarios` (
  `nmid` int(11) NOT NULL AUTO_INCREMENT,
  `tod_p_nombre` varchar(200) NOT NULL,
  `tod_t_documento` varchar(3) NOT NULL COMMENT 'CC para Cedula ciudadania',
  `tod_n_documento`  BIGINT(22) NOT NULL,
  `tod_n_telefonico`  BIGINT(22) NULL,
  `tod_c_electronico` varchar(50) NOT NULL,
  `tod_contra_acceso` varchar(50) NOT NULL,
  `tod_direccion` varchar(50) NOT NULL,
  `tod_cajero` varchar(200)  NOT NULL,
  `dtfechacreacion` timestamp NOT NULL DEFAULT current_timestamp(),
  `dtfechamodificacion` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`nmid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS  `tod_clientes` (
  `nmid` int(11) NOT NULL AUTO_INCREMENT,
  `tod_c_nombre` varchar(200) NOT NULL,
  `tod_t_documento` varchar(3) NOT NULL COMMENT 'CC para Cedula ciudadania ; CE Cedula extranjera; PA para pasaporte',
  `tod_n_documento` BIGINT(22) NOT NULL,
  `tod_n_telefonico` BIGINT(22) NOT NULL,
  `tod_sexo` varchar(3) NOT NULL COMMENT 'M para masculino ; F para femenino; O para otros',
  `tod_d_cliente` varchar(200) DEFAULT NULL,
  `tod_estado` varchar(1) NOT NULL COMMENT 'A para Activo ; I para inactivo',
   `dtfechacreacion` timestamp NOT NULL DEFAULT current_timestamp(),
    `dtfechamodificacion` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`nmid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE IF NOT EXISTS  `tod_ventas` (
  `nmid` int(11) NOT NULL AUTO_INCREMENT,
  `nmid_producto` int(11) NOT NULL,
  `tod_cantidad` int(11)  NOT NULL,
  `tod_p_unitario` decimal(8,0) DEFAULT NULL,
  `tod_total_venta` decimal(8,0) DEFAULT NULL,
  `nmid_promocion` int(11) NOT NULL,
  `tod_estado` varchar(3) NOT NULL COMMENT 'P para procesada ; S para sin procesar',
  `dtfechacreacion` timestamp NOT NULL DEFAULT current_timestamp(),
  `dtfechamodificacion` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`nmid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE IF NOT EXISTS  `tod_ventas_clientes` (
    `nmid` int(11) NOT NULL AUTO_INCREMENT,
    `nmid_cliente`  int(11) NULL ,
    `nmid_venta` int(11) NOT NULL,
    `nmid_usuario` int(11) NOT NULL,
     `dtfechacreacion` timestamp NOT NULL DEFAULT current_timestamp(),
      `dtfechamodificacion` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
     PRIMARY KEY (`nmid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE IF NOT EXISTS  `promociones` (
    `nmid` int(11) NOT NULL AUTO_INCREMENT,
    `tod_nombre` varchar(200) NOT NULL,
    `tod_descripcion` varchar(200) NOT NULL,
    `dtfechainicio` timestamp NOT NULL DEFAULT current_timestamp(),
    `dtfechafinal` timestamp NOT NULL DEFAULT current_timestamp(),
    `tipo_promocion` varchar(200) NOT NULL,
    `tod_descuento` decimal(7,0) DEFAULT NULL,
    `tod_estado` varchar(200) NOT NULL,
     `dtfechacreacion` timestamp NOT NULL DEFAULT current_timestamp(),
      `dtfechamodificacion` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
     PRIMARY KEY (`nmid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

ALTER TABLE `tod_productos` ADD CONSTRAINT FK_nmproveedor_proveedor FOREIGN KEY (nmid_proveedor) REFERENCES tod_proveedor (nmid);
ALTER TABLE `tod_ventas` ADD CONSTRAINT FK_nmproducto_producto FOREIGN KEY (nmid_producto) REFERENCES tod_productos (nmid);
ALTER TABLE `tod_ventas_clientes` ADD CONSTRAINT FK_nmcliente_venta FOREIGN KEY (nmid_cliente) REFERENCES tod_clientes (nmid);
ALTER TABLE `tod_ventas_clientes` ADD CONSTRAINT FK_nmventa_venta_cliente FOREIGN KEY (nmid_venta) REFERENCES tod_ventas (nmid);
ALTER TABLE `tod_ventas_clientes` ADD CONSTRAINT FK_nmventa_usuario FOREIGN KEY (nmid_usuario) REFERENCES tod_usuarios (nmid);
ALTER TABLE `tod_ventas` ADD CONSTRAINT FK_nmventa_promocion FOREIGN KEY (nmid_promocion) REFERENCES promociones (nmid);