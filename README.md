# Documentación del Repositorio PatronBuild

## Descripción

El repositorio PatronBuild es un proyecto Java que implementa el patrón de diseño Builder para la creación de objetos complejos, como `Estudiante`, que incluye atributos como nombre, edad, género, dirección, teléfonos, contactos y programa. Este patrón permite construir un objeto paso a paso, ofreciendo una alternativa al uso de constructores con múltiples parámetros.

## Estructura del Proyecto

El proyecto está estructurado de la siguiente manera:

- `src/main/java/transferencia/datos`: Contiene las clases Java del proyecto.
  - `Contactos.java`: Define la clase `Contactos` con atributos como nombres, teléfonos y dirección.
  - `Direccion.java`: Define la clase `Direccion` con atributos como dirección, ciudad, país y localidad.
  - `Estudiante.java`: Define la clase `Estudiante` y su constructor interno `EstudianteBuilder` para la creación de objetos `Estudiante`.
  - `Programa.java`, `Telefonos.java`: Clases que representan el programa académico y los teléfonos de los estudiantes, respectivamente.
- `pom.xml`: Archivo de configuración de Maven para la gestión de dependencias y la construcción del proyecto.

## Clases Principales

### Estudiante

La clase `Estudiante` representa a un estudiante con atributos como nombre, edad, género, dirección, teléfonos, contactos y programa. Se utiliza el patrón Builder para facilitar la creación de instancias de `Estudiante`.

```java
public class Estudiante {
    // Atributos
    private String nombre;
    private int edad;
    private String genero;
    private Direccion direccion;
    private List<Telefonos> telefonos;
    private List<Contactos> contactos;
    private Programa programa;

    // Constructor privado
    private Estudiante(String nombre, int edad, String genero, Direccion direccion,
                       List<Telefonos> telefonos, List<Contactos> contactos, Programa programa) {
        // Inicialización de atributos
    }

    // Getters, setters y toString
}
```

### EstudianteBuilder

`EstudianteBuilder` es una clase interna de `Estudiante` que implementa el patrón Builder. Permite configurar paso a paso los atributos de un `Estudiante` antes de crear la instancia final.

```java
public static class EstudianteBuilder {
    // Atributos del builder
    private String nombre;
    private int edad;
    private String genero;
    private Direccion direccion;
    private final List<Telefonos> telefonos = new ArrayList<>();
    private final List<Contactos> contactos = new ArrayList<>();
    private Programa programa;

    // Métodos para configurar el builder y construir el objeto Estudiante
    public EstudianteBuilder setNombre(String nombre) { /*...*/ }
    public EstudianteBuilder setEdad(int edad) { /*...*/ }
    // Otros setters...
    public Estudiante build() { /*...*/ }
}

```

### Uso del Builder

Para crear un objeto `Estudiante` utilizando el `EstudianteBuilder`:

```java
Estudiante estudiante = new Estudiante.EstudianteBuilder()
    .setNombre("Juan Perez")
    .setEdad(20)
    .setGenero("Masculino")
    // Configuraciones adicionales...
    .build();

```

### Configuración y Herramientas

El proyecto utiliza Maven como sistema de gestión de proyectos. La configuración de Maven se especifica en el archivo `pom.xml`, donde se define la versión de Java (17) y otras propiedades del proyecto.

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" ...>
    <modelVersion>4.0.0</modelVersion>
    <groupId>org.example</groupId>
    <artifactId>Build_implementacion</artifactId>
    <version>1.0-SNAPSHOT</version>
    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        ...
    </properties>
</project>

```

### Conclusión

El repositorio PatronBuild demuestra la implementación del patrón de diseño Builder en Java, facilitando la creación de objetos complejos como `Estudiante`. Utiliza Maven para la gestión del proyecto, asegurando una estructura y configuración consistentes.
