
package Entity;

public class Registro {
    private int id_registro;
    private int ref_usuario_super;
    private int ref_solicitud;
    private int ref_laboratorio;
    private String fecha;
    private String hora;

    public Registro() {
    }

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public int getRef_usuario_super() {
        return ref_usuario_super;
    }

    public void setRef_usuario_super(int ref_usuario_super) {
        this.ref_usuario_super = ref_usuario_super;
    }

    public int getRef_solicitud() {
        return ref_solicitud;
    }

    public void setRef_solicitud(int ref_solicitud) {
        this.ref_solicitud = ref_solicitud;
    }

    public int getRef_laboratorio() {
        return ref_laboratorio;
    }

    public void setRef_laboratorio(int ref_laboratorio) {
        this.ref_laboratorio = ref_laboratorio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
}
