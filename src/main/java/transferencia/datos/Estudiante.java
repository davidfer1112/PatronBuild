package transferencia.datos;

import java.util.ArrayList;
import java.util.List;
import patronbuilder.InterfaceBuilder;

public class Estudiante {

    private String nombre;
    private int edad;
    private String genero;
    private Direccion direccion;
    private List<Telefonos> telefonos;
    private List<Contactos> contactos;
    private Programa programa; // Nuevo atributo

    private Estudiante(String nombre, int edad, String genero, Direccion direccion,
                       List<Telefonos> telefonos, List<Contactos> contactos, Programa programa) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.direccion = direccion;
        this.telefonos = telefonos;
        this.contactos = contactos;
        this.programa = programa;
    }

    private Estudiante(String nombre, int edad, String genero) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }

    public Estudiante() {
    }

    // Getters y setters...

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "Nombre=" + nombre + ", Edad=" + edad + ", Genero="
                + genero + ", \nDirección=" + direccion + ", \nTelefono=" + telefonos
                + ", \nContactos=" + contactos + ", \nPrograma=" + programa + '}';
    }

    public static class EstudianteBuilder implements InterfaceBuilder<Estudiante> {

        private String nombre;
        private int edad;
        private String genero;
        private Direccion direccion;
        private final List<Telefonos> telefonos = new ArrayList<>();
        private final List<Contactos> contactos = new ArrayList<>();
        private Programa programa; // Nuevo atributo

        public EstudianteBuilder() {
        }

        public EstudianteBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public EstudianteBuilder setEdad(int edad) {
            this.edad = edad;
            return this;
        }

        public EstudianteBuilder setGenero(String genero) {
            this.genero = genero;
            return this;
        }

        public EstudianteBuilder setDireccion(String direccion, String ciudad, String pais, String localidad) {
            this.direccion = new Direccion(direccion, ciudad, pais, localidad);
            return this;
        }

        public EstudianteBuilder addTelefonos(String numeroTelefono, String extension, String tipo) {
            telefonos.add(new Telefonos(numeroTelefono, extension, tipo));
            return this;
        }

        public EstudianteBuilder addContactos(String nombres, String numeroTelefono, String extension, String tipo,
                                              String direccion, String ciudad, String pais, String localidad) {
            contactos.add(new Contactos(nombres, new Telefonos(numeroTelefono, extension, tipo),
                    new Direccion(direccion, ciudad, pais, localidad)));
            return this;
        }

        public EstudianteBuilder addContactos(String nombres, String numeroTelefono, String extension, String tipo) {
            contactos.add(new Contactos(nombres, new Telefonos(numeroTelefono, extension, tipo)));
            return this;
        }

        public EstudianteBuilder setPrograma(String nombrePrograma, int numeroSemestres) {
            this.programa = new Programa(nombrePrograma, numeroSemestres);
            return this;
        }

        @Override
        public Estudiante build() {
            return new Estudiante(nombre, edad, genero, direccion, telefonos, contactos, programa);
        }
    }
}
