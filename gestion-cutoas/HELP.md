# Sistema de Gestión de Cuotas para Club Deportivo (API REST)

## Descripción General

Este proyecto consiste en el desarrollo de una API RESTful utilizando Spring Boot para gestionar las cuotas de los socios de un club deportivo. La API permitirá realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre la información de los socios, las cuotas generadas, los pagos realizados y la gestión de las tarifas de las cuotas.

## Requisitos Funcionales

1.  **Gestión de Socios:**
    * Crear nuevos socios con información básica (nombre, apellido, número de socio único, fecha de alta, email, teléfono).
    * Obtener la lista de todos los socios.
    * Obtener los detalles de un socio específico por su ID.
    * Actualizar la información de un socio existente.
    * Eliminar un socio.
    * Implementar paginación y ordenamiento para la lista de socios.
    * Permitir la búsqueda de socios por nombre o número de socio utilizando query parameters.

2.  **Gestión de Tarifas de Cuotas:**
    * Crear nuevas tarifas de cuotas (descripción, monto mensual).
    * Obtener la lista de todas las tarifas.
    * Obtener los detalles de una tarifa específica por su ID.
    * Actualizar una tarifa existente.
    * Eliminar una tarifa.

3.  **Generación de Cuotas:**
    * Generar automáticamente las cuotas mensuales para todos los socios activos en una fecha específica.
    * Cada cuota debe estar asociada a un socio, un mes/año y una tarifa.
    * Debe tener un estado (pendiente, pagada, vencida).
    * Permitir la generación manual de cuotas para un socio específico.

4.  **Gestión de Pagos:**
    * Registrar el pago de una cuota específica, indicando la fecha de pago y el método de pago.
    * Actualizar el estado de la cuota a "pagada" al registrar un pago.
    * Obtener el historial de pagos de un socio específico.

5.  **Importación de Socios por CSV:**
    * Implementar un endpoint para cargar un archivo CSV con la información de nuevos socios.
    * El archivo CSV debe tener un formato específico (definir las columnas).
    * Validar los datos del CSV antes de la inserción en la base de datos.

## Requisitos Técnicos y Temas a Practicar

1.  **Spring Boot Web App Dependency Injection:**
    * Configurar un proyecto Spring Boot.
    * Utilizar la inyección de dependencias para los diferentes componentes (servicios, repositorios, controladores).
    * Aplicar principios SOLID en el diseño de las clases y la arquitectura.
    * Comprender y utilizar el Spring Context para la gestión de los beans.

2.  **Restful Web Services: HTTP Protocol, RESTFul services:**
    * Diseñar una API RESTful siguiendo las convenciones de HTTP (métodos, códigos de estado).
    * Utilizar JSON como formato de intercambio de datos.

3.  **Lombok:**
    * Utilizar Lombok para reducir la cantidad de código boilerplate (getters, setters, constructores, etc.).

4.  **Spring MVC Rest Services: CRUD + Patch, with Postman:**
    * Implementar controladores REST para exponer los endpoints de gestión de socios, tarifas, cuotas y pagos.
    * Implementar operaciones CRUD completas para cada entidad.
    * Utilizar el método HTTP PATCH para actualizaciones parciales de recursos.
    * Probar la API utilizando Postman.

5.  **Spring MockMVC Test with Mockito and JUnit: tests for repositories, controllers, services:**
    * Escribir pruebas unitarias para los servicios utilizando JUnit y Mockito para simular las dependencias (repositorios).
    * Escribir pruebas de integración para los controladores utilizando Spring MockMvc para simular peticiones HTTP y verificar las respuestas.
    * Escribir pruebas para los repositorios utilizando la infraestructura de testing de Spring Data JPA.

6.  **Exception Handling with Spring MVC: global exception handler:**
    * Implementar un manejo de excepciones robusto.
    * Crear excepciones personalizadas para diferentes escenarios de error (recurso no encontrado, validación fallida, etc.).
    * Implementar un `GlobalExceptionHandler` para centralizar el manejo de excepciones y devolver respuestas HTTP apropiadas con mensajes de error claros.

7.  **Spring Data JPA with Spring MVC: DTO, Mapper, Controller Integration Tests:**
    * Utilizar Spring Data JPA para interactuar con la base de datos.
    * Definir entidades JPA que representen las tablas de la base de datos (Socio, Tarifa, Cuota, Pago).
    * Crear Data Transfer Objects (DTOs) para la transferencia de datos entre la API y la capa de servicio, evitando exponer directamente las entidades.
    * Implementar mappers (manualmente o utilizando una librería como MapStruct) para convertir entre entidades y DTOs.
    * Escribir pruebas de integración para los controladores que involucren la capa de persistencia.

8.  **Data Validation with Spring: data validation, java bean, controller binding, controller testing with jpa:**
    * Utilizar las anotaciones de validación de Java Bean (`@NotNull`, `@NotEmpty`, `@Email`, `@Min`, `@Max`, etc.) para validar los datos de entrada en los DTOs.
    * Asegurar que la validación se realice al recibir las peticiones en los controladores (`@Valid`).
    * Implementar pruebas unitarias para verificar la correcta validación en los controladores.

