package MMUserInterface.MMForms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import MMBusinessLogic.MMHormigaBL;
import MMDataAccess.MMDAO.MMHormigaDAO;
import MMDataAccess.MMDTO.MMHormigaDTO;
import MMUserInterface.MMCustomerController.MMButton;
import MMUserInterface.MMCustomerController.MMPanel;
import MMUserInterface.MMCustomerController.MMStyles;

import java.awt.*;
import java.util.List;


public class MMHormigueroPanel extends MMPanel {

    private JTable tablaHormigas;
    private MMHormigaDAO hormigaDAO;
    private MMHormigaBL hormigaBL; // Declara una instancia de MMHormigaBL


    public MMHormigueroPanel() {
        super(20, MMStyles.MMCOLOR_GREEN); // Mantiene el fondo del panel principal
        hormigaDAO = new MMHormigaDAO();
        hormigaBL = new MMHormigaBL(); // Instancia MMHormigaBL
        

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
        JLabel titleLabel = new JLabel("  Hormiguero virtual", JLabel.LEFT);
        titleLabel.setFont(MMStyles.MMFONT_LANGOSTIONS);
        add(titleLabel, gbc);

        gbc.gridx = 3;
        gbc.gridwidth = 1;
        gbc.weightx = 0.1;
        gbc.anchor = GridBagConstraints.EAST;
        MMButton createAntButton = new MMButton("Crear hormiga larva", false, MMStyles.MMFONT_LANGOSTIONS_SMALL);
        createAntButton.setPreferredSize(new Dimension(150, 25));
        createAntButton.setBackground(MMStyles.MMCOLOR_FOREST_GREEN); 
        add(createAntButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 6;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        tablaHormigas = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaHormigas);
        add(scrollPane, gbc);

        cargarHormigas();
    }

    public void cargarHormigas() {
        try {
            List<MMHormigaDTO> hormigas = hormigaDAO.mmReadAll();
            DefaultTableModel model = new DefaultTableModel(
                    new String[] { "Nombre", "Sexo", "GenoAlimento", "IngestaNativa", "Provincia", "Tipo Hormiga" }, 0);

            for (MMHormigaDTO hormiga : hormigas) {
                String nombreSexo           = hormigaBL.obtenerSexo(hormiga.getIdSexo());
                String nombreGenoAlimento   = hormigaBL.obtenerGenoAlimento(hormiga.getIdGenoAlimento());
                String nombreIngestaNativa  = hormigaBL.obtenerNombreIngestaNativa(hormiga.getIdIngestaNativa());
                String nombreProvincia      = hormigaBL.obtenerProvincia(hormiga.getIdProvincia()
                );
            }

            tablaHormigas.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar hormigas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public MMHormigaDTO obtenerHormigaSeleccionada() {
        int selectedRow = tablaHormigas.getSelectedRow();
        if (selectedRow != -1) {
            String nombreHormiga = (String) tablaHormigas.getValueAt(selectedRow, 0);
            try {
                return hormigaDAO.mmReadAll().stream()
                        .filter(h -> h.getNombre().equals(nombreHormiga))
                        .findFirst().orElse(null);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al obtener la hormiga seleccionada", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }

    public void actualizarHormigaEnTabla(MMHormigaDTO hormiga) {
        int selectedRow = tablaHormigas.getSelectedRow();
        try {
            tablaHormigas.setValueAt(hormigaBL.obtenerGenoAlimento(hormiga.getIdGenoAlimento()),
                    selectedRow, 2);
            tablaHormigas.setValueAt(hormigaBL.obtenerNombreIngestaNativa(hormiga.getIdIngestaNativa()),
                    selectedRow, 3);
            tablaHormigas.setValueAt(hormigaBL.obtenerSexo(hormiga.getIdSexo()), selectedRow, 1);
            tablaHormigas.setValueAt(hormigaBL.obtenerProvincia(hormiga.getIdProvincia()), selectedRow, 4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
