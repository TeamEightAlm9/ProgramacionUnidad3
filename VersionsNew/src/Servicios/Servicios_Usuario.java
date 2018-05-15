package Servicios;

import Modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Servicios_Usuario {
    /** variable para controlar la tabla a la que se accede en la base de datos**/
    private final String tabla = "usuario";
    
    public void create(Connection conexion, Usuario usuario) throws SQLException{
        try{
            PreparedStatement consulta;
            if(usuario.getId()==null){
                consulta = conexion.prepareStatement("INSERT INTO "+this.tabla+"(user, password, gender) VALUES(?,?,?)");
                consulta.setString(1, usuario.getUser());
                consulta.setString(2, usuario.getPassword());
                consulta.setString(3, usuario.getGender());
            }else{
                consulta = conexion.prepareStatement("UPDATE "+this.tabla+" SET user=?, password=?, gender=? WHERE id=?");
                consulta.setString(1, usuario.getUser());
                consulta.setString(2, usuario.getPassword());
                consulta.setString(3, usuario.getGender());
                consulta.setInt(4, usuario.getId());
            }
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public Usuario getById(Connection conexion, int id) throws SQLException{
        Usuario usuario = null;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT user, password, gender FROM "+this.tabla+" WHERE id=?");
            consulta.setInt(1, id);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                usuario = new Usuario(id, resultado.getString("user"), resultado.getString("password"), resultado.getString("gender"));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return usuario;
    }
    
    public void delete(Connection conexion, Usuario usuario) throws SQLException{
        try{
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM "+this.tabla+" WHERE id=?");
            consulta.setInt(1, usuario.getId());
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public List<Usuario> getAll(Connection conexion) throws SQLException{
        List<Usuario> usuarios = new ArrayList<>();
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT id, user, password, gender FROM "+this.tabla);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                usuarios.add(new Usuario(resultado.getInt("id"), resultado.getString("user"), resultado.getString("password"), resultado.getString("gender")));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return usuarios;
    }
    
    public Usuario getByUser(Connection conexion, String user) throws SQLException{
        Usuario usuario =  null;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT id, user, password, gender FROM "+this.tabla+" WHERE user=?");
            consulta.setString(1, user);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                usuario = new Usuario(resultado.getInt("id"), resultado.getString("user"), resultado.getString("password"), resultado.getString("gender"));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        
        return usuario;
    }
}