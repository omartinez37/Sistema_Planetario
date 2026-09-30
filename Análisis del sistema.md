# Análisis del sistema

## Descripción del problema
El sistema a representar es un simulador de una misión de exploración planetaria. En esta misión intervienen vehículos exploradores (rovers terrestres y drones) que recorren diferentes tipos de zonas (seguras, rocosas, peligrosas) y registran descubrimientos científicos. El sistema debe conservar información sobre la identidad de cada explorador, su nivel de energía (estrictamente entre 0 y 100%), la distancia que han recorrido y los hallazgos realizados, todo esto coordinado y registrado por un único centro de control.

## Objetos y responsabilidades

| Objeto propuesto | Información que conserva | Comportamientos | Responsabilidad |
| :--- | :--- | :--- | :--- |
| **Explorador (Base)** | Nombre, Energía (0-100%), Distancia recorrida | Desplazarse, consumir energía, reportar estado | Representar las características básicas de cualquier vehículo de la misión. |
| **RoverTerrestre** | (Hereda de Explorador) | Analizar zona terrestre | Exploración de superficie y análisis de suelo. |
| **DronExplorador** | (Hereda de Explorador) | Analizar zona aérea | Exploración aérea y reconocimiento rápido. |
| **CentroControl** | Historial de descubrimientos, Total de exploradores | Registrar operaciones, consolidar datos | Monitorear la misión global (Singleton). |
| **Descubrimiento** | Tipo, Descripción, Zona (Data class) | Conservar datos del hallazgo | Empaquetar la información científica. |
| **TipoZona** | Constantes: SEGURA, ROCOSA, PELIGROSA | N/A | Tipificar el terreno. |

**Preguntas de Análisis:**
*   **¿Qué características tienen en común el rover y el dron?** Ambos tienen nombre, energía, distancia recorrida y la capacidad de desplazarse.
*   **¿Qué características son diferentes?** La forma en que exploran (suelo vs. aire) y posiblemente su tasa de consumo de energía.
*   **¿Existe un concepto más general que permita representar a ambos?** Sí, el concepto de un "Explorador" genérico (Clase Abstracta).
*   **¿Qué elementos parecen representar capacidades?** La acción de "Analizar una zona" es una capacidad que diferentes vehículos implementan a su manera (Interfaz `Analizable`).

