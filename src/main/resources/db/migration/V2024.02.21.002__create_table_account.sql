CREATE TABLE account
(
    id_ingrediente character varying(36) NOT NULL,
    tx_name character varying(256) NOT NULL,
    tx_descricao character varying(256) NOT NULL,
    CONSTRAINT ingrediente_pkey PRIMARY KEY (id_ingrediente)
);
