
package Entity;

public class Laboratorio {
    private int id_laboratorio;
    private String nombre;
    private int Nmaquinas;
    private String estado;
    
    public Laboratorio() {
    }

    public int getId_laboratorio() {
        return id_laboratorio;
    }

    public void setId_laboratorio(int id_laboratorio) {
        this.id_laboratorio = id_laboratorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNmaquinas() {
        return Nmaquinas;
    }

    public void setNmaquinas(int Nmaquinas) {
        this.Nmaquinas = Nmaquinas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
