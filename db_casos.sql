/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : db_casos

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 18/04/2020 09:30:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_casos
-- ----------------------------
DROP TABLE IF EXISTS `tbl_casos`;
CREATE TABLE `tbl_casos`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(3) NULL DEFAULT NULL,
  `id_vendedor` int(3) NULL DEFAULT NULL,
  `id_usuario` int(3) NULL DEFAULT NULL,
  `honorarios` double(8, 2) NULL DEFAULT NULL,
  `propiedad` double(8, 2) NULL DEFAULT NULL,
  `salarios` double(8, 2) NULL DEFAULT NULL,
  `notas` varchar(255) CHARACTER SET utf8 COLLATE utf8_spanish_ci NULL DEFAULT NULL,
  `id_estado` int(2) NULL DEFAULT NULL,
  `id_tipo_propiedad` int(2) NULL DEFAULT NULL,
  `id_representante` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_cliente_casos`(`id_cliente`) USING BTREE,
  INDEX `id_vendedor_casos`(`id_vendedor`) USING BTREE,
  INDEX `id_usuario_casos`(`id_usuario`) USING BTREE,
  INDEX `id_estado_casos`(`id_estado`) USING BTREE,
  INDEX `id_tipo_propiedad_casos`(`id_tipo_propiedad`) USING BTREE,
  INDEX `id_representante_casos`(`id_representante`) USING BTREE,
  CONSTRAINT `id_cliente_casos` FOREIGN KEY (`id_cliente`) REFERENCES `tbl_clientes` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `id_vendedor_casos` FOREIGN KEY (`id_vendedor`) REFERENCES `tbl_vendedor` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `id_usuario_casos` FOREIGN KEY (`id_usuario`) REFERENCES `tbl_usuarios` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `id_estado_casos` FOREIGN KEY (`id_estado`) REFERENCES `tbl_estado` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `id_tipo_propiedad_casos` FOREIGN KEY (`id_tipo_propiedad`) REFERENCES `tbl_tipo_propiedad` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `id_representante_casos` FOREIGN KEY (`id_representante`) REFERENCES `tbl_representante` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_clientes
-- ----------------------------
DROP TABLE IF EXISTS `tbl_clientes`;
CREATE TABLE `tbl_clientes`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `telefono` varchar(11) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `correo` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `direccion` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `id_estado_civil` int(3) NULL DEFAULT NULL,
  `id_migratorio` int(3) NULL DEFAULT NULL,
  `profesion` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_estado_civil_clientes`(`id_estado_civil`) USING BTREE,
  INDEX `id_migratorio_clientes`(`id_migratorio`) USING BTREE,
  CONSTRAINT `id_estado_civil_clientes` FOREIGN KEY (`id_estado_civil`) REFERENCES `tbl_estado_civil` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `id_migratorio_clientes` FOREIGN KEY (`id_migratorio`) REFERENCES `tbl_migratorio` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_estado
-- ----------------------------
DROP TABLE IF EXISTS `tbl_estado`;
CREATE TABLE `tbl_estado`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `descripicion` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_estado_civil
-- ----------------------------
DROP TABLE IF EXISTS `tbl_estado_civil`;
CREATE TABLE `tbl_estado_civil`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) CHARACTER SET utf8 COLLATE utf8_spanish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_migratorio
-- ----------------------------
DROP TABLE IF EXISTS `tbl_migratorio`;
CREATE TABLE `tbl_migratorio`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) CHARACTER SET utf8 COLLATE utf8_spanish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_registros
-- ----------------------------
DROP TABLE IF EXISTS `tbl_registros`;
CREATE TABLE `tbl_registros`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(3) NULL DEFAULT NULL,
  `fecha` date NULL DEFAULT NULL,
  `notas` varchar(255) CHARACTER SET utf8 COLLATE utf8_spanish_ci NULL DEFAULT NULL,
  `id_casos` int(3) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_usuario_registros`(`id_usuario`) USING BTREE,
  INDEX `id_casos_registors`(`id_casos`) USING BTREE,
  CONSTRAINT `id_usuario_registros` FOREIGN KEY (`id_usuario`) REFERENCES `tbl_usuarios` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `id_casos_registors` FOREIGN KEY (`id_casos`) REFERENCES `tbl_casos` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_spanish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_representante
-- ----------------------------
DROP TABLE IF EXISTS `tbl_representante`;
CREATE TABLE `tbl_representante`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parentezco` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `direccion` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `telefono` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `banco` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_roles
-- ----------------------------
DROP TABLE IF EXISTS `tbl_roles`;
CREATE TABLE `tbl_roles`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `descripcion` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_tipo_propiedad
-- ----------------------------
DROP TABLE IF EXISTS `tbl_tipo_propiedad`;
CREATE TABLE `tbl_tipo_propiedad`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_usuarios
-- ----------------------------
DROP TABLE IF EXISTS `tbl_usuarios`;
CREATE TABLE `tbl_usuarios`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `id_roles` int(1) NULL DEFAULT NULL,
  `telefono` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `correo` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `descripcion` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_roles_usuarios`(`id_roles`) USING BTREE,
  CONSTRAINT `id_roles_usuarios` FOREIGN KEY (`id_roles`) REFERENCES `tbl_roles` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_vendedor
-- ----------------------------
DROP TABLE IF EXISTS `tbl_vendedor`;
CREATE TABLE `tbl_vendedor`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `telefono` int(11) NULL DEFAULT NULL,
  `constructora` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `correo` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
