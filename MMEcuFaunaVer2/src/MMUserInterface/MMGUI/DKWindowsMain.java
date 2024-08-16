package MMUserInterface.MMGUI;

import javax.swing.JFrame;

import MMUserInterface.MMCustomerController.MMPanelBar;
import MMUserInterface.MMForms.MMMainPanel;

import java.awt.BorderLayout;
import java.awt.Container;

public class DKWindowsMain extends JFrame {

    public DKWindowsMain(String titleApp) {
        customizeComponent(titleApp);
    }

    private void customizeComponent(String titleApp) {
        setUndecorated(true);
        setSize(600, 580);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Configurar el contenedor principal
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Añadir barra de título personalizada
        container.add(new MMPanelBar(this), BorderLayout.NORTH);

        // Añadir panel principal
        container.add(new MMMainPanel(), BorderLayout.CENTER);

        setVisible(true);
    }
}
