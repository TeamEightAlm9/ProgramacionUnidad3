package Vistas;

import Modelos.Usuario;
import Servicios.Conexion;
import Servicios.Servicios_Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Vista_Usuarios extends javax.swing.JInternalFrame {
    private final Servicios_Usuario servicio_usuario = new Servicios_Usuario();
    private List<Usuario> usuarios = new ArrayList<>();
    private Usuario actualUser;

    /**
     * Creates new form Vista_Usuarios
     */
    public Vista_Usuarios(Usuario user) {
        actualUser = user;
        initComponents();
        actualizarTabla();
        rellenarLabels();
        detGender();
    }
    
    public void detGender(){
        if(actualUser.getGender().equals("hombre")){
            genderBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hombre.png")));
        }else{
            genderBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/chica.png")));
        }
    }
    
    public void rellenarLabels(){
        idLbl.setText(actualUser.getId().toString());
        userLbl.setText(actualUser.getUser());
        passLbl.setText(actualUser.getPassword());
        genderLbl.setText(actualUser.getGender());
    }
    
    public void actualizarTabla(){
        try{
            this.usuarios = this.servicio_usuario.getAll(Conexion.obtener());
            DefaultTableModel tm = (DefaultTableModel) userTable.getModel();
            tm.setRowCount(0);
            for(int i=0;i<this.usuarios.size();i++){
                tm.addRow(new Object[]{
                    this.usuarios.get(i).getId(),
                    this.usuarios.get(i).getUser(),
                    this.usuarios.get(i).getGender()
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
        String user = txtUser.getText();
        String pass = txtPass.getText();
        validado = (!user.equals("") && !pass.equals(""))||(user.length()>50 || pass.length()>50);
        return validado;
    }
    
    public void guardar(){
        String nUser = txtUser.getText();
        String tPass = txtPass.getText();
        String gender = cbGender.getSelectedItem().toString();
        Usuario user = new Usuario();
        user.setUser(nUser);
        user.setPassword(tPass);
        user.setGender(gender);
        try{
            this.servicio_usuario.create(Conexion.obtener(), user);
            JOptionPane.showMessageDialog(this, "Se a guardado Correctamente!.");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        genderBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idLbl = new javax.swing.JLabel();
        userLbl = new javax.swing.JLabel();
        passLbl = new javax.swing.JLabel();
        genderLbl = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        txtUser = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPass = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbGender = new javax.swing.JComboBox<>();
        registrarBtn = new javax.swing.JButton();
        modificarBtn = new javax.swing.JButton();
        eliminarBtn = new javax.swing.JButton();
        actualizarBtn = new javax.swing.JButton();
        salirBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 102));
        setClosable(true);
        setIconifiable(true);
        setTitle("Gestion de Usuarios");
        setToolTipText("Administre sus usuarios");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/perfil-user.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(600, 500));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion del Usuario", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        genderBtn.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Id:");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Genero:");

        idLbl.setForeground(new java.awt.Color(255, 255, 255));
        idLbl.setText("id aqui");

        userLbl.setForeground(new java.awt.Color(255, 255, 255));
        userLbl.setText("usuario aqui");

        passLbl.setForeground(new java.awt.Color(255, 255, 255));
        passLbl.setText("contraseña aqui");

        genderLbl.setForeground(new java.awt.Color(255, 255, 255));
        genderLbl.setText("genero aqui");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(genderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idLbl)
                    .addComponent(userLbl)
                    .addComponent(passLbl)
                    .addComponent(genderLbl))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(userLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(genderLbl))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(genderBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestion de usuarios", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Usuario", "Genero"
            }
        ));
        userTable.setGridColor(new java.awt.Color(204, 204, 255));
        jScrollPane1.setViewportView(userTable);

        jLabel5.setText("Usuario:");

        jLabel6.setText("Contraseña:");

        jLabel7.setText("Genero:");

        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "hombre", "mujer" }));

        registrarBtn.setBackground(new java.awt.Color(204, 204, 255));
        registrarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar.png"))); // NOI18N
        registrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarBtnActionPerformed(evt);
            }
        });

        modificarBtn.setBackground(new java.awt.Color(204, 204, 255));
        modificarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ajustes-de-conversion.png"))); // NOI18N
        modificarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarBtnActionPerformed(evt);
            }
        });

        eliminarBtn.setBackground(new java.awt.Color(204, 204, 255));
        eliminarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/goma-de-borrar.png"))); // NOI18N
        eliminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBtnActionPerformed(evt);
            }
        });

        actualizarBtn.setBackground(new java.awt.Color(204, 204, 255));
        actualizarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rotacion.png"))); // NOI18N
        actualizarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarBtnActionPerformed(evt);
            }
        });

        salirBtn.setBackground(new java.awt.Color(204, 204, 255));
        salirBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar.png"))); // NOI18N
        salirBtn.setText("Salir");
        salirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(registrarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modificarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(eliminarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(actualizarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(salirBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(registrarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modificarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actualizarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(salirBtn)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirBtnActionPerformed

    private void actualizarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarBtnActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_actualizarBtnActionPerformed

    private void eliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBtnActionPerformed
        int fila_seleccionada = userTable.getSelectedRow();
        if(fila_seleccionada >= 0){
            int decision = JOptionPane.showConfirmDialog(null, "¿Está seguro/a que desea eliminar esta tarea?", "Advertencia", JOptionPane.YES_NO_OPTION);
            if(decision == 0){
                try{
                    Usuario apoyo = usuarios.get(fila_seleccionada);
                    servicio_usuario.delete(Conexion.obtener(), apoyo);
                    JOptionPane.showMessageDialog(this, "Hecho!, Se a eliminado correctamente.");
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
    }//GEN-LAST:event_eliminarBtnActionPerformed

    private void modificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBtnActionPerformed
        if(validar()){
            if(userTable.getSelectedRow()<0){
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
            }else{
                Usuario apoyo = usuarios.get(userTable.getSelectedRow());
                try{
                    Usuario user = new Usuario(apoyo.getId(), txtUser.getText(), txtPass.getText(), cbGender.getSelectedItem().toString());
                    servicio_usuario.create(Conexion.obtener(), user);
                    JOptionPane.showMessageDialog(this, "Se a Modificado Correctamente.");
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
    }//GEN-LAST:event_modificarBtnActionPerformed

    private void registrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarBtnActionPerformed
        if(this.validar()){
            this.guardar();
        }else{
            JOptionPane.showMessageDialog(null, "Campos Incompletos o Mayores a 50 caracteres");
        }
    }//GEN-LAST:event_registrarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarBtn;
    private javax.swing.JComboBox<String> cbGender;
    private javax.swing.JButton eliminarBtn;
    private javax.swing.JButton genderBtn;
    private javax.swing.JLabel genderLbl;
    private javax.swing.JLabel idLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificarBtn;
    private javax.swing.JLabel passLbl;
    private javax.swing.JButton registrarBtn;
    private javax.swing.JButton salirBtn;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUser;
    private javax.swing.JLabel userLbl;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}