import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

import MMBusinessLogic.MMHormigaBL;
import MMDataAccess.MMDataHelper.MMDataHelper;
import MMUserInterface.MMCustomerController.MMComboBox;
import MMUserInterface.MMGUI.MMWindowsMain;



public class App {
    public static void main(String[] args) throws Exception {

        MMWindowsMain app = new MMWindowsMain("Ecuafauna");
        app.setVisible(true);
        // Si tienes los nombres de las hormigas en una lista:
        List<String> hormigaNames = Arrays.asList("Hormiga 1", "Hormiga 2", "Hormiga 3");
        MMComboBox comboBox = new MMComboBox(hormigaNames);

        // Si quieres cargar los nombres desde la base de datos:
        /*Connection connection = MMDataHelper.connect();
        MMComboBox comboBox = new MMComboBox(connection);*/

    }
}
