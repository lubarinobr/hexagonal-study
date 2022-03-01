CREATE TABLE IF NOT EXISTS recipe_product (
    product_id INT NOT NULL,
    recipe_id INT NOT NULL,
    quantity DECIMAL(10,2),
    unit VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    foreign key (product_id) references product(id),
    foreign key (recipe_id) references recipe(id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;