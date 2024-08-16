package MMUserInterface.MMForms;

import MMDataAccess.MMDAO.MMGenoAlimentoDAO;
import MMDataAccess.MMDAO.MMHormigaDAO;
import MMDataAccess.MMDAO.MMIngestaNativaDAO;
import MMDataAccess.MMDTO.MMGenoAlimentoDTO;
import MMDataAccess.MMDTO.MMHormigaDTO;
import MMDataAccess.MMDTO.MMIngestaNativaDTO;
import MMDataAccess.MMDataHelper.MMDataHelper;
import MMUserInterface.MMCustomerController.MMButton;
import MMUserInterface.MMCustomerController.MMComboBox;
import MMUserInterface.MMCustomerController.MMPanel;
import MMUserInterface.MMCustomerController.MMStyles;

import java.util.List;
import javax.swing.JOptionPane;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MMActionPanel extends MMPanel {

    private MMHormigaDAO hormigaDAO;
    private MMComboBox genoAlimentoComboBox;
    private MMComboBox ingestaNativaComboBox;
    private MMHormigueroPanel hormigueroPanel;

    public MMActionPanel(MMHormigueroPanel hormigueroPanel) {
        super(20, MMStyles.MMCOLOR_BORDER); // Cambia color de fondo de Alimentos
        this.hormigueroPanel = hormigueroPanel;

        // Inicializar hormigaDAO asegurando la conexión
        hormigaDAO = new MMHormigaDAO();

        MMIngestaNativaDAO ingestaDAO = new MMIngestaNativaDAO();
        MMGenoAlimentoDAO genoAlimentoDAO = new MMGenoAlimentoDAO();

        List<String> ingestaItems;
        List<String> genoAlimentoItems;

        try {
            ingestaItems = ingestaDAO.mmReadAll().stream().map(ingesta -> ingesta.getNombre()).toList();
            genoAlimentoItems = genoAlimentoDAO.mmReadAll().stream().map(genoAlimento -> genoAlimento.getNombre())
                    .toList();
        } catch (Exception e) {
            e.printStackTrace();
            ingestaItems = List.of("Error al cargar");
            genoAlimentoItems = List.of("Error al cargar");
        }

        genoAlimentoComboBox = new MMComboBox(genoAlimentoItems, "GenoAlimento");
        ingestaNativaComboBox = new MMComboBox(ingestaItems, "IngestaNativa");

        MMButton buttonAlimentarGA = new MMButton("Alimentar con Genoalimento", false,
                MMStyles.MMFONT_LANGOSTIONS_SMALL);
        MMButton buttonAlimentarIN = new MMButton("Alimentar con Ingesta Nativa", false,
                MMStyles.MMFONT_LANGOSTIONS_SMALL);

        buttonAlimentarGA.setBackground(MMStyles.MMCOLOR_FOREST_GREEN); //Color de Alimentar con Genoalimento
        buttonAlimentarIN.setBackground(MMStyles.MMCOLOR_FOREST_GREEN); // Color de Alimentar con Ingesta Nativa

        buttonAlimentarGA.addActionListener(e -> alimentarHormiga("GenoAlimento"));
        buttonAlimentarIN.addActionListener(e -> alimentarHormiga("IngestaNativa"));

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(genoAlimentoComboBox, gbc);

        gbc.gridx = 1;
        add(buttonAlimentarGA, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(ingestaNativaComboBox, gbc);

        gbc.gridx = 1;
        add(buttonAlimentarIN, gbc);
    }

    private void alimentarHormiga(String tipoAlimento) {
        MMHormigaDTO hormiga = hormigueroPanel.obtenerHormigaSeleccionada();
        if (hormiga == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una hormiga antes de alimentarla.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Obtener el id del alimento seleccionado y actualizar la hormiga
        if (tipoAlimento.equals("GenoAlimento")) {
            int idGenoAlimento = obtenerIdGenoAlimento(genoAlimentoComboBox.getSelectedItem().toString());
            hormiga.setIdGenoAlimento(idGenoAlimento);
        } else if (tipoAlimento.equals("IngestaNativa")) {
            int idIngestaNativa = obtenerIdIngestaNativa(ingestaNativaComboBox.getSelectedItem().toString());
            hormiga.setIdIngestaNativa(idIngestaNativa);
        }

        // Actualizar la base de datos
        try {
            hormigaDAO.mmUpdate(hormiga);
            hormigueroPanel.actualizarHormigaEnTabla(hormiga); // Opcional: Refrescar la tabla
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al actualizar el alimento de la hormiga", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private int obtenerIdGenoAlimento(String nombreGenoAlimento) {
        MMGenoAlimentoDAO genoAlimentoDAO = new MMGenoAlimentoDAO();
        try {
            List<MMGenoAlimentoDTO> genoAlimentos = genoAlimentoDAO.mmReadAll();
            for (MMGenoAlimentoDTO genoAlimento : genoAlimentos) {
                if (genoAlimento.getNombre().equals(nombreGenoAlimento)) {
                    return genoAlimento.getIdCatalogoAl();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; // Valor predeterminado en caso de no encontrar el alimento
    }

    private int obtenerIdIngestaNativa(String nombreIngestaNativa) {
        MMIngestaNativaDAO ingestaNativaDAO = new MMIngestaNativaDAO();
        try {
            List<MMIngestaNativaDTO> ingestaNativas = ingestaNativaDAO.mmReadAll();
            for (MMIngestaNativaDTO ingestaNativa : ingestaNativas) {
                if (ingestaNativa.getNombre().equals(nombreIngestaNativa)) {
                    return ingestaNativa.getIdCatalogoAl();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; // Valor predeterminado en caso de no encontrar el alimento
    }

}
