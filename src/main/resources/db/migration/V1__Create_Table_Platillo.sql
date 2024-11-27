CREATE TABLE platillo(
    id_platillo BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_platillo VARCHAR(255) NOT NULL,
    tipo_comida VARCHAR(50) NOT NULL,
    nombre_cocinero VARCHAR(255) NOT NULL,
    descripcion VARCHAR(255)
);