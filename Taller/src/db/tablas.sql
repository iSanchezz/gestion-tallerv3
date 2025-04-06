CREATE DATABASE taller;
USE DATABASE taller;
CREATE TABLE clientes(
    id VARCHAR(12) PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    telefono INT(9) NOT NULL
);
CREATE TABLE empleados(
    id VARCHAR(12) PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    puesto VARCHAR(20) NOT NULL,
    salario DECIMAL(10,2) NOT NULL
);
CREATE TABLE proveedores(
    id VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(30)  NOT NULL,
    telefono INT(9)  NOT NULL
);
CREATE TABLE productos(
    id VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(10) NOT NULL,
    precio DECIMAL(10,2)
);
CREATE TABLE vehiculos(
    id VARCHAR(15) PRIMARY KEY,
    modelo VARCHAR(30) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    duenio VARCHAR(12) NOT NULL,
    FOREIGN KEY (duenio) REFERENCES clientes(id)
);
CREATE TABLE citas(
    numerocita INT(10) PRIMARY KEY,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    idvehiculo VARCHAR(15),
    FOREIGN KEY (idVehiculo) REFERENCES vehiculos(id)
);

CREATE TABLE transacciones (
    id INT PRIMARY KEY,
    tipo VARCHAR(10) NOT NULL,
    cantidad DECIMAL(10,2) NOT NULL,
    descripcion VARCHAR(255),
    fecha TIMESTAMP NOT NULL,
); 

CREATE TABLE servicios(
    id INT(3) PRIMARY KEY,
    idempleado VARCHAR(12),
    idcliente VARCHAR(12),
    idvehiculo VARCHAR(15),
    numerocita INT(10),
    precio DECIMAL(10,2),
    descripcion VARCHAR(200),
    FOREIGN KEY (idempleado) REFERENCES empleados(id),
    FOREIGN KEY (idcliente) REFERENCES clientes(id),
    FOREIGN KEY (idvehiculo) REFERENCES vehiculos(id),
    FOREIGN KEY (numerocita) REFERENCES citas(numerocita),
 );
