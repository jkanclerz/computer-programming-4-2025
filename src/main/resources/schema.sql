CREATE TABLE `product_catalog__products` (
     id VARCHAR(100) NOT NULL,
     name VARCHAR(100) NOT NULL,
     description VARCHAR(100) NOT NULL,
     price DECIMAL(12,2),
     cover VARCHAR(100),
     PRIMARY KEY(id)
);