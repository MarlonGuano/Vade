
package Entity;

public class TipoUsuario {
    private int id_tipoUsuario;
    private String tipo;

    public TipoUsuario() {
    }

    public TipoUsuario(int id_tipoUsuario, String tipo) {
        this.id_tipoUsuario = id_tipoUsuario;
        this.tipo = tipo;
    }

    public int getId_tipoUsuario() {
        return id_tipoUsuario;
    }

    public void setId_tipoUsuario(int id_tipoUsuario) {
        this.id_tipoUsuario = id_tipoUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
