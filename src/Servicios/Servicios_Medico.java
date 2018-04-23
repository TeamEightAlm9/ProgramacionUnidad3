package Servicios;

import Modelos.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Servicios_Medico {
    /** nombre de la tabla de la base de datos a la cual se accedera **/
    private final String tabla = "medico";
    
    /** Metodos CRUD para realizar operaciones basicas **/
    public void create(Connection conexion, Medico medico) throws SQLException{
        try{
            PreparedStatement consulta;
            if(medico.getCodigo()==null){
                consulta = conexion.prepareStatement("INSERT INTO " + this.tabla +"(nombre, apellidos) VALURES(?,?)");
                consulta.setString(1, medico.getNombre());
                consulta.setString(2, medico.getApellidos());
            }else{
                consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET nombre = ?, apellidos = ? WHERE codigo=?");
                consulta.setString(1, medico.getNombre());
                consulta.setString(2, medico.getApellidos());
                consulta.setInt(3, medico.getCodigo());
            }
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public Medico getById(Connection conexion, int codigo) throws SQLException{
        Medico medico = null;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT nombre, apellidos FROM"+this.tabla+"WHERE codigo = ?");
            consulta.setInt(1, codigo);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                medico = new Medico(codigo, resultado.getString("nombre"), resultado.getString("apellidos"));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return medico;
    }
    
    public void delete(Connection conexion, Medico medico) throws SQLException{
        try{
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM"+this.tabla+"WHERE codigo = ?");
            consulta.setInt(1, medico.getCodigo());
            consulta.executeQuery();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    /** este metodo nos retornara todos los registros en una lista, sirve para poder enlistarlos en un JList **/
    public List<Medico> getAll(Connection conexion) throws SQLException{
        List<Medico> medicos = new ArrayList<>();
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT codigo, nombre, apellidos FROM "+this.tabla);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                medicos.add(new Medico(resultado.getInt("codigo"), resultado.getString("nombre"), resultado.getString("apellidos")));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return medicos;
    }
}
