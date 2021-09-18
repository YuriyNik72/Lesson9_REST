DROP TABLE IF EXISTS product;
CREATE TABLE product (
    id INT  AUTO_INCREMENT NOT NULL  PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    price INT NOT NULL
);

INSERT INTO product (title, price) VALUES
('product1','1500'),
('product2','11500'),
('product3','500'),
('product4','2500');