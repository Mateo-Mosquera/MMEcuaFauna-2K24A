package MMUserInterface.MMForms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import MMDataAccess.MMDAO.MMHormigaDAO;
import MMDataAccess.MMDTO.MMHormigaDTO;

public class MMCrearHormigaForm extends JDialog {
    private JTextField nombreField;
    private JComboBox<String> sexoCombo;
    private JComboBox<String> provinciaCombo;
    private JComboBox<String> genoAlimentoCombo;
    private JComboBox<String> ingestaNativaCombo;
    private JTextField estadoField;

    private MMHormigueroPanel hormigueroPanel;

    public MMCrearHormigaForm(JFrame parent, MMHormigueroPanel hormigueroPanel) {
        super(parent, "Crear Hormiga Larva", true);
        this.hormigueroPanel = hormigueroPanel;

        setLayout(new GridLayout(7, 2, 10, 10));
        setSize(400, 300);
        setLocationRelativeTo(parent);

        // Labels and Fields
        add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        add(nombreField);

        add(new JLabel("Sexo:"));
        sexoCombo = new JComboBox<>(new String[]{"Macho", "Hembra"});
        add(sexoCombo);

        add(new JLabel("Provincia:"));
        provinciaCombo = new JComboBox<>(new String[]{"Provincia1", "Provincia2", "Provincia3"}); // Añade las provincias reales
        add(provinciaCombo);

        add(new JLabel("GenoAlimento:"));
        genoAlimentoCombo = new JComboBox<>(new String[]{"Alimento1", "Alimento2"}); // Añade los GenoAlimentos reales
        add(genoAlimentoCombo);

        add(new JLabel("Ingesta Nativa:"));
        ingestaNativaCombo = new JComboBox<>(new String[]{"Ingesta1", "Ingesta2"}); // Añade las Ingestas Nativas reales
        add(ingestaNativaCombo);

        add(new JLabel("Estado:"));
        estadoField = new JTextField("A");
        estadoField.setEnabled(false); // Estado inicial es "A" y no debe ser modificado
        add(estadoField);

        JButton createButton = new JButton("Crear");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearHormiga();
            }
        });
        add(createButton);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(cancelButton);
    }

    private void crearHormiga() {
        try {
            MMHormigaDTO nuevaHormiga = new MMHormigaDTO();
            nuevaHormiga.setNombre(nombreField.getText());
            nuevaHormiga.setIdSexo(sexoCombo.getSelectedIndex() + 1); // Suponiendo que 1 y 2 son los IDs correspondientes
            nuevaHormiga.setIdProvincia(provinciaCombo.getSelectedIndex() + 1); // Igual para provincia
            nuevaHormiga.setIdGenoAlimento(genoAlimentoCombo.getSelectedIndex() + 1);
            nuevaHormiga.setIdIngestaNativa(ingestaNativaCombo.getSelectedIndex() + 1);
            nuevaHormiga.setTipoHormiga("Larva");
            nuevaHormiga.setEstado("A");

            MMHormigaDAO hormigaDAO = new MMHormigaDAO();
            if (hormigaDAO.mmCreate(nuevaHormiga)) {
                JOptionPane.showMessageDialog(this, "Hormiga creada exitosamente");
                hormigueroPanel.cargarHormigas(); // Actualizar la tabla de hormigas
                dispose(); // Cerrar el formulario
            } else {
                JOptionPane.showMessageDialog(this, "Error al crear la hormiga");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
