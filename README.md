# Proyecto de Gestión de Biblioteca en Java

Este proyecto tiene como objetivo implementar una aplicación de gestión de biblioteca en Java, utilizando Access como base de datos.

Durante el desarrollo de este proyecto, el instructor nos impuso una restricción que prohíbe la impresión dentro de los métodos. Esto ha aumentado la complejidad de la lectura del código en el método `main`.

## Descripción

La aplicación permite a los usuarios registrarse en el sistema proporcionando su información personal, como nombre, apellido, dirección, número de teléfono y correo electrónico. Una vez registrados, los usuarios pueden acceder al catálogo de la biblioteca y buscar libros por título, autor o género, y verificar su disponibilidad.

Los bibliotecarios tienen acceso adicional para registrar préstamos y devoluciones de libros, manteniendo un registro actualizado de las fechas de retiro y devolución. Además, el sistema envía notificaciones a los usuarios recordando las fechas de devolución próximas (Se nos indicó que no se realizará el envio de notififaciones).

La aplicación también es capaz de generar informes periódicos sobre el uso de la biblioteca, incluyendo la cantidad de préstamos realizados, los libros más populares y los usuarios con más préstamos.

## Diseño de las tablas en la base de datos

Para almacenar los datos, se ha utilizado una base de datos Access con el siguiente diseño de tablas:

**Tabla "Libros":**
- idLibro (clave primaria)
- título (texto)
- autor (texto)
- género (texto)
- ISBN (texto)
- fechaPublicación (fecha)
- editorial (texto)

**Tabla "Usuarios":**
- idUsuario (clave primaria)
- nombre (texto)
- apellido (texto)
- dirección (texto)
- teléfono (texto)
- correoElectrónico (texto)

**Tabla "Préstamos":**
- idPréstamo (clave primaria)
- idLibro (clave externa hacia la tabla "Libros")
- idUsuario (clave externa hacia la tabla "Usuarios")
- fechaPréstamo (fecha)
- fechaDevolución (fecha)
