/**
 * Clase que extiende el swing worker, sirve a la barra de progreso
 **/
package Config;

import Vistas.Vista_Principal;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;


public class Progreso extends SwingWorker<Integer, String>{

    // Atributos de la clase
    private JProgressBar barra;
    private Vista_Principal aplicacion;

    public Progreso(JProgressBar barra, Vista_Principal aplicacion) {
        this.barra = barra;
        this.aplicacion = aplicacion;
    }
    
    /**
     * @return the aplicacion
     */
    public Vista_Principal getAplicacion() {
        return aplicacion;
    }

    /**
     * @param aplicacion the aplicacion to set
     */
    public void setAplicacion(Vista_Principal aplicacion) {
        this.aplicacion = aplicacion;
    }

    public JProgressBar getBarra() {
        return barra;
    }

    public void setBarra(JProgressBar barra) {
        this.barra = barra;
    }
    
    @Override
    protected Integer doInBackground() throws Exception {
        //la siguiente linea hace que la barra no tenga un fin por ende solo parece cargar pero no muestra
        //progreso
        //barra.setIndeterminate(true);
        try {
            for(int i=0;i<=100;i++){
                barra.setValue(i);
                Thread.sleep(100);
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
        aplicacion.iniciarSesion();
        return 0;
    }
    
}
