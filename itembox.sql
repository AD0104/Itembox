CREATE DATABASE db_itembox;

CREATE TABLE tbl_user_roles (
    usr_rols_id SERIAL PRIMARY KEY,
    usr_rols_rol VARCHAR(50) NOT NULL
);

CREATE TABLE tbl_user_info (
    usr_inf_id SERIAL PRIMARY KEY,
    usr_inf_name VARCHAR(50) NOT NULL,
    usr_inf_password VARCHAR(255) NOT NULL,
    usr_email VARCHAR(255) NOT NULL
);

CREATE TABLE tbl_empresas (
    entrp_id SERIAL PRIMARY KEY,
    entrp_name VARCHAR (255) NOT NULL
);

-- CREATE TABLE tbl_user_authorities (
--     usr_auth_id SERIAL PRIMARY KEY,
--    usr_auth_authorities VARCHAR(250) NOT NULL,
--    usr_inf_id SERIAL NOT NULL,
--    CONSTRAINT fk_user_info FOREIGN KEY (usr_inf_id) REFERENCES tbl_user_info(usr_inf_id)
-- );

CREATE TABLE tbl_sucursales (
    suc_id SERIAL PRIMARY KEY,
    suc_id_external VARCHAR(50) NOT NULL,
    suc_description VARCHAR(100) NOT NULL
);

CREATE TABLE tbl_item_info(
    itm_inf_id SERIAL PRIMARY KEY,
    itm_inf_name VARCHAR(50) NOT NULL,
    itm_inf_description VARCHAR(100),
    itm_inf_stock INTEGER NOT NULL,
    itm_inf_unitary_price NUMERIC(5,2)
);


DROP TABLE tbl_user_info CASCADE;
DROP TABLE tbl_user_roles CASCADE;
DROP TABLE tbl_roles CASCADE;
