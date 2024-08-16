package MMUserInterface.MMForms;

import javax.swing.*;

import MMUserInterface.MMCustomerController.MMTextBox;

import java.awt.*;

public class MMCedulaPanel extends JPanel {

    public MMCedulaPanel() {
        setLayout(new GridBagLayout());
        setBackground(Color.LIGHT_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Alineación y ajustes
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Cedula:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1.0;
        MMTextBox cedulaField = new MMTextBox();
        cedulaField.setPreferredSize(new Dimension(200, 25));
        add(cedulaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Nombres:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1.0;
        MMTextBox nombresField = new MMTextBox();
        nombresField.setPreferredSize(new Dimension(200, 25));
        add(nombresField, gbc);
    }
}
