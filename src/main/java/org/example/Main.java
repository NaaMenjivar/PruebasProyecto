package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
            // Manejo de la excepción si no se puede establecer el look and feel
        }

        JFrame window = new JFrame("Cambiar Clave");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Instancia el panel con el formulario
        CambiarClave panel = new CambiarClave();

        // Agrega el panel a la ventana
        window.setContentPane(panel);

        // Empaqueta para ajustar el tamaño y hace visible la ventana
        window.pack();
        window.setLocationRelativeTo(null); // Centra la ventana
        window.setVisible(true);
    }
}