9.  **MySQL with Spring Boot: MySQL dependencies, schema script generation:**
    * Configurar la conexión a una base de datos MySQL utilizando las dependencias necesarias en `pom.xml` o `build.gradle`.
    * Crear un script SQL (`schema.sql`) para definir el esquema de la base de datos (tablas, relaciones, índices).

10. **Flyway Migrations with Spring Boot: script configuration:**
    * Integrar Flyway para gestionar las migraciones de la base de datos.
    * Configurar Flyway en la aplicación Spring Boot.
    * Crear scripts de migración (en la carpeta `db/migration`) para la creación inicial del esquema y futuras modificaciones.

11. **Test Containers with Spring Boot: spring boot Docker compose:**
    * Utilizar Testcontainers para levantar una instancia de MySQL en un contenedor Docker durante las pruebas de integración.
    * Configurar Spring Boot para conectarse a la instancia de MySQL gestionada por Testcontainers.
    * (Opcional) Utilizar Docker Compose para gestionar múltiples contenedores si fuera necesario en el futuro.

12. **CSV File Uploads; mapping with opencsv, csv data to database:**
    * Implementar un endpoint que permita recibir un archivo CSV.
    * Utilizar la librería `opencsv` para leer y parsear el contenido del archivo CSV.
    * Mapear las filas del CSV a objetos DTO o entidades para su posterior persistencia en la base de datos.
    * Implementar validaciones para los datos leídos del CSV.

13. **Query Parameters with Spring MVC:**
    * Implementar la funcionalidad de búsqueda de socios por nombre o número de socio utilizando query parameters en el endpoint de listado de socios.

14. **Paging and Sorting with Spring MVC:**
    * Implementar la paginación y el ordenamiento en el endpoint de listado de socios utilizando Spring Data JPA (`Pageable`).
    * Permitir a los clientes especificar el número de página y el tamaño de la página, así como el campo por el cual ordenar y la dirección del orden.

15. **JPA Database Relationship Mappings:**
    * Definir las relaciones entre las entidades de la base de datos utilizando las anotaciones de JPA (`@OneToMany`, `@ManyToOne`, `@ManyToOne`, `@JoinColumn`, etc.).
    * Asegurar la correcta persistencia y recuperación de los datos relacionados. Por ejemplo:
        * Un Socio puede tener muchas Cuotas.
        * Una Cuota pertenece a un Socio y está asociada a una Tarifa.
        * Un Pago está asociado a una Cuota.

## Estructura Sugerida del Proyecto

src/
├── main/
│   ├── java/
│   │   └── com/tuproyecto/clubdeportivo/
│   │       ├── controller/
│   │       │   ├── SocioController.java
│   │       │   ├── TarifaController.java
│   │       │   ├── CuotaController.java
│   │       │   └── PagoController.java
│   │       ├── dto/
│   │       │   ├── SocioDTO.java
│   │       │   ├── TarifaDTO.java
│   │       │   ├── CuotaDTO.java
│   │       │   └── PagoDTO.java
│   │       ├── entity/
│   │       │   ├── Socio.java
│   │       │   ├── Tarifa.java
│   │       │   ├── Cuota.java
│   │       │   └── Pago.java
│   │       ├── exception/
│   │       │   ├── ResourceNotFoundException.java
│   │       │   └── GlobalExceptionHandler.java
│   │       ├── mapper/
│   │       │   ├── SocioMapper.java
│   │       │   ├── TarifaMapper.java
│   │       │   ├── CuotaMapper.java
│   │       │   └── PagoMapper.java
│   │       ├── repository/
│   │       │   ├── SocioRepository.java
│   │       │   ├── TarifaRepository.java
│   │       │   ├── CuotaRepository.java
│   │       │   └── PagoRepository.java
│   │       ├── service/
│   │       │   ├── SocioService.java
│   │       │   ├── TarifaService.java
│   │       │   ├── CuotaService.java
│   │       │   └── PagoService.java
│   │       └── ClubDeportivoApplication.java
│   └── resources/
│       ├── application.properties
│       └── db/
│           ├── migration/
│           └── schema.sql
└── test/
├── java/
│   └── com/tuproyecto/clubdeportivo/
│       ├── controller/
│       │   ├── SocioControllerIntegrationTest.java
│       │   ├── TarifaControllerIntegrationTest.java
│       │   ├── CuotaControllerIntegrationTest.java
│   │       │   └── PagoControllerIntegrationTest.java
│       ├── repository/
│       │   ├── SocioRepositoryTest.java
│       │   ├── TarifaRepositoryTest.java
│       │   ├── CuotaRepositoryTest.java
│       │   └── PagoRepositoryTest.java
│       ├── service/
│       │   ├── SocioServiceTest.java
│       │   ├── TarifaServiceTest.java
│       │   ├── CuotaServiceTest.java
│       │   └── PagoServiceTest.java
│       └── ClubDeportivoApplicationTests.java
└── resources/
└── application-test.properties


