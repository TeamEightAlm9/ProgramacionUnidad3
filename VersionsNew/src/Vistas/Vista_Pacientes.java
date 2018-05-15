/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelos.Paciente;
import Servicios.Conexion;
import Servicios.Servicios_Paciente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leonardo
 */
public class Vista_Pacientes extends javax.swing.JInternalFrame {
    private final Servicios_Paciente servicios_Pacientes = new Servicios_Paciente();
    private List<Paciente> pacientes = new ArrayList<>();

    /**
     * Creates new form Vista_Pacientes
     */
    public Vista_Pacientes() {
        initComponents();
        this.actualizarTabla();
    }
    
    public void actualizarTabla(){
        try{
            this.pacientes = this.servicios_Pacientes.getAll(Conexion.obtener());
            DefaultTableModel tm = (DefaultTableModel) pacienteTable.getModel();
            tm.setRowCount(0);
            for(int i=0;i<this.pacientes.size();i++){
                tm.addRow(new Object[]{
                    this.pacientes.get(i).getCodigoP(),
                    this.pacientes.get(i).getNombre(),
                    this.pacientes.get(i).getApellidos()
                });
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al conectar a la Base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Error clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean validar(){
        boolean validado;
        String nombre = txtNombre.getText();
        String apellidos = txtApellido.getText();
        validado = (!nombre.equals("") && !apellidos.equals(""))||(nombre.length()>50 || apellidos.length()>50);
        return validado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnActualizar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pacienteTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 0, 102));
        setClosable(true);
        setIconifiable(true);
        setTitle("Pacientes");
        setToolTipText("Gestione sus Pacientes aqui.");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/paciente-min.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));

        btnActualizar.setBackground(new java.awt.Color(204, 204, 255));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotacion.png"))); // NOI18N
        btnActualizar.setToolTipText("Actualiza la tabla de pacientes");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(204, 204, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ajustes-de-conversion.png"))); // NOI18N
        btnModificar.setToolTipText("Modifica un paciente ya registrado");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(204, 204, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/goma-de-borrar.png"))); // NOI18N
        btnEliminar.setToolTipText("Elimina un paciente ya registrado");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(204, 204, 255));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar.png"))); // NOI18N
        btnRegistrar.setToolTipText("Registra un nuevo paciente");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registrar Paciente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        txtNombre.setToolTipText("Escriba el nombre del nuevo paciente");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setLabelFor(txtNombre);
        jLabel1.setText("Nombre:");
        jLabel1.setToolTipText("");

        txtApellido.setToolTipText("Escriba los apellidos del nuevo paciente");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setLabelFor(txtApellido);
        jLabel2.setText("Apellidos:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtApellido)
                    .addComponent(txtNombre))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pacienteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellidos"
            }
        ));
        jScrollPane2.setViewportView(pacienteTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(229, Short.MAX_VALUE)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnRegistrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if(this.validar()){
            String nombre = txtNombre.getText();
            String apellidos = txtApellido.getText();
            Paciente paciente = new Paciente();
            paciente.setNombre(nombre);
            paciente.setApellidos(apellidos);
            try{
                this.servicios_Pacientes.create(Conexion.obtener(), paciente);
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(null, "Error al conectar a la Base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            }catch(ClassNotFoundException ex){
                JOptionPane.showMessageDialog(null, "Error clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Campos Incompletos o Mayores a 50 caracteres");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        this.actualizarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(validar()){
            if(pacienteTable.getSelectedRow()<0){
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
            }else{
                Paciente apoyo = pacientes.get(pacienteTable.getSelectedRow());
                try{
                    Paciente medico = new Paciente(apoyo.getCodigoP(), txtNombre.getText(), txtApellido.getText());
                    servicios_Pacientes.create(Conexion.obtener(), medico);
                }catch(SQLException ex){
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Error al conectar a la Base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                }catch(ClassNotFoundException ex){
                    JOptionPane.showMessageDialog(null, "Error clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } 
        else{
            JOptionPane.showMessageDialog(null, "Campos Incompletos");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila_seleccionada = pacienteTable.getSelectedRow();
        if(fila_seleccionada >= 0){            
            int decision = JOptionPane.showConfirmDialog(null, "¿Está seguro/a que desea eliminar esta tarea?", "Advertencia", JOptionPane.YES_NO_OPTION);            
            if(decision == 0){
                try{
                    Paciente apoyo = pacientes.get(fila_seleccionada);
                    //Medico medico = new Medico(apoyo.getCodigo(), apoyo.getNombre(), apoyo.getApellidos());
                    servicios_Pacientes.delete(Conexion.obtener(), apoyo);
                }catch(SQLException ex){
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido eliminar el registro.");
                }catch(ClassNotFoundException ex){
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido eliminar el registro.");
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Por favor seleccione una fila.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable pacienteTable;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
