/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CambiaPanel;

/**
 *
 * @author RojeruSan
 */
import javax.swing.JPanel;

public class CambiaPanel {
    //
    private final JPanel container;
    private final JPanel content;


    /**
     * Constructor de clase
     * @param container
     * @param content
     */
    public CambiaPanel(JPanel container, JPanel content) {
        this.container = container;
        this.content = content;
        try {
            
            
        this.container.removeAll();
        this.container.revalidate();
        this.container.repaint();
        
        this.container.add(this.content);
        this.container.revalidate();
        this.container.repaint();
        }catch(Exception ex){
            System.out.print(ex);
        }
       
        
    }

}//--> fin clase