## Lógica de Negocio y Contexto del Sistema de Gestión de Cuotas

**El Corazón del Club: Gestión de Cuotas para una Operativa Financiera Robusta**

El presente sistema se concibe como una API RESTful robusta y eficiente, diseñada para la administración integral de las obligaciones financieras de los socios de un club deportivo. Su propósito fundamental radica en optimizar la gestión de cuotas, proporcionando las herramientas necesarias para el registro, seguimiento y control de los pagos, contribuyendo así a la estabilidad económica de la institución.

**Actores y Roles en el Ecosistema del Sistema:**

El sistema involucra principalmente dos actores clave: los **socios del club** y el **personal administrativo**.

* **Socios del Club:** Representan la base de la organización. Cada socio posee un registro digital único que almacena información personal relevante, la fecha de su incorporación y el historial de las cuotas asociadas a su membresía. Su interacción con el sistema es principalmente a través de los pagos que efectúan. Si bien la presente implementación se centra en una API, en un escenario con interfaz de usuario, los socios podrían acceder a su estado de cuenta y realizar pagos de forma autónoma.

* **Personal Administrativo:** Actúa como el usuario primario de esta API. A través de los endpoints expuestos, el personal puede ejecutar las siguientes funciones críticas:
    * **Alta de Socios:** Registrar nuevos miembros en el sistema, asignando un identificador único y documentando la fecha de afiliación.
    * **Gestión de Tarifas:** Definir y mantener las diferentes categorías de cuotas (ej. estándar, familiar, juvenil) con sus respectivos importes periódicos. Estas tarifas sirven como referencia para la generación de las obligaciones de pago.
    * **Generación de Cuotas:** Automatizar o realizar de forma manual la creación de los registros de cuotas para cada socio activo en un período específico (típicamente mensual). Cada cuota se vincula al socio, al período de facturación y a la tarifa aplicable, estableciendo inicialmente un estado "pendiente".
    * **Registro de Pagos:** Documentar la recepción de los pagos realizados por los socios, incluyendo la fecha y el método utilizado, lo que conlleva la actualización del estado de la cuota a "pagada".
    * **Mantenimiento de Datos:** Actualizar la información personal de los socios cuando sea necesario y gestionar las tarifas de las cuotas (creación, modificación, eliminación).
    * **Importación Masiva:** Facilitar la incorporación de múltiples socios al sistema mediante la carga estructurada de datos a través de archivos CSV, agilizando procesos de alta a gran escala.

**Flujo de la Lógica de Negocio:**

La operativa central del sistema gira en torno a la gestión del ciclo de vida de las cuotas. Inicialmente, se definen las **Tarifas**, las cuales constituyen el marco económico para las obligaciones de los socios. Periódicamente, el sistema orquesta la **Generación de Cuotas**, creando registros individuales para cada **Socio** activo, asociando la tarifa correspondiente al período en curso. Estas cuotas se marcan inicialmente como "pendientes".

Cuando un **Socio** cumple con su obligación financiera, el **Personal Administrativo** registra el **Pago** en el sistema, vinculándolo a la **Cuota** específica y modificando su estado a "pagada". El sistema mantiene un historial detallado de los pagos por cada socio, ofreciendo una trazabilidad completa de sus transacciones.

La arquitectura del sistema se fundamenta en las relaciones entre las entidades: un **Socio** puede generar múltiples **Cuotas** a lo largo de su membresía. Cada **Cuota** está intrínsecamente ligada a un único **Socio** y se basa en una **Tarifa** predefinida. Finalmente, cada **Pago** se asocia inequívocamente a una **Cuota**, cerrando el ciclo de la transacción financiera.

**Contexto y Valor Estratégico:**

Aunque concebido como una API sin interfaz gráfica en su fase inicial, este sistema de gestión de cuotas establece una infraestructura digital esencial para la administración financiera eficiente del club deportivo. La automatización de la generación de cuotas y la simplificación del registro de pagos minimizan la probabilidad de errores operativos y optimizan el tiempo del personal administrativo, permitiéndoles enfocar sus esfuerzos en actividades de mayor valor estratégico para el club.

La centralización y la organización de la información financiera proporcionan una visión clara y precisa de la salud económica del club, facilitando la identificación de tendencias, la gestión de posibles morosidades y la toma de decisiones fundamentadas para la planificación y el crecimiento futuro de la institución.

En conclusión, esta API representa un componente fundamental para la operatividad del club deportivo, ofreciendo una solución tecnológica para la gestión transparente y eficiente de las contribuciones de sus socios, quienes son el activo más valioso de la organización. A través de las funcionalidades implementadas, se busca optimizar la experiencia tanto del personal administrativo como de los socios, contribuyendo a la sostenibilidad y al éxito continuo del club.