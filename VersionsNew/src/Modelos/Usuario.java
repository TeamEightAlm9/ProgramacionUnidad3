package Modelos;

public class Usuario {
    private final Integer id;
    private String usuario;
    private String password;
    private String genero;
    
    public Usuario(){
        this.id = null;
        this.usuario = null;
        this.password = null;
        this.genero = null;
    }
    
    public Usuario(Integer id, String usuario, String password, String genero){
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.genero = genero;
    }
    
    public Integer getId(){
        return id;
    }
    
    public String getUser(){
        return usuario;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getGender(){
        return genero;
    }
    
    public void setUser(String usuario){
        this.usuario = usuario;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setGender(String gender){
        this.genero = gender;
    }
}
