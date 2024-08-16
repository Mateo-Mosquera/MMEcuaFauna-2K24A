package MMUserInterface.MMForms;

import MMDataAccess.MMDAO.MMHormigaDAO;
import MMDataAccess.MMDTO.MMHormigaDTO;
import MMUserInterface.MMCustomerController.MMButton;
import MMUserInterface.MMCustomerController.MMPanel;
import MMUserInterface.MMCustomerController.MMStyles;

import java.awt.*;

import javax.swing.JOptionPane;

public class MMBottomPanel extends MMPanel {

    private MMHormigueroPanel hormigueroPanel;
    private MMHormigaDAO hormigaDAO;

    public MMBottomPanel(MMHormigueroPanel hormigueroPanel) {
        super(15, MMStyles.MMCOLOR_GREEN);
        this.hormigueroPanel = hormigueroPanel;
        hormigaDAO = new MMHormigaDAO();

        MMButton buttonEliminar = new MMButton("Eliminar", false, MMStyles.MMFONT_LANGOSTIONS_SMALL);
        MMButton buttonGuardar = new MMButton("Guardar", false, MMStyles.MMFONT_LANGOSTIONS_SMALL);

        buttonEliminar.setBackground(Color.RED);  // Color de Eliminar
        buttonGuardar.setBackground(Color.GREEN);// Color de Guardar

        buttonGuardar.addActionListener(e -> guardarCambios());
        buttonEliminar.addActionListener(e -> eliminarHormiga());

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(buttonEliminar, gbc);

        gbc.gridx = 1;
        add(buttonGuardar, gbc);
    }

    private void guardarCambios() {
        MMHormigaDTO hormiga = hormigueroPanel.obtenerHormigaSeleccionada();
        if (hormiga != null) {
            try {
                hormigaDAO.mmUpdate(hormiga);
                JOptionPane.showMessageDialog(this, "Cambios guardados exitosamente", "Guardar",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al guardar los cambios", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void eliminarHormiga() {
        MMHormigaDTO hormiga = hormigueroPanel.obtenerHormigaSeleccionada();
        if (hormiga != null) {
            try {
                hormigaDAO.mmDelete(hormiga.getIdHormiga());
                hormigueroPanel.cargarHormigas(); // Recargar la tabla después de eliminar
                JOptionPane.showMessageDialog(this, "Hormiga eliminada exitosamente", "Eliminar",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al eliminar la hormiga", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
