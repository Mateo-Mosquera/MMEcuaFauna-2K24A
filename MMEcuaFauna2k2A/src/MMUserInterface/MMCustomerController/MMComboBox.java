package MMUserInterface.MMCustomerController;

import javax.swing.JComboBox;
import java.awt.Color;
import java.sql.Connection;
import java.util.List;
import java.util.Arrays;
import MMBusinessLogic.MMHormigaBL;

public class MMComboBox extends JComboBox<String> {

    // Constructor que recibe una lista de ítems
    public MMComboBox(List<String> items) {
        super();
        if (items != null) {
            for (String item : items) {
                this.addItem(item);
            }
        }
        customizeComponent();
    }

    // Constructor que recibe un arreglo de ítems
    public MMComboBox(String[] items) {
        this(Arrays.asList(items));
    }

    // Constructor que recibe una conexión y carga los ítems desde la base de datos
    public MMComboBox(Connection connection) {
        super();
        loadHormigaNames(connection);
        customizeComponent();
    }

    // Método para cargar los nombres de hormigas desde la base de datos
    private void loadHormigaNames(Connection connection) {
        MMHormigaBL hormigaBL = new MMHormigaBL(connection);
        List<String> names = hormigaBL.getHormigaNames();
        for (String name : names) {
            this.addItem(name);
        }
    }

    // Personalización del componente
    private void customizeComponent() {
        setFont(MMStyles.MMFONT);
        setForeground(Color.BLACK); // Texto color
        setBackground(Color.WHITE); // cuadro color
        setBorder(MMStyles.mmCreateBorderRect());
    }
}
