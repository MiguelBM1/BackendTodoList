/*
 Navicat Premium Data Transfer

 Source Server         : proy
 Source Server Type    : PostgreSQL
 Source Server Version : 150002 (150002)
 Source Host           : localhost:5432
 Source Catalog        : task_managment
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 150002 (150002)
 File Encoding         : 65001

 Date: 14/04/2024 19:30:46
*/


-- ----------------------------
-- Sequence structure for departamentos_id_departamento_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."departamentos_id_departamento_seq";
CREATE SEQUENCE "public"."departamentos_id_departamento_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for estados_id_estado_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."estados_id_estado_seq";
CREATE SEQUENCE "public"."estados_id_estado_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for personas_id_persona_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."personas_id_persona_seq";
CREATE SEQUENCE "public"."personas_id_persona_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for tareas_id_tarea_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."tareas_id_tarea_seq";
CREATE SEQUENCE "public"."tareas_id_tarea_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Table structure for departamentos
-- ----------------------------
DROP TABLE IF EXISTS "public"."departamentos";
CREATE TABLE "public"."departamentos" (
  "id_departamento" int4 NOT NULL DEFAULT nextval('departamentos_id_departamento_seq'::regclass),
  "nombre" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of departamentos
-- ----------------------------
INSERT INTO "public"."departamentos" VALUES (1, 'RRHH');
INSERT INTO "public"."departamentos" VALUES (2, 'Informatica');
INSERT INTO "public"."departamentos" VALUES (3, 'Administracion');
INSERT INTO "public"."departamentos" VALUES (4, 'Ventas');

-- ----------------------------
-- Table structure for estados
-- ----------------------------
DROP TABLE IF EXISTS "public"."estados";
CREATE TABLE "public"."estados" (
  "id_estado" int4 NOT NULL DEFAULT nextval('estados_id_estado_seq'::regclass),
  "nombre" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of estados
-- ----------------------------
INSERT INTO "public"."estados" VALUES (1, 'Pendiente');
INSERT INTO "public"."estados" VALUES (2, 'Completada');

-- ----------------------------
-- Table structure for personas
-- ----------------------------
DROP TABLE IF EXISTS "public"."personas";
CREATE TABLE "public"."personas" (
  "id_persona" int4 NOT NULL DEFAULT nextval('personas_id_persona_seq'::regclass),
  "codigo" varchar(255) COLLATE "pg_catalog"."default",
  "nombre" varchar(255) COLLATE "pg_catalog"."default",
  "departamento_id" int4
)
;

-- ----------------------------
-- Records of personas
-- ----------------------------
INSERT INTO "public"."personas" VALUES (3, 'Cod-300', 'Mario Lopez', 3);
INSERT INTO "public"."personas" VALUES (4, 'Cod-400', 'Yancy Martinez', 4);
INSERT INTO "public"."personas" VALUES (1, 'Cod-200', 'Miguel Beltran', 2);
INSERT INTO "public"."personas" VALUES (2, 'Cod-100', 'Juan Perez', 1);

-- ----------------------------
-- Table structure for tareas
-- ----------------------------
DROP TABLE IF EXISTS "public"."tareas";
CREATE TABLE "public"."tareas" (
  "id_tarea" int4 NOT NULL DEFAULT nextval('tareas_id_tarea_seq'::regclass),
  "descripcion" varchar(255) COLLATE "pg_catalog"."default",
  "fecha_finalizacion" date,
  "nombre" varchar(255) COLLATE "pg_catalog"."default",
  "estado_id" int4,
  "persona_id" int4
)
;

-- ----------------------------
-- Records of tareas
-- ----------------------------
INSERT INTO "public"."tareas" VALUES (1000, 'Realizar procedimientos de insersion actualizacion y eliminacion de tareas y asignacion a persona que las realizara', '2024-04-23', 'Crud Task', 2, 1);
INSERT INTO "public"."tareas" VALUES (1001, 'realizar un inventario de entradas y salidas de materiales', '2024-04-24', 'actualizar inventario', 1, 3);
INSERT INTO "public"."tareas" VALUES (1002, 'crear reportes de ventas de los ultimos 2 meses ', '2024-04-12', 'Generar Reportes', 1, 4);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."departamentos_id_departamento_seq"
OWNED BY "public"."departamentos"."id_departamento";
SELECT setval('"public"."departamentos_id_departamento_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."estados_id_estado_seq"
OWNED BY "public"."estados"."id_estado";
SELECT setval('"public"."estados_id_estado_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."personas_id_persona_seq"
OWNED BY "public"."personas"."id_persona";
SELECT setval('"public"."personas_id_persona_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."tareas_id_tarea_seq"
OWNED BY "public"."tareas"."id_tarea";
SELECT setval('"public"."tareas_id_tarea_seq"', 6, true);

-- ----------------------------
-- Primary Key structure for table departamentos
-- ----------------------------
ALTER TABLE "public"."departamentos" ADD CONSTRAINT "departamentos_pkey" PRIMARY KEY ("id_departamento");

-- ----------------------------
-- Primary Key structure for table estados
-- ----------------------------
ALTER TABLE "public"."estados" ADD CONSTRAINT "estados_pkey" PRIMARY KEY ("id_estado");

-- ----------------------------
-- Primary Key structure for table personas
-- ----------------------------
ALTER TABLE "public"."personas" ADD CONSTRAINT "personas_pkey" PRIMARY KEY ("id_persona");

-- ----------------------------
-- Primary Key structure for table tareas
-- ----------------------------
ALTER TABLE "public"."tareas" ADD CONSTRAINT "tareas_pkey" PRIMARY KEY ("id_tarea");

-- ----------------------------
-- Foreign Keys structure for table personas
-- ----------------------------
ALTER TABLE "public"."personas" ADD CONSTRAINT "fklr9l2aevl2vgwtud828fn7w1v" FOREIGN KEY ("departamento_id") REFERENCES "public"."departamentos" ("id_departamento") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table tareas
-- ----------------------------
ALTER TABLE "public"."tareas" ADD CONSTRAINT "fk5euy32gp067ytby04j29xadf2" FOREIGN KEY ("estado_id") REFERENCES "public"."estados" ("id_estado") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."tareas" ADD CONSTRAINT "fkids667cq099l6mhby1sngfvfg" FOREIGN KEY ("persona_id") REFERENCES "public"."personas" ("id_persona") ON DELETE NO ACTION ON UPDATE NO ACTION;
