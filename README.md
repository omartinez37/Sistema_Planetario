# Reflexión Final

Este documento resume los aprendizajes clave sobre programación en Kotlin y conceptos de orientación a objetos.

---

## 📌 Diferencias Fundamentales

- **Clase vs Objeto**  
  Una clase es el molde o plano arquitectónico que define propiedades y comportamientos.  
  Un objeto es una instancia concreta en memoria creada a partir de esa clase.

- **val vs var**  
  - `val`: referencias inmutables (solo lectura).  
  - `var`: variables mutables cuyo valor puede reasignarse.

---

## ⚙️ Ventajas y Usos

- **Parámetros predeterminados**  
  Reducen la necesidad de sobrecargar constructores, permitiendo sintaxis más limpia.

- **init**  
  Ejecuta lógica de inicialización y valida el registro del explorador en el `CentroControl`.

- **Clase abstracta (Explorador)**  
  Sirve como plantilla base para `RoverTerrestre` y `DronExplorador`, evitando instanciación directa.

---

## 🧬 Herencia y Polimorfismo

- **Comportamientos heredados**  
  - Gestión de energía  
  - Acumulador de distancia recorrida  
  - Propiedades de identificación  
  - Validación de estado  

- **Comportamientos sobrescritos (override)**  
  - Cálculo del consumo de batería en `desplazarse()`  
  - Ejecución de `misionEspecial()`  

---

## 🔌 Interfaces y Abstracción

- **Interfaz (Analizable)**  
  Representa la capacidad de analizar una zona geográfica.  

- **Razón de usar interfaz en lugar de herencia**  
  El análisis de zonas es un comportamiento compartido por múltiples objetos, independiente de la jerarquía física.

---

## 🗂️ Clases Especiales

- **Data class**  
  Genera automáticamente `toString()`, `equals()`, `hashCode()` y `copy()`.

- **Enum class**  
  Restringe los tipos de zonas a valores constantes y seguros en tiempo de compilación.

---

## ➕ Extensiones y Objetos

- **Función de extensión**  
  Formatea un `Double` añadiendo el sufijo `" km"`.

- **object CentroControl**  
  Singleton encargado de la bitácora y coordinación de la misión.

- **companion object (Explorador)**  
  Contiene el contador de exploradores creados, ligado a la clase y no a instancias individuales.

- **Diferencia entre object y companion object**  
  - `object CentroControl`: instancia única global.  
  - `companion object Explorador`: ligado internamente a la clase.

---

## 🔒 Modificadores de Visibilidad

- `protected`: setter de la distancia recorrida (evita alteraciones arbitrarias).  
- `private`: listas internas del `CentroControl`.

---

## 📦 Organización del Programa

- **Paquetes**  
  - `modelo`: datos  
  - `exploradores`: entidades del dominio  
  - `control`: singleton de mando  
  - `utilidades`: funciones auxiliares  

---

## 🚀 Escalabilidad

- **Agregar un nuevo explorador**  
  Solo requiere crear una nueva subclase que herede de `Explorador` e implemente `Analizable` (si aplica).  
  No es necesario modificar clases existentes ni el `CentroControl`.

---
