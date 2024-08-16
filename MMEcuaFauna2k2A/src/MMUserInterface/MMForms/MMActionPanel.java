package MMUserInterface.MMForms;

import javax.swing.*;

import MMUserInterface.MMCustomerController.MMButton;
import MMUserInterface.MMCustomerController.MMComboBox;

import java.awt.*;

public class MMActionPanel extends JPanel {

    public MMActionPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        /*MMButton GenoAlimentoButton = new MMButton("<GenoAlimento>", false);
        GenoAlimentoButton.setBackground(Color.BLACK);
        GenoAlimentoButton.setForeground(Color.WHITE);
        add(GenoAlimentoButton, gbc);*/
        
        add(new MMComboBox(new String[] { "<GenoAlimento>" }), gbc);

        gbc.gridx = 1;
        MMButton alimentarButton = new MMButton("Alimentar con Genoalimento", false);
        alimentarButton.setBackground(Color.DARK_GRAY); // Cambia el color de fondo
        alimentarButton.setForeground(Color.WHITE); // Cambia el color del texto
        add(alimentarButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        /*MMButton IngestaNativaButton = new MMButton("<IngestaNativa>", false);
        IngestaNativaButton.setBackground(Color.BLACK);
        IngestaNativaButton.setForeground(Color.WHITE);
        add(IngestaNativaButton, gbc);*/
        add(new MMComboBox(new String[] { "<IngestaNativa>" }), gbc);

        gbc.gridx = 1;
        MMButton ingestaButton = new MMButton("Alimentar con Ingesta Nativa", false);
        ingestaButton.setBackground(Color.DARK_GRAY); // Cambia el color de fondo 
        ingestaButton.setForeground(Color.WHITE); // Cambia el color del texto 
        add(ingestaButton, gbc);
    }
}
