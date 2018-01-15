CREATE SCHEMA IF NOT EXISTS `SARES` DEFAULT CHARACTER SET utf8 ;
USE `SARES` ;

CREATE TABLE IF NOT EXISTS `SARES`.`Usuarios` (
	`idUsuario` INT(10) NOT NULL AUTO_INCREMENT,
    `usuario` varchar(25) NOT NULL,
    `password` varbinary(15) not null,
    `cargo` varchar(25) not null,
    `nombre` varchar(25) not null,
    `sueldo` double,
    `apellido` varchar(25),
    `edad` int(10),
    primary key(`idUsuario`));
    
CREATE TABLE IF NOT EXISTS `SARES`.`Categorias` (
	`idCategoria` INT(10) NOT NULL auto_increment,
    `nombre` varchar(25) not null,
    primary key(`idCategoria`));
    
CREATE TABLE IF NOT EXISTS `SARES`.`Plato` (
	`idPlato` INT(10) NOT NULL AUTO_INCREMENT,
    `nombre` varchar(25) not null,
    `Precio` Double not null,
    `idCategoria` INT(10) not null,
    `tiempoEstimado`time,
    `cantidad` int(10),
    primary key(`idPlato`),
    index(`idCategoria`),
    FOREIGN KEY(`idCategoria`) REFERENCES `Categorias`(idCategoria)  );
    
CREATE TABLE IF NOT EXISTS `SARES`.`BEBIDAS` (
	`idBebida` INT(10) NOT NULL auto_increment,
    `nombre` varchar(25) not null,
    `precio` double not null,
    `litros` double not null,
    `cantidad` int(10),
    `idCategoria` int(10) not null,
    PRIMARY KEY(`idBebida`),
    index(`idCategoria`),
    FOREIGN KEY(`idCategoria`) REFERENCES `Categorias`(idCategoria)  );
    
CREATE TABLE IF NOT EXISTS `SARES`.`Pedido` (
	`idPedido` int(10) NOT NULL auto_increment,
    `horaIngreso` datetime,
    `tiempoEstimado` time,
    `estado` varchar(25),
    `observaciones` varchar(50),
    PRIMARY KEY(`idPedido`));
    
CREATE TABLE IF NOT EXISTS `SARES`.`Mesa` (
	`idMesa` INT(10) NOT NULL auto_increment,
    `tratoEspecial` bool,
    `cantSillas` int(10),
    `ambiente` varchar(25) not null,
    primary key(`idMesa`));
    
CREATE TABLE IF NOT EXISTS `SARES`.`Combos` (
	`idCombo` INT(10) NOT NULL auto_increment,
    `nombre` varchar(25) not null,
    `tiempoEstimado` time,
    PRIMARY KEY(`idCombo`));
    
CREATE TABLE IF NOT EXISTS `SARES`.`CombosPlato`(
	`idCombo` INT(10) NOT NULL auto_increment,
    `idPlato` INT(10) not null,
    index(`idCombo`,`idPlato`),
    foreign key(`idCombo`) references `Combos`(`idCombo`),
    foreign key(`idPlato`) references `Plato`(`idPlato`));
    
CREATE TABLE IF NOT EXISTS `SARES`.`CombosBebidas`(
	`idCombo` INT(10) NOT NULL auto_increment,
    `idBebida` int(10) not null,
    index(`idCombo`,`idBebida`),
    foreign key(`idCombo`) references `Combos`(`idCombo`),
    foreign key(`idBebida`) references `Bebidas`(`idBebida`));
    
CREATE TABLE IF NOT EXISTS `SARES`.`Cuentas` (
	`idCuenta` int(10) not null auto_increment,
    `tratoEspecial` bool,
    primary key(`idCuenta`));
    
CREATE TABLE IF NOT EXISTS `SARES`.`Ingredientes` (
	`idIngrediente` int(10) not null auto_increment,
    `nombre` varchar(25) not null,
    `cantidad` int(10) not null,
    primary key(`idIngrediente`));
    
CREATE TABLE IF NOT EXISTS `SARES`.`PlatosIngredientes` (
	`idPlato` int(10) not null,
    `idIngrediente` int(10) not null,
    index(`idPlato`,`idIngrediente`),
    foreign key(`idPlato`) references `plato`(`idPlato`),
    foreign key(`idIngrediente`) references `ingredientes`(`idIngrediente`));
    
CREATE TABLE IF NOT EXISTS `SARES`.`Cliente` (
	`idCliente` int(10) not null auto_increment,
    `nombre` varchar(25) not null,
    `apellido` varchar(25) not null,
    `edad` int(8) not null,
    primary key(`idCliente`));

CREATE TABLE IF NOT EXISTS `SARES`.`MesaCuenta` (
	`idCuenta` int(10) not null,
    `idMesa` int(10) not null,
    index(`idCuenta`,`idMesa`),
    foreign key(`idCuenta`) references `cuentas`(`idCuenta`),
    foreign key(`idMesa`) references `mesa`(`idMesa`));
    
CREATE TABLE IF NOT EXISTS `SARES`.`CuentaPedido` (
	`idCuenta` int(10) not null,
    `idPedido` int(10) not null,
    index(`idCuenta`,`idPedido`),
    foreign key(`idCuenta`) references `cuentas`(`idCuenta`),
    foreign key(`idPedido`) references `pedido`(`idPedido`));
    
CREATE TABLE IF NOT EXISTS `SARES`.`ClienteCuenta` (
	`idCliente` int(10) not null,
    `idCuenta` int(10) not null,
    `descuento` int(8) not null,
    `tipopago` varchar(25) not null,
    `fechaCuenta` datetime not null,
    index(`idCliente`,`idCuenta`),
    foreign key(`idCuenta`) references `cuentas`(`idCuenta`),
    foreign key(`idCliente`) references `cliente`(`idCliente`));
    
CREATE TABLE IF NOT EXISTS `SARES`.`MeseroPedido` (
	`idUsuario` INT(10) NOT NULL,
    `idPedido` INT(10) NOT NULL,
    index(`idUsuario`,`idPedido`),
    foreign key(`idUsuario`) references `usuarios`(`idUsuario`),
    foreign key(`idPedido`) references `pedido`(`idPedido`));
    
CREATE TABLE IF NOT EXISTS `SARES`.`CocineroPedido` (
	`idUsuario` Int(10) not null,
    `idPedido` int(10) not null,
    index(`idUsuario`,`idPedido`),
    foreign key(`idUsuario`) references `usuarios`(`idUsuario`),
    foreign key(`idPedido`) references `pedido`(`idPedido`));
    
CREATE TABLE IF NOT EXISTS `SARES`.`CajeroPedido` (
	`idUsuario` Int(10) not null,
    `idPedido` int(10) not null,
    index(`idUsuario`,`idPedido`),
    foreign key(`idUsuario`) references `usuarios`(`idUsuario`),
    foreign key(`idPedido`) references `pedido`(`idPedido`));
