    CREATE DATABASE demo DEFAULT CHARACTER
    SET utf8mb4 COLLATE utf8mb4_unicode_ci;
    
    SET FOREIGN_KEY_CHECKS=0;
    
    -- ----------------------------
    -- Table structure for t_user
    -- ----------------------------
    DROP TABLE IF EXISTS `t_user`;
    CREATE TABLE `t_user` (
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
      `username` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT 'utf8',
      `password` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
      `sult` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
