# Package com.example.practica5deportes
# Guía de Referencia - Aplicación Deportes

## Descripción Técnica

Esta sección proporciona una visión técnica detallada sobre cómo está construida la aplicación Deportes.

### Instalación

Sigue los pasos detallados en el [Manual de Instalación](Manual_de_instalacion.md).

### Arquitectura

La aplicación sigue una arquitectura basada en componentes reutilizables y modulares.

### Estructura del Proyecto

- `MainActivity`: Clase principal que maneja la interacción del usuario.
- `TarjetaDeportes`: Representa un deporte.
- `TarjetaDeportesAdapter`: Adaptador para manejar la visualización de deportes en un RecyclerView.

## APIs y Endpoints

### Endpoints Disponibles

- **GET /api/deportes**: Obtiene la lista de deportes.
- **POST /api/pedidos**: Crea un nuevo pedido.

## Estructura de Datos

### Clases Principales

#### TarjetaDeportes

```
data class TarjetaDeportes(
    val nombre: String,
    val imagen: Int,
    val seleccionado: Boolean
)
```

### Persistencia de Datos

La aplicación utiliza persistencia de datos para almacenar las selecciones de deportes del usuario, sus configuraciones y otros datos relevantes. Los datos se guardan en [Informacion_persistente.md](Informacion_persistente.md).

