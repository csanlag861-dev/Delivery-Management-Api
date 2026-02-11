# 📦 Delivery Management REST API

API REST desarrollada con Java y Spring Boot que simula la gestión de una distribuidora logística.

Este proyecto ha sido mi primera toma de contacto con el desarrollo backend moderno y me permitió comprender cómo funcionan las APIs REST, el modelado de entidades y las reglas de negocio en un sistema real.

---

## 🚀 Tecnologías utilizadas

- Java
- Spring Boot
- Maven
- H2 Database (base de datos en memoria)
- Bruno (testing de endpoints)

---

## 📌 Descripción del proyecto

La API modela el funcionamiento de una distribuidora que gestiona:

- Conductores
- Productos
- Repartos
- Distribuidoras

---

## 🧠 Lógica de negocio implementada

El sistema incluye reglas como:

- Una distribuidora tiene múltiples conductores.
- Un conductor puede tener un reparto asignado.
- Si el conductor está ocupado, no puede recibir otro reparto.
- Los repartos pueden tener distintos estados:
  - En tránsito
  - Finalizado
  - Pendiente
- Cuando un conductor completa 3 repartos, se le asigna automáticamente un período de descanso.

Este proyecto me permitió entender:

- Arquitectura REST
- Códigos de estado HTTP
- Relaciones entre entidades (OneToMany, ManyToOne)
- Controladores, servicios y repositorios en Spring
- Separación de responsabilidades
- Validación básica de reglas de negocio

---

## 📂 Estructura del proyecto

El proyecto sigue una arquitectura en capas:

- **Controller** → Gestión de endpoints REST
- **Service** → Lógica de negocio
- **Repository** → Acceso a datos
- **Model** → Entidades JPA

---

## 🧪 Testing de Endpoints

Los endpoints fueron probados utilizando Bruno para validar:

- Códigos HTTP
- Respuestas JSON
- Reglas de negocio

---

## ▶️ Cómo ejecutar el proyecto

1. Clonar el repositorio
2. Ejecutar:

```bash
mvn spring-boot:run
```
3. Acceder a la base de datos H2:
http://localhost:8080/h2-console
