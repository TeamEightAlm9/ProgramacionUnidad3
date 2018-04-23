/**
 *Clase para generar Rutas y agilizar el proceso de acceso a archivos externos
 *Hecho por Leonardo Daniel Castro Morales
 **/
package Config;

import java.io.File;

public class GeneraRuta {
    private static String mainPath;
    private static String configPath;
    private static String imagePath;
    
    public GeneraRuta(){
        File path = new File("");
        mainPath = path.getAbsolutePath();
        configPath = mainPath +"/Config";
        imagePath = configPath + "/Images";
    }
    
    public String printMainPath(){
        return mainPath;
    }
    
    public String printConfigPath(){
        return configPath;
    }
    
    public String printImagePath(){
        return imagePath;
    }
}
