# DERRAP

**DERRAP** es una aplicación de escritorio desarrollada en **Java** con **Swing**, orientada a la gestión de un taller mecánico.  
El proyecto permite controlar la información de clientes, mecánicos, vehículos, órdenes de trabajo, stock de repuestos y facturas, diferenciando además el acceso según el rol del usuario.

---

## Índice

- [Descripción del proyecto](#descripción-del-proyecto)
- [Funcionalidades principales](#funcionalidades-principales)
- [Tecnologías utilizadas](#tecnologías-utilizadas)
- [Arquitectura general](#arquitectura-general)
- [Flujo de la aplicación](#flujo-de-la-aplicación)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Base de datos](#base-de-datos)
- [Instalación y ejecución](#instalación-y-ejecución)
- [Autor](#autor)

---

## Descripción del proyecto

DERRAP es una aplicación de escritorio para la gestión interna de un taller mecánico.  
La aplicación centraliza la información operativa del negocio y permite trabajar con distintos módulos desde una interfaz gráfica desarrollada con Java Swing.

El sistema organiza la gestión en varios bloques:

- autenticación de usuarios,
- gestión de clientes,
- gestión de mecánicos,
- gestión de vehículos,
- control de órdenes de trabajo,
- consulta de stock,
- consulta y generación de facturas.

La aplicación distingue entre distintos perfiles de acceso, cargando una interfaz diferente según el rol del usuario autenticado.

---

## Funcionalidades principales

### Inicio de sesión y control de acceso
- Inicio de sesión mediante usuario y contraseña.
- Validación de credenciales contra la base de datos.
- Carga de la interfaz correspondiente según el rol del usuario.
- Separación del acceso entre administrador y mecánico.

### Panel de administrador
El perfil de administrador dispone de un panel principal desde el que puede gestionar la información general del taller.

#### Gestión de clientes
- Consulta del listado de clientes.
- Inserción de nuevos clientes.
- Actualización de datos existentes.
- Búsqueda de clientes.

#### Gestión de mecánicos
- Consulta del listado de mecánicos.
- Alta de mecánicos.
- Actualización de datos.
- Baja lógica de mecánicos mediante cambio de estado.

#### Gestión de vehículos
- Consulta del listado de vehículos.
- Alta de vehículos.
- Modificación de información asociada al vehículo.
- Búsqueda por matrícula.

#### Gestión de órdenes
- Consulta del listado de órdenes de trabajo.
- Creación y modificación de órdenes.
- Eliminación de órdenes.
- Asociación de órdenes a vehículos.

#### Gestión de stock
- Consulta del stock de repuestos.
- Inserción de nuevos repuestos.
- Actualización de precios.

#### Gestión de facturas
- Consulta de facturas generadas.
- Visualización de información relacionada con matrícula y cliente.
- Generación de informes en PDF.

### Panel de mecánico
El perfil de mecánico dispone de una interfaz centrada en su trabajo diario dentro del taller.

#### Consulta de órdenes
- Visualización de órdenes disponibles.
- Consulta de órdenes asignadas al mecánico autenticado.
- Actualización del estado de las órdenes.

#### Gestión de trabajo asignado
- Asignación de una orden al mecánico.
- Cancelación de una orden asignada.
- Finalización de órdenes de trabajo.

#### Consulta operativa
- Consulta de stock de repuestos.
- Consulta de facturas relacionadas con sus órdenes.

---

## Tecnologías utilizadas

### Lenguaje y entorno
- **Java**
- **Java Swing**
- **Eclipse Project Structure** (`.project` y `.classpath`)

### Acceso a datos
- **JDBC**
- **MySQL**
- **MySQL Connector/J 8.0.30**

### Generación de documentos
- **iText 9**
- Generación de informes PDF a partir de la información de las órdenes.

### Recursos visuales
- Imágenes e iconos locales utilizados en la interfaz.
- Navegación entre vistas mediante paneles y `CardLayout`.

---

## Arquitectura general

El proyecto está organizado por paquetes según la responsabilidad de cada módulo.

### Paquete `Inicio`
Contiene la lógica de acceso inicial a la aplicación.

- **`InicioDeSesion.java`**  
  Gestiona la ventana de login y redirige al panel correspondiente según el rol.

- **`ConexionMySQL.java`**  
  Centraliza la conexión con la base de datos y las operaciones de consulta, inserción, actualización y eliminación.

### Paquete `Admin`
Agrupa las pantallas y operaciones disponibles para el perfil administrador.

- **`HomeAdmin.java`**  
  Ventana principal del administrador con acceso a clientes, mecánicos, vehículos, órdenes, stock y facturas.

- **`InsertCliente.java`**  
  Alta y edición de clientes.

- **`InsertMecanico.java`**  
  Alta y edición de mecánicos.

- **`InsertVehiculo.java`**  
  Alta y edición de vehículos.

- **`InsertOrdenes.java`**  
  Alta y edición de órdenes de trabajo.

- **`InsertStock.java`**  
  Inserción de repuestos en stock.

- **`DeleteMecanico.java`**  
  Gestión de baja lógica de mecánicos.

- **`DeleteOrdenes.java`**  
  Eliminación de órdenes.

- **`FacturaInfo.java`**  
  Pantalla de generación de informe de factura.

- **`FacturaPDF.java`**  
  Clase encargada de construir el documento PDF.

### Paquete `Mecanico`
Incluye las ventanas orientadas al trabajo del mecánico.

- **`HomeMecanico.java`**  
  Panel principal del mecánico con acceso a órdenes, stock, facturas y órdenes personales.

- **`UpdateMisOrdenes.java`**  
  Gestión de acciones sobre órdenes asignadas.

---

## Flujo de la aplicación

### 1. Acceso al sistema
El usuario inicia sesión desde la ventana principal introduciendo su identificador y contraseña.

### 2. Validación de rol
La aplicación consulta la base de datos y determina el perfil del usuario autenticado.

### 3. Redirección a la interfaz correspondiente
- Si el usuario tiene rol de **administrador**, accede al panel de administración.
- Si el usuario tiene rol de **mecánico**, accede al panel de trabajo del mecánico.

### 4. Gestión operativa
Desde cada panel se muestran las opciones disponibles según el perfil:

#### Flujo de administrador
- consulta datos,
- inserta nuevos registros,
- actualiza información,
- elimina o da de baja elementos,
- consulta facturas,
- genera informes PDF.

#### Flujo de mecánico
- consulta órdenes disponibles,
- se asigna órdenes,
- visualiza sus órdenes,
- cancela o finaliza órdenes,
- revisa stock y facturas.

---

## Estructura del proyecto

```text
DERRAP/
├── Practica Swing/
│   ├── src/
│   │   ├── Inicio/
│   │   │   ├── ConexionMySQL.java
│   │   │   └── InicioDeSesion.java
│   │   ├── Admin/
│   │   │   ├── HomeAdmin.java
│   │   │   ├── InsertCliente.java
│   │   │   ├── InsertMecanico.java
│   │   │   ├── InsertVehiculo.java
│   │   │   ├── InsertOrdenes.java
│   │   │   ├── InsertStock.java
│   │   │   ├── DeleteMecanico.java
│   │   │   ├── DeleteOrdenes.java
│   │   │   ├── FacturaInfo.java
│   │   │   └── FacturaPDF.java
│   │   ├── Mecanico/
│   │   │   ├── HomeMecanico.java
│   │   │   └── UpdateMisOrdenes.java
│   │   └── img/
│   ├── lib/
│   │   └── mysql-connector-java-8.0.30.jar
│   └── Ordenes_Report.pdf
├── Script BBDD y Inserts.sql
└── Derrap.mwb
```

---

## Base de datos

El proyecto trabaja con una base de datos MySQL llamada **`derrap`**.

El repositorio incluye un script SQL con la estructura base y datos de ejemplo para distintas entidades del sistema, como:

- clientes,
- vehículos,
- mecánicos,
- facturas,
- repuestos,
- proveedores,
- servicios,
- usuarios.

La conexión con la base de datos se realiza mediante JDBC desde la clase `ConexionMySQL`.

---

## Instalación y ejecución

### Requisitos
- Java
- Eclipse o un IDE compatible con proyectos Java
- MySQL
- Librerías necesarias configuradas en el proyecto

### Pasos básicos
1. Clonar el repositorio.
2. Importar el proyecto en Eclipse.
3. Crear la base de datos `derrap`.
4. Ejecutar el script `Script BBDD y Inserts.sql`.
5. Revisar la configuración de conexión en `ConexionMySQL.java`.
6. Añadir correctamente las librerías externas del proyecto.
7. Ejecutar la clase `InicioDeSesion.java`.

---

## Autor

**AsdDev73**  
Proyecto desarrollado como trabajo académico de desarrollo de interfaces.
