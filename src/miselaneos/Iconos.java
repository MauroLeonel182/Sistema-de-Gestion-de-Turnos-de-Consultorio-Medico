/*
 *Clase para trabajar con imagenes para los iconos que se van a necesitar
 *en la clase JButtons
 */
package miselaneos;

import java.awt.Image;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Leo
 */
public class Iconos {
     
    static final String SEP = System.getProperty("file.separator"); //constante que contiene el separador de directorios
    static final String PATHIMG = new File("").getAbsolutePath() + SEP;// constante que contiene la direccion donde se ejecuta el proyecto
    public Icon getKey;
    
    /**
     * Metodo que recibe un valor entero usado para el ancho, otro para el alto  y por ultimo una clase ImageIcon
     * Estos valores son usados para lograr una imagen redimensionada.-
     * @param x
     * @param y
     * @param icono
     * @return 
     */
    public ImageIcon getSizeIcon(int x, int y, ImageIcon icono){
        ImageIcon ImagenIconizable = icono;
        Image imgTrabajar = ImagenIconizable.getImage();
        Image imagenIconizable = imgTrabajar.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(imagenIconizable);
    }
    
    /**
     * Metodo que recibe el tamaño que se va usar tanto para ancho y alto de la imagen
     * @param size
     * @return 
     */
    
    public ImageIcon getSys(int size){
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/sys.png"));
        return getSizeIcon(size,size,icono);
    }
    
    public ImageIcon getAdd(int size){
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/add.png"));
        return getSizeIcon(size,size,icono);
    }
    
    public ImageIcon getEdit(int size){
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/edit.png"));
        return getSizeIcon(size,size,icono);
    }
    
    public ImageIcon getDelete(int size){
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/delete.png"));
        return getSizeIcon(size,size,icono);
    }
    
    public ImageIcon getList(int size){
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/list.png"));
        return getSizeIcon(size,size,icono);
    }
    
    public ImageIcon getFilter(int size){
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/filter.png"));
        return getSizeIcon(size,size,icono);
    }
    
    public ImageIcon getUser(int size){
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/user.png"));
        return getSizeIcon(size,size,icono);
    }
    
    public ImageIcon getClient(int size){
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/client.png"));
        return getSizeIcon(size,size,icono);
    }
    
    public ImageIcon getAcept(int size){
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/acept.png"));
        return getSizeIcon(size,size,icono);
    }
    
    public ImageIcon getExit(int size){
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/exit.png"));
        return getSizeIcon(size,size,icono);
    }
    
    public ImageIcon getLocation(int size){
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/location.png"));
        return getSizeIcon(size,size,icono);
    }
    
    public ImageIcon getProvince(int size){
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/province.png"));
        return getSizeIcon(size,size,icono);
    }
    
    public ImageIcon getUpdate(int size){
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/update.png"));
        return getSizeIcon(size,size,icono);
    }
    
    public ImageIcon getObraSocial(int size){
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/obrasocial.png"));
        return getSizeIcon(size,size,icono);
    }
    
    public ImageIcon getKey(int size){
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/key.png"));
        return getSizeIcon(size,size,icono);
    }
    
    public ImageIcon getClock(int size) {
        ImageIcon icono = new ImageIcon(getClass().getResource("/iconos/clock.png"));
        return getSizeIcon(size, size, icono);
    }
    
    public ImageIcon getCheck(int size) {
        ImageIcon icono = new ImageIcon(getClass().getResource("/iconos/check.png"));
        return getSizeIcon(size, size, icono);
    }
    
    public ImageIcon getEspecialidades(int size){
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/especialidades.png"));
        return getSizeIcon(size,size,icono);
    }
}
