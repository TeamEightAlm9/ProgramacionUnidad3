package Servicios;

import java.sql.*;

public class Conexion {
    /** generacion de connection cnx, esta permite acceder a la base de datos**/
    private static Connection cnx = null;
    /** variables solo de apoyo para datos de acceso a la base de datos**/
    private static String hostname = "localhost";
    private static String user = "root";
    private static String p = "";
    /** añadidos post creacion de clase **/
    /** variable para administrar el nombre de la base de datos **/
    private static String nameDB = "hospital";
    
    
    /** metodo para generar la conexion, esta sera utilziada para los metodos en las vistas**/
    public static Connection obtener() throws SQLException, ClassNotFoundException{
        if(cnx == null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://"+hostname+"/"+nameDB, user, p);
            }catch(SQLException ex){
                throw new SQLException(ex);
            }catch(ClassNotFoundException ex){
                throw new ClassNotFoundException(ex.getMessage());
            }
        }
        return cnx;
    }
    
    
    /** es necesario terminar la conexion con la base de datos**/
    public static void cerrar() throws SQLException{
        if(cnx!=null){
            cnx.close();
        }
    }
}
