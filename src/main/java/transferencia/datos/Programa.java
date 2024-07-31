package transferencia.datos;

public class Programa {
    private String nombrePrograma;
    private int numeroSemestres;

    public Programa() {
    }

    public Programa(String nombrePrograma, int numeroSemestres) {
        this.nombrePrograma = nombrePrograma;
        this.numeroSemestres = numeroSemestres;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    public int getNumeroSemestres() {
        return numeroSemestres;
    }

    public void setNumeroSemestres(int numeroSemestres) {
        this.numeroSemestres = numeroSemestres;
    }

    @Override
    public String toString() {
        return "Programa{" + "NombrePrograma=" + nombrePrograma + ", NumeroSemestres=" + numeroSemestres + '}';
    }
}
