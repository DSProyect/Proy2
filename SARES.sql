drop database if exists SARES;

create database if not exists SARES;

use SARES;

CREATE TABLE Usuario(
	usuario varchar(50) not null,
    clave varchar(50) not null,
    primary key (usuario)
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
    idCargo int not null auto_increment,
    usuario varchar(50) not null,
    eliminado boolean not null,
    primary key (cedula),
    foreign key (usuario) references Usuario(usuario),
    foreign key (idRol) references Cargo(idRol)
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
    FOREIGN KEY (idCliente) REFERENCES Cliente(cedula),
    FOREIGN KEY (idMesero) REFERENCES Personal(cedula),
    FOREIGN KEY (idChef) REFERENCES Personal(cedula)
);

CREATE TABLE Detalle_Orden(

	ID_detalle int NOT NULL auto_increment,
    ID_Orden int NOT NULL,
    ID_Item int NOT NULL,
    cantidad int,
    Observaciones varchar(255),
    
    
    PRIMARY KEY (ID_detalle),
    FOREIGN KEY (ID_Orden) references Orden(id),
    foreign key (ID_Articulo) references Articulo(ID)
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
    FOREIGN KEY (Id_cliente) REFERENCES Cliente(cedula),
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

INSERT INTO Usuario (usuario, clave)
VALUES 	('admin', 'superclave'), 
		('cajero', '1234'), 
        ('repartidor', '0987'), 
        ('mesero_1', 'sssd123'),
        ('mesero_2', '739873'),
        ('chef', '125');

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

