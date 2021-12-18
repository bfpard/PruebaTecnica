CREATE SCHEMA `tienda3` DEFAULT CHARACTER SET utf8 ;
CREATE TABLE `tienda3`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `cedula` VARCHAR(255) NULL,
  `fullname` VARCHAR(255) NULL,
  `userlogin` VARCHAR(255) NULL,
  `password` VARCHAR(255) NULL,
  `dinero_actual` VARCHAR(255) NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `userlogin_UNIQUE` (`userlogin` ASC) VISIBLE,
  UNIQUE INDEX `cedula_UNIQUE` (`cedula` ASC) VISIBLE);
  CREATE TABLE `tienda3`.`rol` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rol_nombre` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `rol_nombre_UNIQUE` (`rol_nombre` ASC) VISIBLE);
  CREATE TABLE `tienda3`.`usuario_rol` (
  `usuario_id` INT NOT NULL,
  `rol_id` INT NOT NULL,
  PRIMARY KEY (`usuario_id`, `rol_id`),
  INDEX `roli_idx` (`rol_id` ASC) VISIBLE,
  CONSTRAINT `roli`
    FOREIGN KEY (`rol_id`)
    REFERENCES `tienda3`.`rol` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `userlo`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `tienda3`.`usuario` (`id_usuario`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);
    
    INSERT INTO `tienda3`.`rol` (`id`, `rol_nombre`) VALUES ('1', 'ROLE_ADMIN');
	INSERT INTO `tienda3`.`rol` (`id`, `rol_nombre`) VALUES ('2', 'ROLE_USER');

    INSERT INTO `tienda3`.`usuario` (`id_usuario`, `cedula`, `fullname`, `userlogin`, `password`, `dinero_actual`) VALUES ('1', '147', 'admin inicial', 'admin', '$2a$10$4HYKtZGkJJb6Nfl88yShkuL3srf5ps6x.4cA61DtK6lH9.NKMkX86', '0');
	INSERT INTO `tienda3`.`usuario` (`id_usuario`, `cedula`, `fullname`, `userlogin`, `password`, `dinero_actual`) VALUES ('2', '258', 'Felipe Pardo', 'bfpardo', '$10$XykzPG9ZHjUT1lx4msXrk.HPJoecapLsaCNln3ZXJNwatWjOt.mjG', '5300000');
	INSERT INTO `tienda3`.`usuario` (`id_usuario`, `cedula`, `fullname`, `userlogin`, `password`, `dinero_actual`) VALUES ('3', '369', 'Angy Parra', 'amparra', '$10$XykzPG9ZHjUT1lx4msXrk.HPJoecapLsaCNln3ZXJNwatWjOt.mjG', '1200000');
	INSERT INTO `tienda3`.`usuario` (`id_usuario`, `cedula`, `fullname`, `userlogin`, `password`, `dinero_actual`) VALUES ('4', '789', 'Natalia Perez', 'naperez', '$10$XykzPG9ZHjUT1lx4msXrk.HPJoecapLsaCNln3ZXJNwatWjOt.mjG', '900000');
    
    INSERT INTO `tienda3`.`usuario_rol` (`usuario_id`, `rol_id`) VALUES ('1', '1');
	INSERT INTO `tienda3`.`usuario_rol` (`usuario_id`, `rol_id`) VALUES ('1', '2');
	INSERT INTO `tienda3`.`usuario_rol` (`usuario_id`, `rol_id`) VALUES ('2', '2');
	INSERT INTO `tienda3`.`usuario_rol` (`usuario_id`, `rol_id`) VALUES ('3', '2');
	INSERT INTO `tienda3`.`usuario_rol` (`usuario_id`, `rol_id`) VALUES ('4', '2');
    CREATE TABLE `tienda3`.`producto` (
  `id_producto` INT NOT NULL AUTO_INCREMENT,
  `carrito` VARCHAR(255) NULL,
  `fecha_expiracion` VARCHAR(255) NULL,
  `fecha_publicacion` VARCHAR(255) NULL,
  `nombre_producto` VARCHAR(255) NULL,
  `precio` VARCHAR(255) NULL,
  PRIMARY KEY (`id_producto`));
  INSERT INTO `tienda3`.`producto` (`id_producto`, `carrito`, `fecha_expiracion`, `fecha_publicacion`, `nombre_producto`, `precio`) VALUES ('1', 'off', '18/12/2023', '18/12/2021', 'Computador ASUS', '3500000');
	INSERT INTO `tienda3`.`producto` (`id_producto`, `carrito`, `fecha_expiracion`, `fecha_publicacion`, `nombre_producto`, `precio`) VALUES ('2', 'off', '18/12/2023', '18/12/2021', 'Celular Nokia', '1200000');
	INSERT INTO `tienda3`.`producto` (`id_producto`, `carrito`, `fecha_expiracion`, `fecha_publicacion`, `nombre_producto`, `precio`) VALUES ('3', 'off', '18/12/2023', '18/12/2021', 'Mouse Logitech', '240000');
	INSERT INTO `tienda3`.`producto` (`id_producto`, `carrito`, `fecha_expiracion`, `fecha_publicacion`, `nombre_producto`, `precio`) VALUES ('4', 'off', '18/12/2023', '18/12/2021', 'Teclado Logitech', '120000');
	INSERT INTO `tienda3`.`producto` (`id_producto`, `carrito`, `fecha_expiracion`, `fecha_publicacion`, `nombre_producto`, `precio`) VALUES ('5', 'off', '18/12/2023', '18/12/2021', 'Camara SONY', '1700000');
	INSERT INTO `tienda3`.`producto` (`id_producto`, `carrito`, `fecha_expiracion`, `fecha_publicacion`, `nombre_producto`, `precio`) VALUES ('6', 'off', '18/12/2023', '18/12/2021', 'Disco Duro SSD 512GB', '450000');
	UPDATE `tienda3`.`usuario` SET `password` = '$2a$10$XykzPG9ZHjUT1lx4msXrk.HPJoecapLsaCNln3ZXJNwatWjOt.mjG' WHERE (`id_usuario` = '2');
	UPDATE `tienda3`.`usuario` SET `password` = '$2a$10$FZ.XGZcJXiiH.gWOi.4zGObruIibSOM2NBbeHYUZ3nxdNcT5GGr/K' WHERE (`id_usuario` = '3');
	UPDATE `tienda3`.`usuario` SET `password` = '$2a$10$/10GkGkFfdy3YO2V9uTlzu07peJxaSCgxBBev6AyGThwEuqqbgnGK' WHERE (`id_usuario` = '4');
    