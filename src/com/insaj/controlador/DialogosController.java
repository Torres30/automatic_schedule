/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.insaj.controlador;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JDialog;

public class DialogosController {
    public void MostrarNuevoDialogo(JDialog diag, String titulo){
        
       diag.setModal(true);
       diag.setResizable(false);
       diag.setTitle(titulo);
       /* try{
            BufferedImage myImg;
            myImg = ImageIO.read(diag.getClass().getResourceAsStream("/icons/Frame-Icon1.png" ));
            diag.setIconImage(myImg);
        }catch(IOException ie){
                //error al poner icon
        }*/
        
        diag.setVisible(true);
       // WebLookAndFeel.setDecorateDialogs ( decorateFrames );
    } 
}
