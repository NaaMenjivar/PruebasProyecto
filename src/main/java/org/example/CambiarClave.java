package org.example;

import org.example.Modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CambiarClave extends JPanel {
    private JLabel ClaveActual;
    private JLabel ClaveNueva;
    private JLabel Confirmacion;
    private JButton Guardar;
    private JButton Cancelar;
    private JRadioButton MostrarClaveActual;
    private JRadioButton MostrarClaveNueva;
    private JRadioButton MostrarConfirmacion;
    private JPasswordField EspacioClaveActual;
    private JPasswordField EspacioClaveNueva;
    private JPasswordField ConfirmarClaveNueva;

    public CambiarClave() {
        // Usa un BorderLayout para la estructura principal
        setLayout(new BorderLayout(10, 10));

        // 1. Panel para los campos de texto y los radio buttons
        JPanel panelCampos = new JPanel(new GridLayout(3, 3, 5, 5));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        ClaveActual = new JLabel("Clave Actual:");
        EspacioClaveActual = new JPasswordField(15);
        MostrarClaveActual = new JRadioButton();

        ClaveNueva = new JLabel("Clave Nueva:");
        EspacioClaveNueva = new JPasswordField(15);
        MostrarClaveNueva = new JRadioButton();

        Confirmacion = new JLabel("Confirmar Clave:");
        ConfirmarClaveNueva = new JPasswordField(15);
        MostrarConfirmacion = new JRadioButton();

        // Carga y escala los íconos para los radio buttons (ojos)
        try {
            ImageIcon ojoCerrado = new ImageIcon(getClass().getResource("/images/ojo_cerrado.png"));
            ImageIcon ojoAbierto = new ImageIcon(getClass().getResource("/images/ojo_abierto.png"));

            Image ojoCerradoEscalado = ojoCerrado.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
            Image ojoAbiertoEscalado = ojoAbierto.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);

            ImageIcon ojoCerradoIcon = new ImageIcon(ojoCerradoEscalado);
            ImageIcon ojoAbiertoIcon = new ImageIcon(ojoAbiertoEscalado);

            MostrarClaveActual.setIcon(ojoCerradoIcon);
            MostrarClaveActual.setSelectedIcon(ojoAbiertoIcon);

            MostrarClaveNueva.setIcon(ojoCerradoIcon);
            MostrarClaveNueva.setSelectedIcon(ojoAbiertoIcon);

            MostrarConfirmacion.setIcon(ojoCerradoIcon);
            MostrarConfirmacion.setSelectedIcon(ojoAbiertoIcon);

        } catch (Exception e) {
            System.err.println("No se pudieron cargar los íconos de los radio buttons.");
        }

        // Agrega los componentes al panel de campos
        panelCampos.add(ClaveActual);
        panelCampos.add(EspacioClaveActual);
        panelCampos.add(MostrarClaveActual);

        panelCampos.add(ClaveNueva);
        panelCampos.add(EspacioClaveNueva);
        panelCampos.add(MostrarClaveNueva);

        panelCampos.add(Confirmacion);
        panelCampos.add(ConfirmarClaveNueva);
        panelCampos.add(MostrarConfirmacion);

        // 2. Panel para los botones (sección inferior)
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        Guardar = new JButton();
        Cancelar = new JButton();

        // Carga y escala las imágenes para los botones
        try {
            ImageIcon iconoOriginalGuardar = new ImageIcon(getClass().getResource("/images/save_icon.jpg"));
            ImageIcon iconoOriginalCancelar = new ImageIcon(getClass().getResource("/images/cancel_icon.jpg"));

            Image imagenEscaladaGuardar = iconoOriginalGuardar.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            Image imagenEscaladaCancelar = iconoOriginalCancelar.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);

            ImageIcon iconoGuardar = new ImageIcon(imagenEscaladaGuardar);
            ImageIcon iconoCancelar = new ImageIcon(imagenEscaladaCancelar);

            Guardar.setIcon(iconoGuardar);
            Cancelar.setIcon(iconoCancelar);

            // Elimina el borde y el fondo para que solo se vea la imagen
            Guardar.setContentAreaFilled(false);
            Guardar.setBorderPainted(false);
            Guardar.setFocusPainted(false);

            Cancelar.setContentAreaFilled(false);
            Cancelar.setBorderPainted(false);
            Cancelar.setFocusPainted(false);

        } catch (Exception e) {
            System.err.println("No se pudieron cargar las imágenes de los botones.");
            e.printStackTrace();
        }

        panelBotones.add(Guardar);
        panelBotones.add(Cancelar);

        // Agrega los paneles al panel principal con BorderLayout
        add(panelCampos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        // 3. Configura los Listeners
        Guardar.addActionListener(e -> procesarDatos());
        Cancelar.addActionListener(e -> limpiarCampos());

        ActionListener mostrarClaveListener = e -> {
            JRadioButton rb = (JRadioButton) e.getSource();
            if (rb.equals(MostrarClaveActual)) {
                EspacioClaveActual.setEchoChar(rb.isSelected() ? (char) 0 : '*');
            } else if (rb.equals(MostrarClaveNueva)) {
                EspacioClaveNueva.setEchoChar(rb.isSelected() ? (char) 0 : '*');
            } else if (rb.equals(MostrarConfirmacion)) {
                ConfirmarClaveNueva.setEchoChar(rb.isSelected() ? (char) 0 : '*');
            }
        };

        MostrarClaveActual.addActionListener(mostrarClaveListener);
        MostrarClaveNueva.addActionListener(mostrarClaveListener);
        MostrarConfirmacion.addActionListener(mostrarClaveListener);
    }

    private void limpiarCampos() {
        EspacioClaveActual.setText("");
        EspacioClaveNueva.setText("");
        ConfirmarClaveNueva.setText("");
        MostrarClaveActual.setSelected(false);
        MostrarClaveNueva.setSelected(false);
        MostrarConfirmacion.setSelected(false);
        EspacioClaveActual.setEchoChar('*');
        EspacioClaveNueva.setEchoChar('*');
        ConfirmarClaveNueva.setEchoChar('*');
        EspacioClaveActual.requestFocusInWindow();
    }

    private void procesarDatos() {
        String claveActual = new String(EspacioClaveActual.getPassword());
        String nuevaClave = new String(EspacioClaveNueva.getPassword());
        String confirmacionClave = new String(ConfirmarClaveNueva.getPassword());
        if (!nuevaClave.equals(confirmacionClave)) {
            JOptionPane.showMessageDialog(this, "Las nuevas claves no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Clave miClave = new Clave(claveActual, nuevaClave);
        JOptionPane.showMessageDialog(this, "Clave cambiada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        limpiarCampos();
        System.out.println("Clave actual: " + miClave.getClaveActual());
        System.out.println("Nueva clave: " + miClave.getNuevaClave());
    }
}