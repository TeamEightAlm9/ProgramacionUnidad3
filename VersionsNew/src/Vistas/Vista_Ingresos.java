package Vistas;

import Modelos.Ingreso;
import Modelos.Medico;
import Modelos.Paciente;
import Servicios.Conexion;
import Servicios.Servicios_Ingreso;
import Servicios.Servicios_Medico;
import Servicios.Servicios_Paciente;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Vista_Ingresos extends javax.swing.JInternalFrame {
    private final Servicios_Ingreso servicios_ingresos = new Servicios_Ingreso();
    private final Servicios_Medico servicios_medicos = new Servicios_Medico();
    private final Servicios_Paciente servicios_pacientes = new Servicios_Paciente();
    private List<Ingreso> ingresos = new ArrayList<>();
    private List<Medico> medicos = new ArrayList<>();
    private List<Paciente> pacientes = new ArrayList<>();

    /**
     * Creates new form Vista_Ingresos
     */
    public Vista_Ingresos() {
        initComponents();
        this.actualizarTabla();
        this.rellenaCBPaciente();
        this.rellenarCBMedico();
    }
    
    public void actualizarTabla(){
        try{
            this.ingresos = this.servicios_ingresos.getAll(Conexion.obtener());
            DefaultTableModel tm = (DefaultTableModel) ingresoTable.getModel();
            tm.setRowCount(0);
            for(int i=0;i<this.ingresos.size();i++){
                //Medico medico = this.servicios_medicos.getById(Conexion.obtener(), this.ingresos.get(i).getCodigo_m().intValue());
                //Paciente paciente = this.servicios_pacientes.getById(Conexion.obtener(), this.ingresos.get(i).getCodigo_p().intValue());
                tm.addRow(new Object[]{
                    this.ingresos.get(i).getCodigoI(),
                    this.ingresos.get(i).getHabitacion(),
                    this.ingresos.get(i).getFecha(),
                    this.ingresos.get(i).getCodigo_m(),
                    this.ingresos.get(i).getCodigo_p()
                });
            }
        }catch(SQLException ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error al conectar a la Base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Error clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean validar(){
        boolean valida = true;
        try{
            valida = txtHabitacion.equals(Integer.parseInt(txtHabitacion.getText())>0) || Integer.parseInt(txtHabitacion.getText())<15;
            //valida = dateChooser.getDate() != null;
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Ingrese valores numericos del 1 al 14", "Error", JOptionPane.ERROR_MESSAGE);
            valida = false;
        }
        return valida;
    }
    
    public void rellenarCBMedico(){
        cbMedico.removeAllItems();
        try{
            medicos = this.servicios_medicos.getAll(Conexion.obtener());
            for(int i=0;i<medicos.size();i++){
                cbMedico.addItem(medicos.get(i).getNombre());
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al conectar a la Base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Error clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void rellenaCBPaciente(){
        cbPaciente.removeAllItems();
        try{
            pacientes = this.servicios_pacientes.getAll(Conexion.obtener());
            for(int i=0;i<pacientes.size();i++){
                cbPaciente.addItem(pacientes.get(i).getNombre());
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al conectar a la Base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Error clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void guardar(){
        Integer habitacion = Integer.parseInt(txtHabitacion.getText());
        String fecha = dateChooser.getDate().toString();
        try{
            Medico medico = this.servicios_medicos.getByName(Conexion.obtener(), cbMedico.getSelectedItem().toString());
            Paciente paciente = this.servicios_pacientes.getByName(Conexion.obtener(), cbPaciente.getSelectedItem().toString());
            Ingreso ingreso = new Ingreso();
            ingreso.setHabitacion(habitacion);
            ingreso.setFecha(fecha);
            ingreso.setCodigo_m(medico.getCodigo());
            ingreso.setCodigo_p(paciente.getCodigoP());
            this.servicios_ingresos.create(Conexion.obtener(), ingreso);
            JOptionPane.showMessageDialog(null, "Exito!, se a Registrado correctamente");
        }catch(SQLException ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error al conectar a la Base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Error clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        ingresoTable = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtHabitacion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbMedico = new javax.swing.JComboBox<>();
        cbPaciente = new javax.swing.JComboBox<>();
        dateChooser = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(0, 0, 102));
        setClosable(true);
        setIconifiable(true);
        setTitle("Ingresos");
        setToolTipText("Gestione sus Ingresos aqui.");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ingresos-min.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(600, 400));

        ingresoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Habitacion", "Fecha", "Medico", "Paciente"
            }
        ));
        ingresoTable.setToolTipText("Muestra de los Ingresos actuales");
        jScrollPane1.setViewportView(ingresoTable);

        btnActualizar.setBackground(new java.awt.Color(204, 204, 255));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotacion.png"))); // NOI18N
        btnActualizar.setToolTipText("Actualiza la tabla.");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(204, 204, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ajustes-de-conversion.png"))); // NOI18N
        btnModificar.setToolTipText("Modifica un ingreso ya registrado");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(204, 204, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/goma-de-borrar.png"))); // NOI18N
        btnEliminar.setToolTipText("Elimina un ingreso ya existente");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(204, 204, 255));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar.png"))); // NOI18N
        btnRegistrar.setToolTipText("Registra un nuevo Ingreso");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registrar Ingreso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Habitacion:");

        txtHabitacion.setToolTipText("Ingrese el numero de la habitacion");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Medico:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Paciente:");

        cbMedico.setToolTipText("Seleccione al medico que lo atendera");

        cbPaciente.setToolTipText("Seleccione al paciente a ser atendido");

        dateChooser.setToolTipText("Ingrese la fecha de ingreso");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtHabitacion)
                    .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbMedico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbPaciente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(cbMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cbPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(233, Short.MAX_VALUE)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        //System.out.println(validar());
        if(validar()){
            if(dateChooser.getDate()!=null){
                this.guardar();
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese una fecha", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila_seleccionada = ingresoTable.getSelectedRow();
        if(fila_seleccionada >= 0){            
            int decision = JOptionPane.showConfirmDialog(null, "¿Está seguro/a que desea eliminar esta tarea?", "Advertencia", JOptionPane.YES_NO_OPTION);            
            if(decision == 0){
                try{
                    Ingreso ingreso = ingresos.get(fila_seleccionada);
                    //Medico medico = new Medico(apoyo.getCodigo(), apoyo.getNombre(), apoyo.getApellidos());
                    servicios_ingresos.delete(Conexion.obtener(), ingreso);
                    JOptionPane.showMessageDialog(null, "Exito!, se a borrado correctamente");
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

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        this.actualizarTabla();
        this.rellenaCBPaciente();
        this.rellenarCBMedico();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(validar()){
            if(ingresoTable.getSelectedRow()<0){
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
            }else{
                Ingreso apoyo = ingresos.get(ingresoTable.getSelectedRow());
                try{
                    Medico medico = this.servicios_medicos.getByName(Conexion.obtener(), cbMedico.getSelectedItem().toString());
                    Paciente paciente = this.servicios_pacientes.getByName(Conexion.obtener(), cbPaciente.getSelectedItem().toString());
                    Ingreso ingreso = new Ingreso(apoyo.getCodigoI(), 
                            Integer.parseInt(txtHabitacion.getText()), 
                            dateChooser.getDate().toString(), 
                            medico.getCodigo(), 
                            paciente.getCodigoP());
                    servicios_ingresos.create(Conexion.obtener(), ingreso);
                    JOptionPane.showMessageDialog(null, "Exito!, se a Modificado Correctamente");
                }catch(SQLException ex){
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Error al conectar a la Base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                }catch(ClassNotFoundException ex){
                    JOptionPane.showMessageDialog(null, "Error clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Campos Incompletos");
        }
    }//GEN-LAST:event_btnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbMedico;
    private javax.swing.JComboBox<String> cbPaciente;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JTable ingresoTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtHabitacion;
    // End of variables declaration//GEN-END:variables
}
