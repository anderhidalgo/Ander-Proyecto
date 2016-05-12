
DROP TABLE Login CASCADE CONSTRAINTS;
DROP TABLE Centro CASCADE CONSTRAINTS;
DROP TABLE Trabajador CASCADE CONSTRAINTS;
DROP TABLE Parte CASCADE CONSTRAINTS;
DROP TABLE Abierto CASCADE CONSTRAINTS;
DROP TABLE Cerrado CASCADE CONSTRAINTS;
DROP TABLE Modifica CASCADE CONSTRAINTS;
DROP TABLE Viaje CASCADE CONSTRAINTS;


CREATE TABLE Centro (
    id_centro VARCHAR2 (10) NOT NULL,
    nombre    VARCHAR2 (15) NOT NULL,
    tlf_fijo  VARCHAR2 (9) NOT NULL,
    cp        VARCHAR2 (5) NOT NULL,
    provincia VARCHAR2 (10) NOT NULL,
    ciudad    VARCHAR2 (15) NOT NULL,
    calle     VARCHAR2 (30) NOT NULL,
    numero    VARCHAR2 (3) NOT NULL
);
ALTER TABLE Centro ADD CONSTRAINT Centro_PK PRIMARY KEY (id_centro);


CREATE TABLE Trabajador (
    dni          VARCHAR2 (9) NOT NULL,
    nombre       VARCHAR2 (15) NOT NULL,
    apellido1    VARCHAR2 (20) NOT NULL,
    apellido2    VARCHAR2 (20) NOT NULL,
    calle        VARCHAR2 (30) NOT NULL,
    numero       VARCHAR2 (3) NOT NULL,
    piso         VARCHAR2 (3) NOT NULL,
    mano         VARCHAR2 (5) NOT NULL,
    tlf_empresa  VARCHAR2 (9) NOT NULL,
    tlf_personal VARCHAR2 (9),
    fecha_nac    DATE,
    salario      FLOAT (9),
    tipo         VARCHAR(1),
    Centro_id_centro VARCHAR2 (10) NOT NULL,
    Login_usuario VARCHAR2(20) NOT NULL
);
ALTER TABLE Trabajador ADD CONSTRAINT Trabajador_PK PRIMARY KEY (dni);


CREATE TABLE Parte (
    id_parte      NUMBER(3)
    GENERATED ALWAYS AS IDENTITY
                        MINVALUE 1
                        MAXVALUE 999
                        INCREMENT BY 1
                        START WITH 1
                        NOCYCLE NOT NULL ENABLE,
    fecha_inicio  DATE NOT NULL,
    fecha_fin     DATE NOT NULL,
    km_inicio     NUMBER (10) NOT NULL,
    km_fin        NUMBER (10) NOT NULL,
    gasoil        NUMBER (5),
    autopista     NUMBER (5),
    dieta         NUMBER (5),
    otros         NUMBER (5),
    incidencias   VARCHAR2 (500),
    estado        VARCHAR2(10),
    validado      VARCHAR2(2),
    Trabajador_dni VARCHAR2 (9) NOT NULL
    
);

ALTER TABLE Parte ADD CONSTRAINT Parte_PK PRIMARY KEY (id_parte);


CREATE TABLE Abierto (
    id_parte VARCHAR2 (10) NOT NULL
);

ALTER TABLE Abierto ADD CONSTRAINT Abierto_PK PRIMARY KEY (id_parte);


CREATE TABLE Cerrado (
    id_parte           VARCHAR2 (10) NOT NULL,
    validacion         CHAR (1) NOT NULL,
    fecha_fin          DATE NOT NULL,
    Trabajador_dni VARCHAR2 (9) NOT NULL
);

ALTER TABLE Cerrado ADD CONSTRAINT Cerrado_PK PRIMARY KEY (id_parte);


CREATE TABLE Modifica (
    Trabajador_dni VARCHAR2 (9) NOT NULL,
    Parte_id_parte     VARCHAR2 (10) NOT NULL,
    fecha_modif        DATE NOT NULL
);
ALTER TABLE modifica ADD CONSTRAINT modifica_PK PRIMARY KEY (Trabajador_dni, Parte_id_parte);


CREATE TABLE Viaje (
    albaran NUMBER(3)
    GENERATED ALWAYS AS IDENTITY
                        MINVALUE 1
                        MAXVALUE 999
                        INCREMENT BY 1
                        START WITH 1
                        NOCYCLE NOT NULL ENABLE,
    hora_inicio    VARCHAR2 (5) NOT NULL,
    hora_fin       VARCHAR2 (5) NOT NULL,
    vehiculo      VARCHAR2 (9) NOT NULL,
    Parte_id_parte VARCHAR2 (10) NOT NULL
);

ALTER TABLE Viaje ADD CONSTRAINT Viaje_PK PRIMARY KEY (albaran);

CREATE TABLE Login (
    usuario       VARCHAR2 (20) NOT NULL,
    contraseña    VARCHAR2 (20) NOT NULL

);

ALTER TABLE Login ADD CONSTRAINT Login_PK PRIMARY KEY (usuario);

ALTER TABLE Trabajador ADD CONSTRAINT Trabajador_Login_FK FOREIGN KEY (Login_usuario)
REFERENCES Login (usuario) ON DELETE CASCADE;

ALTER TABLE Trabajador ADD CONSTRAINT Trabajador_Centro_FK FOREIGN KEY (Centro_id_centro)
REFERENCES Centro (id_centro) ON DELETE CASCADE;

