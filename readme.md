# Crud En Spring

Esta es mi primera vez utilizando las tecnologías de spring, donde use un patrón de diseño repositorio y cree el crud de Stores y Productos.

Esta cuenta con dos entidades que son:


  -Store
  
  -Producto

  
Estas cuenta con los Repository y las relaciones many to many creando una tabla intermedia donde se haran las querys, ademas para la flexibilidad y la creacion de las bases de datos utilice un ORM de forma que sea mas facil de desplegar el proyecto, creando la conexion en algun gestor de base de datos (en mi caso DBeaver).

Ademas para los filters de las querys utilice un CriteriaBuilder.
