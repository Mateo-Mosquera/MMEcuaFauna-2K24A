package MMUserInterface.MMForms;

import javax.swing.*;
import MMUserInterface.MMCustomerController.MMButton;
import MMUserInterface.MMCustomerController.MMStyles;
import java.awt.*;

public class MMHormigueroPanel extends JPanel {

    public MMHormigueroPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.05;
        gbc.anchor = GridBagConstraints.WEST;
        JLabel logoLabel = new JLabel(new ImageIcon(MMStyles.URL_ICON_ANT));
        add(logoLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 0.25;
        gbc.anchor = GridBagConstraints.WEST;
        JLabel titleLabel = new JLabel("Hormiguero virtual", JLabel.LEFT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(titleLabel, gbc);

        // Boton y texto de crear hormiga larva
        gbc.gridx = 3;
        gbc.gridwidth = 1;
        gbc.weightx = 0.1;
        gbc.anchor = GridBagConstraints.EAST;
        MMButton createAntButton = new MMButton("Crear hormiga larva", false);       
        createAntButton.setPreferredSize(new Dimension(150, 25));
        createAntButton.setBackground(Color.DARK_GRAY); // Cambia el color de fondo
        createAntButton.setForeground(Color.WHITE); // Cambia el color del texto
        add(createAntButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 6;
        gbc.weightx = 1.0;
        JPanel gridPanel = new JPanel(new GridLayout(3, 6, 10, 10));
        for (int i = 0; i < 18; i++) {
            JTextField field = new JTextField("");
            field.setEditable(false);
            field.setBackground(new Color(192, 192, 192));
            field.setPreferredSize(new Dimension(40, 25));
            gridPanel.add(field);
        }
        add(gridPanel, gbc);
    }
}