ALTER TABLE Parte ADD CONSTRAINT Parte_Trabajador_FK FOREIGN KEY (Trabajador_dni)
REFERENCES Trabajador (dni) ON DELETE CASCADE;

ALTER TABLE Abierto ADD CONSTRAINT Abierto_Parte_FK FOREIGN KEY (id_parte)
REFERENCES Parte (id_parte);

ALTER TABLE Cerrado ADD CONSTRAINT Cerrado_Trabajador_FK FOREIGN KEY (Trabajador_dni)
REFERENCES Trabajador (dni) ON DELETE CASCADE;

ALTER TABLE Cerrado ADD CONSTRAINT Cerrado_Parte_FK FOREIGN KEY (id_parte)
REFERENCES Parte (id_parte);

ALTER TABLE modifica ADD CONSTRAINT FK_ASS_6 FOREIGN KEY (Trabajador_dni)
REFERENCES Trabajador (dni) ON DELETE CASCADE;

ALTER TABLE modifica ADD CONSTRAINT FK_ASS_7 FOREIGN KEY (Parte_id_parte)
REFERENCES Parte (id_parte) ON DELETE CASCADE;

ALTER TABLE Viaje ADD CONSTRAINT Viaje_Parte_FK FOREIGN KEY (Parte_id_parte)
REFERENCES Parte (id_parte) ON DELETE CASCADE;

INSERT INTO Login VALUES ('aritzGM', '1A');
INSERT INTO Login VALUES ('amaiaGP', '2B');
INSERT INTO Login VALUES ('jonFL', '3C');
INSERT INTO Login VALUES ('aneAS','4D');
INSERT INTO Login VALUES ('markelMR','5E');
INSERT INTO Login VALUES ('naiaAG','6F');
INSERT INTO Login VALUES ('nicolasMC','7G');
INSERT INTO Login VALUES ('leireMB','8H');
INSERT INTO Login VALUES ('aimarCB','9I');
INSERT INTO Login VALUES ('hodeiQP','0J');
INSERT INTO Login VALUES ('admin','admin');


INSERT INTO Centro VALUES ('111111111','Primero','945155636','01001','Alava','Vitoria-Gasteiz','calle Postas','7');
INSERT INTO Centro VALUES ('222222222','Segundo','943135619','03003','Pontevedra','Sanxenxo','calle Rua Castelao','13');
INSERT INTO Centro VALUES ('333333333','Tercero','941564578','01204','Madrid','Madrid','Gran Via','48');
INSERT INTO Centro VALUES ('444444444','Cuarto','947321465','06004','Sevilla','Sevilla','calle Ramon Carande','24');
INSERT INTO Centro VALUES ('555555555','Quinto','948257621','03507','Barcelona','Sabadell','carrer del Valles','30');
INSERT INTO Centro VALUES ('666666666','Sexto' ,'948666666','03508','Barcelona','Sabadell','carrer del Valles','30');


INSERT INTO Trabajador VALUES ('11111111A','Aritz','Garcia','Martinez','calle Perdida','1','1','Dcha','645783521','694525315','21/03/1990',999.99,'A','111111111','aritzGM');
INSERT INTO Trabajador VALUES ('22222222B','Amaia','Gomez','Pereda','calle Nula','4','2','Izqu','612785432','698452135','12/11/1895',999.99,'L','111111111','amaiaGP');
INSERT INTO Trabajador VALUES ('33333333C','Jon','Fernandez','Larrinoa','calle Salida','7','3','Dcha','678541235','698523214','02/09/1893',999.99,'A','222222222','jonFL');
INSERT INTO Trabajador VALUES ('44444444D','Ane','Anton','Salazar','calle Arriaga','11','4','Izqu','687521432','698532147','06/05/1892',999.99,'L','222222222','aneAS');
INSERT INTO Trabajador VALUES ('55555555E','Markel','Madina','Roldan','calle Alacala','15','5','Dcha','678521456','698632564','15/08/1890',999.99,'A','333333333','markelMR');
INSERT INTO Trabajador VALUES ('66666666F','Naia','Azkorreta','Gutierrez','calle Paz','1','6','Izqu','689452512','632124574','08/06/1998',999.99,'L','333333333','naiaAG');
INSERT INTO Trabajador VALUES ('77777777G','Nicolas','Masvidal','Cuesta','calle Erre','1','7','Dcha','645127898','632541278','16/09/1991',999.99,'A','444444444','nicolasMC');
INSERT INTO Trabajador VALUES ('88888888H','Leire','Munar','Bengoa','calle Zapa','1','8','Izqu','698572514','678523659','30/10/1995',999.99,'L','444444444','leireMB');
INSERT INTO Trabajador VALUES ('99999999I','Aimar','Corres','Bueno','calle Kutxi','1','9','Dcha','698542132','698632589','11/05/1993',999.99,'A','555555555','aimarCB');
INSERT INTO Trabajador VALUES ('00000000J','Hodei','Quintas','Prieto','calle Pinto','1','10','Izqu','698523258','689452132','26/08/1999',999.99,'L','555555555','hodeiQP');
INSERT INTO Trabajador VALUES ('admin','administrador','administrador','administrador','calle Pinto','3','10','Izqu','697523258','699452132','26/08/1998',999.99,'A','555555555','admin');

commit;

