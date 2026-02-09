# Sistema de Gestión de Productos

Sistema básico de registro y consulta de información de productos desarrollado en Java como parte del Módulo 1 del curso de Java Senior AI.

## Descripción

Este programa de consola permite gestionar la información de productos en una tienda, aplicando conceptos fundamentales de Java como:
- Métodos y modularización
- Variables estáticas
- Estructuras condicionales (if-else, switch)
- Bucles (while, do-while)
- Validaciones de entrada
- Manejo de excepciones básicas

## Características

El sistema incluye las siguientes funcionalidades:

### Funcionalidades Principales

1. **Registrar nuevo producto**
   - Solicita nombre, precio unitario y cantidad en inventario
   - Valida que el precio sea mayor que 0
   - Valida que la cantidad sea un entero no negativo
   - Pregunta antes de sobrescribir datos existentes

2. **Mostrar información del producto actual**
   - Visualiza nombre, precio y cantidad del producto registrado
   - Muestra mensaje si no hay datos registrados

3. **Calcular valor total del inventario**
   - Calcula: `precio × cantidad`
   - Formatea el resultado con separador de miles y 2 decimales

4. **Mostrar resumen completo del producto**
   - Muestra todos los datos del producto
   - Indica el estado del stock:
     - **Stock bajo**: cantidad < 5
     - **Stock suficiente**: 5 ≤ cantidad ≤ 20
     - **Stock alto**: cantidad > 20

5. **Limpiar datos del producto actual**
   - Restablece todas las variables a su estado inicial

## Requisitos

- Java Development Kit (JDK) 8 o superior
- Terminal o consola de comandos

## Estructura del Proyecto

```
gestion-productos/
├── src/
│   └── App.java          # Clase principal con toda la lógica
├── bin/
│   └── App.class         # Archivos compilados
├── lib/                  # Dependencias (vacío por ahora)
└── README.md            # Este archivo
```

## Cómo ejecutar

### Compilar el programa

```bash
cd "/media/manuelbth/6136e182-7c9f-4766-a146-327c0ad0f1e6/manuebth/Academia/Dev Senior/Java Senior AI/Modulo 1/Unidad 1/gestion-productos"
javac src/App.java -d bin
```

### Ejecutar el programa

```bash
java -cp bin App
```

## Ejemplo de uso

```
--- Sistema de Gestión de Productos ---

1. Registrar nuevo producto
2. Mostrar información del producto actual
3. Calcular valor total del inventario
4. Mostrar resumen completo del producto
5. Limpiar datos del producto actual
0. Salir
Ingrese su opción: 1

Ingrese el nombre del producto: Laptop Lenovo
Ingrese el precio unitario: 2500000
Ingrese la cantidad en inventario: 5
Producto registrado exitosamente.

--- Sistema de Gestión de Productos ---
...
Ingrese su opción: 4

--- Resumen del Producto ---
Nombre: Laptop Lenovo
Precio Unitario: $2,500,000.00
Cantidad en Inventario: 5
Valor Total en Inventario: $12,500,000.00
Estado del Stock: Stock suficiente
```

## Arquitectura del Código

### Variables Estáticas
```java
private static String nombreProducto = "N/A";
private static double precioUnitario = 0.0;
private static int cantidadInventario = 0;
```

### Métodos Implementados

| Método | Descripción |
|--------|-------------|
| `main()` | Punto de entrada y control del menú |
| `mostrarMenu()` | Muestra las opciones del menú |
| `registrarProducto(Scanner)` | Registra un nuevo producto |
| `mostrarInformacion()` | Muestra datos básicos del producto |
| `calcularValorTotal()` | Calcula y muestra el valor total |
| `mostrarResumen()` | Muestra resumen completo con estado de stock |
| `limpiarDatos()` | Restablece variables al estado inicial |
| `validarPrecio(double)` | Valida que el precio sea > 0 |
| `validarCantidad(int)` | Valida que la cantidad sea >= 0 |
| `validarNombre(String)` | Valida que el nombre no esté vacío |

## Validaciones

El sistema incluye validaciones para garantizar la integridad de los datos:

- **Nombre**: No puede estar vacío ni contener solo espacios
- **Precio**: Debe ser un número mayor que 0
- **Cantidad**: Debe ser un número entero mayor o igual a 0

## Autor

Desarrollado como parte del curso **Java Senior AI - Módulo 1**.

## Licencia

Este proyecto es de uso educativo.

---

**Nota**: Este es un proyecto de consola diseñado para practicar conceptos básicos de Java. No incluye persistencia de datos (la información se pierde al cerrar el programa).