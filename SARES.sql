drop database if exists SARES;

create database if not exists SARES;

use SARES;

CREATE TABLE Usuario(
	usuario varchar(50) not null,
    clave varchar(50) not null,
    primary key (usuario),
    eliminado boolean not null
);

CREATE TABLE Rol(
	idRol int not null auto_increment,
    nombreRol varchar(50) not null,
    eliminado boolean not null,
    primary key (idRol)
);

CREATE TABLE Empleado(
	cedula varchar(10) not null,
    nombres varchar(255) not null,
    apellidos varchar(255) not null,
    edad int not null,
    sueldo float not null,
    idRol int not null auto_increment,
    usuario varchar(50) not null,
    eliminado boolean not null,
    primary key (cedula),
    foreign key (usuario) references Usuario(usuario),
    foreign key (idRol) references Rol(idRol)
);

CREATE TABLE Environments(
	idENvi int not null auto_increment,
    nombre varchar(255) not null,
    eliminado boolean not null,
    primary key (idEnvi)
);

CREATE TABLE Mesa(
	idMesa int not null auto_increment,
    asientos int not null,
    disponibilidad boolean not null,
    idEnvi int not null,
    eliminado boolean not null,
    Primary Key (idMesa),
    foreign key (idEnvi) references Environments(idEnvi)
);

CREATE TABLE Cliente (
	ced varchar(10) not null,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Direccion varchar(255),
    eliminado boolean not null,
    PRIMARY KEY (ced)
);

CREATE TABLE Categoria_Item(
	ID int NOT NULL,
    Nombre VARCHAR(255),
    Descripcion VARCHAR(255),
    
    PRIMARY KEY(ID)
);

CREATE TABLE Item(

	ID int NOT NULL,
    Nombre VARCHAR(255),
    Descripcion VARCHAR(255),
    
    Precio DOUBLE not null,
    Disponibilidad boolean not null,
	TiempoPreparacion int not null,
    IdCategoria int not null,
    eliminado boolean not null,
    
    PRIMARY KEY (ID),
    FOREIGN KEY (IdCategoria) references Categoria_Item(ID)
);

CREATE TABLE Orden (
	id int not null auto_increment,
    pagado boolean not null,
    enPreparacion boolean not null,
    cocinado boolean not null,
    entregado boolean not null,
    idCliente varchar(10) not null,
    idMesero varchar(10) not null,
    idChef varchar(10) not null,
    
    PRIMARY KEY (id),
    FOREIGN KEY (idCliente) REFERENCES Cliente(ced),
    FOREIGN KEY (idMesero) REFERENCES Empleado(cedula),
    FOREIGN KEY (idChef) REFERENCES Empleado(cedula)
);

CREATE TABLE Detalle_Orden(

	ID_detalle int NOT NULL auto_increment,
    ID_Orden int NOT NULL,
    ID_Item int NOT NULL,
    cantidad int,
    Observaciones varchar(255),
    
    
    PRIMARY KEY (ID_detalle),
    FOREIGN KEY (ID_Orden) references Orden(id),
    foreign key (ID_Item) references Item(ID)
);

CREATE TABLE MesaOrden(
	id int not null auto_increment,
    idMesa int not null,
    idOrden int not null,
    fecha Date,
    hora time,
    
    primary key (id),
    foreign key (idMesa) references Mesa(idMesa),
    foreign key (idOrden) references Orden(id)
);

CREATE TABLE TipoDePago(
	ID int,
    Tipo varchar(30),
    
    PRIMARY KEY (ID)
);

CREATE TABLE Factura (
    ID int NOT NULL auto_increment,
    TOTAL double,
    Fecha DATE,
    Id_cliente varchar(10) not null,
    Descuento int,
    TipoDePago int,
    
    PRIMARY KEY (ID),
    FOREIGN KEY (Id_cliente) REFERENCES Cliente(ced),
    FOREIGN KEY (TipoDePago) REFERENCES TipoDePago(ID)
);

CREATE TABLE Detalle_Factura(
	id_detalle int,
    id_factura int,
    id_orden int,
    PRIMARY KEY (id_detalle),
    FOREIGN KEY (id_factura) REFERENCES Factura(ID),
    FOREIGN KEY (id_orden) REFERENCES Orden(ID)
);
delimiter $$

