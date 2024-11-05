create database derrap;
use derrap;

CREATE TABLE Cliente (
    DNI INT PRIMARY KEY,
    Nombre VARCHAR(45),
    Apellido VARCHAR(45),
    Tlf VARCHAR(45)
);

CREATE TABLE Vehiculo (
    Matricula INT PRIMARY KEY,
    Marca VARCHAR(45),
    Modelo VARCHAR(45),
    Color VARCHAR(45),
    Fecha_Entrada VARCHAR(45),
    Fecha_Salida VARCHAR(45),
    Cliente_DNI INT,
    Reparacion_Codigo_Reparacion INT,
    FOREIGN KEY (Cliente_DNI) REFERENCES Cliente(DNI) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Mecánico (
    No_Empleado INT PRIMARY KEY,
    DNI VARCHAR(9),
    Nombre VARCHAR(45),
    Apellido VARCHAR(45),
    Tlf VARCHAR(45),
    Estado VARCHAR(45)
);

CREATE TABLE Factura (
    ID_Factura INT PRIMARY KEY,
    IVA DECIMAL,
    Precio_sin_IVA DECIMAL,
    Precio_Total DECIMAL
);

CREATE TABLE Repuesto (
    Codigo_Repuesto INT PRIMARY KEY,
    Precio DECIMAL,
    Cantidad INT,
    Proveedor_codigo INT,
    FOREIGN KEY (Proveedor_codigo) REFERENCES Proveedor(codigo) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Proveedor (
    codigo INT PRIMARY KEY,
    Nombre VARCHAR(45),
    email VARCHAR(45),
    tlf VARCHAR(45)
);

CREATE TABLE Servicios (
    Codigo_servicio INT PRIMARY KEY,
    Precio_por_hora DECIMAL,
    Servicioscol VARCHAR(45)
);

CREATE TABLE Reparacion (
    Codigo_Reparacion INT PRIMARY KEY,
    Mano_de_obra DECIMAL,
    tiempo INT,
    Estado VARCHAR(45),
    Mecanico_No_Empleado INT,
    Factura_ID_Factura INT,
    Repuesto_Codigo_Repuesto INT,
    FOREIGN KEY (Mecanico_No_Empleado) REFERENCES Mecánico(No_Empleado) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Factura_ID_Factura) REFERENCES Factura(ID_Factura) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Repuesto_Codigo_Repuesto) REFERENCES Repuesto(Codigo_Repuesto) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Reparacion_has_Repuesto (
    Reparacion_Codigo_Reparacion INT,
    Repuesto_Codigo_Repuesto INT,
    PRIMARY KEY (Reparacion_Codigo_Reparacion, Repuesto_Codigo_Repuesto),
    FOREIGN KEY (Reparacion_Codigo_Reparacion) REFERENCES Reparacion(Codigo_Reparacion) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Repuesto_Codigo_Repuesto) REFERENCES Repuesto(Codigo_Repuesto) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Solicitudes (
    Id_solicitud INT PRIMARY KEY,
    Repuesto_Codigo_Repuesto INT,
    FOREIGN KEY (Repuesto_Codigo_Repuesto) REFERENCES Repuesto(Codigo_Repuesto) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Usuarios (
    ID_Usuario INT PRIMARY KEY,
    Contraseña VARCHAR(45),
    Usuario VARCHAR(45),
    Rol INT
);

-- Insertar datos en la tabla Cliente
INSERT INTO Cliente (DNI, Nombre, Apellido, Tlf) VALUES 
(12345678, 'Juan', 'Perez', '123456789'),
(23456789, 'Ana', 'Gomez', '987654321');

-- Insertar datos en la tabla Vehiculo
INSERT INTO Vehiculo (Matricula, Marca, Modelo, Color, Fecha_Entrada, Fecha_Salida, Cliente_DNI, Reparacion_Codigo_Reparacion) VALUES 
(1111, 'Toyota', 'Corolla', 'Rojo', '2024-01-01', '2024-01-05', 12345678, 1001),
(2222, 'Ford', 'Fiesta', 'Azul', '2024-02-01', '2024-02-10', 23456789, 1002);

-- Insertar datos en la tabla Mecánico
INSERT INTO Mecánico (No_Empleado, DNI, Nombre, Apellido, Tlf, Estado) VALUES 
(1, '98765432A', 'Carlos', 'Ramirez', '123123123', 'Disponible'),
(2, '87654321B', 'Luisa', 'Martinez', '321321321', 'Ocupado');

-- Insertar datos en la tabla Factura
INSERT INTO Factura (ID_Factura, IVA, Precio_sin_IVA, Precio_Total) VALUES 
(1, 21.00, 100.00, 121.00),
(2, 21.00, 150.00, 181.50);

-- Insertar datos en la tabla Repuesto
INSERT INTO Repuesto (Codigo_Repuesto, Precio, Cantidad, Proveedor_codigo) VALUES 
(5001, 50.00, 10, 2001),
(5002, 75.00, 5, 2002);

-- Insertar datos en la tabla Proveedor
INSERT INTO Proveedor (codigo, Nombre, email, tlf) VALUES 
(2001, 'Proveedor A', 'contactoA@proveedor.com', '555111222'),
(2002, 'Proveedor B', 'contactoB@proveedor.com', '555333444');

-- Insertar datos en la tabla Servicios
INSERT INTO Servicios (Codigo_servicio, Precio_por_hora, Servicioscol) VALUES 
(3001, 30.00, 'Cambio de Aceite'),
(3002, 45.00, 'Revisión General');

-- Insertar datos en la tabla Reparacion
INSERT INTO Reparacion (Codigo_Reparacion, Mano_de_obra, tiempo, Estado, Mecanico_No_Empleado, Factura_ID_Factura, Repuesto_Codigo_Repuesto) VALUES 
(1001, 2.5, 3, 'Completado', 1, 1, 5001),
(1002, 3.0, 4, 'En Progreso', 2, 2, 5002);

-- Insertar datos en la tabla Reparacion_has_Repuesto
INSERT INTO Reparacion_has_Repuesto (Reparacion_Codigo_Reparacion, Repuesto_Codigo_Repuesto) VALUES 
(1001, 5001),
(1002, 5002);

-- Insertar datos en la tabla Solicitudes
INSERT INTO Solicitudes (Id_solicitud, Repuesto_Codigo_Repuesto) VALUES 
(4001, 5001),
(4002, 5002);

-- Insertar datos en la tabla Usuarios
INSERT INTO Usuarios (ID_Usuario, Contraseña, Usuario, Rol) VALUES 
(1, 'password123', 'usuario1', 1),
(2, 'password456', 'usuario2', 2);


select * from factura;
select * from repuesto;




