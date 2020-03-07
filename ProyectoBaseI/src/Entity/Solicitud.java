
package Entity;

public class Solicitud {
    private int id_solicitud;
    private int ref_usuario;
    private String Descripcion;
    private String Estado;

    public Solicitud() {
    }

    public int getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(int id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public int getRef_usuario() {
        return ref_usuario;
    }

    public void setRef_usuario(int ref_usuario) {
        this.ref_usuario = ref_usuario;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
}
