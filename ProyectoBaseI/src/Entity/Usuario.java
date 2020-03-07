
package Entity;

public class Usuario {
    private int id_usuario;
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String usuario;
    private String contrasena;
    private TipoUsuario obj;
    private String TUsuario; 

    public Usuario() {
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public TipoUsuario getObj() {
        return obj;
    }

    public void setObj(TipoUsuario obj) {
        this.obj = obj;
    }

    public String getTUsuario() {
        return TUsuario;
    }

    public void setTUsuario(String TUsuario) {
        this.TUsuario = TUsuario;
    }

   
}
