# Tarea de Programación Funcional en Java

## Requisitos
- Java 17
- Maven 3.6+

### Actividad 2: Procesador Funcional de Productos
...
* **Evidencia de ejecución:**
  ![Ejecución Actividad 2](capturas_ejecucion/Ejecución1.png)

---

### Actividad 3: Calculadora de Tributos (Interfaz Funcional Personalizada)
...
* **Evidencia de ejecución:**
  ![Ejecución Actividad 3](capturas_ejecucion/Ejecución2.png)

---

### Actividad 4: Composición de Cadenas y Funciones Pipeline
...
* **Evidencia de ejecución:**
  ![Ejecución Actividad 4](capturas_ejecucion/Ejecución3.png)


## Requisitos del Sistema y Versiones
* **Versión de Java Utilizada:** Java 17 (Compatible con Java 17 LTS o superior)
* **Gestor de Dependencias:** Maven 3.6+
* **Framework base:** Spring Boot 3.x (Estructura base del proyecto)

---

## Instrucciones para Compilar el Proyecto

Para limpiar los artefactos previos y compilar todo el código fuente del proyecto garantizando que no existan errores sintácticos ni de dependencias, ejecute el siguiente comando en la raíz del proyecto (donde se encuentra el archivo `pom.xml`):

## Ingreso a la carpeta

```bash
cd 2PTarea1_Avanzada\funcional

./mvnw clean compile

## Actividad 2
.\mvnw.cmd exec:java "-Dexec.mainClass=tarea.funcional.actividad2.ProcesadorFuncional"

## Actividad 3
 .\mvnw.cmd exec:java "-Dexec.mainClass=tarea.funcional.actividad3.CalculadoraTributoApp"

 ## Actividad 4
 .\mvnw.cmd exec:java "-Dexec.mainClass=tarea.funcional.actividad4.ComposicionCadenas"