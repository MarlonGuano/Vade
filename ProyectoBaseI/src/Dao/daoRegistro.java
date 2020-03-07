
package Dao;

import Entity.Conexion;
import Entity.Registro;
import java.sql.CallableStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;


public class daoRegistro {
    public void InsertarRegistro(Registro obj){
        Conexion cn = new Conexion();
        Connection con = cn.Conectar();
        try {
            CallableStatement pst = con.prepareCall("{call dbo.INSERTAR_REGISTRO(?,?,?)}");
            pst.setInt(1, obj.getRef_usuario_super());
            pst.setInt(2, obj.getRef_laboratorio());
            pst.setInt(3, obj.getRef_laboratorio());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "REGISTRADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO REGISTRADO");
            e.printStackTrace();
        }
    }
}
