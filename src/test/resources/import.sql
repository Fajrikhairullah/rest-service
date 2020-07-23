INSERT INTO `item` (`id`, `created_date`, `modified_date`, `name`) VALUES (1, '2020-03-04 05:57:54.000000', NULL, 'Beras');
INSERT INTO `item` (`id`, `created_date`, `modified_date`, `name`) VALUES (2, '2020-03-04 05:57:54.000000', NULL, 'Kopi Hitam');
INSERT INTO `item` (`id`, `created_date`, `modified_date`, `name`) VALUES (3, '2020-03-04 05:57:54.000000', NULL, 'Mie Instan');
INSERT INTO `item` (`id`, `created_date`, `modified_date`, `name`) VALUES (4, '2020-03-04 05:57:54.000000', NULL, 'Mie Goreng Instan');
INSERT INTO `item` (`id`, `created_date`, `modified_date`, `name`) VALUES (5, '2020-03-04 05:57:54.000000', NULL, 'Minyak Goreng');

INSERT INTO `unit` (`id`, `created_date`, `modified_date`, `name`) VALUES (1, '2020-03-04 05:57:54.000000', NULL, 'l');
INSERT INTO `unit` (`id`, `created_date`, `modified_date`, `name`) VALUES (2, '2020-03-04 05:57:54.000000', NULL, 'g');
INSERT INTO `unit` (`id`, `created_date`, `modified_date`, `name`) VALUES (3, '2020-03-04 05:57:54.000000', NULL, 'pack');
INSERT INTO `unit` (`id`, `created_date`, `modified_date`, `name`) VALUES (4, '2020-03-04 05:57:54.000000', NULL, 'pack');
INSERT INTO `unit` (`id`, `created_date`, `modified_date`, `name`) VALUES (5, '2020-03-04 05:57:54.000000', NULL, 'l');


INSERT INTO `stock` (`id`, `created_date`, `modified_date`, `qty`, `item_id`, `unit_id`) VALUES (1, '2020-03-04 05:57:54.000000', NULL, 2, 1, 1);
INSERT INTO `stock` (`id`, `created_date`, `modified_date`, `qty`, `item_id`, `unit_id`) VALUES (2, '2020-03-04 05:57:54.000000', NULL, 1000, 2, 2);
INSERT INTO `stock` (`id`, `created_date`, `modified_date`, `qty`, `item_id`, `unit_id`) VALUES (3, '2020-03-04 05:57:54.000000', NULL, 15, 3, 3);
INSERT INTO `stock` (`id`, `created_date`, `modified_date`, `qty`, `item_id`, `unit_id`) VALUES (4, '2020-03-04 05:57:54.000000', NULL, 15, 4, 4);
INSERT INTO `stock` (`id`, `created_date`, `modified_date`, `qty`, `item_id`, `unit_id`) VALUES (5, '2020-03-04 05:57:54.000000', NULL, 5, 5, 5);

