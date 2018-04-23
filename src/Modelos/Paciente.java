package Modelos;

public class Paciente {
    private final Integer codigoP;
    private String nombre;
    private String apellidos;
    
    public Paciente(){
        this.codigoP = null;
        this.nombre = null;
        this.apellidos = null;
    }
    
    public Paciente(Integer codigoP, String nombre, String apellidos){
        this.codigoP = codigoP;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    
    public Integer getCodigoP(){
        return codigoP;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public  String getApellidos(){
        return apellidos;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
}
