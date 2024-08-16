package MMUserInterface.MMForms;

import javax.swing.*;

import MMUserInterface.MMCustomerController.MMStyles;

import java.awt.*;

public class MMMainPanel extends JPanel {

    public MMMainPanel() {
        setBackground(MMStyles.MMCOLOR_GREEN);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1.0;
        gbc.weighty = 0.2;

        MMHormigueroPanel hormigueroPanel = new MMHormigueroPanel();
        MMActionPanel actionPanel = new MMActionPanel(hormigueroPanel);
        MMBottomPanel bottomPanel = new MMBottomPanel(hormigueroPanel);

        // Fila 1: CedulaPanel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(new MMCedulaPanel(), gbc);

        // Fila 2: HormigueroPanel
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weighty = 0.6;
        gbc.anchor = GridBagConstraints.CENTER;
        add(hormigueroPanel, gbc);

        // Fila 3: ActionPanel
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(actionPanel, gbc);

        // Fila 4: BottomPanel
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(bottomPanel, gbc);
    }
}
