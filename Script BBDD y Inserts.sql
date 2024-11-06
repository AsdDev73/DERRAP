CREATE DATABASE Acceso;
USE acesso;

CREATE TABLE Clientes (
    ClienteID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100),
    Direccion VARCHAR(150),
    Telefono VARCHAR(15),
    Email VARCHAR(100)
);
CREATE TABLE Productos (
    ProductoID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100),
    Descripcion TEXT,
    Precio DECIMAL(10, 2)
);
CREATE TABLE Pedidos (
    PedidoID INT AUTO_INCREMENT PRIMARY KEY,
    ClienteID INT,
    Fecha DATE,
    Total DECIMAL(10, 2),
    FOREIGN KEY (ClienteID) REFERENCES Clientes(ClienteID) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE DetallesPedidos (
    DetalleID INT AUTO_INCREMENT PRIMARY KEY,
    PedidoID INT,
    ProductoID INT,
    Cantidad INT,
    Precio DECIMAL(10, 2),
    FOREIGN KEY (PedidoID) REFERENCES Pedidos(PedidoID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (ProductoID) REFERENCES Productos(ProductoID) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE Departamentos (
    DepartamentoID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100)
);
CREATE TABLE Empleados (
    EmpleadoID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100),
    Telefono VARCHAR(15),
    DepartamentoID INT,
    FOREIGN KEY (DepartamentoID) REFERENCES Departamentos(DepartamentoID) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE Proveedores (
    ProveedorID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100),
    Telefono VARCHAR(15),
    Email VARCHAR(100)
);
CREATE TABLE ProductosProveedores (
    ProductoID INT,
    ProveedorID INT,
    Precio DECIMAL(10, 2),
    PRIMARY KEY (ProductoID, ProveedorID),
    FOREIGN KEY (ProductoID) REFERENCES Productos(ProductoID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (ProveedorID) REFERENCES Proveedores(ProveedorID) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE RegistroCambios (
    RegistroID INT AUTO_INCREMENT PRIMARY KEY,
    TablaModificada VARCHAR(100),
    FechaHora TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

select * from empleados;





