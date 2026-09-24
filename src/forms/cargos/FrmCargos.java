/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package forms.cargos;
// Vista: Clase FrmCargo
import datos.CargoDAO;
import entidades.Cargo;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Leo
 */
public class FrmCargos extends JFrame {
    private CargoDAO cargoDAO;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txtDescripcion;
    private JButton btnAdd, btnUpdate, btnDelete;

    public FrmCargos(Connection connection) {
        cargoDAO = new CargoDAO(connection);

        setTitle("Gestión de Cargos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de formulario
        JPanel formPanel = new JPanel(new GridLayout(2, 2));
        formPanel.add(new JLabel("Descripción:"));
        txtDescripcion = new JTextField();
        formPanel.add(txtDescripcion);

        btnAdd = new JButton("Agregar");
        btnUpdate = new JButton("Actualizar");
        btnDelete = new JButton("Eliminar");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);

        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        // Tabla
        tableModel = new DefaultTableModel(new String[]{"ID", "Descripción"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Eventos
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCargo();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCargo();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCargo();
            }
        });

        loadCargos();
    }



    private void loadCargos() {
        try {
            tableModel.setRowCount(0);
            List<Cargo> cargos = cargoDAO.getAll();
            for (Cargo cargo : cargos) {
                tableModel.addRow(new Object[]{cargo.getId(), cargo.getDescripcion()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + ex.getMessage());
        }
    }

    private void addCargo() {
        try {
            String descripcion = txtDescripcion.getText();
            if (descripcion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "La descripción no puede estar vacía.");
                return;
            }

            Cargo cargo = new Cargo();
            cargo.setDescripcion(descripcion);
            if (cargoDAO.insert(cargo)) {
                JOptionPane.showMessageDialog(this, "Cargo agregado exitosamente.");
                loadCargos();
                txtDescripcion.setText("");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al agregar el cargo: " + ex.getMessage());
        }
    }

    private void updateCargo() {
        try {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un cargo para actualizar.");
                return;
            }

            int id = (int) tableModel.getValueAt(selectedRow, 0);
            String descripcion = txtDescripcion.getText();
            if (descripcion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "La descripción no puede estar vacía.");
                return;
            }

            Cargo cargo = new Cargo(id, descripcion);
            if (cargoDAO.update(cargo)) {
                JOptionPane.showMessageDialog(this, "Cargo actualizado exitosamente.");
                loadCargos();
                txtDescripcion.setText("");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el cargo: " + ex.getMessage());
        }
    }

    private void deleteCargo() {
        try {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un cargo para eliminar.");
                return;
            }

            int id = (int) tableModel.getValueAt(selectedRow, 0);
            if (cargoDAO.delete(id)) {
                JOptionPane.showMessageDialog(this, "Cargo eliminado exitosamente.");
                loadCargos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar el cargo: " + ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
