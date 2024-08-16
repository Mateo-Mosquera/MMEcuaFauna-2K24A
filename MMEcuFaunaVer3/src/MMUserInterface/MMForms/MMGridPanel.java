package MMUserInterface.MMForms;

import javax.swing.*;

import MMUserInterface.MMCustomerController.MMButton;
import MMUserInterface.MMCustomerController.MMStyles;

import java.awt.*;

public class MMGridPanel extends JPanel {

    public MMGridPanel() {
        setLayout(new BorderLayout());

        JLabel logoLabel = new JLabel(new ImageIcon(MMStyles.URL_ICON_ANT));
        add(logoLabel, BorderLayout.WEST);

        // Ajuste de la grilla para 3 filas y 4 columnas
        JPanel grid = new JPanel(new GridLayout(3, 4, 5, 5));
        for (int i = 0; i < 12; i++) { // 3x4 = 12 cuadros
            grid.add(new JLabel(""));
        }
        add(grid, BorderLayout.CENTER);

    
        MMButton createAntButton = new MMButton("Crear hormiga larva", false, MMStyles.MMFONT_LANGOSTIONS);
        add(createAntButton, BorderLayout.EAST);
    }
}
