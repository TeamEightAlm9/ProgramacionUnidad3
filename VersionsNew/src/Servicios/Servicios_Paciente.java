package Servicios;

import Modelos.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Servicios_Paciente {
    /** variable para controlar el nombre de la tabla de la base de datos a la que sera accedida**/
    private final String tabla = "paciente";
    
    /** a continuacion se generan los metodos para  el sisemta basico CRUD**/
    public void create(Connection conexion, Paciente paciente) throws SQLException{
        try{
            PreparedStatement consulta;
            if(paciente.getCodigoP() == null){
                consulta = conexion.prepareStatement("INSERT INTO "+this.tabla+"(nombre,apellidos) VALUES(?,?)");
                consulta.setString(1, paciente.getNombre());
                consulta.setString(2, paciente.getApellidos());
            }else{
                consulta = conexion.prepareStatement("UPDATE "+this.tabla+" SET nombre=?, apellidos=? WHERE codigoP=?");
                consulta.setString(1, paciente.getNombre());
                consulta.setString(2, paciente.getApellidos());
                consulta.setInt(3, paciente.getCodigoP());
            }
            consulta.executeUpdate();
        }catch(SQLException ex){
                throw new SQLException(ex);
        }
    }
        
        public Paciente getById(Connection conexion, int codigoP) throws SQLException{
            Paciente paciente = null;
            try{
                PreparedStatement consulta = conexion.prepareStatement("SELECT nombre, apellidos FROM "+this.tabla+"WHERE codigoP=?");
                consulta.setInt(1, codigoP);
                ResultSet resultado = consulta.executeQuery();
                while(resultado.next()){
                    paciente = new Paciente(codigoP,resultado.getString("nombre"), resultado.getString("apellidos"));
                }
            }catch(SQLException ex){
                throw new SQLException(ex);
            }
            return paciente;
        }
        
        public void delete(Connection conexion, Paciente paciente) throws SQLException{
            try{
                PreparedStatement consulta = conexion.prepareStatement("DELETE FROM "+this.tabla+" WHERE codigoP=?");
                consulta.setInt(1, paciente.getCodigoP());
                consulta.executeUpdate();
            }catch(SQLException ex){
                throw new SQLException(ex);
            }
        }
        
        /** este metodo nos retornara todos los registros en una lista, sirve para poder enlistarlos en un JList **/
    public List<Paciente> getAll(Connection conexion) throws SQLException{
        List<Paciente> pacientes = new ArrayList<>();
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT codigoP, nombre, apellidos FROM "+this.tabla);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                pacientes.add(new Paciente(resultado.getInt("codigoP"), resultado.getString("nombre"), resultado.getString("apellidos")));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return pacientes;
    }
    
    public Paciente getByName(Connection conexion, String nombre) throws SQLException{
        Paciente paciente = null;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT codigoP, nombre, apellidos FROM "+this.tabla+" WHERE nombre=?");
            consulta.setString(1, nombre);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                paciente = new Paciente(resultado.getInt("codigoP"), resultado.getString("nombre"), resultado.getString("apellidos"));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return paciente;
    }
}