## Reglas de Energía y Desplazamiento
*   **Rango de energía:** La propiedad `energia` utiliza un *setter personalizado* que restringe cualquier valor asignado mediante la función `coerceIn(0.0,# Exploración Planetaria Kotlin

Este proyecto es un simulador de misiones espaciales que aplica los principios fundamentales de la Programación Orientada a Objetos en Kotlin. El sistema orquesta diferentes tipos de vehículos autónomos (rovers y drones) que interactúan con el terreno y gestionan sus recursos energéticos. La simulación centraliza el registro de operaciones a través de un único centro de control, permitiendo el despliegue de telemetría y descubrimientos científicos a medida que las unidades avanzan por los distintos sectores geográficos.

## Estructura del Proyecto

*   **Exploradores:** Base arquitectónica conformada por la clase abstracta `Explorador`, la cual deriva en las plataformas físicas `RoverTerrestre` y `DronExplorador`.
*   **Interfaces:** `Analizable`, que expone un contrato unificado para la recolección de datos, permitiendo que cualquier plataforma compatible con la misión pueda interactuar con el entorno geológico de manera estandarizada.
*   **Control y Registro:** El `CentroControl` gestiona el flujo de la misión, mientras que la estructura de datos `Descubrimiento` encapsula los hallazgos de cada expedición.

## Reglas de Energía y Desplazamiento

El sistema impone restricciones estrictas sobre los parámetros operativos de las unidades móviles:
*   **Rango de Batería:** El nivel de energía está estrictamente confinado entre el 0% y el 100%. Si las operaciones del vehículo generan un cálculo fuera de este rango, el setter personalizado interviene para establecer el valor en los umbrales seguros e impedir fallas lógicas.
*   **Dinámica de Consumo:** Cada acción de desplazamiento o análisis aumenta la distancia total recorrida y consume un porcentaje fijo de energía. Un vehículo de tipo dron, que requiere vencer la gravedad en sus despegues, presentará una caída de batería mayor por unidad de desplazamiento en comparación con los rodamientos de un rover terrestre. Si el nivel de energía es insuficiente para realizar una acción, el vehículo suspende su rutina hasta ser reabastecido.

## Ejecución

El programa se ejecuta directamente desde el archivo principal. Al compilar y ejecutar la función `main()`, la simulación instanciará las unidades mecánicas, invocará los desplazamientos y delegará la impresión del registro final de la misión al `CentroControl`.

## Conceptos Aplicados

*   **Constructor primario:** Establece los parámetros operativos iniciales, como el identificador del hardware y la capacidad de batería[cite: 1]. 
*   **Parámetros predeterminados:** Agilizan la instanciación de unidades de exploración al asumir que, por defecto, inician con la batería al 100%[cite: 1].
*   **init:** Bloque utilizado para verificar que los parámetros iniciales del sistema no representen estados inválidos antes de inicializar la simulación[cite: 1].
*   **Getter personalizado:** Empleado para derivar el estado general de salud del vehículo a partir del análisis de su distancia y batería en tiempo real[cite: 1].
*   **Setter personalizado:** Fuerza los límites físicos de la batería, impidiendo sobrecargas eléctricas (mayores a 100) o caídas por debajo de cero.
*   **Herencia:** Permite agrupar las dinámicas de desplazamiento comunes en una superclase padre[cite: 1].
*   **Clase abstracta:** Modela el concepto teórico de un vehículo de exploración genérico que consolida el estado, pero deja la implementación específica para las subclases físicas[cite: 1].
*   **open / override:** Autoriza y ejecuta la reescritura de las rutinas de movimiento, permitiendo diferenciar un desplazamiento por contacto terrestre frente a uno aerodinámico[cite: 1].
*   **Interfaz:** Define la capacidad operativa transversal para procesar recolección de muestras sin acoplarla a un modelo físico concreto[cite: 1].
*   **data class:** Optimiza el almacenamiento de descubrimientos, proporcionando constructores limpios para reportes telemétricos con funciones preconstruidas de impresión[cite: 1].
*   **enum class:** Enumera exhaustivamente las clasificaciones del terreno (SEGURA, ROCOSA, PELIGROSA) garantizando consistencia arquitectónica[cite: 1].
*   **Función de extensión:** Extiende numéricos estándar para concatenar automáticamente la unidad de medida (kilómetros o grados) sin alterar la sintaxis de base de Kotlin[cite: 1].
*   **object:** Define el `CentroControl` como una instancia única, garantizando que todos los registros de los vehículos apunten a la misma terminal[cite: 1].
*   **companion object:** Almacena los parámetros estáticos globales (como factores climáticos) dentro del contexto de clase[cite: 1].
*   **private / protected:** Oculta los algoritmos internos de fricción y variables de desgaste de la batería, exponiendo solo interfaces públicas estables.
*   **Paquetes:** Aísla dominios lógicos (modelos cinemáticos, controladores web o locales) previniendo colisiones en variables.

## Reflexión Final

*   **¿Qué diferencia existe entre una clase y un objeto?**
    Una clase actúa como el diseño estructural (el plano de fabricación), mientras que el objeto es una instancia física operativa generada a partir de dicho diseño[cite: 1].
*   **¿Qué diferencia encontraste entre val y var?**
    `val` establece que la variable será inmutable una vez inicializada, comportándose como una constante (ideal para el nombre de un vehículo), mientras que `var` permite sobreescribir el dato en tiempo de ejecución (necesario para el consumo continuo de batería).
*   **¿Qué ventaja ofrecen los parámetros predeterminados?**
    Disminuyen la proliferación y complejidad de múltiples constructores secundarios al asignar valores nominales operativos por defecto[cite: 1].
*   **¿Para qué utilizaste init?**
    Se empleó como el primer nivel de configuración y validación en la instanciación de una clase para evitar arranque del sistema con parámetros mecánicos desestabilizados[cite: 1].
*   **¿Por qué utilizaste una clase abstracta para representar a los exploradores?**
    Porque un vehículo "genérico" no puede ser instanciado operativamente; la clase consolida los parámetros que toda máquina debe poseer, pero obliga a heredar sus características estructurales a un tipo de modelo determinado[cite: 1]. 
*   **¿Qué comportamiento heredaron las subclases?**
    Asimilaron las variables de rastreo base (energía, nombre, odómetro) y funciones elementales para calcular un movimiento unidimensional.
*   **¿Qué comportamiento sobrescribiste mediante override?**
    La mecánica de análisis, requiriendo que la respuesta cinemática se adapte al ambiente: el dron utiliza rutinas de planeo, y el rover rutinas de contacto[cite: 1]. 
*   **¿Qué representa la interfaz de tu programa?**
    Representa un contrato de interacción estricto al que toda clase debe adherirse para certificar que posee los sensores de procesamiento necesarios[cite: 1]. 
*   **¿Por qué esa capacidad se representó mediante una interfaz y no mediante herencia?**
    Kotlin implementa herencia simple; las interfaces superan este límite añadiendo capacidades funcionales de manera independiente, permitiendo que una entidad ofrezca un comportamiento sin forzar su clasificación en el árbol principal de jerarquías[cite: 1]. 
*   **¿Qué ventaja tuvo utilizar una data class?**
    Almacena directamente agrupaciones lógicas de estado y preconstruye internamente métodos `toString` y utilidades de clonación de objetos (`copy()`), optimizando el código para paquetes de datos simples[cite: 1]. 
*   **¿Qué ventaja tuvo utilizar una enum class?**
    Obliga a los componentes del sistema a usar exclusivamente constantes predefinidas como tipos de terreno, imposibilitando los estados ilegales o las fallas de compatibilidad[cite: 1]. 
*   **¿Qué hace la función de extensión que implementaste?**
    Añade propiedades de procesamiento a tipos nativos sin acceder a su código fuente estructural original, comportándose como una herramienta agregada transparente[cite: 1]. 
*   **¿Qué representa object CentroControl?**
    Un "Singleton". Asegura la orquestación coordinada proveyendo un único objeto universal en la memoria sin requerir inicializaciones iterativas[cite: 1]. 
*   **¿Qué colocaste en el companion object y por qué?**
    Coloqué variables que corresponden conceptualmente a toda la línea de fabricación o el estado ambiental compartido por todas las unidades creadas, no atado a una instancia independiente[cite: 1]. 
*   **¿Cuál es la diferencia entre object y companion object en tu programa?**
    El `object` es una entidad aislada de instancia global; el `companion object` existe siempre anidado a la identidad y vida compartida de una clase base general[cite: 1]. 
*   **¿Qué información protegiste mediante modificadores de visibilidad?**
    Propiedades vitales como la variable interna de la batería usando `private`, para impedir lecturas y escrituras perjudiciales directas que ignoren el getter y el setter[cite: 1].
*   **¿Cómo organizaste tu programa mediante paquetes?**
    Estructuralmente en grupos jerárquicos como interfaces, modelo base, y módulos de control para crear áreas modulares fáciles de gestionar y expandir[cite: 1]. 
*   **Si tuvieras que agregar un nuevo tipo de explorador, ¿qué partes del programa tendrías que modificar?**
    Únicamente sería necesario codificar una nueva clase (e.g., `RoverAnfibio`) derivándola de `Explorador` implementando sus funciones especializadas, e inyectarla localmente en el `main()`. La arquitectura basal, las interfaces analíticas y el centro de control se mantendrán inalterables.
