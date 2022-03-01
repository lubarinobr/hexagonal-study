INSERT INTO product (id, name,created_at,updated_at) VALUES
	 (1, 'Macarrão','2022-03-01 21:05:29','2022-03-01 21:05:29'),
	 (2, 'Molho de Tomate','2022-03-01 21:05:29','2022-03-01 21:05:29'),
	 (3, 'Sal','2022-03-01 21:05:29','2022-03-01 21:05:29'),
	 (4, 'Carne picada','2022-03-01 21:05:29','2022-03-01 21:05:29');
INSERT INTO recipe (id, name,created_at,updated_at) VALUES
	 (1, 'Macarrão bolonhesa','2022-03-01 21:05:29','2022-03-01 21:05:29');
INSERT INTO recipe_product (product_id,recipe_id, quantity, unit, created_at,updated_at) VALUES
	 (1,1, 1, 'kg','2022-03-01 21:05:29','2022-03-01 21:05:29'),
	 (2,1,500, 'g','2022-03-01 21:05:29','2022-03-01 21:05:29'),
	 (3,1, 2, "colheres (sopa)", '2022-03-01 21:05:29','2022-03-01 21:05:29'),
	 (4,1, 1, 'kg', '2022-03-01 21:05:29','2022-03-01 21:05:29');