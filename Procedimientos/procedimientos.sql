--------------------------------------------------------
-- Archivo creado  - miércoles-marzo-23-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Package FASE3
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE PACKAGE "DAW10"."FASE3" IS

  type g_cursor is ref cursor;
  
  PROCEDURE VER_TRABAJADOR_DNI(P_DNI IN TRABAJADOR.DNI%TYPE, T_CURSOR OUT g_cursor);
  PROCEDURE VER_CENTROS(T_CURSOR OUT g_cursor);
  PROCEDURE VER_TRABAJADORES(P_ID_CENTRO IN CENTRO.ID_CENTRO%TYPE, T_CURSOR OUT g_cursor);

END FASE3;

/
