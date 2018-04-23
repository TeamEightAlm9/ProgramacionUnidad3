package Servicios;

import Modelos.Ingreso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Servicios_Ingreso {
    /** variabel para  controlar nombre de la tabla de la base de datos a la cual se accedera **/
    private final String tabla = "ingreso";
    
    public void create(Connection conexion, Ingreso ingreso) throws SQLException{
        try{
            PreparedStatement consulta;
            if(ingreso.getCodigoI()==null){
            consulta = conexion.prepareStatement("INSERT INTO "+this.tabla+"(habitacion, fecha, codigo_m, codigo_p) VALUES (?,?,?,?)");
            consulta.setInt(1, ingreso.getHabitacion());
            consulta.setDate(2, ingreso.getFecha());
            consulta.setInt(3, ingreso.getCodigo_m());
            consulta.setInt(4, ingreso.getCodigo_p());
            }else{
                consulta = conexion.prepareStatement("UPDATE "+this.tabla+" SET habitacion=?, fecha=?, codigo_m=?, codigo_p=? WHERE codigoI=?");
                consulta.setInt(1, ingreso.getHabitacion());
                consulta.setDate(2, ingreso.getFecha());
                consulta.setInt(3, ingreso.getCodigo_m());
                consulta.setInt(4, ingreso.getCodigo_p());
                consulta.setInt(5, ingreso.getCodigoI());
            }
            consulta.executeQuery();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public Ingreso getById(Connection conexion, int codigoI) throws SQLException{
        Ingreso ingreso = null;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT habitacion, fecha, codigo_m, codigo_p FROM "+this.tabla+" WHERE codigoI=?");
            consulta.setInt(1, codigoI);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                ingreso = new Ingreso(codigoI, resultado.getInt("habitacion"), resultado.getDate("fecha"), resultado.getInt("codigo_m"), resultado.getInt("codigo_p"));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return ingreso;
    }
    
    public void delete(Connection conexion, Ingreso ingreso) throws SQLException{
        try{
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM "+this.tabla+"WHERE codigoI=?");
            consulta.setInt(1, ingreso.getCodigoI());
            consulta.executeQuery();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    
    public List<Ingreso> getAll(Connection conexion) throws SQLException{
        List<Ingreso> ingresos = new ArrayList<>();
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT codigoI, habitacion, fecha, codigo_m, codigo_p FROM "+this.tabla);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                ingresos.add(new Ingreso(resultado.getInt("codigoI"), resultado.getInt("habitacion"), resultado.getDate("fecha"), resultado.getInt("codigo_m"), resultado.getInt("codigo_p")));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return ingresos;
    }
}
