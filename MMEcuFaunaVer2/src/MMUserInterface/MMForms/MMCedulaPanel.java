package MMUserInterface.MMForms;

import java.awt.*;

import javax.swing.JLabel;

import MMUserInterface.MMCustomerController.MMPanel;
import MMUserInterface.MMCustomerController.MMTextBox;
import MMUserInterface.MMCustomerController.MMStyles;

public class MMCedulaPanel extends MMPanel {

    public String mmNombre = "Mateo Mosquera";
    public String mmCedula = "175136688-9";

    public MMCedulaPanel() {
        // Configuración del panel con bordes redondeados y fondo transparente
        super(20, MMStyles.MMCOLOR_BORDER); // Color panel de cedula y nombre

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Aumentar márgenes

        // Alineación y ajustes para el campo "Cedula"
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        JLabel cedulaLabel = new JLabel("Cedula del alumno:");
        cedulaLabel.setFont(MMStyles.MMFONT_LANGOSTIONS_SMALL); // Establecer fuente personalizada
        add(cedulaLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1.0;
        MMTextBox cedulaField = new MMTextBox();
        cedulaField.setFont(MMStyles.MMFONT_LANGOSTIONS_SMALL); // Establecer fuente personalizada
        cedulaField.setText(mmCedula); // Inicializar con el valor de la cédula
        cedulaField.setEditable(false); // Deshabilitar el campo de edición
        cedulaField.setPreferredSize(new Dimension(200, 25)); // Ajustar tamaño
        add(cedulaField, gbc);

        // Alineación y ajustes para el campo "Nombres"
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        JLabel nombresLabel = new JLabel("Nombres completos del alumno:");
        nombresLabel.setFont(MMStyles.MMFONT_LANGOSTIONS_SMALL); // Establecer fuente personalizada
        add(nombresLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1.0;
        MMTextBox nombresField = new MMTextBox();
        nombresField.setFont(MMStyles.MMFONT_LANGOSTIONS_SMALL); // Establecer fuente personalizada
        nombresField.setText(mmNombre); // Inicializar con el valor del nombre
        nombresField.setEditable(false); // Deshabilitar el campo de edición
        nombresField.setPreferredSize(new Dimension(200, 25)); // Ajustar tamaño
        add(nombresField, gbc);
    }
}
