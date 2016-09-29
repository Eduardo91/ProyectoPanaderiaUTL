DROP DATABASE IF EXISTS Panaderiagil3;
CREATE DATABASE Panaderiagil3;
USE Panaderiagil3;

CREATE TABLE panes
(
	idP INT PRIMARY KEY AUTO_INCREMENT,
	codigoPan VARCHAR(10),
    nombre VARCHAR(25),
    descripcion VARCHAR(50),
    precioP DOUBLE NOT NULL,
    precioV DOUBLE,
    imagen LONG,
    estatus INT(1) DEFAULT 1
);

CREATE TABLE inventario
(
	idI INT PRIMARY KEY AUTO_INCREMENT,
	idP INT NOT NULL,
	existencia INT DEFAULT 0,
	fecha DATE NOT NULL,
    
    CONSTRAINT fk_invenatarioPanaes 
    FOREIGN KEY (idP) REFERENCES panes(idP)
);

CREATE TABLE ventas
(
	folio INT PRIMARY KEY AUTO_INCREMENT ,
    fecha DATE NOT NULL,
    total DOUBLE DEFAULT 0
);

CREATE TABLE detalle
(
	idD INT PRIMARY KEY AUTO_INCREMENT,
    folio INT NOT NULL,
    idP INT NOT NULL,
    cantidad INT DEFAULT  0,
    importe DOUBLE,
    total DOUBLE,
    
    CONSTRAINT fk_detallePanaes 
    FOREIGN KEY (idP) REFERENCES panes(idP),
    CONSTRAINT fk_detalleVentas 
    FOREIGN KEY (folio) REFERENCES ventas(folio)
    
);

DROP TRIGGER IF EXISTS actualizarInventario;
DELIMITER //
CREATE TRIGGER actualizarInventario
AFTER INSERT ON detalle
FOR EACH ROW 
BEGIN
declare precio double;

	update inventario 
    set existencia = existencia-new.cantidad
    WHERE idP = new.idP;
    
    
    set precio = (select precioV
    from panes
    where idP = new.idP);
	
    update ventas 
    set total = total + (precio * new.cantidad)
    where folio = new.folio;
end;
//
delimiter ;
DROP PROCEDURE IF EXISTS actualizarPan;
DELIMITER $$
CREATE PROCEDURE actualizarPan(IN var_idPan INT,
                                     IN var_codigoPan VARCHAR(10),
                                     IN var_nombre VARCHAR(25), 
                                     IN var_descripcion VARCHAR(50),
                                     IN var_precioP DOUBLE,
                                     IN var_precioV DOUBLE)
                                      
                                    
    BEGIN       
        /*Iniciamos una transacción para asegurar la integridad de los registros:*/
        START TRANSACTION;
            /*Actualizamos la tabla persona:*/
            UPDATE panes SET    nombre = var_nombre, codigoPan = var_codigoPan, 
                                descripcion = var_descripcion, precioP = var_precioP,
                                precioV = var_precioV                              
            WHERE idP = var_idPan;      
        /*Si no hay error, aceptamos los cambios de forma permanente:*/
            
        COMMIT;
    END $$ /*Terminamos el procedimiento almacenado*/
/*Reestablecemos el delimitador de instrucciones al punto y coma:*/ 
DELIMITER ;

INSERT INTO panes(codigoPan, nombre, descripcion, precioP, precioV, imagen)
VALUES ('15001272', 'EMPANADA', 'PAN DULCE RELLENO DE FRESA', 5.50, 7.50, ' ');
INSERT INTO panes(codigoPan, nombre, descripcion, precioP, precioV, imagen)
VALUES ('15001461', 'DONA', 'PAN DULCE ESPOLVOREADO DE AZUCAR', 3.50, 5.50, ' ');
INSERT INTO panes(codigoPan, nombre, descripcion, precioP, precioV, imagen)
VALUES ('15001530', 'MANTECADA', 'PAN DULCE SABOR VAINILLA', 6.50, 9.50, ' ');

INSERT INTO inventario(idP, existencia, fecha)
VALUES (1,32,curdate());
INSERT INTO inventario(idP, existencia, fecha)
VALUES (2,46,curdate());
INSERT INTO inventario(idP, existencia, fecha)
VALUES (3,39,curdate());

INSERT INTO ventas (fecha)
VALUES (curdate());

INSERT INTO detalle(folio, idP, cantidad)
VALUES(1,1,5);
INSERT INTO detalle(folio, idP, cantidad)
VALUES(1,2,5);


select * from panes;
select * from inventario;
select * from ventas;
select * from detalle;