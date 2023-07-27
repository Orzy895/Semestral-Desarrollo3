Proyecto Semestral de Desarrollo de Software III

Proyecto realizado usando Java y Access

Enunciado del Problema:

Se solicita el diseño y desarrollo de una aplicación de gestión de biblioteca que proporcione una interfaz intuitiva y amigable tanto para los usuarios como para los bibliotecarios. Además, se desea llevar un registro actualizado de los libros disponibles, así como de los préstamos realizados.
Los usuarios de la biblioteca podrán registrarse en el sistema proporcionando su información personal, como nombre, apellido, dirección, número de teléfono y correo electrónico. Una vez registrados, podrán acceder al catálogo de la biblioteca y buscar libros de interés por título, autor o género, podrá verificar su disponibilidad.
El sistema debe permitir a los bibliotecarios registrar los préstamos y devoluciones, especificando la fecha de retiro o devoluciones. Enviar notificaciones a los usuarios sobre fechas de devolución próximas.
Además, se desea generar informes periódicos sobre el uso de la biblioteca, como la cantidad de préstamos realizados, los libros más populares y los usuarios con más préstamos.

Diseño de las tablas a utilizar:

Tabla "Libros":
• idLibro (clave primaria)
• título (texto)
• autor (texto)
• género (texto)
• ISBN (texto)
• fechaPublicación (fecha)
• editorial (texto)

Tabla "Usuarios":
• idUsuario (clave primaria)
• nombre (texto)
• apellido (texto)
• dirección (texto)
• teléfono (texto)
• correoElectrónico (texto)

Tabla "Préstamos":
• idPréstamo (clave primaria)
• idLibro (clave externa hacia la tabla "Libros")
• idUsuario (clave externa hacia la tabla "Usuarios")
• fechaPréstamo (fecha)
• fechaDevolución (fecha)
