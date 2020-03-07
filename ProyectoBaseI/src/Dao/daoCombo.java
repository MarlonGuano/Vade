package Dao;

import Entity.Combo;
import Entity.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class daoCombo {

    public void llenarCMB(JComboBox cmb) {
        cmb.removeAllItems();
        try {
            Conexion cn = new Conexion();
            Connection con = cn.Conectar();
            CallableStatement clbs = con.prepareCall("SELECT * FROM dbo.LLENARCOMBO_USUARIO");
            ResultSet rs = clbs.executeQuery();
            while (rs.next()) {
                Combo obj = new Combo(rs.getInt(1), rs.getString(2));
                cmb.addItem(obj);
            }
            con.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(daoCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarCMB_Solicitud(JComboBox cmb) {
        cmb.removeAllItems();
        try {
            Conexion cn = new Conexion();
            Connection con = cn.Conectar();
            CallableStatement clbs = con.prepareCall("SELECT * FROM dbo.LLENARCOMBO_SOLICITUD");
            ResultSet rs = clbs.executeQuery();
            while (rs.next()) {
                cmb.addItem(rs.getInt(1));
            }
            con.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(daoCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarCMB_Laboratorio(JComboBox cmb) {
        cmb.removeAllItems();
        try {
            Conexion cn = new Conexion();
            Connection con = cn.Conectar();
            CallableStatement clbs = con.prepareCall("SELECT * FROM dbo.LABORATORIOS_DISPONIBLES");
            ResultSet rs = clbs.executeQuery();
            while (rs.next()) {
                cmb.addItem(rs.getInt(2));
            }
            con.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(daoCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
