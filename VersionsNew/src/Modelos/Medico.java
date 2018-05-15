package Modelos;


public class Medico {
    private final Integer codigo;
    private String nombre;
    private String apellidos;
    
    public Medico(){
        this.codigo = null;
        this. nombre = null;
        this.apellidos = null;
    }
    
    public Medico(Integer codigo, String nombre, String apellidos){
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    
    public Integer getCodigo(){
        return codigo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getApellidos(){
        return apellidos;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    
}
