# Proyecto Java - Compilación, Ejecución y Pruebas con JUnit

## Instrucciones para compilar, ejecutar y probar

### Requisitos previos

- Tener instalado Java JDK 8 o superior.

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
