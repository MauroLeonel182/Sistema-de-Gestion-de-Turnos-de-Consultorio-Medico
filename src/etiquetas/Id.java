/*
 *  CLASE PARA MOSTRAR UN TEXTO E ICONO ASOCIADO
 */
package etiquetas;

import static clinica.FrmSistema.iconos;

/**
 *
 * @author Leo
 */
public class Id extends Lbl{
    
    public Id(){
        setText("Id: ");
        setIcon(iconos.getKey(16));
        
    }
}
