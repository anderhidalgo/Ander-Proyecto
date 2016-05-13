# Ander-Proyecto

Ander Hidalgo - Jon Ander Vicente

Para crear el Modelo MER relacional hemos utilizado el Oracle Datamodeler Versión 4.1.1.888.

Para crear el Modelo Lógico hemos utilizado el Oracle SQLDeveloper Versión 4.1.1.19.

Para crear el Diagrama de clases hemos utilizado el Visual Paradigm 13.0. Para poder además visualizar el diagrama en cualquier ordernador lo hemos exportado en formato jpeg.

Para crear la aplicación de java hemos utilizado el IDE Netbeans 8.1.

La Base de Datos utilizada es Oracle Database Enterprise Edition Release 12.1.0.2.0.

//
//
// Despliegue de la aplicación
//
//

En SQLDeveloper abriremos y ejecutaremos el modelo lógico para crear primero la base de datos de oracle sobre la que trabajaremos.

Para hacer funcionar la aplicación importaremos el proyecto en Netbeans, al importar nos encontrara varios problemas ya que no encuentra las librerias utilizadas.

Debemos de acordarnos también de modificar el codigo del GenericoBD en el modelo segun nuestras necesidades, ya que en este caso tenemos la conexion con nuestra base de datos que es daw10.

Los campos que se modifican en el codigo son estos dos:           
  String user = "daw10";
  String pass = "daw10";

Las librerias las adjuntamos en el repositorio y son Datechooser.jar (para el datachoosercombo de fecha) y ojdbc6.jar (para la conexión de java con la base de datos oracle).

Una vez resuelto los problemas con las librerías ejecutaremos el programa en Netbeans. Esto nos llevara a la primera ventana que es Login. Tendremos que introducir un usuario y contraseña metido en la base de datos. Estos usuarios seran de administración o logística.

Para hacer una prueba hay creado un usuario admin con contraseña admin. Este usuario de prueba es de tipo administración, asi que es capaz de acceder a todo.

También se puede entrar por ejemplo con el usuario aritzGM con contraseña 1A que sería de administración o con amaiaGP con contraseña 2B que es de logística.

Para cualquier otra duda el enlace a nuestro blog semanal esta en el repositorio.
