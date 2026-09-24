/*
 * SUPERCLASE PARA ETIQUETAS O JLabel
 */
package etiquetas;

import javax.swing.JLabel;
import static clinica.FrmSistema.iconos;

/**
 *
 * @author Leo
 */
public class LblFilter extends JLabel{
    
    public LblFilter(){
        setText("Filtrar");
        setIcon(iconos.getFilter(16));
    }
    
}
