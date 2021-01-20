/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio.pkg1;

import javax.swing.UIManager;
import laboratorio.pkg1.vista.ReproductorMP3;

/**
 *
 * @author Casa
 */
public class Laboratorio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
            UIManager.put("RootPane.setupButtonVisible", false);
        } catch (Exception e) {
        }
        ReproductorMP3 ventana = new ReproductorMP3();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

}
