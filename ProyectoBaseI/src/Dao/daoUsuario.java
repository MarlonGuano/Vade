
package Dao;

import Entity.Conexion;
import Entity.TipoUsuario;
import Entity.Usuario;
import GUI.frmMenu;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class daoUsuario {
    public void InsertarUsuario(Usuario obj){
        Conexion cn = new Conexion();
        Connection con = cn.Conectar();
        try {
            CallableStatement pst = con.prepareCall("{call dbo.INSERTAR_USUARIO(?,?,?,?,?,?,?)}");
            pst.setString(1, obj.getCedula());
            pst.setString(2, obj.getNombre());
            pst.setString(3, obj.getApellido());
            pst.setString(4, obj.getCorreo());
            pst.setString(5, obj.getUsuario());
            pst.setString(6, obj.getContrasena());
            pst.setInt(7, obj.getObj().getId_tipoUsuario());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "GUARDADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO GUARDADO");
            e.printStackTrace();
        }
    }
    
    public void InsertarTipoUsuario(TipoUsuario obj){
        Conexion cn = new Conexion();
        Connection con = cn.Conectar();
        try {
            CallableStatement pst = con.prepareCall("{call dbo.INSERTAR_TIPO_USUARIO(?)}");
            pst.setString(1, obj.getTipo());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "AGREGADO CON EXITO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO AGREGADO");
            e.printStackTrace();
        }
    }
    public boolean login(Usuario obj){
         Conexion cn = new Conexion();
        Connection con = cn.Conectar();
        try {
            CallableStatement pst = con.prepareCall("{call dbo.VERIFICACION_LOGIN(?)}");
            pst.setString(1, obj.getUsuario());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                if(obj.getContrasena().equals(rs.getString(3))){
                    frmMenu.user.setId_usuario(rs.getInt(1));
                    frmMenu.user.setCedula(rs.getString(4));
                    frmMenu.user.setNombre(rs.getString(5));
                    frmMenu.user.setApellido(rs.getString(6));
                    frmMenu.user.setTUsuario(rs.getString(7));
                    
                    return true;
                }else{
                    return false;
                }
            }
            return false;
        } catch (Exception e) {
           e.printStackTrace();
           return false;
        }
    }
}
