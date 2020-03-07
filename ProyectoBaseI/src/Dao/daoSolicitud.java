package Dao;

import Entity.Conexion;
import Entity.Solicitud;
import java.sql.CallableStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class daoSolicitud {

    public void InsertarSolicitud(Solicitud obj) {
        Conexion cn = new Conexion();
        Connection con = cn.Conectar();
        try {
            CallableStatement pst = con.prepareCall("{call dbo.INSERTAR_SOLICITUD(?,?)}");
            pst.setInt(1, obj.getRef_usuario());
            pst.setString(2, obj.getDescripcion());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "ENVIADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO ENVIADO");
            e.printStackTrace();
        }
    }

    public void Cambiar_Estado(int id, String estado) {
        Conexion cn = new Conexion();
        Connection con = cn.Conectar();
        try {
            CallableStatement pst = con.prepareCall("{call dbo.ACTUALIZAR_ESTADO_SOLICITUD(?,?)}");
            pst.setInt(1, id);
            pst.setString(2, estado);
            pst.executeUpdate();
            System.out.println("ESTADO ACTUALIZADO");
        } catch (Exception e) {
            System.out.println("ERROR AL ACTUALIZAR ESTADO");
            e.printStackTrace();
        }
    }
}
