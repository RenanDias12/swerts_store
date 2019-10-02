package view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class LojaVazia extends javax.swing.JInternalFrame {

    public LojaVazia() {
        initComponents();
        try {
            BufferedImage imagemBuffer = null;
            String caminho = "src/img/lojaVazia.jpg";
            //String caminho = "test/lojaVazia.jpg";
            imagemBuffer = ImageIO.read(new File(caminho));
            Image diminuirImagem = imagemBuffer.getScaledInstance(1346, 600, 0);
            imagem.setIcon(new ImageIcon(diminuirImagem));
        } catch (IOException ex) {
            System.out.println("Erro = " + ex);
        } catch (NullPointerException ex1) {
            System.out.println("Erro = " + ex1);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagem = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1346, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagem, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagem, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imagem;
    // End of variables declaration//GEN-END:variables
}
