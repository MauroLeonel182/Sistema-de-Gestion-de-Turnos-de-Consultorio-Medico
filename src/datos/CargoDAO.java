/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

/**
 *
 * @author Leo
 */
// Controlador: Clase CargoDAO
import entidades.Cargo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CargoDAO {
    private Connection conn;

    public CargoDAO(Connection connection) {
        this.conn = connection;
    }

    public List<Cargo> getAll() throws SQLException {
        List<Cargo> cargos = new ArrayList<>();
        String query = "SELECT * FROM cargos";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            Cargo cargo = new Cargo(rs.getInt("id"), rs.getString("descripcion"));
            cargos.add(cargo);
        }
        return cargos;
    }

    public boolean insert(Cargo cargo) throws SQLException {
        String query = "INSERT INTO cargos (descripcion) VALUES (?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, cargo.getDescripcion());
        return stmt.executeUpdate() > 0;
    }

    public boolean update(Cargo cargo) throws SQLException {
        String query = "UPDATE cargos SET descripcion = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, cargo.getDescripcion());
        stmt.setInt(2, cargo.getId());
        return stmt.executeUpdate() > 0;
    }

    public boolean delete(int id) throws SQLException {
        String query = "DELETE FROM cargos WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        return stmt.executeUpdate() > 0;
    }
}
