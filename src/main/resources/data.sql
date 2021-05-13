DROP TABLE IF EXISTS producto;

CREATE TABLE producto (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nombre VARCHAR(250) NOT NULL,
  cantidad int NOT NULL,
  reutilizable int DEFAULT NULL,
    estado varchar(10) not null
);

INSERT INTO producto (nombre, cantidad, reutilizable, estado) VALUES
  ('Computadora', 3, 1, 'ACT'),
  ('Teclado', 3, 1, 'ACT'),
  ('Mouse', 4, 0, 'ACT');