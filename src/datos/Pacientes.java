/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;



/**
 *
 * @author Leo
 */
import com.mysql.jdbc.Statement;
import entidades.Paciente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
/*import static clinica.FrmSistema.fe;*/

import java.sql.*;
import java.util.ArrayList;

/**
 * Clase para manejar la conexión y operaciones con la base de datos de pacientes.
 */
public class Pacientes {

    // Información necesaria para realizar la conexión
    static final String DRIVER = "com.mysql.jdbc.Driver";
    static final String servidor = "localhost";
    static final String DB = "clinica";
    static final String puerto = "3306";
    static final String usuario = "mauro";
    static final String pws = "12345678a";
    static final String URL = "jdbc:mysql://" + servidor + ":" + puerto + "/" + DB + "?" + "user=" + usuario + "&password=" + pws;
    public static final String TABLA = "pacientes";
    private Connection cn;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public boolean isOkConexion() {
        boolean isOk = false;
        try {
            Class.forName(DRIVER).newInstance();
            cn = DriverManager.getConnection(URL);
            setCn(cn);
            isOk = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isOk;
    }

    public boolean isCloseConexion() {
        boolean isOk = false;
        try {
            if (getCn() != null && !getCn().isClosed()) {
                getCn().close();
                setCn(null);
                isOk = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return isOk;
        }
    }

    public boolean isCancelConexion() {
        return isCloseConexion();
    }

    public boolean isNew(Paciente c) {
        boolean isOk = false;
        try {
            Statement st = (Statement) this.getCn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("SELECT * FROM " + TABLA + " WHERE id=-1");
            rs.moveToInsertRow();
            rs.updateString("apellido", c.getLastName());
            rs.updateString("nombre", c.getName());
            rs.updateString("domicilio", c.getDomicilio());
            rs.updateInt("dni_paciente", c.getDocument());
            rs.updateInt("id_obrasocial", c.getId_obrasocial());
            rs.updateString("provincia", c.getProvincia());
            rs.updateString("telefonos", c.getMovils());
            rs.updateString("emails", c.getEmail());
            rs.insertRow();
            rs.close();
            st.close();
            isOk = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return isOk;
        }
    }

    public boolean isUpdate(Paciente c) {
        boolean isOk = false;
        try {
            Statement st = (Statement) this.getCn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("SELECT * FROM " + TABLA + " WHERE id=" + c.getId());
            if (rs.next()) {
                rs.updateString("apellido", c.getLastName());
                rs.updateString("nombre", c.getName());
                rs.updateString("domicilio", c.getDomicilio());
                rs.updateInt("dni_paciente", c.getDocument());
                rs.updateInt("id_obrasocial", c.getId_obrasocial());
                rs.updateString("provincia", c.getProvincia());
                rs.updateString("telefonos", c.getMovils());
                rs.updateString("emails", c.getEmail());
                rs.updateRow();
                isOk = true;
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return isOk;
        }
    }

    public boolean isDelete(Paciente c) {
        boolean isOk = false;
        try {
            Statement st = (Statement) this.getCn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("SELECT * FROM " + TABLA + " WHERE id=" + c.getId());
            if (rs.next()) {
                rs.deleteRow();
                isOk = true;
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return isOk;
        }
    }

    public boolean isDeleteAll() {
        boolean isOk = false;
        try {
            Statement st = (Statement) this.getCn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            isOk = st.executeUpdate("DELETE FROM " + TABLA) > 0;
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return isOk;
        }
    }

    public ArrayList<Paciente> listPaciente(String query) {
        ArrayList<Paciente> list = new ArrayList<Paciente>();
        try {
            Statement st = (Statement) this.getCn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Paciente paciente = new Paciente(rs.getInt("id"),
                        rs.getString("apellido"),
                        rs.getString("nombre"),
                        rs.getString("domicilio"),
                        rs.getInt("dni_paciente"),
                        rs.getInt("id_obrasocial"),
                        rs.getString("provincia"),
                        rs.getString("telefonos"),
                        rs.getString("emails"));
                list.add(paciente);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            return list;
        }
    }

    public Paciente getPaciente(int id) {
        Paciente c = null;
        if (isOkConexion()) {
            String query = "SELECT * FROM " + TABLA + " WHERE id=" + id;
            ArrayList<Paciente> pacienteList = listPaciente(query);
            isCloseConexion();
            if (pacienteList.size() == 1) {
                Paciente cList = pacienteList.get(0);
                c = new Paciente(cList.getId(),
                        cList.getLastName(),
                        cList.getName(),
                        cList.getDomicilio(),
                        cList.getDocument(),
                        cList.getId_obrasocial(),
                        cList.getProvincia(),
                        cList.getMovils(),
                        cList.getEmail());
            }
        }
        return c;
    }
}

