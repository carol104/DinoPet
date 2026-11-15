# 🦖 DinoPet

Un simulador interactivo de mascota virtual desarrollado en **Java Swing**, donde deberás adoptar, cuidar y mantener con vida a un pequeño dinosaurio gestionando sus necesidades vitales en tiempo real.

---

## 📋 Tabla de Contenidos
1. [Descripción del Proyecto](#-descripción-del-proyecto)
2. [Requisitos del Sistema](#-requisitos-del-sistema)
3. [Instrucciones de Ejecución](#-instrucciones-de-ejecución)
4. [Mecánicas del Juego y Controles](#-mecánicas-del-juego-y-controles)
5. [Estados del Tamagotchi](#-estados-del-tamagotchi)
6. [Arquitectura y Patrones de Diseño](#-arquitectura-y-patrones-de-diseño)
7. [Estructura del Proyecto](#-estructura-del-proyecto)

---

## 📖 Descripción del Proyecto

Al iniciar el juego, presenciarás el nacimiento de un dinosaurio bebé listo para ser adoptado. Una vez en el mundo principal, el dinosaurio interactuará en diferentes escenarios (sala, comedor, dormitorio, enfermería, baño y sala de videojuegos) según las acciones que realices y los estados en que se encuentre.

A medida que transcurre el tiempo, las necesidades vitales del dinosaurio se degradan de forma natural cada 2 segundos. Deberás atenderlo a tiempo para evitar que enferme o muera por descuido total.

---

## 💻 Requisitos del Sistema

- **Java Runtime Environment (JRE)** o **Java Development Kit (JDK)** versión **8** o superior (compatible y probado con Java 21 LTS).
- **Sistema Operativo:** Windows 10/11, Linux o macOS.
- **Entorno de Desarrollo (Opcional):** NetBeans IDE, IntelliJ IDEA, Eclipse o VS Code con extensión para Java.

> [!NOTE]
> Para verificar que tienes Java instalado en tu computadora, abre una terminal y escribe:
> ```bash
> java -version
> ```

---

## 🚀 Instrucciones de Ejecución

Tienes varias opciones sencillas para ejecutar el juego:

### Opción 1: Lanzador rápido (Windows)
Haz doble clic en el archivo:
```
iniciar_tamagotchi.bat
```
Ubicado en la carpeta principal del proyecto.

### Opción 2: Desde la Terminal o Línea de Comandos
Abre una terminal en la carpeta raíz del proyecto y ejecuta:
```bash
java -jar Tamagotchi/dist/Tamagotchi.jar
```
*(O también `.\iniciar_tamagotchi.bat` en PowerShell / CMD)*.

### Opción 3: Desde NetBeans IDE
1. Abre NetBeans y selecciona **File > Open Project**.
2. Selecciona la carpeta `Tamagotchi`.
3. Presiona **F6** o haz clic derecho sobre el proyecto y selecciona **Run**.

---

## 🎮 Mecánicas del Juego y Controles

### Barras de Estado
El bienestar del dinosaurio se mide a través de 5 barras de progreso:

| Estadística | Valor Óptimo | Valor Crítico | Efecto en el Dinosaurio |
| :--- | :---: | :---: | :--- |
| **Hambre** | 0% | 100% | Aumenta con el tiempo y el juego; se reduce alimentándolo. |
| **Sueño** | 0% | 100% | Aumenta con el tiempo; se reduce haciéndolo dormir. |
| **Felicidad** | 100% | 0% | Disminuye con el tiempo; aumenta jugando o alimentándolo. |
| **Salud** | 100% | 0% | Disminuye con el tiempo; aumenta al curar, asear o dormir. |
| **Limpieza** | 100% | 0% | Disminuye con el tiempo y la comida; aumenta al asearlo. |

### Botones de Acción
- **Comer 🍖:** Reduce el hambre en 5 unidades y aporta felicidad. Lleva al dinosaurio al comedor.
- **Jugar 🎮:** Aumenta la felicidad en 5 unidades (aumenta ligeramente el hambre y reduce limpieza). Lleva al dinosaurio a la sala de videojuegos.
- **Dormir 💤:** Disminuye el sueño en 5 unidades y recupera salud. Lleva al dinosaurio al dormitorio.
- **Asear 🧼:** Aumenta el nivel de limpieza y beneficia la salud. Lleva al dinosaurio al baño.
- **Curar 💊:** Restaura salud y felicidad cuando el dinosaurio está enfermo. Lleva al dinosaurio a la enfermería.

### Fin del Juego (Muerte) 💀
Si todas las necesidades llegan al extremo de descuido crítico (Hambre al 100%, Sueño al 100%, Limpieza al 0%, Salud al 0% y Felicidad al 0%), la mascota no podrá continuar y se desplegará la pantalla de **Fin del Juego**.

---

## 🧠 Estados del Tamagotchi

El comportamiento del dinosaurio implementa una máquina de estados que reacciona de acuerdo con la necesidad más urgente:

- **Estado Normal:** El dinosaurio acepta cualquier interacción gustosamente.
- **Estado Hambriento:** Cuando el hambre supera el 70%. Rechaza dormir, asearse, jugar o curarse hasta que coma.
- **Estado Cansado:** Cuando el sueño supera el 70%. Rechaza comer, jugar, asearse o curarse hasta que duerma.
- **Estado Aburrido:** Cuando la felicidad cae por debajo del 30%. Pide jugar.
- **Estado Sucio:** Cuando la limpieza cae por debajo del 30%. Necesita bañarse para continuar con normalidad.
- **Estado Enfermo:** Cuando la salud baja del 30%. Requiere atención médica inmediata.

---

## 🏗️ Arquitectura y Patrones de Diseño

El proyecto fue diseñado aplicando buenas prácticas de programación orientada a objetos (POO):

- **Patrón Singleton:** Utilizado en `Tamagotchi` y `Mensaje` para asegurar una única instancia del dinosaurio y del despachador de mensajes durante el ciclo de vida del juego.
- **Patrón State (Estado):** La clase abstracta `Estado` define el contrato de comportamiento para cada estado específico (`EstadoNormal`, `EstadoHambriento`, `EstadoCansado`, `EstadoEnfermo`, `EstadoAburrido`, `EstadoSucio`).
- **Verificador de Prioridad:** El componente `VerificadorEstados` evalúa cuál de las necesidades es la más distante de su valor ideal para asignar la transición de estado correspondiente.
- **Swing & AWT:** Utiliza `AbsoluteLayout`, `JProgressBar` personalizados y un `Timer` en segundo plano para el ciclo de degradación biológica constante.

---

## 📁 Estructura del Proyecto

```text
Tamagotchi/
│
├── iniciar_tamagotchi.bat      # Script lanzador en un clic para Windows
├── README.md                   # Documentación del proyecto
├── .gitignore                  # Configuración de exclusiones para Git
│
└── Tamagotchi/                 # Proyecto Java NetBeans
    ├── build.xml               # Script de construcción Ant
    ├── manifest.mf             # Manifiesto base
    ├── nbproject/              # Metadatos del proyecto NetBeans
    │   ├── project.properties
    │   ├── project.xml
    │   └── ...
    ├── src/                    # Código fuente Java
    │   └── Tamagotchi/
    │       ├── Tamagotchi.java         # Clase núcleo y punto de entrada (Main)
    │       ├── Mundo.java              # Ventana principal del juego
    │       ├── Nacimiento.java         # Pantalla inicial de bienvenida
    │       ├── Muerte.java             # Pantalla de fin de juego
    │       ├── BarrasEstado.java       # Componente gráfico de estadísticas
    │       ├── Lugar.java              # Carga y gestión de escenarios
    │       ├── DinosaurioActuando.java # Carga de animaciones/imágenes de acción
    │       ├── Mensaje.java            # Cuadros de diálogo y avisos
    │       ├── VerificadorEstados.java # Lógica de evaluación de estados
    │       ├── Estado*.java            # Clases del patrón State
    │       └── Imagenes/               # Sprites, botones y fondos (.png)
    └── dist/                   # Ejecutables compilados listos para distribución
        ├── Tamagotchi.jar      # Archivo JAR ejecutable
        └── lib/
            └── AbsoluteLayout.jar
```
