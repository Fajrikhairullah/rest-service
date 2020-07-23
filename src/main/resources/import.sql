INSERT INTO user (id, username, password, activated) VALUES ('1', 'admin', '{bcrypt}$2b$10$TGJHtL7f0zYir/xrIPRrOOMTe5mI1TZRBkoS/GI4029WzSKIrc5Si', true);
INSERT INTO user (id, username, password, activated) VALUES ('2', 'user', '{bcrypt}$2b$10$TGJHtL7f0zYir/xrIPRrOOMTe5mI1TZRBkoS/GI4029WzSKIrc5Si', true);

INSERT INTO role (id, name) VALUES (1, 'ADMIN');
INSERT INTO role (id, name) VALUES (2, 'USER');

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO `item` (`id`, `created_date`, `modified_date`, `name`) VALUES (1, '2020-03-04 05:57:54.000000', NULL, 'Beras');
INSERT INTO `item` (`id`, `created_date`, `modified_date`, `name`) VALUES (2, '2020-03-04 05:57:54.000000', NULL, 'Kopi Hitam');
INSERT INTO `item` (`id`, `created_date`, `modified_date`, `name`) VALUES (3, '2020-03-04 05:57:54.000000', NULL, 'Mie Instan');
INSERT INTO `item` (`id`, `created_date`, `modified_date`, `name`) VALUES (4, '2020-03-04 05:57:54.000000', NULL, 'Mie Goreng Instan');
INSERT INTO `item` (`id`, `created_date`, `modified_date`, `name`) VALUES (5, '2020-03-04 05:57:54.000000', NULL, 'Minyak Goreng');

INSERT INTO `unit` (`id`, `created_date`, `modified_date`, `description`, `name`) VALUES (1, '2020-03-04 05:57:54.000000', NULL, 'litre', 'l');
INSERT INTO `unit` (`id`, `created_date`, `modified_date`, `description`, `name`) VALUES (2, '2020-03-04 05:57:54.000000', NULL, 'gram', 'g');
INSERT INTO `unit` (`id`, `created_date`, `modified_date`, `description`, `name`) VALUES (3, '2020-03-04 05:57:54.000000', NULL, 'kilogram', 'kg');
INSERT INTO `unit` (`id`, `created_date`, `modified_date`, `description`, `name`) VALUES (4, '2020-03-04 05:57:54.000000', NULL, 'package', 'pack');
INSERT INTO `unit` (`id`, `created_date`, `modified_date`, `description`, `name`) VALUES (5, '2020-03-04 05:57:54.000000', NULL, 'dus', 'dus');

INSERT INTO `stock` (`id`, `created_date`, `modified_date`, `qty`, `item_id`, `unit_id`) VALUES (1, '2020-03-04 05:57:54.000000', NULL, 2, 1, 1);
INSERT INTO `stock` (`id`, `created_date`, `modified_date`, `qty`, `item_id`, `unit_id`) VALUES (2, '2020-03-04 05:57:54.000000', NULL, 1000, 2, 2);
INSERT INTO `stock` (`id`, `created_date`, `modified_date`, `qty`, `item_id`, `unit_id`) VALUES (3, '2020-03-04 05:57:54.000000', NULL, 15, 3, 3);
INSERT INTO `stock` (`id`, `created_date`, `modified_date`, `qty`, `item_id`, `unit_id`) VALUES (4, '2020-03-04 05:57:54.000000', NULL, 15, 4, 4);
INSERT INTO `stock` (`id`, `created_date`, `modified_date`, `qty`, `item_id`, `unit_id`) VALUES (5, '2020-03-04 05:57:54.000000', NULL, 5, 5, 5);

INSERT INTO `transaction` (`id`, `created_date`, `modified_date`, `amount`, `description`, `type_enum`) VALUES (1, '2020-03-13 07:15:14', '2020-03-13 07:30:53', '100.00', 'update', 'SALE');
INSERT INTO `transaction` (`id`, `created_date`, `modified_date`, `amount`, `description`, `type_enum`) VALUES (2, '2020-03-13 08:02:04', NULL, '90.00', 'Second Transaction', 'PURCHASE');
INSERT INTO `transaction` (`id`, `created_date`, `modified_date`, `amount`, `description`, `type_enum`) VALUES (3, '2020-03-13 08:03:36', NULL, '70.00', 'New Transaction', 'PURCHASE');
INSERT INTO `transaction` (`id`, `created_date`, `modified_date`, `amount`, `description`, `type_enum`) VALUES (4, '2020-03-13 08:03:49', NULL, '60.00', 'New Transaction', 'PURCHASE');
INSERT INTO `transaction` (`id`, `created_date`, `modified_date`, `amount`, `description`, `type_enum`) VALUES (5, '2020-04-06 15:33:36', NULL, '123456.00', 'gagsgssg', 'SALE');