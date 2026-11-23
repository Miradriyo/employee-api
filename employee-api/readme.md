# 👨‍💼 Employee API

![Java](https://shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![MySQL](https://shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

> 🚀 **API REST** desarrollada en **Java** con **Spring Boot** y **MySQL** para gestionar y consultar un listado de empleados junto con sus fotografías almacenadas internamente.

---

## 📋 Historias de Usuario y Criterios de Aceptación

### 🆔 HU-01: Listado de empleados en formato JSON

| Rol / Elemento | Descripción |
| :--- | :--- |
| 👤 **Como** | Consumidor de la API (cliente / frontend) |
| 🎯 **Quiero** | Realizar una petición `GET` al endpoint `/employees` |
| 💡 **Para** | Obtener el listado completo de empleados con su `id`, `nombre`, `email` y la URL de su fotografía en formato JSON |

#### ✅ Criterios de Aceptación (Gherkin)

```gherkin
Escenario 1: Consulta exitosa del listado de empleados
  Given que existen empleados registrados en la base de datos employee_db
  When realizo una petición GET al endpoint http://localhost:8080/employees
  Then el sistema responde con código de estado 200 OK
  And devuelve un array en formato JSON donde cada objeto contiene id, name, email y photoUrl con formato http://localhost:8080/employees/{id}/foto
```
### 💾 HU-02: Carga inicial de 10 empleados en base de datos

| Rol / Elemento | Descripción |
| :--- | :--- |
| 🛠️ **Como** | Desarrollador / administrador del sistema |
| 🎯 **Quiero** | Que la aplicación precargue automáticamente 10 empleados con sus datos y rutas de imagen en la base de datos al iniciar si esta se encuentra vacía |
| 💡 **Para** | Disponer de datos de prueba inmediatos sin tener que insertarlos manualmente ni habilitar un endpoint de subida |

#### ✅ Criterios de Aceptación (Gherkin)

```gherkin
Escenario 1: Precarga automática al iniciar con la tabla vacía
  Given que la tabla de empleados en la base de datos está vacía al arrancar la aplicación Spring Boot
  When la aplicación termina de inicializarse
  Then se insertan automáticamente 10 empleados de prueba con sus datos y rutas internas de imagen asociadas

Escenario 2: Evitar duplicados en reinicios posteriores
  Given que la tabla de empleados ya contiene registros en la base de datos
  When se reinicia la aplicación Spring Boot
  Then no se vuelven a insertar los 10 empleados de prueba para evitar duplicados

---

### 💾 HU-02: Carga inicial de 10 empleados en base de datos

| Rol / Elemento | Descripción |
| :--- | :--- |
| 🛠️ **Como** | Desarrollador / administrador del sistema |
| 🎯 **Quiero** | Que la aplicación precargue automáticamente 10 empleados con sus datos y rutas de imagen en la base de datos al iniciar si esta se encuentra vacía |
| 💡 **Para** | Disponer de datos de prueba inmediatos sin tener que insertarlos manualmente ni habilitar un endpoint de subida |

#### ✅ Criterios de Aceptación (Gherkin)

```gherkin
Escenario 1: Precarga automática al iniciar con la tabla vacía
  Given que la tabla de empleados en la base de datos está vacía al arrancar la aplicación Spring Boot
  When la aplicación termina de inicializarse
  Then se insertan automáticamente 10 empleados de prueba con sus datos y rutas internas de imagen asociadas

Escenario 2: Evitar duplicados en reinicios posteriores
  Given que la tabla de empleados ya contiene registros en la base de datos
  When se reinicia la aplicación Spring Boot
  Then no se vuelven a insertar los 10 empleados de prueba para evitar duplicados
```

---

### 🖼️ HU-03: Obtención de la fotografía de cada empleado

| Rol / Elemento | Descripción |
| :--- | :--- |
| 👤 **Como** | Consumidor de la API (cliente / frontend) |
| 🎯 **Quiero** | Acceder a la URL de la imagen de un empleado específico (`/employees/{id}/foto`) |
| 💡 **Para** | Visualizar o descargar la fotografía almacenada y gestionada internamente por Spring Boot |

#### ✅ Criterios de Aceptación (Gherkin)

```gherkin
Escenario 1: Consulta exitosa de la imagen de un empleado existente
  Given que existe un empleado con un id válido y una imagen almacenada en los recursos internos de Spring Boot
  When realizo una petición GET a http://localhost:8080/employees/{id}/foto
  Then el sistema responde con código de estado 200 OK y devuelve el archivo de imagen correspondiente

Escenario 2: Consulta de imagen de un empleado inexistente
  Given que no existe ningún empleado con el id solicitado
  When realizo una petición GET a http://localhost:8080/employees/{id}/foto
  Then el sistema responde con código de estado 404 Not Found
```