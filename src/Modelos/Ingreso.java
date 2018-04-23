package Modelos;

import java.sql.Date;

public class Ingreso {
    private final Integer codigoI;
    private Integer habitacion;
    private Date fecha;
    private Integer codigo_m;
    private Integer codigo_p;
    
    public Ingreso(){
        this.codigoI = null;
        this.habitacion = null;
        this.fecha = null;
        this.codigo_m = null;
        this.codigo_p = null;
    }
    
    public Ingreso(Integer codigoI, Integer habitacion, Date fecha, Integer codigo_m, Integer codigo_p){
        this.codigoI = codigoI;
        this.habitacion = habitacion;
        this.fecha = fecha;
        this.codigo_m = codigo_m;
        this.codigo_p = codigo_p;
    }
    
    public Integer getCodigoI(){
        return codigoI;
    }
    
    public Integer getHabitacion(){
        return habitacion;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    public Integer getCodigo_m(){
        return codigo_m;
    }
    
    public Integer getCodigo_p(){
        return codigo_p;
    }
    
    public void setHabitacion(Integer habitacion){
        this.habitacion = habitacion;
    }
    
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    
    public void setCodigo_m(Integer codigo_m){
        this.codigo_m = codigo_m;
    }
    
    public void setCodigo_p(Integer codigo_p){
        this.codigo_p = codigo_p;
    }
}
