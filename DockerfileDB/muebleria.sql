DROP DATABASE IF EXISTS Muebleria;
CREATE DATABASE Muebleria;

GRANT ALL PRIVILEGES ON DATABASE Muebleria to administrador;

CREATE FUNCTION public.eliminarmueble(id integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
BEGIN
 delete from Muebles where idmueble = id;
end;
$$;


CREATE TABLE public.mueble (
    idmueble integer NOT NULL,
    nombre character varying,
    direccion character varying,
    antiguedad character varying,
    habitaciones integer,
    estufa boolean,
    banios boolean,
    estacionamiento boolean,
    capacidad integer,
    fechaalta date,
    fechamodificacion date
);

CREATE SEQUENCE public.mueble_idmueble_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
   
ALTER TABLE ONLY public.mueble ALTER COLUMN idmueble SET DEFAULT nextval('public.mueble_idmueble_seq'::regclass);

ALTER TABLE ONLY public.mueble
    ADD CONSTRAINT mueble_pk PRIMARY KEY (idmueble);   

CREATE TABLE public.persona (
    idpersona integer NOT NULL,
    nombre character varying,
    apellidos character varying,
    telefono character varying
);


CREATE SEQUENCE public.persona_idpersona_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
   
ALTER TABLE ONLY public.persona ALTER COLUMN idpersona SET DEFAULT nextval('public.persona_idpersona_seq'::regclass);


ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pk PRIMARY KEY (idpersona);

CREATE TABLE public.usuario (
    idusuario integer NOT NULL,
    usuario character varying(40) NOT NULL,
    contrasenia character varying(12) NOT NULL,
    idpersona integer NOT NULL
);

CREATE SEQUENCE public.usuario_idusuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE ONLY public.usuario ALTER COLUMN idusuario SET DEFAULT nextval('public.usuario_idusuario_seq'::regclass);

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pk PRIMARY KEY (idusuario);

 ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_persona_fk FOREIGN KEY (idpersona) REFERENCES public.persona(idpersona);
   
INSERT INTO public.mueble VALUES (5, 'Casa en Mexico', 'Paseo de la reforma', '10 años', 5, true, NULL, true, 12, NULL, NULL);
INSERT INTO public.mueble VALUES (4, 'Casa en Xalapa, Veracruz', 'Av. Enriquez 120', '32 años', 10, true, NULL, false, 25, NULL, NULL);
INSERT INTO public.mueble VALUES (6, 'Casa en Villahermosa, Tabasco', 'Av. Blancas Mariposas 1234', '8 años', 3, false, NULL, true, 5, NULL, NULL);
INSERT INTO public.mueble VALUES (1, 'Casa en Guadalajara, Jalisco', 'Panfilo Natera 12345', '2 años', 3, true, NULL, true, 5, NULL, NULL);