create procedure buscarUsuario(in cadena varchar(255))
begin
	select *
    from Usuario
    where usuario = cadena;
end$$

create procedure verificarUsuarioContrasena(in inUsuario varchar(255), in inContrasena varchar(255))
begin
	select *
    from Usuario
    where usuario = inUsuario and clave = inContrasena;
end$$

create procedure ObtenerEmpleadoPorUsuario(in cadena varchar(255))
begin
	select *
    from Empleado
    where usuario = cadena;
end$$

delimiter ;
INSERT INTO Rol (idRol, nombreRol, eliminado) 
VALUES 	(1, 'Administrador', 0), 
		(2, 'Cocinero', 0), 
		(3, 'Mesero', 0), 
        (4, 'Repartidor', 0), 
        (5, 'Cajero', 0);


INSERT INTO Categoria_Item (ID, Nombre) 
VALUES	(1, 'Entrada'), 
		(2, 'Segundo'), 
        (3, 'Postre'), 
        (4, 'Refresco'), 
        (5, 'Natural'),
        (6, 'Artificial');

INSERT INTO TipoDePago (ID, Tipo) 
VALUES 	(1, 'Efectivo'),  
		(2, 'Tarjeta de Credito'), 
        (3, 'Dinero Electronico');

INSERT INTO Environments (idEnvi, nombre, eliminado) 
VALUES 	(1, 'Normal', 0), 
		(2, 'VIP', 0);

INSERT INTO Mesa (idMesa, asientos, disponibilidad, idEnvi, eliminado) 
VALUES 	(1, 2, 1, 1, 0), 
		(2, 2, 1, 1, 0), 
		(3, 2, 1, 2, 0), 
        (4, 4, 1, 1, 0), 
        (5, 4, 1, 2, 0), 
        (6, 6, 1, 1, 0), 
        (7, 8, 1, 1, 0);

INSERT INTO Usuario (usuario, clave,eliminado)
VALUES 	('admin', 'superclave',0), 
		('cajero', '1234',0), 
        ('repartidor', '0987',0), 
        ('mesero_1', 'sssd123',0),
        ('mesero_2', '739873',0),
        ('chef', '125',0);

INSERT INTO Empleado (cedula, nombres, apellidos, edad, sueldo, idRol, usuario, eliminado) 
VALUES 	('0900000000', 'Luis', 'Arizaga', 23, 500, 1, 'admin', 0),
		('0921234567', 'Carlos Andres', 'Garcia Zambrano', 25, 350, 2, 'elcocinero', 0),
        ('0987654321', 'Alberto Luis', 'Andrade Li', 75, 300, 4, 'elrepartidor', 0), 
        ('0912873456', 'Estefany karen', 'Falconi Seto', 27, 300, 3, 'elmesero1', 0),
        ('0981237645', 'Jose Jose', 'Primero Segundo', 19, 300, 3, 'elmesero2', 0),
        ('0987612345', 'Leonardo', 'Velez', 23, 325, 5, 'elcajero', 0);

INSERT INTO Item (ID, Nombre, Descripcion, Precio, Disponibilidad, TiempoPreparacion, IdCategoria, eliminado) 
VALUES 	(1, 'limonada', 'jarra de limonada ', 4, 1, 3, 5, 0),
		(2, 'Jugo de Durazno', 'Jugo Artificial', 1, 1, 0, 6, 0),
		(3, 'Patacones', 'patacones con queso', 2, 1, 4, 1, 0),
        (4, 'seco de pollo', 'seco de pollo', 4, 1, 10, 2, 0),
        (5, 'Arroz marinero', 'arroz marinero', 7, 1, 13, 2, 0),
        (6, 'tres leches', 'tres leches', 3, 1, 4, 3, 0);
delimiter $$

create procedure ObtenerEmpleadoPorUsuario(in cadena varchar(255))
begin
	select *
    from Empleado
    where usuario = cadena;
end$$

create procedure verificarUsuarioContrasena(in inUsuario varchar(255), in inContrasena varchar(255))
begin
	select *
    from Usuario
    where usuario = inUsuario and clave = inContrasena;
end$$



create procedure AgregarUsuario(in usuario varchar(255), IN contraseña VARCHAR(255))
begin
	INSERT INTO Usuario (usuario, clave, eliminado)
	VALUES 	(usuario, contraseña, 0);
end$$

