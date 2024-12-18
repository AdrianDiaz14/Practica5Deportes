# Module Deportes

## Estructura de Información Persistente

Este documento describe la estructura de la información persistente en la aplicación Deportes.

### Clase `TarjetaDeportes`

| Campo         | Tipo       | Descripción                                               |
|---------------|------------|-----------------------------------------------------------|
| `nombre`      | TEXT       | Nombre del deporte.                                       |
| `imagen`      | INTEGER    | Imagen representativa del deporte.                        |
| `seleccionado`| BOOLEAN    | Indica si el deporte está seleccionado.                   |

#### Descripción Técnica

Esta clase almacena los datos persistentes sobre los deportes seleccionados por los usuarios en la aplicación Deportes. La información incluye el nombre del deporte, la ruta de la imagen asociada y si ha sido seleccionado o no por el usuario.

### Actualización Automática

La documentación se genera automáticamente utilizando los comentarios KDoc en el código fuente, asegurando que cualquier cambio en la estructura de la clase se refleje de inmediato en la documentación.
