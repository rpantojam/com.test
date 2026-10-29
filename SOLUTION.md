# Cambios realizados
En el proyecto se realizaron los siguientes cambios:

* Se implementó base de datos mysql en lugar la existente sql server por cuestiones de disponibilidad
* Se implementó documentación swagger.
* Se implementó control de excepciones para manejar el caso de cliente no existente.
* Se implementó el API de eliminación del cliente

# Decisiones Técnicas

### Base de datos
Se optó por cambiar el motor de base de datos a MySQL debido a que es con la cual cuento con mayor experiencia y disponbilidad en mi equipo.

### Swagger
Se implementó la documentación con Swagger debido a que el ejercicio así lo plantea, documentando el controller y sus tres métodos.

### Repositorio
Se incluye interfaz que hereda de JpaRepository para que el cambio de motor de BD funcione correctamente.

### Estructura del proyecto
No se realizaron mayores cambios en la estructura de directorios ya que respeta de cierto modo lo que dictan las arquitecturas limpias. Se agregaron dos módulos para el manejo de excepciones y configuraciones.

# Dificultades Encontradas
* En el momento del primer despliegue el IDE se tardó un poco más de lo previsto ya que el proyecto necesitaba construirse para IntelliJ que es mi IDE de preferencia.
* Se presentó un error de compilación que correspondía a la versión de lombok usada, se especificó el número de versión funcional en el pom.

# Mejoras adicionales a futuro
* Protección de las APIS con token de acceso para evitar pérdida de información.
* Validación de los campos del body para evitar que se violen las restricciones de campos de la base de datos.
* Mejora de las respuestas en casos negativos, como por ejemplo, en caso de que no se pueda crear el usuario.
* Centralizaría el tema del CORS en un archivo de configuración para evitar hacerlo API por API.

# Items pendientes
* No me alcanzó el tiempo para realizar la parte del frontEnd.
* No realicé varios commits debido a que esa parte la leí cuanddo ya tenía el ejercicio del backend finalizado.