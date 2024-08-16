package MMUserInterface.MMForms;

import javax.swing.*;

import MMUserInterface.MMCustomerController.MMButton;


import java.awt.*;

public class MMBottomPanel extends JPanel {

    public MMBottomPanel() {
        setLayout(new GridBagLayout());
        setBackground(Color.LIGHT_GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        MMButton eliminarButton = new MMButton("Eliminar", false);
        eliminarButton.setBackground(Color.CYAN); // Cambia el color de fondo
        eliminarButton.setForeground(Color.BLACK); // Cambia el color del texto
        add(eliminarButton, gbc);

        gbc.gridx = 1;
        MMButton guardarButton = new MMButton("Guardar", false);
        guardarButton.setBackground(Color.CYAN); // Cambia el color de fondo
        guardarButton.setForeground(Color.BLACK); // Cambia el color del texto
        add(guardarButton, gbc);

    }
}
