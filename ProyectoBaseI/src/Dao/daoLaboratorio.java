
package Dao;

import Entity.Conexion;
import Entity.Laboratorio;
import java.sql.CallableStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class daoLaboratorio {
    public void InsertarLaboratorio(Laboratorio obj){
        Conexion cn = new Conexion();
        Connection con = cn.Conectar();
        try {
            CallableStatement pst = con.prepareCall("{call dbo.INSERTAR_LABORATORIO(?,?,?)}");
            pst.setString(1, obj.getNombre());
            pst.setInt(2, obj.getNmaquinas());
            pst.setString(3, obj.getEstado());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "GUARDADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO GUARDADO");
            e.printStackTrace();
        }
    }
}
