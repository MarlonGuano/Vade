
package Entity;

public class Combo {
    private int id_combo;
    private String nombre_combo;

    public Combo(int id_combo, String nombre_combo) {
        this.id_combo = id_combo;
        this.nombre_combo = nombre_combo;
    }

    public int getId_combo() {
        return id_combo;
    }

    public void setId_combo(int id_combo) {
        this.id_combo = id_combo;
    }

    public String getNombre_combo() {
        return nombre_combo;
    }

    public void setNombre_combo(String nombre_combo) {
        this.nombre_combo = nombre_combo;
    }
    
    @Override
    public String toString(){
        return nombre_combo;
    }
    
}
