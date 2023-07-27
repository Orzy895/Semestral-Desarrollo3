# Proyecto Semestral de Desarrollo de Software III

Este es un proyecto de gestión de biblioteca desarrollado en Java y utilizando Access como base de datos.
Durante este curso, el/la instructor nos había prohibido la impresión dentro de los métodos y por ello la complejidad de la lectura del main.

## Enunciado del Problema

El objetivo de este proyecto es crear una aplicación que permita gestionar una biblioteca de manera eficiente y brinde una experiencia intuitiva tanto para los usuarios como para los bibliotecarios. Entre las funcionalidades principales se encuentran:

- Registro de usuarios: Los usuarios podrán registrarse proporcionando su información personal, incluyendo nombre, apellido, dirección, número de teléfono y correo electrónico.
- Catálogo de libros: Los usuarios podrán acceder al catálogo de la biblioteca y buscar libros por título, autor o género para verificar su disponibilidad.
- Préstamos y devoluciones: Los bibliotecarios podrán registrar los préstamos y devoluciones de libros, especificando las fechas correspondientes.
- Notificaciones (Se nos indicó que no se realizara esta función): El sistema enviará notificaciones a los usuarios sobre fechas de devolución próximas.
- Informes periódicos: Se generarán informes periódicos que incluyan datos como la cantidad de préstamos realizados, los libros más populares y los usuarios con más préstamos.

## Diseño de las tablas a utilizar

El diseño de las tablas en la base de datos Access será el siguiente:

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

