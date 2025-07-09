# Tarea 3
## Datos Estudiante

Nombre: Pablo Marambio

Rol: 202073108-k

## Diagrama UML

![Diagrama uml](/uml.png)

## Instrucciones

### Requisitos previos

- Tener instalado Java JDK 8 o superior.
- Descargar el .jar para junit de este enlace: https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.9.3/
- Dejar el .jar dentro de una carpeta llamada lib dentro del directorio del proyecto.

### Compilar

```bash
make build
```

Esto compilará todos los archivos `.java` en el directorio `src` y `test`, generando las clases compiladas en el directorio `bin`.

### Ejecutar

```bash
make run
```

### Ejecutar pruebas

```bash
make test
```

## Ejemplo de salida de tests
```bash
Ejecutando pruebas JUnit...

Thanks for using JUnit! Support its development at https://junit.org/sponsoring

╷
├─ JUnit Jupiter ✔
│ └─ MainTest ✔
│ ├─ crearClienteValido() ✔
│ ├─ crearClienteConCorreoInvalido() ✔
│ ├─ crearCompraYActualizarPuntos() ✔
│ ├─ mostrarClienteNoExistente() ✔
│ └─ flujoEliminarClienteYCompras() ✔
├─ JUnit Vintage ✔
└─ JUnit Platform Suite ✔

Test run finished after 65 ms
[ 4 containers found ]
[ 0 containers skipped ]
[ 4 containers started ]
[ 0 containers aborted ]
[ 4 containers successful ]
[ 0 containers failed ]
```

## ¿Qué tipo de cobertura he medido y por qué?

Gracias a Eclemma se obtiene una cobertura de 68,5%, es decir, al menos el 68,5% de las líneas de código fueron ejecutadas al menos una vez durante las pruebas.

![Imagen eclipse](/eclipse.png)

## Consideraciones

Para calcular la cobertura tuve que modificar un poco la estructura del codigo dentro de eclipse.