create procedure EliminarUsuario(in usuario varchar(255))
begin
	update Usuario
	set eliminado=1
    where Usuario.usuario = usuario;
end$$

create procedure CambiarContraseña(in usuario varchar(255), IN contraseña VARCHAR(255))
begin
	update Usuario 
	set clave=contraseña
	where Usuario.clave = contraseña; 
end$$

create procedure CambiarUsuario(in usuario varchar(255), IN nuevo VARCHAR(255))
begin
	update Usuario 
	set Usuario.usuario = nuevo
	where Usuario.usuario = usuario; 
end$$

create procedure AgregarAmbiente(in Nombre varchar(255))
begin
	INSERT INTO Environments (nombre, eliminado)
	VALUES 	(Nombre, 0);
end$$

create procedure EliminarAmbiente(in id INT)
begin
	update Environments
	set eliminado=1
    where Environments.idEnvi = id;
end$$

create procedure ActualizarAmbiente(in Nombre varchar(255), in nuevo varchar(255))
begin
	update Environments
	set Environments.nombre = nuevo
    where Environments.nombre = Nombre;
end$$

create procedure VerAmbientes()
begin
	select * from  Environments;
end$$

create procedure AgregarMesa(in inAsientos int, in inEnvi int)
begin
	INSERT INTO Sares.Mesa (asientos, disponibilidad, idEnvi, eliminado)
	VALUES 	(inAsientos, 1, inAmbiente, 0);
end$$

create procedure EliminarMesa(in id INT)
begin
	update Mesa
	set Mesa.eliminado=1
    where Mesa.idMesa = id;
end$$

create procedure ActualizarMesa(in id int, in Asientos int, in Disponibilidad tinyint, in Ambiente int)
begin


	update Mesa
	set Mesa.asientos = Asientos, Mesa.disponibilidad = Disponibilidad, Mesa.idEnvi = Ambiente
    where Mesa.idMesa = id;
end$$

create procedure VerMesas()
begin
	select * from Mesa;
end$$
delimiter ;
delimiter $$

create procedure NuevaOrden(in cliente varchar(10), in mesero varchar(10), in mesa int, out NuevaOrden int)
begin
	INSERT INTO Orden(EnCola, pagado, enPreparacion, cocinado, entregado, idCliente, idMesero) 
    VALUES (0, 0, 0, 0, 0, cliente, mesero);
    
    SELECT LAST_INSERT_ID() into NuevaOrden;
    
    Insert INTO MesaOrden(idMesa, idOrden)
    values(mesa, NuevaOrden);
    
end$$

create procedure EliminarOrden(in inOrden int)
begin
	delete from Orden
    where Orden.id = inOrden;
end$$

create procedure EliminarItemOrden(in inOrden int, in inItem int)
begin
	Delete from SARES.Detalle_Orden
    where Detalle_Orden.ID_Orden = inOrden AND Detalle_Orden.ID_Item = Item;
end$$

Create PROCEDURE EncolarPedido(in pedido int)
begin
	update Pedido
    set Pedido.EnCola = 1
    where Pedido.id = pedido;
end$$
create procedure AgregarItemAOrden(in inItem int, in inOrden int, in Cantidad int,in obs varchar(255))
begin
	INSERT INTO Detalle_Orden(ID_Item, ID_Orden, cantidad, Observaciones)
    VALUES (inItem, inOrden, Cantidad, obs);
end$$

CREATE PROCEDURE ActualizarDetalleOrden(in inItem int, in inOrden int, in Cantidad int,in obs varchar(255))
begin
	update Detalle_Orden
    set Detalle_Orden.cantidad = cantidad, Detalle_Orden.Observaciones = Obs
    where Detalle_Orden.ID_Item=inItem AND Detalle_Orden.ID_Orden = inOrden;
end$$
CREATE procedure AceptarOrden(in inOrden int, in id int)
begin
	update Orden
    set Orden.idChef = id, Orden.enPreparacion = 1
    where Orden.id = inOrden;
end$$

create procedure OrdenTerminada(in inOrden int)
begin
	UPDATE Orden
    set Orden.cocinado = 1
    where Orden.id = inOrden;
end$$

create procedure FaltaIngrediente(in inItem int)
begin
	update Item
    set Item.Disponibilidad = 0
    where Item.ID = inItem;
end$$


delimiter ;
